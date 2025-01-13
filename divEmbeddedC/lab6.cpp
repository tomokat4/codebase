#include "mbed.h" //MBEDv5


/*
//Oppgave 5

Timeout onTime;
Ticker periodTimer;
DigitalOut led(PA_5);
InterruptIn b1(USER_BUTTON);

float periodTime = 0.020;
float dutyCycle = .05;

void turnLightOff(){
    led=0;
}

void turnLightOn(){
    led=1;
    onTime.attach(&turnLightOff, (float)periodTime*dutyCycle);
}

void knappeTrykk(){
    if (dutyCycle >= 1.0){
        dutyCycle = 0.00;
    }
    dutyCycle = dutyCycle+0.05;
}

int main(){
    printf("LAB6 opg5 er begynt \n");
    b1.fall(&knappeTrykk);
    periodTimer.attach(&turnLightOn, periodTime);

        while(1){
            printf("dutyCycle er %f \n", dutyCycle);
            wait_ms(200);
        }
}
*/

/*
//Oppgave 4

InterruptIn b1(USER_BUTTON);
Timeout timeOutlrq;

int teller = 0;
int flag = 0;

void enableKnappeTrykk(){
    b1.enable_irq();
}

void knappeTrykket(){
    //b1.disable_irq();
    //timeOutlrq.attach(&enableKnappeTrykk, .1);
    teller=teller+1;
    flag=1;
}

int main(){
    printf("LAB6 opg4 startet\n");
    b1.fall(&knappeTrykket);
    while(1){
        if(flag==1){
            flag=0;
            printf("Tallverdi til teller : %d\r\n", teller);
        }
    }
}
*/

/*
//Oppgave 3

Ticker flipper;
DigitalOut led1(PA_5);
InterruptIn butomg(USER_BUTTON);

float halvprd = 0.1;


void flip(){
    led1 = !led1;
}

void buttonPressed(){
    halvprd = halvprd + 0.1f;
    flipper.attach(&flip, halvprd);
}

int main(){
    printf("LAB6 opg3 begynt\n");

    butomg.fall(&buttonPressed);
    led1 = 0;
    flipper.attach(&flip, 0.2);

    while(1){}
}
*/

/*
//oppgave 2
#define MAX 2500
#define MIN 1500

InterruptIn knapp1(USER_BUTTON);
PwmOut servo(PA_7);

void forwardBack();

int main(){
    printf("LAB6 OPG2 startet\n");
    servo.period(0.02);
    servo.pulsewidth_us(1500);
    wait_us(200000);
    knapp1.fall(&forwardBack);
    while(1){
        printf("tekst\n");
        wait_us(200000);
    }
}

void forwardBack(){
    for (int i = 1500; i < 2500; i+=5){
        servo.pulsewidth_us(i);
        wait_us(2000);
    }
    for (int i = 2500; i > 1500; i-=5){
        servo.pulsewidth_us(i);
        wait_us(2000);
    }
}
*/



/* //Oppgave 1
InterruptIn sw1(BUTTON1);

Timer timer;
int flag=0;

void startKlokke(){
    timer.reset();
    timer.start();
}

void stopKlokke(){
    timer.stop();
    flag=1;
}

int main(){

    printf("LAB6 a start\n");

    int sek = 0;

    sw1.fall(&startKlokke);
    sw1.rise(&stopKlokke);
    while(true){
        if (flag==1){
            flag = 0;
            printf("Tid: %.3f sek\r\n", timer.read());
        }
    }
    
    // while(1){
    //     sek=0;
    //     timer.reset();
    //     while(sw1==1){}
    //         timer.start();
    //     while(sw1==0){}
    //         timer.stop();
        
    //     printf("Tid: %.3f sek\r\n", timer.read());
    //     thread_sleep_for(200);
    // }
} */


