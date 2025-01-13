#include "PinNames.h"
#include "mbed.h"
#include <stdio.h>


/* //oppgave 8 er ferdig
//Definer knapper
BusIn Switches(PA_1, PA_4, PB_0);
//Definer led outptuts
BusOut LEDs(PA_5, PA_6, PA_7, PB_6);

int main(){
    int viseverdi;
    LEDs = 0xF; //std pos for led bus output er 1111 bit
    while (1){
        printf("Skriv inn den verdien du vil vise :\r\n");
        scanf(" %d", &viseverdi);
        LEDs = ~viseverdi; //bitwise NOT operator
        printf("Bryterverdi =0x%x\r\n", viseverdi&0xF);
    }
}
*/

/* //oppgave 7 er ferdig
BusIn Switches(PA_1, PA_4, PB_0);
BusOut LEDs(PA_5, PA_6, PA_7, PB_6);

int main(){
    while (1) {LEDs = Switches &0x3;} //0x3 er 011 som &operatør kjører igjennom signal fra switches
    //derfor bli aldri signal til d3 1, fordi sw1 = 1 + 0 i 011 aldri blir output 1 til led 
}
*/
/*
//oppgave 6 ferdig 
DigitalIn SW1(PA_1);
DigitalIn SW2(PA_4);
BusOut LEDs(PA_5, PA_6, PA_7, PB_6);

int main(){

    LEDs = 0;
    int teller = 0;

    while (1){
        if (SW1==0){
            teller = teller+1;
            LEDs = ~teller;
            wait_ms(2);
            while(SW1==0){}
        }
        else if (SW2==0){
            teller = teller-1;
            LEDs = ~teller;
            wait_ms(2);
            while(SW2==0){}
        }
    }
    
}
*/
/*
DigitalIn SW1(PA_1);
BusOut LEDs(PA_5, PA_6, PA_7, PB_6);

int main(){

    LEDs = 0;
    int teller = 0;

    while (1){
        if (SW1==0){
            teller = teller+1;
            LEDs = ~teller;
            wait_ms(2);
            while(SW1==0){} //Jeg tror koden registrerer flere trykk uten wait funksjonen
        }
    }
    
}
*/

/* //oppgave 4 er ferdig
DigitalOut led2(PA_6);
DigitalIn button2(PA_7);

int main(){
    printf("Velkommen!");
    button2.mode(PullUp); //denne flipper funksjonaliteten av knappen
    while (true){
        if (button2==1)
        led2 = 1;
        else
        led2 = 0;
        wait(0.1);

    }
}
*/

/*
//oppgave 3 er ferdig
DigitalIn button2(PA_7);
DigitalOut led2(PA_6);

int main(){
    printf("Velkommen!");

    while (true){
        if (button2==1)
        led2 = 1;
        else
        led2 = 0;
        wait(0.1);

    }
}
*/

/*
 // oppgave 2 ferdig
DigitalOut myled1(LED1); //integrert led på pcb
DigitalOut myled2(PA_6); //led koblet til D12 på pcb
DigitalIn mybutton(USER_BUTTON);

int main(){

    printf("Velkommen!\r\n");

    while (true) {
        if (mybutton==0) { //turn on led if button is pressed
        myled1 = 1;
        myled2 = 0;
        wait(0.1);
        }
        else if (mybutton==1){ //leave led off if button isnt pushed
        myled1 = 0;
        myled2 = 1;
        wait(0.1);
        }
    }

}
*/
/*
//oppgave 1 er ferdig
DigitalOut myled(LED1);
DigitalIn mybutton(USER_BUTTON);

int main(){

    printf("Velkommen!\r\n");

    while (true) {
        if (mybutton==0) { //turn on led if button is pressed
        myled = 1;
        wait(0.1);
        }
        else if (mybutton==1){ //leave led off if button isnt pushed
        myled = 0;
        wait(0.1);
        }
    }

}
*/
