--2 input AND gate
library ieee;
use ieee.std_logic_1164.all;
 entity myAND is
     port (outA,outB: in std_logic;
 outAND: out std_logic);
 end myAND;
 architecture Structure of myAND is
 begin
    outAND<= outA and outB;
 end Structure;
 
 
 -- 2 input OR gate  
library ieee;
use ieee.std_logic_1164.all;
  entity myOR is
        port (outA,outB: in std_logic;
 outOR: out std_logic);
 end myOR;
 architecture Structure of myOR is
  begin
        outOR <= outA or outB;
 end Structure;    
 
 
--2 input XOR gate
library ieee;
use ieee.std_logic_1164.all;
    entity myXOR is
        port(outA,outB: in std_logic;
 outXOR: out std_logic);
    end myXOR;
    architecture Structure of myXOR is
    begin
    outXOR <= outA xor outB;
    end Structure;      
 
--3 input full adder      
library ieee;
use ieee.std_logic_1164.all;
    entity fulladder is
        port(CarryIn,outA,outB: in std_logic;
					sum,CarryOut: out std_logic);
    end fulladder;
    architecture Structure of fulladder is
    begin
	  CarryOut<= (outB and CarryIn) or (outA and CarryIn) or (outA and outB);
     sum<= (outA and not outB and not CarryIn) or (not outA and outB and not CarryIn) or (not outA and not outB and CarryIn) or (outA and outB and CarryIn);
    end Structure;
 
--1 input notA/notB
library ieee;
use ieee.std_logic_1164.all;
    entity notx is
        port(x: in std_logic; xinvert:in std_logic;
 outx: out std_logic);
    end notx;
    architecture Structure of notx is
    begin
    outx <=  x when xinvert = '0' else not x ;
    end Structure;

 
 
--4 input MUX
library ieee;
use ieee.std_logic_1164.all;
    entity mux4to1 is
        port(outAND, outOR, sum, outXOR: in std_logic; operation: in std_logic_vector(1 downto 0);
 Result: out std_logic);
    end mux4to1;
architecture Structure of mux4to1 is
    begin
    with operation select
        Result<= outAND when "00",
                 outOR  when "01",
					  sum    when "10",
                 outXOR when OTHERS;
    end Structure ;
 
 -------------------------------------------------------------------------------------------------
library IEEE;
use ieee.std_logic_1164.all;
entity alu_1_bit is 
    port (a,b, CarryIn: in std_logic;
            operation : in std_logic_vector ( 1 downto 0);
				ainvert, binvert : in std_logic;
            Result,CarryOut : out std_logic);
end alu_1_bit;
 
architecture Structure of alu_1_bit is 
 
	-- AND declaration
	 component myAND
			  port (outA,outB: in std_logic;
	 outAND: out std_logic);
	 end component;
	 
	 
	-- OR declaration
	  component myOR          
			 port (outA,outB: in std_logic;
	outOR: out std_logic);
	 end component;
	 
	-- XOR2 declaration
	  component myXOR          
			 port (outA,outB: in std_logic;
	outXOR: out std_logic);
	 end component;
	 
	--fulladder declaration
	  component fulladder    
					port(CarryIn,outA,outB: in std_logic;
	sum,CarryOut: out std_logic);
	  end component;
	 
	--Ainvert declaration
	component notx        
					port(x: in std_logic; xinvert:in std_logic; outx: out std_logic);
	  end component;    

	--mux4to1 declaration
		 component mux4to1          
					port(outAND, outOR, sum, outXOR: in std_logic; operation: in std_logic_vector(1 downto 0);
	Result: out std_logic);
		 end component;

    signal outAND,outOR,outXOR,sum,outA,outB : std_logic;
    signal invertA,invertB : std_logic;
    signal operationCode : std_logic_vector (1 downto 0);
begin 
 
