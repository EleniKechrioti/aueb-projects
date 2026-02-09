library IEEE;
use ieee.std_logic_1164.all;

ENTITY problem3 IS
PORT ( x1, x2, x3  : IN  STD_LOGIC;
		 f           : OUT STD_LOGIC) ;
END problem3 ;

ARCHITECTURE Behavior OF problem3 IS 
BEGIN
	f <= (not x1 and not x3) or (x1 and x3) or (x2 and x1);
END Behavior ;
