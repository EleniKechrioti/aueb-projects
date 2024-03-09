

		.text
		.globl main

		
main:	

	again:																#loop while yn == yes continue
	
		la $a0, prompt													# print "Number: "
		li $v0, 4
		syscall
		
		li $v0, 5														# read number
		syscall
		
		sw $v0, result													# store number in result
		
	again2:																# while operator =! '=' continue
		
		
		la $a0, prompt1													# print "Operator: "
		li $v0, 4
		syscall
		
		la $a0, op														# read operator
		li $v0,8
		syscall
		
		lb $t3, op														#load byte of operator in $t3
		
		
	bne $t3, '+', er1													#if op != '+' go to er1 else jump to allgood (continue with the program)
		j allgood
	er1:	bne $t3, '-', er2											#if op != '-' go to er2 else jump to allgood (continue with the program)
	j allgood
	er2:	bne $t3, '/', er3											#if op != '/' go to er3 else jump to allgood (continue with the program)
	j allgood
	er3:	bne $t3, '*', er4											#if op != '*' go to er4 else jump to allgood (continue with the program)
	j allgood
	er4:	bne $t3, '%', er5											#if op != '%' go to er5 else jump to allgood (continue with the program)
	j allgood
	er5:	bne $t3, '=', errorop										#if op != '=' then op is not an operator and goes to errorop
		
		
		
	allgood:	
		#li $t4, '='
		
		beq $t3, '=', print												#if op == '=' go to print
		
		la $a0, prompt													# print "Number: "
		li $v0, 4
		syscall
		
		li $v0, 5														# read number 2 (y)
		syscall
		
		sw $v0, y														# store in y
		
		lw $t1, result 													#load result in $t1
		lw $t2, y														#load y in $t2
		
		bne $t2, 0, calc													# if y=!0 got to calc else continue
		
	beq $t3, '/', errord												# if op == '/' then go to errord, we have a division error
	beq $t3, '%', errord												# if op == '%' then go to errord, we have a division error
		
	calc:	
		beq $t3, '+', plus												#if op == '+' go to plus
		
		beq $t3, '-', subt												#if op == '-' go to subt
		
		beq $t3, '*', multiply											#if op == '*' go to multiply
		
		beq $t3, '/', divide											#if op == '/' go to divide
		
		beq $t3, '%', divi												#if op == '%' go to divi
		
		
		
plus:		add $t1, $t1, $t2											# $t1 = $t1 + $t2
sw $t1, result															# store in result
j again2																# go to again2, second loop

subt:		sub $t1, $t1, $t2											# $t1 = $t1 - $t2
sw $t1, result															# store in result
j again2

multiply:	mul $t1, $t1, $t2											# $t1 = $t1 * $t2
sw $t1, result															# store in result
j again2

divide:		div $t1, $t1, $t2											# $t1 = $t1 / $t2
sw $t1, result															# store in result
j again2

divi:		rem $t1, $t1, $t2											# $t1 = $t1 % $t2
sw $t1, result															# store in result
j again2
		
		
print:		
		la $a0, ans 													# print " The result is: "
		li $v0,4
		syscall
		
		lw $t1, result													# load result in $t1
		move $a0, $t1													# print result
		li $v0,1
		syscall
		
		la $a0, question 												# print "\nDo you want to continue with a new expression? (y/n)\n"
		li $v0,4
		syscall
		
		la $a0, yn														#read yn, user answer
		li $a1,80 
		li $v0,8
		syscall
		
		lb $t0, yn														#load byte of yn
		li $t6,  'y'
		beq $t0, $t6, again												#if yn == 'y' then go to again( first loop), do another calculation
		
		j exit															#else go to exit, exit the program

errord:  la $a0, error_div 												# print "\nError: Divide by zero\n"
		li $v0,4
		syscall
		j exit															#user gave an error, program ends, go to exit

errorop: la $a0, error_oper 											# print "\nError: Invalid operator.\n"
		li $v0,4
		syscall
		
exit:	li $v0, 10														#exit, program ends
		syscall
		
		.data
result:	 .space 4			# integer result (4 bytes)
y:		 .space 4			# integer y (4 bytes)
op:		 .space 1			# string op with max 1 char
yn:		 .space 80			# string op with max 80 char
prompt:	 .asciiz "Number: "
prompt1: .asciiz "Operator: "
ans:	 .asciiz "The result is: "
error_div:     .asciiz "\nError: Divide by zero\n"
error_oper:	   .asciiz "\nError: Invalid operator.\n"
question:	   .asciiz "\nDo you want to continue with a new expression? (y/n)\n"
	
