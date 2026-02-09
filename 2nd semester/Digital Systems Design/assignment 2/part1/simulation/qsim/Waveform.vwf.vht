-- Copyright (C) 2019  Intel Corporation. All rights reserved.
-- Your use of Intel Corporation's design tools, logic functions 
-- and other software and tools, and any partner logic 
-- functions, and any output files from any of the foregoing 
-- (including device programming or simulation files), and any 
-- associated documentation or information are expressly subject 
-- to the terms and conditions of the Intel Program License 
-- Subscription Agreement, the Intel Quartus Prime License Agreement,
-- the Intel FPGA IP License Agreement, or other applicable license
-- agreement, including, without limitation, that your use is for
-- the sole purpose of programming logic devices manufactured by
-- Intel and sold by Intel or its authorized distributors.  Please
-- refer to the applicable agreement for further details, at
-- https://fpgasoftware.intel.com/eula.

-- *****************************************************************************
-- This file contains a Vhdl test bench with test vectors .The test vectors     
-- are exported from a vector file in the Quartus Waveform Editor and apply to  
-- the top level entity of the current Quartus project .The user can use this   
-- testbench to simulate his design using a third-party simulation tool .       
-- *****************************************************************************
-- Generated on "06/05/2022 22:27:51"
                                                             
-- Vhdl Test Bench(with test vectors) for design  :          alu_1_bit
-- 
-- Simulation tool : 3rd Party
-- 

LIBRARY ieee;                                               
USE ieee.std_logic_1164.all;                                

ENTITY alu_1_bit_vhd_vec_tst IS
END alu_1_bit_vhd_vec_tst;
ARCHITECTURE alu_1_bit_arch OF alu_1_bit_vhd_vec_tst IS
-- constants                                                 
-- signals                                                   
SIGNAL a : STD_LOGIC;
SIGNAL ainvert : STD_LOGIC;
SIGNAL b : STD_LOGIC;
SIGNAL binvert : STD_LOGIC;
SIGNAL CarryIn : STD_LOGIC;
SIGNAL CarryOut : STD_LOGIC;
SIGNAL operation : STD_LOGIC_VECTOR(1 DOWNTO 0);
SIGNAL Result : STD_LOGIC;
COMPONENT alu_1_bit
	PORT (
	a : IN STD_LOGIC;
	ainvert : IN STD_LOGIC;
	b : IN STD_LOGIC;
	binvert : IN STD_LOGIC;
	CarryIn : IN STD_LOGIC;
	CarryOut : OUT STD_LOGIC;
	operation : IN STD_LOGIC_VECTOR(1 DOWNTO 0);
	Result : OUT STD_LOGIC
	);
END COMPONENT;
BEGIN
	i1 : alu_1_bit
	PORT MAP (
-- list connections between master ports and signals
	a => a,
	ainvert => ainvert,
	b => b,
	binvert => binvert,
	CarryIn => CarryIn,
	CarryOut => CarryOut,
	operation => operation,
	Result => Result
	);

-- a
t_prcs_a: PROCESS
BEGIN
LOOP
	a <= '0';
	WAIT FOR 180000 ps;
	a <= '1';
	WAIT FOR 180000 ps;
	IF (NOW >= 360000 ps) THEN WAIT; END IF;
END LOOP;
END PROCESS t_prcs_a;

-- b
t_prcs_b: PROCESS
BEGIN
LOOP
	b <= '0';
	WAIT FOR 90000 ps;
	b <= '1';
	WAIT FOR 90000 ps;
	IF (NOW >= 360000 ps) THEN WAIT; END IF;
END LOOP;
END PROCESS t_prcs_b;

-- ainvert
t_prcs_ainvert: PROCESS
BEGIN
	ainvert <= '0';
WAIT;
END PROCESS t_prcs_ainvert;

-- binvert
t_prcs_binvert: PROCESS
BEGIN
	binvert <= '0';
WAIT;
END PROCESS t_prcs_binvert;

-- CarryIn
t_prcs_CarryIn: PROCESS
BEGIN
	CarryIn <= '0';
WAIT;
END PROCESS t_prcs_CarryIn;
-- operation[1]
t_prcs_operation_1: PROCESS
BEGIN
	operation(1) <= '0';
WAIT;
END PROCESS t_prcs_operation_1;
-- operation[0]
t_prcs_operation_0: PROCESS
BEGIN
	operation(0) <= '0';
WAIT;
END PROCESS t_prcs_operation_0;
END alu_1_bit_arch;
