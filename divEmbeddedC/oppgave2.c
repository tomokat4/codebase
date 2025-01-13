#include "stdio.h"
#include "stdlib.h"

int main(){
	int fodsels_aar;
	int alder;
	int dette_aaret = 2023;

	printf("Hei, hvor gammel er du vennen min simlefjes:");
	scanf(" %d", &fodsels_aar);
	alder = dette_aaret - fodsels_aar;
	printf("Du ble født i herrens %d år.", alder);

	getchar();
	getchar();
	return 0;
}

