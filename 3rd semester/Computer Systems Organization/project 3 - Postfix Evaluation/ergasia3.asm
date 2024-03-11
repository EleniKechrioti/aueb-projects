# Kechrioti Eleni 
# AM: 3210078

.text

.globl main

main:
	
	la $a0, msg1
	li $v0, 4								#print "Enter postfix expression:\n"
	syscall
	
	
	li $t0,0								#$t0 is stack pointer, i = 0
	
	
readChar:
		li $v0, 12							#reads char
		syscall
		
		move $t1,$v0 						#store ch in $t1
	
		beq $t1,'=',Result 					#if $t1 == '=' goto Result
		
		bne $t1,' ', valueofChar 			#if $t1 != ' ' goto valueofChar
		
		j readChar							#read next char
		
		
		
valueofChar:
		li $t2,0 							# $t2 = number = 0
		
while: 
	beq $t1, ' ', push						#if ch = ' ' goto push
	bge $t1, '0', calculation				#if ch >= '0' goto calculation // 0..9
	ble $t1, '9', character					#if ch =< '9' goto 
	beq $t1, '=', Result					#if ch = '=' goto Result

	
character:
	beq $t1,'*',multiplication				#if	$t1 = '*' goto multiplication
	beq $t1,'+',addition					#if $t1 = '+' goto addition
	beq $t1,'-',subtraction					#if $t1 = '-' goto subtraction
	beq $t1,'/',division					#if $t1 = '/' goto division
	blt $t1,'0',Result 						#if $t1 < '0' goto Result,  anything else than the above characters
											#else $t1 >= '0', 0..9 continue to calculation

calculation: 
	
	
	bge $t1,'A',Result 						# if $t1 >='A' goto Result, user pressed a letter or another sumbol
	 
	
	mul $t2,$t2,10							# calculates the number 
	sub $t1,$t1,48							#number = 10*number + (ch-48)
	add $t2,$t2,$t1
	
	
	move $t3,$t2							# move the value of $t2 to $t3
	
        
    li $v0, 12								#reads a char
    syscall
    move $t1, $v0
	j while
	
# 


addition:
	jal pop
	move $t5,$t4
	jal pop
	add $t3,$t4,$t5
	j push 									# push the result in stack


subtraction: 
	jal pop
	move $t5,$t4
	jal pop 
	sub $t3,$t4,$t5
	j push 									# push the result in stack

	
multiplication:	
	jal pop
	move $t5, $t4
	jal pop
	mul $t3, $t4, $t5
	j push 									# push the result in stack


division: 
	jal pop
	move $t5,$t4
	jal pop
	beq $t5,0,DivisionError 				# if second char = 0, goto DivisionError
	div $t3,$t4,$t5
	j push 									# push the result in stack
	
##### SubPrograms ####
pop:  										# pop the numbers from top of the stack to calculate the result
	lw $t4,0($sp) 							# top of stack
	addi $sp,$sp,4
	addi $t0, $t0, -1						# decreases pointer // i--
	jr $ra
	

push: 										# push the numbers in stack
	addi $sp,$sp,-4
	sw $t3,0($sp)
	addi $t0, $t0, 1						# increases pointer // i++
	j readChar 
	
#### SubPrograms #####
	
DivisionError: 
	la $a0, error_msg2
	li $v0, 4
	syscall
	j exit
	
Result: 	
	beq $t0,0,invalid 						#if $t0 = 0 goto invalid 
	
	la $a0, msg2							#print "\nPostfix Evaluation: "
	li $v0, 4
	syscall
	
	lw $t3,0($sp)							#prints result, which is the top of the stack
	move $a0, $t3
	li $v0, 1
	syscall
	
	j exit


invalid:									# if $t0 = 0 then the stack is empty and the user pressed '=' 
	la $a0, error_msg1
	li $v0, 4
	syscall
	j exit
	
exit:
	li $v0,10
	syscall
	

.data

error_msg1:	.asciiz		"\nInvalid Postfix\n"
error_msg2:	.asciiz		"\nDivision error\n"
msg1:		.asciiz		"Enter postfix expression:\n"
msg2:		.asciiz		"\nPostfix Evaluation: "	

#$t0 = i , int i = pointer , points the top of the stack
#$t1 = ch
#$t2 = number 
#$t3 = result , pushed back in stack
#$t4 = x1 , popped from stack
#$t5 = x2 , popped from stack