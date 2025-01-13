#include <stdio.h>
#include <stdlib.h>
#include <math.h>
typedef struct punkt2D{
	int x;
	int y;
} Punkt2D;

Punkt2D p1 = {0, 0};
Punkt2D p2 = {0, 2};
Punkt2D p3 = {2, 2};

float avstand(Punkt2D p1, Punkt2D p2);
int main(){

	printf("Punkt1 (x1 = %d), (y1 = %d)\n", p1.x, p1.y);
	printf("Punkt2 (x2 = %d), (y2 = %d)\n", p2.x, p2.y);
	printf("Punkt3 (x3 = %d), (y3 = %d)\n", p3.x, p3.y);
	float resultat1 = avstand(p1, p2);
	float resultat2 = avstand(p1, p3);
	printf("Avstand fra p1 og p2 er %f\n", resultat1);
	printf("Avstand fra p1 og p3 er %f\n", resultat2);
	if(resultat1<resultat2) printf("Korteste vei er fra punkt p1 til p2 er %f\n", resultat1);
	else printf("Korteste vei er fra punkt p1 til p3 er %f\n", resultat2);
	return 0;
}


float avstand(Punkt2D p1, Punkt2D p2){
	return sqrt(pow((p1.x - p2.x),2) + pow((p1.y - p2.y),2));
}


