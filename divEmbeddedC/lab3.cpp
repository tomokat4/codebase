#include "mbed.h"
#include <stdio.h>

/* //Oppgave 1a
DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

int main(){
    while(1){
        SevenSegPlot(0x80FE); wait_ms(500); //1000 0000 1111 1110
        SevenSegPlot(0x80FD); wait_ms(500); //1000 0000 1111 1101
        SevenSegPlot(0x80FB); wait_ms(500); //1000 0000 1111 1011
        SevenSegPlot(0x80F7); wait_ms(500); //1000 0000 1111 0111
        SevenSegPlot(0x80EF); wait_ms(500); //1000 0000 1110 1111
        SevenSegPlot(0x80DF); wait_ms(500); //1000 0000 1101 1111
        SevenSegPlot(0x80BF); wait_ms(500); //1000 0000 1011 1111
        SevenSegPlot(0x807F); wait_ms(500); //1000 0000 0111 1111

    }
}
*/

/*
 //Oppgave 1B og 1C
DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

int main(){
    while(1){

        //Oppgave 1B
        //SevenSegPlot(0x80FF); wait(1.0);
        //SevenSegPlot(0x8000); wait(1.0);

        //Oppgave 1C
        //SevenSegPlot(0x8049); wait(1.0);
        //SevenSegPlot(0x8041); wait(1.0);

    }
}
*/

/*
//Oppgave 2

DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

int main(){
    int teller;
    while(1){
        //teller = 0;

        while(SW1==1){
            teller = (teller+1)%6;
            wait_ms(10);
        }

        switch(teller){
        case 1 : SevenSegPlot(0x809F); wait_ms(2000); break; // 1
        case 2 : SevenSegPlot(0x8025); wait_ms(2000); break;
        case 3 : SevenSegPlot(0x800D); wait_ms(2000); break;
        case 4 : SevenSegPlot(0x8099); wait_ms(2000); break;
        case 5 : SevenSegPlot(0x8049); wait_ms(2000); break;
        case 0 : SevenSegPlot(0x8041); wait_ms(2000); break;
        default : break;
    }
    }
}
*/

/*
//Oppgave 3

DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

void plotNumbers1(){
    SevenSegPlot(0x8000); wait(0.5);
    SevenSegPlot(0x4000); wait(0.5);
    SevenSegPlot(0x2000); wait(0.5);
    SevenSegPlot(0x1000); wait(0.5);
}

void plotNumbers2(){
    SevenSegPlot(0x8000); wait(0.5);
    SevenSegPlot(0xC000); wait(0.5);
    SevenSegPlot(0xE000); wait(0.5);
    SevenSegPlot(0xF000); wait(0.5);
}

int main(){
    while(1){
        //plotNumbers1();
        plotNumbers2();
    }
}
*/

/*
//Oppgave 4
DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

void plotNumbers1(){
    SevenSegPlot(0x8000); wait(0.5);
    SevenSegPlot(0x4000); wait(0.5);
    SevenSegPlot(0x2000); wait(0.5);
    SevenSegPlot(0x1000); wait(0.5);
}

void plotNumbers2(){
    SevenSegPlot(0x8000); wait(0.5);
    SevenSegPlot(0xC000); wait(0.5);
    SevenSegPlot(0xE000); wait(0.5);
    SevenSegPlot(0xF000); wait(0.5);
}

void plotNumbers3(int t){
    SevenSegPlot(0x809F); wait_ms(t);
    SevenSegPlot(0x4025); wait_ms(t);
    SevenSegPlot(0x200D); wait_ms(t);
    SevenSegPlot(0x1099); wait_ms(t);
}

int main(){
    while(1){
        //plotNumbers1();
        //plotNumbers2();
        plotNumbers3(500); //500 lyser opp en av gangen, 10 blinker alle, 1 lyser alle
    }
}
*/

/*
//Oppgave 5 utgpkt
DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

int teller = 0;
int flag = 0;


void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

int main(){
    SevenSegPlot(0x8003); //0 som stdverdi
    while(1){
        if(SW1==1){
            teller = (teller+1)%10;
            while(SW1==1){
                if      (teller==0) {SevenSegPlot(0x8003);}
                else if (teller==1) {SevenSegPlot(0x809F);}
                else if (teller==2) {SevenSegPlot(0x8025);}
                else if (teller==3) {SevenSegPlot(0x800D);}
                else if (teller==4) {SevenSegPlot(0x8099);}
                else if (teller==5) {SevenSegPlot(0x8049);}
                else if (teller==6) {SevenSegPlot(0x8041);}
                else if (teller==7) {SevenSegPlot(0x801F);}
                else if (teller==8) {SevenSegPlot(0x8001);}
                else                {SevenSegPlot(0x8019);}
            }
        }
    }
}
*/

/*
DigitalIn SW1(PA_1);

DigitalOut Latch(PB_5);
DigitalOut CLK(PA_8);
DigitalOut D(PA_9);

int teller = 0;
int flag = 0;


void SevenSegPlot(int Data){
    Latch = 0;
    for (int i=0;i<=15;i++){
        CLK=0;
        if((Data>>i) &0x1){D.write(1);}
        else{D.write(0);}
        CLK = 1;
    }
    Latch=1;
}

int main(){
    printf("lab3 opg5 start\n");
    SevenSegPlot(0x8003); //0 som stdverdi
    while(1){
        if(SW1==1){
            teller = (teller+1)%10;
            while(SW1==1){
                switch(teller){
                case 0 : SevenSegPlot(0x8003); break;
                case 1 : SevenSegPlot(0x809F); break;
                case 2 : SevenSegPlot(0x8025); break;
                case 3 : SevenSegPlot(0x800D); break;
                case 4 : SevenSegPlot(0x8099); break;
                case 5 : SevenSegPlot(0x8049); break;
                case 6 : SevenSegPlot(0x8041); break;
                case 7 : SevenSegPlot(0x801F); break;
                case 8 : SevenSegPlot(0x8001); break;
                case 9 : SevenSegPlot(0x8019); break;
                default : break;
                }
            }
        }
        if(teller==9){
            break;
        }
    }
    printf("Hovedløkken er avsluttet, lab03 ferdig\n");
}
*/
