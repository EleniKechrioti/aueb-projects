"""
    Αρχείο python με τις συναρτήσεις  
"""




lang= ['A','B','C','D','E','F','G','H','I','J']                               #λίστα που ονομάζει τις γραμμές του πίνακα

numbers = '  1   2   3   4   5   6   7   8   9   10'                          #xχαρακτήρας που ονομάζει τις στήλες του πίνακα

board = 102*[' ']

def table(board,x):
    """
        Συνάρτηση που εκτυπώνει πίνακα μεγέθους ανάλογου με αυτό που ζητήσει
        ο χρήστης [αριθμός γραμμών/στηλών, πίνακα n*n] και τα στοιχεία του.

        >>> table(board,6)
          1   2   3   4   5   6
        ------------------------
        A|   |   |   |   |   |   |
        B|   |   |   |   |   |   |
        C|   |   |   |   |   |   |
        D|   |   |   |   |   |   |
        E|   |   |   |   |   |   |
        F|   |   |   |   |   |   |
        ------------------------
    """
    print(numbers[:4*x])
    print(x*'----')
    for i in range (1,x*x,x):
        if x == 5:
            print(lang[int((i-1)/5)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|')
        elif x ==6:
            print(lang[int((i-1)/6)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|', board[i+4], '|')
        elif x == 7:
            print(lang[int((i-1)/7)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|', board[i+4], '|', board[i+5], '|')
        elif x == 8:
            print(lang[int((i-1)/8)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|', board[i+4], '|', board[i+5], '|', board[i+6], '|')
        elif x == 9:
            print(lang[int((i-1)/9)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|', board[i+4], '|',board[i+5], '|', board[i+6], '|', board[i+7], '|')
        elif x == 10:
            print(lang[int((i-1)/10)]+'|',board[i-1], '|',board[i], '|', board[i+1], '|', board[i+2] , '|',board[i+3], '|', board[i+4], '|', board[i+5], '|', board[i+6], '|', board[i+7], '|', board[i+8], '|')

    print(x*'----')

def table01(board,lines,t):
    """
        Μετατροπή του πίνακα board για αποθήκευση σε αρχείο csv

        >>> board2 = 27*[' ']
        >>> board[5] = 'X'
        >>> table01(board,5,board2)
        >>> board2
        [0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ' ', ' ']
    """
    for i in range(lines**2):
        if board[i] == 'X':
            t[i] = 2
        elif board[i] == 'O':
            t[i] = 1
        else:
            t[i] = 0
        t[lines**2] = board[lines**2]
        t[lines**2+1] = board[lines**2+1]




def fill_board(board,lines,y,ox):
    """
        Συνάρτηση που γεμίζει τον πίνακα board με τα πιόνια των παικτών σε μορφή στοίβας

        >>> board = 25*[' ']
        >>> fill_board(board, 5, 5, 'X')
        >>> table(board, 5)
          1   2   3   4   5
        --------------------
        A|   |   |   |   |   |
        B|   |   |   |   |   |
        C|   |   |   |   |   |
        D|   |   |   |   |   |
        E|   |   |   |   | X |
        --------------------
    """
    a = 0
    x = lines**2 -1- (lines-y)
    while board[x] != ' ':
        a +=1
        x =  x - lines
        if a==lines:
            break
    if a!= lines:
        board[lines**2 -1 -(lines -y) - a*lines] = ox
    else:
        y = int(input('Επέλεξε μια μη γεμάτη στήλη για το πιόνι σου: '))
        fill_board(board,lines,y,ox)

def point(k,board,lines,points):
    """
        Αυξάνει το στοιχείο του πίνακα board που αποθηκεύει τους πόντους του κάθε παίκτη
    """
    if k == 'X':
        board[lines**2 +1] +=points
    elif k == 'O':
        board[lines**2] +=points


def olor(board,lines,i,j,k,points):
    """
        olor = olis8hsh orizontia
        Αν σχηματιστεί τετράδα ορίζόντια τότε απαλείφονται τα στοιχεία της τετράδας και
        ολισθαίνουν ολα τα στοιχεία που βρίσκονται πάνω απο την τετράδα ακριβώς μια σειρά κάτω.
        Μετά τις εντολές if...else, αφού έχουν γίνει όλες οι ολισθήσεις θέτω στα πρώτα στοιχεία των στηλών που
        εντοπίστηκε η τετράδα τον κενό(' ') εφόσον δεν υπάρχουν άλλα στοιχεία απο πάνω για να ολισθήσουν.

        Περίπτωση 1η : η τετράδα να είναι κολλητή στην τελευταία στήλη του πίνακα
                       το maximum είναι το τελευταίο στοιχείο της οριζόντιας ν-άδας, οπου ν= 4 εως 10
                       το minimum ίναι το πρώτο στοιχείο της οριζόντιας ν-άδας
                       z , r είναι μετρητές, όπου z είναι ο αριμός της στήλης και r ο αριθμός της γραμμής

        Περίπτωση 2η : η τετράδα να ξεκινάει απο την πρώτη στήλη του πίνακα

        Περίπτωση αλλιώς : η τετράδα να είναι ανάμεσα στην δεύτερη και πρώτελευταία στήλη
    """
    r = j -1                                                                                     
    z = j+4
    maximum,minimum = j+3 , j
    if board[lines*i+j+3] == board[lines*i+lines-1]:   
        if r>=0: 
            while  k == board[lines*(i)+r] and r>=0:
                minimum = r
                maximum = lines
                r -=1
    elif board[lines*i+j]==board[lines*i]:
        while k ==board[lines*i+z]:
            maximum = z
            minimum = 0
            z +=1
    else:
        a = j -1                                                                               
        b = j+4                                                           
        if a >=0:
            while k == board[lines*i +a] and a>=0:
                minimum = a
                a -=1
        if b<=lines:
            while k ==board[lines*(i)+b]:
                maximum = b
                b+=1
    if maximum!=j+3:
        for x in range(j+4,maximum+1):
            board[lines*i + x] = '*'
    if minimum !=j :
        for x in range(minimum,j+1):
            board[lines*i + x] = '*'
    table(board,lines)
    for h in range(minimum,maximum+1):    
        for d in range(i,0,-1):
            board[lines*d+h] = board[lines*(d-1)+h]
        points+=1
        board[lines*(d-1)+h] = ' '
    point(k,board,lines,points)

def olka8(board,lines,i,j,k):
    """
        olka8 = olis8thsh ka8eta
        
        Περίπτωση 1η : αν το i είναι 0, δηλαδή το i-1<0, τότε δεν υπάρχουν στοιχεία πάνω απο
                       την τετράδα για να ολισθήσουν και απλά διαγράφεται η τετράδα
                       
        Περίπτωση αλλιώς: υπάρχει ένα στοιχείο να ολισθήσει, οπότε το στοιχείο αυτό αποθηκεύεται
                          στη θέση του τελευταίου στοιχείου της τετράδας και τα υπόλοιπα
                          διαγράφονται
    """
    if i-1<0:
        board[lines*(i)+j] =   ' '
        board[lines*(i+1)+j] = ' '
        board[lines*(i+2)+j] = ' '
        board[lines*(i+3)+j] = ' '
    else:
        board[lines*(i+3)+j] = board[lines*(i-1)+j]
        board[lines*(i+2)+j] = ' '
        board[lines*(i+1)+j] = ' '
        board[lines*(i)+j] = ' '

def oldk(k,board,lines,i,j,points):
    """
        oldk = olis8hsh diagwnioy kyrias
        
        Πραγματοποίει ολήσθηση όλων των στοιχείων που βρίσκονται πάνω απο τη κύρια διαγώνιο προς τα κάτω
        Μετά τις εντολές if...else, αφού έχουν γίνει όλες οι ολισθήσεις θέτω στα πρώτα στοιχεία των στηλών που
        εντοπίστηκε η τετράδα τον κενό(' ') εφόσον δεν υπάρχουν άλλα στοιχεία απο πάνω για να ολισθήσουν.


        Περίπτωση 1η: το πρώτο στοιχείου της κύριας διαγωνίου βρίσκεται στην πρώτη γραμμή του πίνακα
                      r = συμβολίζει τις γραμμές του πίνακα
                      z = συμβολίζει τις στήλες του πίνακα
                      count = μετρήτης, θέλω η ολίσθηση να πραγματοποιηθεί 3 φορές αφού δεν υπάρχει
                              άλλο στοιχείο πάνω απο το πρώτο στοιχείο της τετράδας
                      count1 = μετρητής, ανάλογα με τη θέση του στοιχείου πραγματοποιείται και ανάλογος
                               αριθμός ολισθήσεων. π.χ για το 3ο στοιχείο πραγματοποιούνται 2
                               ολισθήσεις, για το δεύτερο 1 και για το 4ο 3 ολισθήσεις

        Περίπτωση αλλιώς: το πρώτο στοιχείου της κύριας διαγωνίου δεν βρίσκεται στην πρώτη γραμμή του πίνακα
                          count = μετρήτης, θέλω η ολίσθηση να πραγματοποιηθεί 4 φορές αφού υπάρχει
                                  άλλο στοιχείο πάνω απο το πρώτο στοιχείο της τετράδας
                          Παίρνω δυο περιπτώσεις
                          1: Αν το τελευταίο στοιχείο της τετράδας αποτελεί στοιχείο της τελευταίας γραμμής του πίνακα
                             count1 = μετρητής, θέλω τα στοιχεία που βρισκονταί πανω απο το τελευταίο στοιχείο της τετράδας
                                      να ολισθήσουν lines -1 φορές, δηλαδή σε ενα πίνακα με 7 γραμμές και στήλες θέλω τα
                                      στοιχεία να ολισθήσουν 6 φορές
                             count2 = μετρητής, θέτω στο count2 το count1 γιατι οι ολισθήσεις θέλω να γίνουν count1 φορές
                                      το count2 υστερα μειωνεται κατα 1 και το count1 μειώνεται κατα 1 γιατι οι ολισθήσεις του
                                      επόμενου στοιχείου ειναι κατα 1 λιγότερες
                          2: Αν το τελευταίο στοιχείο της τετράδας δεν αποτελεί στοιχείο της τελευταίας γραμμής του πίνακα
                             count1 = μετρητής, θέλω τα στοιχεία που βρισκονταί πανω απο το τελευταίο στοιχείο της τετράδας
                                      να ολισθήσουν i+3 φορές, γιατί υπάρχουν στοιχεία κάτω από την τετράδα που δεν
                                      θέλω να αλλάξουν.  
    """
    if board[lines*(i)+j]== board[j]:
        count = 3
        z = j + 3
        points = 4
        while count>0:
            r = i +count
            count1 = count
            while count1>0:
                board[lines*(r) +z]=board[lines*(r-1)+z]
                r -=1
                count1 -=1
            z -=1
            count -=1
        board[j] = ' '
        board[j+1] = ' '
        board[j+2] = ' '
        board[j+3] = ' '
    else:
        if board[lines*(i+3)+j+3] == board[lines*(lines-1)+j+3]:
            count1 = lines-1
        else:
            count1 = i+3
        z = j + 3                        
        count = 4
        while count>0:
            r = count1 
            count2 = count1
            while count2>0:
                board[lines*r +z] = board[lines*(r-1)+z]
                r -=1
                count2 -=1
            count1 -=1
            z -=1
            count -=1
        board[j] = ' '
        board[j+1] = ' '
        board[j+2] = ' '
        board[j+3] = ' '
        points=4
        point(k,board,lines,points)

def oldd(k,board,lines,i,j,points):
    """
        oldd = olis8hsh diagvnioy deutereuoysas

        Πραγματοποίει ολίσθηση όλων των στοιχείων που βρίσκονται πάνω απο τη δευτερεύουσα διαγώνιο προς τα κάτω
        Μετά τις εντολές if...else, αφού έχουν γίνει όλες οι ολισθήσεις θέτω στα πρώτα στοιχεία των στηλών που
        εντοπίστηκε η τετράδα τον κενό(' ') εφόσον δεν υπάρχουν άλλα στοιχεία απο πάνω για να ολισθήσουν.

        Περίπτωση 1η: το πρώτο στοιχείου της δευτερεύουσας διαγωνίου βρίσκεται στην πρώτη γραμμή του πίνακα
                      r = συμβολίζει τις γραμμές του πίνακα
                      z = συμβολίζει τις στήλες του πίνακα
                      count = μετρήτης, θέλω η ολίσθηση να πραγματοποιηθεί 3 φορές αφού δεν υπάρχει
                              άλλο στοιχείο πάνω απο το πρώτο στοιχείο της τετράδας
                      count1 = μετρητής, ανάλογα με τη θέση του στοιχείου πραγματοποιείται και ανάλογος
                               αριθμός ολισθήσεων. π.χ για το 1ο στοιχείο πραγματοποιούνται 3
                               ολισθήσεις, για το 2ο 2 και για το 3ο 1 ολισθήση

        Περίπτωση αλλιώς: το πρώτο στοιχείου της δευτερεύουσας διαγωνίου δεν βρίσκεται στην πρώτη γραμμή του πίνακα
                          count = μετρήτης, θέλω η ολίσθηση να πραγματοποιηθεί 4 φορές αφού υπάρχει
                                  άλλο στοιχείο πάνω απο το πρώτο στοιχείο της τετράδας
                          Παίρνω δυο περιπτώσεις
                          1: Αν το πρώτο στοιχείο της τετράδας αποτελεί στοιχείο της τελευταίας γραμμής του πίνακα
                             count1 = μετρητής, θέλω τα στοιχεία που βρίσκονται πάνω απο το τελευταίο στοιχείο της τετράδας
                                      να ολισθήσουν lines -4 φορές, δηλαδή σε ενα πίνακα με 7 γραμμές και στήλες θέλω τα
                                      στοιχεία να ολισθήσουν 3 φορές
                             count2 = μετρητής, θέτω στο count2 το count1 γιατι οι ολισθήσεις θέλω να γίνουν count1 φορές
                                      το count2 υστερα μειωνεται κατα 1 και το count1 αυξάνεται κατα 1 γιατι οι ολισθήσεις του
                                      προηγούμενου στοιχείου είναι κατα 1 περισσότερες
                          2: Αν το πρώτο στοιχείο της τετράδας δεν αποτελεί στοιχείο της τελευταίας γραμμής του πίνακα
                             count1 = μετρητής, θέλω τα στοιχεία που βρίσκονται πάνω απο το τελευταίο στοιχείο της τετράδας
                                      να ολισθήσουν i φορές, γιατί υπάρχουν στοιχεία κάτω από την τετράδα που δεν
                                      θέλω να αλλάξουν. το i είναι οι γραμμές που υπάρχουν πάνω απο το τελευταίο στοιχείο της τετράδας
                                      Η ολίσθηση αρχίζει απο το τελευταίο στοιχείο της τετράδας, οποτε οι ολισθήσεις πρεπει να είναι i
                                      και για το προηγούμενο στοιχείο της τετράδας, το οποίο βρίσκεται μια γραμμή κάτω, οι ολισθήσεις
                                      αυξανονται κατά 1 και γίνονται i+1
    """
    if board[lines*(i)+j] == board[j]:
        z = j-1
        count = 1
        while count<4:
            r = count
            count1 = count
            while count1>0:
                board[lines*r +z] = board[lines*(r-1)+z]
                r -=1
                count1 -=1
            z -=1
            count +=1
    else:
        z = j
        if board[lines*(i+3)+j-3] == board[lines*(lines - 1) + j-3]:
            count1 = lines - 4
        else:
            count1 =  i
        count = 1
        while count < 5:
            r = count1
            count2 = count1
            while count2 > 0:
                board[lines*r +z] = board[lines*(r-1)+z]
                r -=1
                count2 -=1
            z -=1
            count +=1
            count1 +=1
    board[j] = ' '
    board[j-1] = ' '
    board[j-2] = ' '
    board[j-3] = ' '
    points=4
    point(k,board,lines,points)
    


def stars(board,lines):
    """
        Όταν εντοπίζει τετράδα ανακοινώνει τον νικήτη του γύρου και "δείχνει" την τετράδα αφού στα στοιχεία της
        αποθηκεύει το σύμβολο '*'
        Ταυτόχρονα καλεί τις συναρτήσεις ολίσθησης ανάλογα με το πως είναι η τετράδα (κάθετα, οριζόντια, διαγώνια)
        και εκτυπώνει τον πίνακα
        Κάθε συνάρτηση ολίσθησης καλεί τη συνάρτηση point, η οποία μετράει τους πόντους του κάθε παίκτη και τους
        αποθηκεύει στα δυο τελευταία στοιχεία του πίνακα board
    """
    for i in range(0,lines):
        for j in range(0,lines):
            if i >=0 and i<lines-3:
                if board[lines*(i)+j] == board[lines*(i+1)+j] and board[lines*(i+1)+j]== board[lines*(i+2)+j] and board[lines*(i+3)+j]== board[lines*(i+2)+j] and board[lines*(i+2)+j]!=' ':
                    if board[lines*(i)+j] == 'O':
                        print('Νικητής γύρου ο Παίκτης 1')
                        k = 'O'
                        board[lines**2] +=4
                    elif board[lines*(i)+j]=='X':
                        print('Νικητής γύρου ο παίκτης 2')
                        k = 'X'
                        board[lines**2+1] +=4
                    board[lines*(i)+j] =   '*'
                    board[lines*(i+1)+j] = '*'
                    board[lines*(i+2)+j] = '*'
                    board[lines*(i+3)+j] = '*'
                    table(board,lines)
                    olka8(board,lines,i,j,k)
                    table(board,lines)
            elif j >=0 and j<lines-3:
                if board[lines*i +j]== board[lines*i +j+1] and board[lines*i +j+1] == board[lines*i +j+2] and board[lines*i +j+3]==board[lines*i +j+2] and board[lines*i +j+2]!=' ':
                    if board[lines*i+j] == 'O':
                        print('Νικητής γύρου ο Παίκτης 1')
                        k = 'O'
                    elif board[lines*i+j]=='X':
                        print('Νικητής γύρου ο παίκτης 2')
                        k = 'X'
                    board[lines*i +j]='*'
                    board[lines*i +j+1] = '*'
                    board[lines*i +j+3] = '*'
                    board[lines*i +j+2] = '*'
                    points=0
                    olor(board,lines,i,j,k,points)
                    table(board,lines)
                    
            if i>=0 and i<lines-3 and j >=0 and j<lines-3:
                if board[lines*(i)+j]== board[lines*(i+1)+j+1] and board[lines*(i+1)+j+1] ==board[lines*(i+2)+j+2] and board[lines*(i+2)+j+2]== board[lines*(i+3)+j+3] and board[lines*(i+1)+j+1]!=' ':
                    if board[lines*(i)+j] == 'O':
                        print('Νικητής γύρου ο Παίκτης 1')
                        k = 'O'
                    elif board[lines*(i)+j]=='X':
                        print('Νικητής γύρου ο παίκτης 2')
                        k = 'X'
                    board[lines*(i)+j] = '*'
                    board[lines*(i+1)+j+1]='*'
                    board[lines*(i+2)+j+2]= '*'
                    board[lines*(i+3)+j+3] = '*'
                    table(board,lines)
                    points = 0
                    oldk(k,board,lines,i,j,points)
                    print(board[lines**2 +1],board[lines**2])
                    table(board,lines)
            if j>=3 and j<lines and i<=lines-4:
                if board[lines*i+j]==board[lines*(i+1)+j-1] and board[lines*(i+1)+j-1]==board[lines*(i+2)+j-2] and board[lines*(i+2)+j-2]==board[lines*(i+3)+j-3] and board[lines*(i+1)+j-1]!=' ':
                    if board[lines*i+j] == 'O':
                        print('Νικητής γύρου ο Παίκτης 1')
                        k = 'O'
                    elif board[lines*i+j]=='X':
                        print('Νικητής γύρου ο παίκτης 2')
                        k = 'X'
                    board[lines*i+j]= '*'
                    board[lines*(i+1)+j-1] = '*'
                    board[lines*(i+2)+j-2] = '*'
                    board[lines*(i+3)+j-3] = '*'
                    table(board,lines)
                    points = 0
                    oldd(k,board,lines,i,j,points)
                    table(board,lines)

