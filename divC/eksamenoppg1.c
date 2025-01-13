#include <stdio.h>
#include "lotto_funksjoner.h"
#include <time.h>
#include <stdlib.h>

int main(){
	int t;
	long seed = (unsigned) time(&t);
	srand(seed);
	trekkTall();
	printf("hehhehehehe");
	skrivUt(lotto);
	return 0;
}

void skrivUt(int lotto[]){
	printf("Dine lottotall er :");
	for(int i=0;i < ANTALL + EKSTRA;i++){
		if (i>=0 && i<7) printf("%d ", lotto[i]);
		if (i>=7 && i<10) printf("[%d]", lotto[i]);
	}
	printf("\nTakk for at du spilte!\n");
}

void trekkTall(){
	for(int i=0;i < ANTALL + EKSTRA;i++){
		lotto[i] = -1;
	}
	for(int i=0;i < ANTALL + EKSTRA;i++){
		int temp = rand() % 34 + 1;
		while(finnTall(temp)){
		temp = rand() % 34 + 1;
		}
		lotto[i]=temp;
		}
}
		


 // Oppgave A
int finnTall(int test_tall){
	for(int i=0;i < ANTALL + EKSTRA;i++){
		if (test_tall == lotto[i]) return 1;
	}
	return 0;
}
