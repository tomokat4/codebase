#include <stdio.h>

int main(){
	char tabell[5] = {'E', 'D', 'C', 'B', 'C'};
	printf("Velg et tall mellom 1 og 6\n");
	int tall = getchar() - '0';
	switch(tall){
		case 2: printf("Din karakter er %c\n", tabell[0]); break;
		case 3: printf("Din karakter er %c\n", tabell[1]); break;
		case 4: printf("Din karakter er %c\n", tabell[2]); break;
		case 5: printf("Din karakter er %c\n", tabell[3]); break;
		case 6: printf("Din karakter er %c\n", tabell[4]); break;
		default: printf("Karakter F (Stryk)\n"); break;
	}
	return 0;
}
