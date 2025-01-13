#include <stdio.h>

int main(){
	float paaKonto=0, utAvKonto;
	printf("Skriv inn belop som er paa konto\n");
	scanf(" %f", &paaKonto);
	printf("/nHvor mye onsker du å ta ut av konto\n");
	scanf(" %f", &utAvKonto);
	printf("Det staar da igjenn %.2f paa konto\n", paaKonto-utAvKonto);
	getchar();
	getchar();
	return 0;
}
