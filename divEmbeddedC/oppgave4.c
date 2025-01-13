#include <stdio.h>

int main(){
	float lengde, hoyde, svar;
	printf("Skriv inn lengden på grunnlinjen til trekanten\n");
	scanf(" %f", &lengde);
	printf("Skriv inn høyden til trekanten\n");
	scanf(" %f", &hoyde);
	svar = (lengde*hoyde)/2;
	printf("Arealet til trekanten er %.1f", svar);

	getchar ();
	getchar ();
	return 0;
}

	
