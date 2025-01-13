#include <stdio.h>

struct Student{
	char navn[50];
	int poengSum;
};

int main(){

	struct Student Studenter[5]; 
	int i,index, bestScore = 0;
	float avgScore;
	printf("Velkommen til Haram kommune alumniaggregator\n");

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

	printf("Liste over studenter og poengsummer følger\n");
	printf("Navn		Poengsum\n");
	for(i=0;i<5;i++){
		printf("%s		%d\n", Studenter[i].navn, Studenter[i].poengSum);
	}

	printf("Eleven med den høyeste poengsummen er : %s med %d poeng\n", Studenter[index].navn, Studenter[index].poengSum);
	for(i=0;i<5;i++){
		avgScore = avgScore + Studenter[i].poengSum;
	}
	avgScore = avgScore/5;
	printf("Gjennomsnittlig poengsum blant elevene er %.2f\n", avgScore);

	return 0;
}