u0 : myAND port map (outA => outA,outB => outB,outAND =>outAND);
u1 : myOR port map (outA => outA,outB => outB,outOR=>outOR);
u2 : myXOR port map (outA => outA,outB => outB,outXOR=>outXOR);
u3 : fulladder port map (CarryIn => CarryIn,outA => outA,outB => outB,sum =>sum,CarryOut=>CarryOut);
u4 : notx port map (x=>a,xinvert=>invertA,outx=> outA);
u5 : notx port map (x=>b,xinvert=> invertB,outx=>outB);
u6 : mux4to1 port map (outAND =>outAND, outOR=>outOR,sum =>sum, outXOR=>outXOR, operation =>operationCode, Result => Result);
end Structure; 
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------- 
-----------------------------------------------------------------------------------------------	
-----------------------------------------------------------------------------------------------

	library IEEE;
	use ieee.std_logic_1164.all;
	--LIBRARY work ;
	--use work.erotima2.all;
	
	entity ControlCircuit is
    port (
            opcode      :in std_logic_vector (2 downto 0);
            ainvert, binvert : out  std_logic;
            operation : out std_logic_vector(1 downto 0);
            CarryIn : out std_logic);              
	end ControlCircuit;
 
	architecture Structure of ControlCircuit is 
	signal s1,s2:std_logic;   
	
	begin
	s1 <= opcode(1) and opcode(0);
	s2 <= opcode(2) and not opcode(1);
	
	carryin <= s1;
	ainvert <=s2;
	binvert <= s1 or s2;
	operation(1) <= opcode(1);
	operation(0) <= (not opcode(1) and opcode(0)) or ( opcode(2) and opcode(1));
	end Structure;

-----------------------------------------------------------------------------------------------

library ieee;
use ieee.std_logic_1164.all;
use ieee.numeric_std.all;
--LIBRARY work ;
--use work.erotima2.all;

entity alu_16_bit is
 port( a,b: in std_logic_vector(15 downto 0);
				opcode : in std_logic_vector(2 downto 0);
				result: out std_logic_vector(15 downto 0);
				overflow: out std_logic);
end alu_16_bit;

architecture Structure of alu_16_bit is

		--ControlCircuit declaration--
	component ControlCircuit
		 port (
					opcode : in std_logic_vector (2 downto 0);
					ainvert,binvert : out std_logic;
					operation : out std_logic_vector (1 downto 0);
					CarryIn: out std_logic);
	 
	end component;

   -- Alu declaration --	
	component alu_1_bit
		port(a,b, CarryIn: in std_logic;
		     operation : in std_logic_vector(1 downto 0);
	        ainvert,binvert : in std_logic;
			  Result : out std_logic; 
			  CarryOut: out std_logic);
	end component;

	signal operation	: std_logic_vector(1 downto 0);
	signal ainvert, binvert, CarryIn, CarryOut	:std_logic;
	signal c: std_logic_vector (14 downto 0);
 begin
   u8 : ControlCircuit port map(opcode,ainvert,binvert,operation,CarryIn);
	A1: alu_1_bit port map (a(0), b(0), CarryIn, operation, ainvert, binvert, Result(0), c(0));
	A2: alu_1_bit port map (a(1), b(1),c(0), operation, ainvert, binvert, Result(1), c(1));
	A3:  alu_1_bit port map (a(2), b(2),c(1), operation, ainvert, binvert, Result(2), c(2));
	A4:  alu_1_bit port map (a(3), b(3),c(2), operation, ainvert, binvert, Result(3), c(3));
	A5:  alu_1_bit port map (a(4), b(4),c(3), operation, ainvert, binvert, Result(4), c(4));
	A6:  alu_1_bit port map (a(5), b(5),c(4), operation, ainvert, binvert, Result(5), c(5));
	A7:  alu_1_bit port map (a(6), b(6),c(5), operation, ainvert, binvert, Result(6), c(6));
	A8:  alu_1_bit port map (a(7), b(7),c(6), operation, ainvert, binvert, Result(7), c(7));
	A9:  alu_1_bit port map (a(8), b(8),c(7), operation, ainvert, binvert, Result(8), c(8));
	A10: alu_1_bit port map (a(9), b(9),c(8), operation, ainvert, binvert, Result(9), c(9));
	A11: alu_1_bit port map (a(10), b(10),c(9), operation, ainvert, binvert, Result(10), c(10));
	A12: alu_1_bit port map (a(11), b(11),c(10), operation, ainvert, binvert, Result(11), c(11));
	A13: alu_1_bit port map (a(12), b(12),c(11), operation, ainvert, binvert, Result(12), c(12));
	A14: alu_1_bit port map (a(13), b(13),c(12), operation, ainvert, binvert, Result(13), c(13));
	A15: alu_1_bit port map (a(14), b(14),c(13), operation, ainvert, binvert, Result(14), c(14));
	A16: alu_1_bit port map (a(15), b(15),c(14), operation, ainvert, binvert, Result(15), CarryOut);
	overflow<= c(14) xor CarryOut;
 
end Structure;