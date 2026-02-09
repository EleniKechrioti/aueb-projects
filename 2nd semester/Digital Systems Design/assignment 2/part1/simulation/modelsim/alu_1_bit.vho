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

-- VENDOR "Altera"
-- PROGRAM "Quartus Prime"
-- VERSION "Version 19.1.0 Build 670 09/22/2019 SJ Lite Edition"

-- DATE "06/05/2022 23:38:52"

-- 
-- Device: Altera 5M40ZM64C4 Package MBGA64
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY IEEE;
LIBRARY MAXV;
USE IEEE.STD_LOGIC_1164.ALL;
USE MAXV.MAXV_COMPONENTS.ALL;

ENTITY 	alu_1_bit IS
    PORT (
	a : IN std_logic;
	b : IN std_logic;
	CarryIn : IN std_logic;
	operation : IN std_logic_vector(1 DOWNTO 0);
	ainvert : IN std_logic;
	binvert : IN std_logic;
	Result : OUT std_logic;
	CarryOut : OUT std_logic
	);
END alu_1_bit;

-- Design Ports Information


ARCHITECTURE structure OF alu_1_bit IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_a : std_logic;
SIGNAL ww_b : std_logic;
SIGNAL ww_CarryIn : std_logic;
SIGNAL ww_operation : std_logic_vector(1 DOWNTO 0);
SIGNAL ww_ainvert : std_logic;
SIGNAL ww_binvert : std_logic;
SIGNAL ww_Result : std_logic;
SIGNAL ww_CarryOut : std_logic;
SIGNAL \a~combout\ : std_logic;
SIGNAL \b~combout\ : std_logic;
SIGNAL \u0|outAND~combout\ : std_logic;
SIGNAL \CarryIn~combout\ : std_logic;
SIGNAL \u3|CarryOut~0_combout\ : std_logic;
SIGNAL \u0|ALT_INV_outAND~combout\ : std_logic;

BEGIN

ww_a <= a;
ww_b <= b;
ww_CarryIn <= CarryIn;
ww_operation <= operation;
ww_ainvert <= ainvert;
ww_binvert <= binvert;
Result <= ww_Result;
CarryOut <= ww_CarryOut;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
\u0|ALT_INV_outAND~combout\ <= NOT \u0|outAND~combout\;

-- Location: PIN_H7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a,
	combout => \a~combout\);

-- Location: PIN_F8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b,
	combout => \b~combout\);

-- Location: LC_X6_Y1_N4
\u0|outAND\ : maxv_lcell
-- Equation(s):
-- \u0|outAND~combout\ = (((\a~combout\) # (\b~combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fff0",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datac => \a~combout\,
	datad => \b~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \u0|outAND~combout\);

-- Location: PIN_A6,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\CarryIn~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_CarryIn,
	combout => \CarryIn~combout\);

-- Location: LC_X6_Y1_N2
\u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \u3|CarryOut~0_combout\ = ((\CarryIn~combout\ & ((\b~combout\) # (!\a~combout\))) # (!\CarryIn~combout\ & (!\a~combout\ & \b~combout\)))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "cf0c",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \CarryIn~combout\,
	datac => \a~combout\,
	datad => \b~combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \u3|CarryOut~0_combout\);

-- Location: PIN_B1,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\operation[0]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_operation(0));

-- Location: PIN_C5,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\operation[1]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_operation(1));

-- Location: PIN_A1,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\ainvert~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_ainvert);

-- Location: PIN_H4,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\binvert~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_binvert);

-- Location: PIN_D8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\Result~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_Result);

-- Location: PIN_C8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\CarryOut~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \u3|CarryOut~0_combout\,
	oe => VCC,
	padio => ww_CarryOut);
END structure;


