#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#define antall 20

void trekkTall(int* tallTabell, int **pekerTabell);
void bubbleSort(int **pekerTabell);

int main(){
	int t;
	int tallTabell[20];
	int* pekerTabell[20];
	srand(time(NULL));
	printf("Hei! Jeg trekker 20 tall mellom 0 og 99, før jeg printer en usortert og sortert tabell av dette\n");
	trekkTall(&tallTabell, pekerTabell);
	bubbleSort(pekerTabell);
	printf("Takk for at du trakk tall med killi's supercomputer idag\n");
	return 0;

}

void trekkTall(int *tallTabell, int **pekerTabell){
	int tall;
	for (int i=0; i < antall; i++){
		tall = rand() %1000+1;
		tallTabell[i] = tall;
		pekerTabell[i] = &tallTabell[i];
	}
	printf("Du har trekt følgende tall\n");
	for (int i=0; i < antall; i++){
		printf("%d\n", tallTabell[i]);
	}
}

void bubbleSort(int** pekerTabell){
	int* index;
	for (int i=0; i < antall; i++){
		for (int j=i+1; j<antall; j++){
			if(*(pekerTabell[i])>*(pekerTabell[j])){
				index=pekerTabell[i];
				pekerTabell[i]=pekerTabell[j];
				pekerTabell[j]=index;
			}
		}
	}
	printf("Listen etter sortering\n");
	for (int i=0; i < antall; i++){
		printf("%d\n", *pekerTabell[i]);
	}
	
}			
