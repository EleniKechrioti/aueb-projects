

#include "p3210078-p3190167-p3190043-pizzeria.h"
int n_cust;									//number of customers
int n_fail=0;								//number of totel orders that failed in payment
int n_pass=0;								//number of total orders that succeded in payment
int total_special = 0;						//number ot total special pizzas that were ordered
int total_plain = 0;						//number of total plain pizzas that were ordered
int total_cost =0;							//total revenue at the end of the day for the pizzeria
int n_available_cooks = Ncook;				//number of available cooks that can take an order
int n_available_ovens = Noven;				//number of available ovens thac can bake a pizza
int n_available_packer = Npacker;			//number of available packer employees that can pack the order
int n_available_deliverers = Ndeliverer;	//number of available deliverers that are ready to deliver an order
int total_service_time = 0; int  max_service_time = -1; int total_colding_time = 0; int max_colding_time = -1;  //initializations of global time variables for our statistics
unsigned int seed;									

//mutexes and conds needed to complete each step of the order
pthread_mutex_t  oven_lock, cook_lock, packet_lock, deliverer_lock, screen_lock, operator_lock  , stats_lock;
pthread_cond_t  oven_cond, cook_cond, packet_cond, deliverer_cond;


void rc_check(int rc){		//ckecks the response code from every mutex lock/unlock condition wait/signal etc.
	if(rc != 0){
		printf("ERROR: return code %d from rc",rc);	//prints error message
		destructor(7,4);								//destroys all mutexes and conds 
		exit(-1);									//terminates the program
	}	
}
void mutex_destroyer(pthread_mutex_t *mutex){		//destroys the mutex, and checks the response code
	int rc = pthread_mutex_destroy(mutex);
	if (rc != 0) {
		printf("ERROR: return code from pthread_mutex_destroy() is %d\n", rc);
		//exit(-1);	destructor will continue to destroy the other mutexes/conds		
	}
}
void cond_destroyer(pthread_cond_t *cond){		//destroys the cond, and checks the response code
	int rc = pthread_cond_destroy(cond);
	if (rc != 0) {
		printf("ERROR: return code from pthread_cond_destroy() is %d\n", rc);
		//exit(-1);	destructor will continue to destroy the other mutexes/conds
	}
}

void mutex_lock(pthread_mutex_t *mutex){		//locks the mutex and checks responce code
	int rc = pthread_mutex_lock(mutex);
	rc_check(rc);
}

void mutex_unlock(pthread_mutex_t *mutex){		//unlocks the mutex and checks response code
	int rc = pthread_mutex_unlock(mutex);
	rc_check(rc);
}
//we did not make similar functions for cond wait and signal, because the number of calls for lock/unlock of a mutex were more than the conds

void destructor(int lock_input, int cond_input){
	//Destructors	
	
	pthread_mutex_t* locks[] = {&cook_lock, &oven_lock, &packet_lock, &deliverer_lock, &screen_lock, &operator_lock, &stats_lock};
	pthread_cond_t* conds[] = {&cook_cond, &oven_cond, &packet_cond, &deliverer_cond};
	
	for (int i = 0; i < lock_input; i++){
		mutex_destroyer(locks[i]);
	}
	for (int i = 0; i < cond_input; i++){
		cond_destroyer(conds[i]);
	}
	
	
	pthread_exit(NULL);
}





