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

-- DATE "06/05/2022 23:54:55"

-- 
-- Device: Altera 5M80ZT100C4 Package TQFP100
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY IEEE;
LIBRARY MAXV;
USE IEEE.STD_LOGIC_1164.ALL;
USE MAXV.MAXV_COMPONENTS.ALL;

ENTITY 	alu_16_bit IS
    PORT (
	a : IN std_logic_vector(15 DOWNTO 0);
	b : IN std_logic_vector(15 DOWNTO 0);
	opcode : IN std_logic_vector(2 DOWNTO 0);
	result : OUT std_logic_vector(15 DOWNTO 0);
	overflow : OUT std_logic
	);
END alu_16_bit;

-- Design Ports Information


ARCHITECTURE structure OF alu_16_bit IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL devoe : std_logic := '1';
SIGNAL devclrn : std_logic := '1';
SIGNAL devpor : std_logic := '1';
SIGNAL ww_devoe : std_logic;
SIGNAL ww_devclrn : std_logic;
SIGNAL ww_devpor : std_logic;
SIGNAL ww_a : std_logic_vector(15 DOWNTO 0);
SIGNAL ww_b : std_logic_vector(15 DOWNTO 0);
SIGNAL ww_opcode : std_logic_vector(2 DOWNTO 0);
SIGNAL ww_result : std_logic_vector(15 DOWNTO 0);
SIGNAL ww_overflow : std_logic;
SIGNAL \A1|u0|outAND~combout\ : std_logic;
SIGNAL \A2|u0|outAND~combout\ : std_logic;
SIGNAL \A3|u0|outAND~combout\ : std_logic;
SIGNAL \A4|u0|outAND~combout\ : std_logic;
SIGNAL \A5|u0|outAND~combout\ : std_logic;
SIGNAL \A6|u0|outAND~combout\ : std_logic;
SIGNAL \A7|u0|outAND~combout\ : std_logic;
SIGNAL \A8|u0|outAND~combout\ : std_logic;
SIGNAL \A9|u0|outAND~combout\ : std_logic;
SIGNAL \A10|u0|outAND~combout\ : std_logic;
SIGNAL \A11|u0|outAND~combout\ : std_logic;
SIGNAL \A12|u0|outAND~combout\ : std_logic;
SIGNAL \A13|u0|outAND~combout\ : std_logic;
SIGNAL \A14|u0|outAND~combout\ : std_logic;
SIGNAL \A15|u0|outAND~combout\ : std_logic;
SIGNAL \A16|u0|outAND~combout\ : std_logic;
SIGNAL \A1|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A3|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A3|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A5|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A5|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A7|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A7|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A9|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A9|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A11|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A11|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A13|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A13|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \A15|u3|CarryOut~0_combout\ : std_logic;
SIGNAL \A15|u3|CarryOut~1_combout\ : std_logic;
SIGNAL \overflow~0_combout\ : std_logic;
SIGNAL \a~combout\ : std_logic_vector(15 DOWNTO 0);
SIGNAL \b~combout\ : std_logic_vector(15 DOWNTO 0);
SIGNAL \opcode~combout\ : std_logic_vector(2 DOWNTO 0);
SIGNAL \A16|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A15|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A14|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A13|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A12|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A11|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A10|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A9|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A8|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A7|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A6|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A5|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A4|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A3|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A2|u0|ALT_INV_outAND~combout\ : std_logic;
SIGNAL \A1|u0|ALT_INV_outAND~combout\ : std_logic;

BEGIN

ww_a <= a;
ww_b <= b;
ww_opcode <= opcode;
result <= ww_result;
overflow <= ww_overflow;
ww_devoe <= devoe;
ww_devclrn <= devclrn;
ww_devpor <= devpor;
\A16|u0|ALT_INV_outAND~combout\ <= NOT \A16|u0|outAND~combout\;
\A15|u0|ALT_INV_outAND~combout\ <= NOT \A15|u0|outAND~combout\;
\A14|u0|ALT_INV_outAND~combout\ <= NOT \A14|u0|outAND~combout\;
\A13|u0|ALT_INV_outAND~combout\ <= NOT \A13|u0|outAND~combout\;
\A12|u0|ALT_INV_outAND~combout\ <= NOT \A12|u0|outAND~combout\;
\A11|u0|ALT_INV_outAND~combout\ <= NOT \A11|u0|outAND~combout\;
\A10|u0|ALT_INV_outAND~combout\ <= NOT \A10|u0|outAND~combout\;
\A9|u0|ALT_INV_outAND~combout\ <= NOT \A9|u0|outAND~combout\;
\A8|u0|ALT_INV_outAND~combout\ <= NOT \A8|u0|outAND~combout\;
\A7|u0|ALT_INV_outAND~combout\ <= NOT \A7|u0|outAND~combout\;
\A6|u0|ALT_INV_outAND~combout\ <= NOT \A6|u0|outAND~combout\;
\A5|u0|ALT_INV_outAND~combout\ <= NOT \A5|u0|outAND~combout\;
\A4|u0|ALT_INV_outAND~combout\ <= NOT \A4|u0|outAND~combout\;
\A3|u0|ALT_INV_outAND~combout\ <= NOT \A3|u0|outAND~combout\;
\A2|u0|ALT_INV_outAND~combout\ <= NOT \A2|u0|outAND~combout\;
\A1|u0|ALT_INV_outAND~combout\ <= NOT \A1|u0|outAND~combout\;

