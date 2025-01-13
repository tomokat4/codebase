#include <stdio.h>
#include <string.h>

int main(){
	int i, j;
	char Navn[5][30];
	char index[30];
	printf("Velkommen til LAB06\n");
	printf("Her skal du oppgi 5 navn, og jeg sorterer de\n");

	for(i=0;i<5;i++){
		printf("Oppgi navn nr %d : \n", i+1);
		scanf("%s", &Navn[i]);
	}
	printf("Du har oppgitt følgende navn\n");
	for(i=0;i<5;i++){
		printf("%s, ", Navn[i]);
	}
	printf("før sortering\n");
	for(i=0;i<5;i++){
		for(j=i+1;j<5;j++){
			if(strcmp(Navn[i], Navn[j])>0){
				strcpy(index,Navn[i]);
				strcpy(Navn[i],Navn[j]);
        			strcpy(Navn[j],index);
			}
		}
	}
	for(i0;i<5;i++){
		printf("%s, ", Navn[i]);
	}
	printf("etter sortering\n");
	return 0;
}




/* //Oppgave 3a
int tall[5];


int main(){
	int index, i, j;
	printf("Velkommen til LAB06\n");
	printf("Her skal du oppgi 5 tall, og jeg sorterer de\n");

	for(i=0;i<5;i++){
		printf("Oppgi tall nr %d : \n", i+1);
		scanf("%d", &tall[i]);
	}
	printf("Du har oppgitt følgende tall\n");
	for(i=0;i<5;i++){
		printf("%d, ", tall[i]);
	}
	printf("før sortering\n");
	for(i=0;i<5;i++){
		for(j=i+1;j<5;j++){
			if(tall[i]>tall[j]){
					index = tall[i];
					tall[i] = tall[j];
					tall[j] = index;
					}
		}
	}
	for(i=0;i<5;i++){
		printf("%d, ", tall[i]);
	}
	printf("etter sortering\n");
	return 0;
}
*/








/*
	for(i=0;i<5;i++){
		printf("Oppgi navn på studenten :\n");
		scanf("%s", &Studenter[i].navn);
		printf("Oppgi poengsum til studenten :\n");
		scanf("%d", &Studenter[i].poengSum);
		if(Studenter[i].poengSum>bestScore){
			bestScore = Studenter[i].poengSum;
			index = i;
		}
	}
*/
