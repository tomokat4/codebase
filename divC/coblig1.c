#include <stdio.h>

float celius;
float fahr;
void infoTilBruker();
int meny();
void celciusToKelvin();
void kelvinToCelcius();
void celciusToFahrenheit();
void fahrenheitToCelcius();

int main(){
	int menyvalg;
	infoTilBruker();
	menyvalg = meny();
	switch(menyvalg){
		case 1 : celciusToKelvin();
			 break;
		case 2 : kelvinToCelcius();
			 break;
		case 3 : celciusToFahrenheit();
			 break;
		case 4 : fahrenheitToCelcius();
			 break;
		case 5 : return 0;
		default: printf("Hvordan klarte du det?");
			 break;
		}
	}
			





void infoTilBruker(void){
	printf("Dette programmet skal utføre temperaturkonvertering mellom Celcius, Kelvin og Fahrenheit.\n");
}

int meny(void){
	int menyvalg;
	while(1){
	printf(" 1. Konvertere temperatur fra Celcius til Kelvin\n");
	printf(" 2. Konvertere temperatur fra Kelvin til Celcius\n");
	printf(" 3. Konvertere temperatur fra Celcius til Fahrenheit\n");
	printf(" 4. Konvertere temperatur fra Fahrenheit til Celcius\n");
	printf(" 5. Avslutter programmet\n");
	scanf(" %d", &menyvalg);
	getchar();
	if(menyvalg>=1 && menyvalg<=5) return menyvalg;
	printf("Ugyldig tastevalg, prøv igjen\n");
	}
}

void kelvinToCelcius(void){
	float celcius;
	float kelvin;
	printf("Hva er temperaturen i Kelvin?");
	scanf(" %f", &kelvin);
	celcius = kelvin-273.15;
	printf("Temperaturen %.2f i Celcius tilsvarer Kelvin %.2f.\n", celcius, kelvin);
}

void celciusToKelvin(void){
	float celcius;
	float kelvin;
	printf("Hva er temperaturen i Celcius?");
	scanf(" %f", &celcius);
	kelvin = celcius+273.15;
	printf("Temperaturen %.2f i Kelvin tilsvarer Celcius %.2f.\n", kelvin, celcius);
}

void celciusToFahrenheit(void){
	float celcius;
	float fahrenheit;
	printf("Hva er temperaturen i Celcius?");
	scanf(" %f", &celcius);
	fahrenheit = (celcius*1.8)+32;
	printf("Temperaturen %.2f i Fahrenheit tilsvarer Celcius %.2f.\n", fahrenheit, celcius);
}

void fahrenheitToCelcius(void){
	float celcius;
	float fahrenheit;
	printf("Hva er temperaturen i Fahrenheit?");
	scanf(" %f", &fahrenheit);
	celcius = (fahrenheit-32)/1.8;
	printf("Temperaturen %.2f i Celcius tilsvarer Fahrenheit %.2f.\n", celcius, fahrenheit);
}