-- Location: PIN_37,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[0]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(0),
	combout => \b~combout\(0));

-- Location: PIN_38,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[0]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(0),
	combout => \a~combout\(0));

-- Location: LC_X4_Y2_N3
\A1|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A1|u0|outAND~combout\ = (\b~combout\(0)) # (((\a~combout\(0))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fafa",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \b~combout\(0),
	datac => \a~combout\(0),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A1|u0|outAND~combout\);

-- Location: PIN_40,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[1]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(1),
	combout => \a~combout\(1));

-- Location: PIN_39,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[1]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(1),
	combout => \b~combout\(1));

-- Location: LC_X4_Y2_N2
\A2|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A2|u0|outAND~combout\ = ((\a~combout\(1)) # ((\b~combout\(1))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(1),
	datad => \b~combout\(1),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A2|u0|outAND~combout\);

-- Location: PIN_91,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[2]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(2),
	combout => \b~combout\(2));

-- Location: PIN_61,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[2]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(2),
	combout => \a~combout\(2));

-- Location: LC_X4_Y2_N8
\A3|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A3|u0|outAND~combout\ = ((\b~combout\(2)) # ((\a~combout\(2))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(2),
	datad => \a~combout\(2),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A3|u0|outAND~combout\);

-- Location: PIN_89,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[3]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(3),
	combout => \a~combout\(3));

-- Location: PIN_36,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[3]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(3),
	combout => \b~combout\(3));

-- Location: LC_X4_Y2_N6
\A4|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A4|u0|outAND~combout\ = (\a~combout\(3)) # (((\b~combout\(3))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fafa",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \a~combout\(3),
	datac => \b~combout\(3),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A4|u0|outAND~combout\);

-- Location: PIN_30,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[4]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(4),
	combout => \b~combout\(4));

-- Location: PIN_19,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[4]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(4),
	combout => \a~combout\(4));

-- Location: LC_X3_Y3_N3
\A5|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A5|u0|outAND~combout\ = (\b~combout\(4)) # (((\a~combout\(4))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fafa",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \b~combout\(4),
	datac => \a~combout\(4),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A5|u0|outAND~combout\);

-- Location: PIN_3,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[5]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(5),
	combout => \a~combout\(5));

-- Location: PIN_12,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[5]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(5),
	combout => \b~combout\(5));

-- Location: LC_X3_Y3_N5
\A6|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A6|u0|outAND~combout\ = ((\a~combout\(5)) # ((\b~combout\(5))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fcfc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(5),
	datac => \b~combout\(5),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A6|u0|outAND~combout\);

-- Location: PIN_97,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[6]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(6),
	combout => \a~combout\(6));

-- Location: PIN_14,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[6]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(6),
	combout => \b~combout\(6));

-- Location: LC_X3_Y3_N1
\A7|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A7|u0|outAND~combout\ = (\a~combout\(6)) # (((\b~combout\(6))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fafa",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \a~combout\(6),
	datac => \b~combout\(6),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A7|u0|outAND~combout\);

-- Location: PIN_35,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[7]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(7),
	combout => \a~combout\(7));

-- Location: PIN_92,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[7]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(7),
	combout => \b~combout\(7));

-- Location: LC_X3_Y3_N2
\A8|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A8|u0|outAND~combout\ = ((\a~combout\(7)) # ((\b~combout\(7))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(7),
	datad => \b~combout\(7),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A8|u0|outAND~combout\);

-- Location: PIN_7,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[8]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(8),
	combout => \b~combout\(8));

-- Location: PIN_6,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[8]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(8),
	combout => \a~combout\(8));

