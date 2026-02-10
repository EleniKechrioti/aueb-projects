// SPDX-License-Identifier: GPL-3.0

pragma solidity ^0.8.*;

contract CryptoSOS
{
    address public player1;
    address public player2;
    uint8 public currentPlayer; // 1: Player 1, 2: Player 2
    uint64 firstJoinTime;
    uint64 lastMoveTime;
    uint8[9] public board;
    uint8 public movesMade; 

    // Owner
    address public owner;

    constructor()
    {
        owner = msg.sender;
    }

    modifier onlyOwner()
    {
        require(msg.sender == owner);
        _;
    }

    // Constants
    uint private constant fee = 1 ether;
    uint private constant prize = 1.8 ether;
    uint private constant tieRefund = 0.95 ether;
    uint private constant tooSlowRefund = 1.5 ether;

	// Events
	event StartGame(address player1, address player2);
	event Move(address player, uint8 square, uint8 symbol);
	event Winner(address player);
	event Tie(address player1, address player2);

    // Functions
    function join() public payable
    {
        require(msg.value == fee, "Entry fee is precisely 1 ether");

        if (player1 == address(0))
        {
            player1 = msg.sender; // The first player that calls the function join(), becomes Player 1
            player2 = address(0); // Waits for a second player
            firstJoinTime = uint64(block.timestamp); // Player 1 can call the function cancel() after 2 minutes have past

            movesMade = 0;
            delete board;
            emit StartGame(player1, address(0));
            return;
        }
        else if (player1 != address(0) && player2 == address(0))
        {
            require(msg.sender != player1, "Wait for another player to join"); // Checks so the first player does not join again

            player2 = msg.sender;
            currentPlayer = 1; // Player 1 starts the game
            lastMoveTime = uint64(block.timestamp); // A player can call the function tooSLow() after 1 minute have past from the last move

            emit StartGame(player1, player2);
            return;
        }
        else
        {
            revert("A game is already in progress");
        }

    }

    function placeS(uint8 square) external {
        _makeMove(square, 1);
    }

    function placeO(uint8 square) external {
        _makeMove(square, 2); 
    }

    function _makeMove(uint8 square, uint8 symbol) internal {
        require(player1 != address(0) && player2 != address(0), "There is no game in progress");
        require(square >= 1 && square <= 9, "Square must be 1-9");
        uint8 index = square - 1;
        require(board[index] == 0, "Square already occupied");

        address currentAddr = (currentPlayer == 1) ? player1 : player2;
        require(msg.sender == currentAddr, "Not your turn");

        board[index] = symbol;
        movesMade++; 
        lastMoveTime = uint64(block.timestamp);

        emit Move(msg.sender, square, symbol);

        uint8[9] memory mBoard = board; 

        if (_checkSOS(mBoard)) {
            _endGame(currentAddr, false);
            return;
        }

        if (movesMade == 9) {
            _endGame(address(0), false);
            return;
        }

        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    function _checkSOS(uint8[9] memory mBoard) internal pure returns (bool) {
        // Check centers first
        if(mBoard[4] == 2){
            if (mBoard[3] == 1 && mBoard[5] == 1) return true; // Middle Row
            if (mBoard[1] == 1 && mBoard[7] == 1) return true; // Middle Col
            if (mBoard[0] == 1 && mBoard[8] == 1) return true; // Diagonal \
            if (mBoard[2] == 1 && mBoard[6] == 1) return true; // Diagonal /
        }
        // Other Rows
        if (mBoard[0] == 1 && mBoard[1] == 2 && mBoard[2] == 1) return true;
        if (mBoard[6] == 1 && mBoard[7] == 2 && mBoard[8] == 1) return true;
        // Other Cols
        if (mBoard[0] == 1 && mBoard[3] == 2 && mBoard[6] == 1) return true;
        if (mBoard[2] == 1 && mBoard[5] == 2 && mBoard[8] == 1) return true;
        
        return false;
    }

    function _endGame(address winner, bool isSlowWin) internal {
        address p1 = player1;
        address p2 = player2;
        _resetGame();

        if (winner != address(0)) {
            (bool success, ) = payable(winner).call{value: isSlowWin ? tooSlowRefund : prize}("");
            require(success, "Transfer failed");
            emit Winner(winner);
        } else {
            (bool success1, ) = payable(p1).call{value: tieRefund}("");
            (bool success2, ) = payable(p2).call{value: tieRefund}("");
            require(success1 && success2, "Transfer failed");
            emit Tie(p1, p2);
        }
    }

    function getGameState() external view returns (string memory)
    {
        bytes memory currentState = new bytes(9);
        for (uint8 i = 0; i < 9; i++)
        {
            if (board[i] == 0)
            {
                currentState[i] = bytes1("-");
            }
            else if (board[i] == 1)
            {
                currentState[i] = bytes1("S");
            }
            else
            {
                currentState[i] = bytes1("O");
            }
        }

        return string(currentState);
    }

    function sweepBalance(uint amount) external onlyOwner{
        uint contractBalance = address(this).balance;

        // Must be reserved at least 1 ether in case one player has joined, 1.9 ether in case a game is in progress 
        // (tie worst case senario in terms of payment ammount) and 0 in case there is no game in progress
        uint reservedBalance;
        if (player1 != address(0) && player2 == address(0))
        {
            reservedBalance = fee;
        }
        else if (player1 != address(0) && player2 != address(0))
        {
            reservedBalance = tieRefund * 2;
        }
        else
        {
            reservedBalance = 0;
        }

        require(contractBalance >= reservedBalance, "Insufficient owner balance");
        uint ownerAvailableAmount = contractBalance - reservedBalance;

        require(amount <= ownerAvailableAmount, "The asked amount exceeds the available owner's balance");
        (bool success, ) = payable(owner).call{value: amount}("");
        require(success, "Sweep balance failed");
    }

    function cancel() external
    {
        require(player1 != address(0) && player2 == address(0), "There is no palyer waiting");
        require(msg.sender == player1, "Only player 1 can cancel");
        require(block.timestamp >= firstJoinTime + 2 minutes, "2 minutes have not passed since you joined");

        _resetGame();
  
        (bool success, ) = payable(msg.sender).call{value: fee}("");
        require(success, "Transfer failed");

    }

    function tooSlow() external
    {
        require(player1 != address(0) && player2 != address(0), "There is no game in progress");
        
        if (msg.sender == player1 || msg.sender == player2)
        {
            // If the player whose turn it is to play delays his move by 1 minute or more, the other player is allowed to 
            // call the function
            require(block.timestamp >= lastMoveTime + 1 minutes, "1 minute has not passed since your last move");

            if (currentPlayer == 1)
            {
                require(msg.sender == player2, "You did not made the last move");
            }
            else
            {
                require(msg.sender == player1, "You did not made the last move");
            }

            _resetGame();
            emit Winner(msg.sender);

            (bool success, ) = payable(msg.sender).call{value: tooSlowRefund}("");
            require(success, "Payment failed");
        }
        else if (msg.sender == owner)
        {
            // If none of the players have played for 5 minutes ore more, then the owner is allowed to call the function
            require(block.timestamp >= lastMoveTime + 5 minutes, "5 minutes have not passed since a player made a move");
            address p1 = player1;
            address p2 = player2;
            _resetGame();
            emit Tie(p1, p2);

            (bool success1, ) = payable(p1).call{value: tieRefund}("");
            require(success1, "Payment to player 1 failed");
            (bool success2, ) = payable(p2).call{value: tieRefund}("");
            require(success2, "Payment to player 2 failed");
        }
        else
        {
            revert("Not authorized");
        }
    }

    function _resetGame() internal
    {
        player1 = address(0);
        player2 = address(0);
        currentPlayer = 0;
        firstJoinTime = 0;
        lastMoveTime = 0;
        movesMade = 0;

        for (uint i = 0; i < 9; i++)
        {
            board[i] = 0;
        }
    }
}