int main(int argc, char *argv[]) {
	
	//check for valid parameters
	if (argc != 3) {
		printf("Δώσατε λάθος αριθμό παραμέτρων.\n");
		exit(-1);
	}
	
	int rc;
	double next_order;
	n_cust = atoi(argv[1]);		//first parameter is the number of customers
	seed = atoi(argv[2]);		//second parameter is the starting seed
	int order_id[n_cust];		//table that stores the id of each oder

    //Check number of customers
    if(n_cust < 0) {
        printf("Μη έγκυρος αριθμός πελατών.\n\n");
        exit(-1);
    }	

	if(initializations() == 1) {  	//an error occurred during the initialization of a mutex/cond
		exit(-1);
	}
	pthread_t threads[n_cust];		//table that stores each thread/customer created
	
	//Create Customers threads
	for (int i = 0; i < n_cust; i++) {
		order_id[i] = i + 1;			//unique order id
		rc = pthread_create(&threads[i], NULL, order, &order_id[i]);
		if (rc != 0) {
    		printf("ERROR: return code from pthread_create() is %d\n", rc);
			destructor(7,4);				//if an error occured destroy all the mutexes/cond and exit the program
       		exit(-1);
		}
		unsigned int local_seed = seed + order_id[i];		//every order must have a unique seed to avoid getting the same pseudo-random sequence of numbers
		next_order = rand_r(&local_seed) % (Torderhigh + 1 - Torderlow) + Torderlow;
		sleep(next_order);									//till the next customer order arrives | thread created
	}
	
	for (int i = 0; i < n_cust; i++) {
		rc = pthread_join(threads[i], NULL);		
		if (rc != 0) {
			printf("ERROR: return code from pthread_join() is %d\n", rc);
			destructor(7,4);				//if an error occured destroy all the mutexes/cond and exit the program
			exit(-1);		
		}
	}
	
	
	printf("Τα συνολικά έσοδα από τις πωλήσεις: %d ευρω.\n", total_cost);
    printf("Tο πλήθος των special παραγγελιών: %d.\n",total_special);
	printf("Tο πλήθος των plain παραγγελιών: %d.\n", total_plain);
	printf("Tο πλήθος των επιτυχημένων παραγγελιών: %d.\n", n_pass);
	printf("Tο πλήθος των αποτυχημένων παραγγελιών: %d.\n", n_fail);
    printf("Μέσος χρόνος εξυπηρέτησης των πελατών: %.2f λεπτά.\n",(double) total_service_time/ n_pass);
	printf("Μέγιστος χρόνος εξυπηρέτησης των πελατών: %d λεπτά.\n", (int) max_service_time);
    printf("Μέσος χρόνος  κρυώματος των παραγγελιών: %.2f λεπτά.\n", (double) total_colding_time/ n_pass);
	printf("Μέγιστος χρόνος  κρυώματος των παραγγελιών: %d λεπτά.\n", (int) max_colding_time);
	
	
	destructor(7,4);
}