-- Location: LC_X3_Y3_N7
\A9|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A9|u0|outAND~combout\ = ((\b~combout\(8)) # ((\a~combout\(8))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "fcfc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(8),
	datac => \a~combout\(8),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A9|u0|outAND~combout\);

-- Location: PIN_83,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[9]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(9),
	combout => \b~combout\(9));

-- Location: PIN_70,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[9]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(9),
	combout => \a~combout\(9));

-- Location: LC_X6_Y4_N2
\A10|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A10|u0|outAND~combout\ = (((\b~combout\(9)) # (\a~combout\(9))))

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
	datac => \b~combout\(9),
	datad => \a~combout\(9),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A10|u0|outAND~combout\);

-- Location: PIN_48,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[10]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(10),
	combout => \a~combout\(10));

-- Location: PIN_78,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[10]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(10),
	combout => \b~combout\(10));

-- Location: LC_X6_Y4_N0
\A11|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A11|u0|outAND~combout\ = (((\a~combout\(10)) # (\b~combout\(10))))

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
	datac => \a~combout\(10),
	datad => \b~combout\(10),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A11|u0|outAND~combout\);

-- Location: PIN_87,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[11]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(11),
	combout => \b~combout\(11));

-- Location: PIN_67,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[11]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(11),
	combout => \a~combout\(11));

-- Location: LC_X6_Y4_N3
\A12|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A12|u0|outAND~combout\ = ((\b~combout\(11)) # ((\a~combout\(11))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(11),
	datad => \a~combout\(11),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A12|u0|outAND~combout\);

-- Location: PIN_72,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[12]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(12),
	combout => \b~combout\(12));

-- Location: PIN_71,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[12]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(12),
	combout => \a~combout\(12));

-- Location: LC_X6_Y4_N5
\A13|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A13|u0|outAND~combout\ = ((\b~combout\(12)) # ((\a~combout\(12))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(12),
	datad => \a~combout\(12),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A13|u0|outAND~combout\);

-- Location: PIN_53,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[13]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(13),
	combout => \b~combout\(13));

-- Location: PIN_57,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[13]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(13),
	combout => \a~combout\(13));

-- Location: LC_X5_Y3_N8
\A14|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A14|u0|outAND~combout\ = (((\b~combout\(13)) # (\a~combout\(13))))

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
	datac => \b~combout\(13),
	datad => \a~combout\(13),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A14|u0|outAND~combout\);

-- Location: PIN_66,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[14]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(14),
	combout => \b~combout\(14));

-- Location: PIN_90,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[14]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(14),
	combout => \a~combout\(14));

-- Location: LC_X5_Y3_N9
\A15|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A15|u0|outAND~combout\ = (((\b~combout\(14)) # (\a~combout\(14))))

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
	datac => \b~combout\(14),
	datad => \a~combout\(14),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A15|u0|outAND~combout\);

-- Location: PIN_68,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\a[15]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_a(15),
	combout => \a~combout\(15));

-- Location: PIN_74,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\b[15]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_b(15),
	combout => \b~combout\(15));

-- Location: LC_X5_Y3_N6
\A16|u0|outAND\ : maxv_lcell
-- Equation(s):
-- \A16|u0|outAND~combout\ = ((\a~combout\(15)) # ((\b~combout\(15))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "ffcc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(15),
	datad => \b~combout\(15),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A16|u0|outAND~combout\);

-- Location: PIN_34,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\opcode[0]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_opcode(0),
	combout => \opcode~combout\(0));

-- Location: PIN_47,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\opcode[1]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_opcode(1),
	combout => \opcode~combout\(1));

