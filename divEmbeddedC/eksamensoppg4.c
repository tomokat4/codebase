#include <stdio.h>
#include "mbed.h"

AnalogIn vBes(PA_10);
PwmOut dcMotor(PA_6);
DigitalOut led(PB_9);

float bestand;

int main(){
	bestand = vBes.read();
	while(1){
		if(bestand<0.25){
			dcMotor = 0.0;
		}
		if(bestand>0.25 && bestand<0.5){
			dcMotor = 0.5;
		}
		if(bestand>0.5 && bestand<1.01){
			dcMotor = 1.0;
			led = 1;
		}
		wait_ms(10);
		}
}

