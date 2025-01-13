#include <stdio.h>

void komma(void);

//int mittTall=0;
int main(){
	int mittTall=0;
	printf("tast inn et heltall ");
	scanf(" %d", &mittTall);
	printf("Dette er en test\t");
	komma();
	printf("test2 %d\n",mittTall);
	getchar();

	return 0;
}

void komma(void){
	printf(",");
}