-- Location: LC_X4_Y2_N7
\A1|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A1|u3|CarryOut~0_combout\ = (\b~combout\(0) & (((\opcode~combout\(0) & \opcode~combout\(1))) # (!\a~combout\(0)))) # (!\b~combout\(0) & (\opcode~combout\(0) & (!\a~combout\(0) & \opcode~combout\(1))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "8e0a",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \b~combout\(0),
	datab => \opcode~combout\(0),
	datac => \a~combout\(0),
	datad => \opcode~combout\(1),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A1|u3|CarryOut~0_combout\);

-- Location: LC_X4_Y2_N5
\A3|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A3|u3|CarryOut~0_combout\ = ((\a~combout\(1) & (\A1|u3|CarryOut~0_combout\ & \b~combout\(1))) # (!\a~combout\(1) & ((\A1|u3|CarryOut~0_combout\) # (\b~combout\(1)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f330",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(1),
	datac => \A1|u3|CarryOut~0_combout\,
	datad => \b~combout\(1),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A3|u3|CarryOut~0_combout\);

-- Location: LC_X4_Y2_N9
\A3|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A3|u3|CarryOut~1_combout\ = ((\b~combout\(2) & ((\A3|u3|CarryOut~0_combout\) # (!\a~combout\(2)))) # (!\b~combout\(2) & (\A3|u3|CarryOut~0_combout\ & !\a~combout\(2))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "c0fc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(2),
	datac => \A3|u3|CarryOut~0_combout\,
	datad => \a~combout\(2),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A3|u3|CarryOut~1_combout\);

-- Location: LC_X4_Y2_N4
\A5|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A5|u3|CarryOut~0_combout\ = (\a~combout\(3) & (((\b~combout\(3) & \A3|u3|CarryOut~1_combout\)))) # (!\a~combout\(3) & (((\b~combout\(3)) # (\A3|u3|CarryOut~1_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f550",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \a~combout\(3),
	datac => \b~combout\(3),
	datad => \A3|u3|CarryOut~1_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A5|u3|CarryOut~0_combout\);

-- Location: LC_X3_Y3_N4
\A5|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A5|u3|CarryOut~1_combout\ = (\b~combout\(4) & (((\A5|u3|CarryOut~0_combout\) # (!\a~combout\(4))))) # (!\b~combout\(4) & (((!\a~combout\(4) & \A5|u3|CarryOut~0_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "af0a",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \b~combout\(4),
	datac => \a~combout\(4),
	datad => \A5|u3|CarryOut~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A5|u3|CarryOut~1_combout\);

-- Location: LC_X3_Y3_N9
\A7|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A7|u3|CarryOut~0_combout\ = (\A5|u3|CarryOut~1_combout\ & (((\b~combout\(5))) # (!\a~combout\(5)))) # (!\A5|u3|CarryOut~1_combout\ & (!\a~combout\(5) & (\b~combout\(5))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "b2b2",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \A5|u3|CarryOut~1_combout\,
	datab => \a~combout\(5),
	datac => \b~combout\(5),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A7|u3|CarryOut~0_combout\);

-- Location: LC_X3_Y3_N6
\A7|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A7|u3|CarryOut~1_combout\ = (\a~combout\(6) & (((\b~combout\(6) & \A7|u3|CarryOut~0_combout\)))) # (!\a~combout\(6) & (((\b~combout\(6)) # (\A7|u3|CarryOut~0_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f550",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \a~combout\(6),
	datac => \b~combout\(6),
	datad => \A7|u3|CarryOut~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A7|u3|CarryOut~1_combout\);

-- Location: LC_X3_Y3_N8
\A9|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A9|u3|CarryOut~0_combout\ = ((\a~combout\(7) & (\A7|u3|CarryOut~1_combout\ & \b~combout\(7))) # (!\a~combout\(7) & ((\A7|u3|CarryOut~1_combout\) # (\b~combout\(7)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f330",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(7),
	datac => \A7|u3|CarryOut~1_combout\,
	datad => \b~combout\(7),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A9|u3|CarryOut~0_combout\);

-- Location: LC_X3_Y3_N0
\A9|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A9|u3|CarryOut~1_combout\ = ((\b~combout\(8) & ((\A9|u3|CarryOut~0_combout\) # (!\a~combout\(8)))) # (!\b~combout\(8) & (!\a~combout\(8) & \A9|u3|CarryOut~0_combout\)))

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
	datab => \b~combout\(8),
	datac => \a~combout\(8),
	datad => \A9|u3|CarryOut~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A9|u3|CarryOut~1_combout\);

-- Location: LC_X6_Y4_N7
\A11|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A11|u3|CarryOut~0_combout\ = (\b~combout\(9) & (((\A9|u3|CarryOut~1_combout\) # (!\a~combout\(9))))) # (!\b~combout\(9) & (((\A9|u3|CarryOut~1_combout\ & !\a~combout\(9)))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "a0fa",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	dataa => \b~combout\(9),
	datac => \A9|u3|CarryOut~1_combout\,
	datad => \a~combout\(9),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A11|u3|CarryOut~0_combout\);

-- Location: LC_X6_Y4_N4
\A11|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A11|u3|CarryOut~1_combout\ = ((\A11|u3|CarryOut~0_combout\ & ((\b~combout\(10)) # (!\a~combout\(10)))) # (!\A11|u3|CarryOut~0_combout\ & (!\a~combout\(10) & \b~combout\(10))))

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
	datab => \A11|u3|CarryOut~0_combout\,
	datac => \a~combout\(10),
	datad => \b~combout\(10),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A11|u3|CarryOut~1_combout\);

-- Location: LC_X6_Y4_N6
\A13|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A13|u3|CarryOut~0_combout\ = ((\b~combout\(11) & ((\A11|u3|CarryOut~1_combout\) # (!\a~combout\(11)))) # (!\b~combout\(11) & (\A11|u3|CarryOut~1_combout\ & !\a~combout\(11))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "c0fc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(11),
	datac => \A11|u3|CarryOut~1_combout\,
	datad => \a~combout\(11),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A13|u3|CarryOut~0_combout\);

-- Location: LC_X6_Y4_N9
\A13|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A13|u3|CarryOut~1_combout\ = ((\b~combout\(12) & ((\A13|u3|CarryOut~0_combout\) # (!\a~combout\(12)))) # (!\b~combout\(12) & (\A13|u3|CarryOut~0_combout\ & !\a~combout\(12))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "c0fc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \b~combout\(12),
	datac => \A13|u3|CarryOut~0_combout\,
	datad => \a~combout\(12),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A13|u3|CarryOut~1_combout\);

-- Location: LC_X5_Y3_N2
\A15|u3|CarryOut~0\ : maxv_lcell
-- Equation(s):
-- \A15|u3|CarryOut~0_combout\ = ((\A13|u3|CarryOut~1_combout\ & ((\b~combout\(13)) # (!\a~combout\(13)))) # (!\A13|u3|CarryOut~1_combout\ & (\b~combout\(13) & !\a~combout\(13))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "c0fc",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \A13|u3|CarryOut~1_combout\,
	datac => \b~combout\(13),
	datad => \a~combout\(13),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A15|u3|CarryOut~0_combout\);

-- Location: LC_X5_Y3_N4
\A15|u3|CarryOut~1\ : maxv_lcell
-- Equation(s):
-- \A15|u3|CarryOut~1_combout\ = ((\a~combout\(14) & (\b~combout\(14) & \A15|u3|CarryOut~0_combout\)) # (!\a~combout\(14) & ((\b~combout\(14)) # (\A15|u3|CarryOut~0_combout\))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "f330",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(14),
	datac => \b~combout\(14),
	datad => \A15|u3|CarryOut~0_combout\,
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \A15|u3|CarryOut~1_combout\);

-- Location: LC_X5_Y3_N5
\overflow~0\ : maxv_lcell
-- Equation(s):
-- \overflow~0_combout\ = ((\a~combout\(15) & (\A15|u3|CarryOut~1_combout\ & !\b~combout\(15))) # (!\a~combout\(15) & (!\A15|u3|CarryOut~1_combout\ & \b~combout\(15))))

-- pragma translate_off
GENERIC MAP (
	lut_mask => "03c0",
	operation_mode => "normal",
	output_mode => "comb_only",
	register_cascade_mode => "off",
	sum_lutc_input => "datac",
	synch_mode => "off")
-- pragma translate_on
PORT MAP (
	datab => \a~combout\(15),
	datac => \A15|u3|CarryOut~1_combout\,
	datad => \b~combout\(15),
	devclrn => ww_devclrn,
	devpor => ww_devpor,
	combout => \overflow~0_combout\);

-- Location: PIN_85,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: Default
\opcode[2]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "input")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_opcode(2));

-- Location: PIN_26,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[0]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A1|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(0));

-- Location: PIN_29,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[1]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A2|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(1));

-- Location: PIN_41,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[2]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A3|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(2));

-- Location: PIN_58,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[3]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A4|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(3));

-- Location: PIN_16,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[4]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A5|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(4));

-- Location: PIN_5,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[5]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A6|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(5));

-- Location: PIN_17,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[6]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A7|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(6));

-- Location: PIN_8,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[7]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A8|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(7));

-- Location: PIN_15,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[8]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A9|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(8));

-- Location: PIN_82,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[9]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A10|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(9));

-- Location: PIN_84,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[10]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A11|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(10));

-- Location: PIN_81,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[11]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A12|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(11));

-- Location: PIN_76,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[12]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A13|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(12));

-- Location: PIN_88,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[13]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A14|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(13));

-- Location: PIN_42,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[14]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A15|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(14));

-- Location: PIN_64,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\result[15]~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \A16|u0|ALT_INV_outAND~combout\,
	oe => VCC,
	padio => ww_result(15));

-- Location: PIN_75,	 I/O Standard: 3.3-V LVTTL,	 Current Strength: 16mA
\overflow~I\ : maxv_io
-- pragma translate_off
GENERIC MAP (
	operation_mode => "output")
-- pragma translate_on
PORT MAP (
	datain => \overflow~0_combout\,
	oe => VCC,
	padio => ww_overflow);
END structure;


