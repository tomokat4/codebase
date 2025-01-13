#include "TextLCD.h"
#include "mbed.h"
#include "mbed_thread.h"


TextLCD lcd(D8, D14, D9, D4, D5, D6, D7);

/*  //OPPGAVE 4
int main(){
    char meldingTilLCDPanel[80]; //Melding som vises på LCD-modulen

    while(1){
    printf("Skriv det inn her vennligst :\n");
    scanf("%[^\r\n]s", meldingTilLCDPanel);
    getchar();
    getchar();
    printf("Du har skrevet %s\n", meldingTilLCDPanel);
    lcd.lcdComand(0x01);
    thread_sleep_for(2);
    lcd.gotoxy(1, 1);
    lcd.printf(meldingTilLCDPanel);
    thread_sleep_for(300);
    getchar();
    }
}
 */

/* 
// oppg3
int main()
{
int counter = 0;

while(1){
    lcd.gotoxy(1,1);
    lcd.printf("Nr: %d", counter);
    counter = counter+1;
    thread_sleep_for(300);
    lcd.gotoxy(1, 2);
    lcd.printf("Nr: %d", counter);
    counter = counter+1;
    thread_sleep_for(300);
    }
}

 */

/*
//Oppgave 2
int main()
 {
    lcd.gotoxy(1,1);
    lcd.printf("Hello");
    lcd.gotoxy(1,2);
    lcd.printf("       World");
    lcd.lcdComand(0x0F);

    while(1) {
        thread_sleep_for(300);
    }
}
*/