void * order(void *threadid) {
	int OrderID = *(int *)threadid;											//number of order
	unsigned int local_seed = seed + OrderID;								//unique seed of each order
	int number_of_pizzas = rand_r(&local_seed)%(Norderhigh - Norderlow + 1) + Norderlow;	//random number of pizzas for that order
	struct timespec order_start, cold_start, order_end, packet;				//declaring variables for time
	int rc;																	//variable for the responce code of the conds wait/signal

	clock_gettime(CLOCK_REALTIME, &order_start);		//time order starts

	
	int special = 0; int plain = 0;				//number of plain and special 
    for (int j = 0; j< number_of_pizzas;j++){	//for each pizza ordered
        int c = (rand_r(&local_seed)%100+1 <= Pplain*100 ? 1 : 0);//the possibility each pizza is plain or not
        if(c==1) plain++;
        if(c==0) special++;
    }
	int cost = 12*special + 10*plain;		//cost for the order

	
	mutex_lock(&screen_lock);
	printf("Η παραγγελία με id %d περιέχει %d special, %d απλές και κοστίζει %d ευρώ.\n", OrderID, special, plain, cost);
	mutex_unlock(&screen_lock);
	
	
	int payment = (rand_r(&local_seed)%100+1 <= Pfail*100 ? 0 : 1);			//the possibility the payment for the order succeded or failed
	
	mutex_lock(&screen_lock);
    printf("Η πληρωμή για την παραγγελία %d %s\n",OrderID,  payment == 0? "απέτυχε. Η παραγγελία ακυρώθηκε." : "πέτυχε. Η παραγγελία ετοιμάζεται.");
    mutex_unlock(&screen_lock);

    sleep((rand_r(&local_seed) %(Tpaymenthigh - Tpaymentlow + 1)) + Tpaymentlow);	//time to check the card and pay for the order
	if(payment!= 1){ 				//if payment failed
		mutex_lock(&operator_lock);
		n_fail++; 					//number of total orders that failed increases
		mutex_unlock(&operator_lock);
		pthread_exit(NULL);			//thread-customer exit
	}		


	//if payment succeded

    mutex_lock(&stats_lock);
	total_cost += cost;
	total_plain = total_plain + plain;
	total_special = total_special + special;
	mutex_unlock(&stats_lock);

	//Cook availability check

	mutex_lock(&cook_lock);					//cook locked
	while (n_available_cooks == 0) {		//while there is no cook to take on the order
		mutex_lock(&screen_lock);
		printf("H παραγγελία με αριθμό %d δεν βρήκε διαθέσιμο ψήστη...\n", OrderID);
		mutex_unlock(&screen_lock);
		rc = pthread_cond_wait(&cook_cond, &cook_lock);	//wait till another thread sends signal that n_available_cooks have been altered
		rc_check(rc);
    } 

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d βρήκε διαθέσιμο ψήστη!\n", OrderID);	
	mutex_unlock(&screen_lock);

    n_available_cooks--;	//we found an available cook, decrease the number of the available left
    mutex_unlock(&cook_lock);

	//wait for pizzas to be prepared by the cook
    sleep(Tprep * number_of_pizzas);	


	//Oven availability check

    mutex_lock(&oven_lock);
	while (n_available_ovens < number_of_pizzas) {		//while there are not enough ovens to bake all of the pizzas at the same time
		mutex_lock(&screen_lock);
		printf("H παραγγελία με αριθμό %d δεν βρήκε τον απαραίτητο αριθμό διαθέσιμων φούρνων.... \n", OrderID);
		mutex_unlock(&screen_lock);
		rc = pthread_cond_wait(&oven_cond, &oven_lock);
		rc_check(rc);
    }

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d βρήκε τον απαραίτητο αριθμό διαθέσιμων φούρνων!\n", OrderID);
	mutex_unlock(&screen_lock);

	n_available_ovens -= number_of_pizzas;		//we found enough ovens to bake the pizzas, decrease the available left
	mutex_unlock(&oven_lock);

	//Release cook as the pizzas are baking
	mutex_lock(&cook_lock);					
	n_available_cooks++;	//increase the number of the available cooks to take on orders
	rc = pthread_cond_signal(&cook_cond);		//send signal to a thread that available cooks have increased
	rc_check(rc);
	mutex_unlock(&cook_lock);

	//wait till the pizzas are baked
    sleep(Tbake);	

	mutex_lock(&screen_lock);
    printf("H παραγγελία με αριθμό %d ψήθηκε επιτυχώς! \n", OrderID);
	mutex_unlock(&screen_lock);


	clock_gettime(CLOCK_REALTIME, &cold_start);		//pizzas are baked and they start to get cold

	//Packer availability check

	mutex_lock(&packet_lock);
	while (n_available_packer == 0) {				//while there is no available packer to pack the order
		mutex_lock(&screen_lock);
		printf("H παραγγελία με αριθμό %d δεν βρήκε διαθέσιμο υπάλληλο πακεταρίσματος...\n", OrderID);
		mutex_unlock(&screen_lock);
		rc = pthread_cond_wait(&packet_cond, &packet_lock);	//wait for signal
		rc_check(rc);
    }

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d βρήκε διαθέσιμο υπάλληλο πακεταρίσματος!\n", OrderID);
	mutex_unlock(&screen_lock);

    n_available_packer--;				//we found an available packer, decrease the number of the available left
    mutex_unlock(&packet_lock);

	//wait till the pizzas are packed and ready to go
    sleep(Tpack*number_of_pizzas);
	clock_gettime(CLOCK_REALTIME, &packet);				//time the order is ready and packed 

	double delta = packet.tv_sec - order_start.tv_sec;
    int packettime = (int)delta;

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d ετοιμάστηκε σε %d λεπτά.\n", OrderID, packettime);
	mutex_unlock(&screen_lock);


	//Release packer, pizzas are ready to go
	mutex_lock(&packet_lock);
	n_available_packer++;						//packer is done with packing the order and goes to the next one, increase the number of those available
	rc = pthread_cond_signal(&packet_cond);		//send signal
	rc_check(rc);
	mutex_unlock(&packet_lock);

	//Release ovens, the pizzas are already baked and packed
	mutex_lock(&oven_lock);
	n_available_ovens += number_of_pizzas;		//increase the number of the available ovens, since the pizzas were baked and packed
	rc = pthread_cond_signal(&oven_cond);		//send signal
	rc_check(rc);
	mutex_unlock(&oven_lock);

	//Deliverer availability check

	mutex_lock(&deliverer_lock);
	while (n_available_deliverers == 0) {	//while there is no deliverer at the shop available
		mutex_lock(&screen_lock);
		printf("H παραγγελία με αριθμό %d δεν βρήκε διαθέσιμο διανομέα...\n", OrderID);
		mutex_unlock(&screen_lock);
		rc = pthread_cond_wait(&deliverer_cond, &deliverer_lock);	//wait for signal 
		rc_check(rc);
    }

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d βρήκε διαθέσιμο διανομέα!\n", OrderID);
	mutex_unlock(&screen_lock);

    n_available_deliverers--;					//we found available deliverer, decrease the number of those available
    mutex_unlock(&deliverer_lock);



	//wait till the order are delivered to the customer
    int time = (rand_r(&local_seed) %(Tdelhigh - Tdellow + 1)) + Tdellow; //random number to deliver the pizza
	sleep(time);													
	clock_gettime(CLOCK_REALTIME, &order_end);                          //end of order, the order was delivered		
    
    //wait till delivery guy is back in the pizzeria
	sleep(time);													
	mutex_lock(&deliverer_lock);
	n_available_deliverers++;			//deliverer is back at the shop and is available again
    rc = pthread_cond_signal(&deliverer_cond);	//send signal
	rc_check(rc);
    mutex_unlock(&deliverer_lock);


	delta = order_end.tv_sec - order_start.tv_sec;		
	

	mutex_lock(&screen_lock);
	printf("H παραγγελία με αριθμό %d παραδόθηκε σε %d λεπτά.\n", OrderID,(int)delta);
	mutex_unlock(&screen_lock);


    //update total service time
	mutex_lock(&operator_lock);						//lock to alter the global variables | only one thread at a time 
    total_service_time += (int)delta;
	if ((int)delta > max_service_time) {
		max_service_time = (int)delta;						//max service time, since the customer's order arrived
	}
	delta = order_end.tv_sec - cold_start.tv_sec;				
	if ((int)delta > max_colding_time) {
		max_colding_time = (int)delta;						//max colding time, since the order is out of the oven
	}
	total_colding_time+= (int) delta;
	n_pass++;
	mutex_unlock(&operator_lock);
	
	//update total revenue and quantity of each type of pizza
    //mutex_lock(&stats_lock);
	//total_cost += cost;
	//total_plain = total_plain + plain;
	//total_special = total_special + special;
	//mutex_unlock(&stats_lock);
	//order and payment completed 
	pthread_exit(NULL);					//order ends
}




