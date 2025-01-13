#include "AnalogIn.h"
#include "AnalogOut.h"
#include "DigitalOut.h"
#include "mbed.h"
#include <algorithm>
#include <stdio.h>


/*
//oppgave 1
DigitalOut Vcc(PA_0), Gnd(PA_4);
AnalogIn Ainn(PA_1);
float voltage, maxVoltage, minVoltage;

int main(){
    Vcc = 1;
    Gnd = 0;
    maxVoltage=minVoltage=Ainn.read()*3.3;

    while(1){
        voltage = Ainn.read()*3.3;


        if(voltage>maxVoltage) maxVoltage = voltage;
        if(voltage<minVoltage) minVoltage = voltage;

        //Oppgave C for å oppdatere min og max voltage

        printf("Gjeldende: %3.f, ", voltage);
        printf("Max: %.3f, Min: %.3f, ", maxVoltage, minVoltage);
        printf("Max-Min: %.3f,\r\n", maxVoltage-minVoltage);
        wait_us(100000);
    }
}
*/

/*
//oppgave 2 ferdig
DigitalOut Vcc(PA_0), Gnd(PA_4);
AnalogIn Ainn(PA_1);
float voltageAVG, maxVoltage, minVoltage;

int main(){
    Vcc = 1;
    Gnd = 0;
    maxVoltage=minVoltage=Ainn.read()*3.3;

    while(1){
        int i = 0;
        for(int i=0;i<=1000;i++){
            voltageAVG = voltageAVG+Ainn.read()*3.3;
            }
        voltageAVG = voltageAVG/1000;

        if(voltageAVG>maxVoltage) maxVoltage = voltageAVG;
        if(voltageAVG<minVoltage) minVoltage = voltageAVG;
        //Oppgave C for å oppdatere min og max voltage

        printf("Gjeldende: %3.f, ", voltageAVG);
        printf("Max: %.3f, Min: %.3f, ", maxVoltage, minVoltage);
        printf("Max-Min: %.3f,\r\n", maxVoltage-minVoltage);
        wait_us(100000);
    }
}
*/

/*
//Oppgave 3 ferdig
DigitalOut Vcc(PA_0), Gnd(PA_4);
AnalogIn Ainn(PA_1);
float voltageAVG, maxVoltage, minVoltage;

int main(){
    Vcc = 1;
    Gnd = 0;
    maxVoltage=minVoltage=Ainn.read()*3.3;

    while(1){
        int i = 0;
        for(int i=0;i<=1000;i++){
            voltageAVG = voltageAVG+Ainn.read()*3.3;
            }
        voltageAVG  = voltageAVG/1000;
        //Oppgave C for å oppdatere min og max voltage


        if(voltageAVG<1){
            printf("Spenning - %.3f : For lav spenning\n", voltageAVG);
        }
        
        else if(voltageAVG>=1 && voltageAVG<=2){
            printf("Spenning - %.3f : Riktig spenning\n", voltageAVG);
        }

        else if(voltageAVG>=2){
            printf("Spenning - %.3f : For høy spenning\n", voltageAVG);
        }

        else printf("koden er bunk");


         //Rester av kode fra oppg 2
        //printf("Gjeldende: %3.f, ", voltageAVG);
        //printf("Max: %.3f, Min: %.3f, ", maxVoltage, minVoltage);
        //printf("Max-Min: %.3f,\r\n", maxVoltage-minVoltage);
        wait_us(100000);
        
    }
}
*/

/*
//Oppgave 4 med VV
DigitalOut Vcc(PA_0);
AnalogIn aInn(PA_1);
DigitalOut Gnd(PA_4);

AnalogOut aOut(PA_5);

int main(){

    Vcc = 1;
    Gnd = 0;

    while(1){
        aOut = aInn;
    }
}
*/

/*
//Oppgave 4 med forsøkt med PWM
DigitalOut Vcc(PA_0);
AnalogIn aInn(PA_1);
DigitalOut Gnd(PA_4);

PwmOut aOut(PA_5);

int main(){

    Vcc = 1;
    Gnd = 0;
    aOut.period(0.010);
    while(1){
        aOut = aInn.read();
        wait(0.1);
    }
}
*/
