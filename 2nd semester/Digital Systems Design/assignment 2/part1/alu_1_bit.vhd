 



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