int initializations(){
	//Initialize	
	if (pthread_mutex_init(&cook_lock, NULL) != 0) {
        return 1;
    }
	if (pthread_mutex_init(&oven_lock, NULL) != 0) {
		destructor(1,0);
        return 1;
    }
	if (pthread_mutex_init(&packet_lock, NULL) != 0) {
		destructor(2,0);
        return 1;
	}
	if (pthread_mutex_init(&deliverer_lock, NULL) != 0) {
		destructor(3,0);
        return 1;
    }
	if (pthread_mutex_init(&screen_lock, NULL) != 0) {
		destructor(4,0);
        return 1;
    }
	if (pthread_mutex_init(&operator_lock, NULL) != 0) {
		destructor(5,0);
        return 1;
    }
	if (pthread_mutex_init(&stats_lock, NULL) != 0) {
		destructor(6,0);
        return 1;
    }
	if (pthread_cond_init(&cook_cond, NULL) != 0) {
		destructor(7,0);
        return 1;
    }
	if (pthread_cond_init(&oven_cond, NULL) != 0) {
			destructor(7,1);
			return 1;
		}
	if (pthread_cond_init(&packet_cond, NULL) != 0) {
			destructor(7,2);
			return 1;
		}
	if (pthread_cond_init(&deliverer_cond, NULL) != 0) {
			destructor(7,3);
			return 1;
		}
	return 0;
}
