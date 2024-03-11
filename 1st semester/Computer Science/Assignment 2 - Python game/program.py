lang= ['A','B','C','D','E','F','G','H','I','J']                               #λίστα που ονομάζει τις γραμμές του πίνακα

numbers = '  1   2   3   4   5   6   7   8   9   10'                          #χαρακτήρας που ονομάζει τις στήλες του πίνακα

import csv

from synarthseis import *

print('Καλωσήλθατε στο παιχνίδι!')
l = input('Επιθυμείτε νέο παιχνίδι (Ν) ή φόρτωση παιχνιδιού απο αρχείο (S); ')
while l !='N' and l!='S':
    print('Παρακαλώ πληκτρολόγησε (Ν) για νέο παιχνίδι ή (S) για φόρτωση παιχνιδιού απο αρχείο')
    l = input('Επιθυμείτε νέο παιχνίδι (Ν) ή φόρτωση παιχνιδιού απο αρχείο (S); ')


if l == 'N':
    lines = int(input('Δώστε αριθμό στηλών παιχνιδιού (5-10): '))
    while lines<5 or lines>10:
        print('Δώσε έναν έγκυρο αριθμό για στήλες')
        lines = int(input('Δώστε αριθμό στηλών παιχνιδιού (5-10): '))
    board =(lines**2 + 2)*[' ']
    """
        Δημιουργεί πίνακα n*n, όπου n = lines, για τα στοιχεία του πίνακα
        +2 για τους πόντους των δυο παικτών
    """
    board[lines**2], board[lines**2+1] = 0 , 0
    """
        Μηδενίζω τα δυο τελευταία στοιχεία του πίνακα, γιατί σε νέο παιχνίδι οι δυο παίκτες δεν
        έχουν πόντους
    """
else:
    y=[]
    name = input('Δώστε όνομα αρχείου: ')
    f = open(name,'r')
    csv_reader = csv.reader(f)
    for line in csv_reader:
        y= y+ line
    x = len(y)-2
    board = (x**2 +2)*[' ']
    for i in range(x):
        if y[i]== '0':
            board[i]=' '
        elif y[i] == '1':
            board[i] = 'O'
        else:
            board[i] = 'X'
        lines = int(x**0.5)
        board[lines**2] = int(y[len(y)-2])
        board[lines**2 +1] = int(y[len(y)-1])

board2 = board

c = ' '
while c != 's':
    table(board, lines)
    p1 = int(input('Παίκτης 1: Επέλεξε στήλη για το πιόνι σου: '))
    while p1<1 or p1>lines :
        p1 = int(input('Παίκτης 1: Παρακαλώ πληκτρολόγησε έγκυρο αριθμό στήλης για το πιόνι σου: '))
    fill_board(board,lines,p1,'O')
    p2 = int(input('Παίκτης 2: Επέλεξε στήλη για το πιόνι σου: '))
    while p2<1 or p2>lines :
        p2 = int(input('Παίκτης 2: Παρακαλώ πληκτρολόγησε έγκυρο αριθμό στήλης για το πιόνι σου: '))
    fill_board(board,lines,p2,'X')
    stars(board,lines)
    c = input('Πατήστε οποιοδήποτε πλήκτρο για να συνεχίσετε.\nΓια παύση του παιχνιδιού και αποθήκευση σε αρχείο επιλέξτε "s": ')
    print(' ')



if board[lines**2]>board[lines**2+1]:
    print('Νικητής ο Παίκτης 1 με σκορ:',board[lines**2],'-',board[lines**2+1],'.')
elif board[lines**2]< board[lines**2+1]:
    print('Νικητής ο Παίκτης 2 με σκορ:',board[lines**2+1],'-',board[lines**2],'.')
else:
    print('Ισοπαλία:',board[lines**2],'-',board[lines**2+1],'.')


if c == 's':
    board2 = (lines**2+2)*['']
    table01(board,lines,board2)
    filename=input('Δώσε όνομα αρχείου:')
    f = open(filename,'w')
    file=csv.writer(f)
    for i in range(lines):
        file.writerow(board2[i*lines:lines*(i+1)]) # 0,1 nikhtes
    file.writerow([board[lines**2],board[lines**2+1]])
