
		.text
		.globl __start
		
main:
		la $a0, str	# str = read(string)
		li $a1, 128
		li $v0, 8
		syscall
		la $t0, str
		            	
								               # SEARCH FOR '#'
search:	lb $t1, ($t0)	                       # ch = 	next char from str
		beqz $t1, not_ok  	                   # if ch = 0 ...
	    beq $t1, '#', continue                 # if ch = '#' ...
		add $t0, $t0, 1 	                   # 
		j search	                           # goto search
				
continue:
		li $t2, 1	                           # counter = 1 
again:	bgt $t2, 4, ok  	                   # if counter > 4 ...
		add $t0, $t0, 1                    	   # ch = next char from str
		lb $t1, ($t0)	                       # 
		beqz $t1, not_ok 	                   # if ch == 0  ...
		bgt $t1, '1', not_ok 	               # if ch > '1' ...
		blt $t1, '0', not_ok	                   # if ch < '0' ...
		add $t2, $t2, 1   	                   # counter++
		j again	                               # goto again

not_ok:	la $a0, error_mesg
		li $v0, 4 		
		syscall
		j exit

ok:		la $a0, no_error_mesg
		li $v0, 4
		syscall

exit:	li $v0, 10	                           # end of program
		syscall	

		.data

error_mesg:     	.asciiz "Not OK"

str:				.space 128

no_error_mesg:  	.asciiz "OK"