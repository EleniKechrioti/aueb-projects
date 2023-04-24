-----------------------------------------
library ieee;
use ieee.std_logic_1164.all;

ENTITY oros1 IS 
PORT (in1,in2, in3: IN STD_LOGIC;
		  out1      : OUT STD_LOGIC) ;
END oros1;


architecture model_conc of oros1 is
begin
out1 <= in1 or in2 or in3;
end model_conc;

------------------------------------------
library ieee;
use ieee.std_logic_1164.all;

entity oros2 is
port (in1, in2 : in std_logic;
			out1  : out std_logic);
end oros2;

architecture model_conc2 of oros2 is
begin
out1 <= in1 or in2;
end model_conc2;

------------------------------------------
library ieee;
use ieee.std_logic_1164.all;

entity POS1 is
port (in1, in2, in3: in std_logic; out1: out std_logic);
end POS1;

architecture model_conc3 of POS1 is
begin
out1 <= in1 and in2 and in3;
end model_conc3;	  

----------------------------------------------
library IEEE;
use ieee.std_logic_1164.all;

entity problem1 is
port (x1,x2,x3,x4,x5 :  in std_logic;
		f              : out std_logic);
end problem1;

 

architecture structural of problem1 is
component oros1
     port (in1, in2, in3: in std_logic; out1: out std_logic);
end component;

component oros2
     port (in1, in2: in std_logic; out1: out std_logic);
end component;

component POS1
     port (in1, in2, in3: in std_logic; out1: out std_logic);
end component;
signal oros11, oros21, oros22: std_logic;

begin
	I0: oros1 port map (not x1, x2, not x4, oros11); 
	I1: oros2 port map (x4, not x2, oros21); 
	I2: oros2 port map (x2, not x5, oros22); 
	I3: POS1 port map (oros11, oros21, oros22, f); 
end structural;
