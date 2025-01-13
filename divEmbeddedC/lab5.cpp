#include "mbed.h"

/* //Oppgave 1
Serial pc(USBTX, USBRX);

int main(){
    printf("LAB5 Oppgave 1 begynt\n");
    while(1){
        //pc.putc(pc.getc());
        pc.putc(pc.getc()+1); //her legger den til 1 på hexadesimale asciverdien på input?
    }
}
*/

/* //Oppgave 2
Serial serial3(PB_9, PB_8);
Serial pcTerminal(USBTX, USBRX);

void fromSerialToPc();
void fromPcToSerial();

int main(){
    pcTerminal.printf("LAB5 Oppgave 2 begynt\n");
    while(1){
        fromPcToSerial();
        fromSerialToPc();
        wait_ms(500);
    }
}

void fromSerialToPc(){
    pcTerminal.putc(serial3.getc());
}

void fromPcToSerial(){
    serial3.putc(pcTerminal.getc());
}
*/

/*
//Oppgave 3

Serial serial3(PB_9, PB_8);
Serial pcTerminal(USBTX, USBRX);

void fromSerialToPc();
void fromPcToSerial();

int main(){
    pcTerminal.printf("LAB5 Oppgave 3 Nucleokort 2 begynt\n");
    char data1;
    char data2;

    while(1){
        if(pcTerminal.readable()){
            data1 = pcTerminal.getc();
            serial3.putc(data1);
            printf("Local data %c\n", data1);
        }
        if(serial3.readable()){
            data2 = serial3.getc();
            printf("Remote data %c\n", data2);
        }
    }
}

void fromSerialToPc(){
    pcTerminal.putc(serial3.getc());
}

void fromPcToSerial(){
    serial3.putc(pcTerminal.getc());
}
*/

/*
//Oppgave 4

#define maksAntall 119

I2C i2cBus(PB_9, PB_8);
Serial pc(USBTX, USBRX);

int main(){
    i2cBus.frequency(100000);

    printf("LAB5 oppgave 4 begynt\n");

    int i2cAddress=0x0;
    // int i2c8BitAddress=i2cAddress << 1;

    for(int index = 3; index <= maksAntall; index++){
        i2cAddress = index;
        int i2c8BitAddress=i2cAddress << 1;
        int results=i2cBus.write(i2c8BitAddress, NULL, 0);
        if (results==0){
            printf("I2C device found at address 0x%X    \r\n", i2cAddress);
    }
        if (results==1){
            printf("I2C device not found at address 0x%X    \r\n", i2cAddress);
    }
   printf("Search finished\n");
}
}
*/

/*
//Oppgave 4 +

I2C TMP102(PB_9, PB_8);
Serial pc(USBTX, USBRX);

const int addr = 0x90;
char config_t[3];
char temp_read[2];
float temperatur;

int main(){
    
    printf("LAB5 oppgave 4 begynt\n");

    config_t[0] = 0x01;
    config_t[1] = 0x60;
    config_t[2] = 0xA0;
    TMP102.write(addr, config_t, 3);
    config_t[0]=0x00;
    TMP102.write(addr, config_t, 1);

    int temperaturTmp;
    int absTemperatur;
    float conversionFactor = 0.0625;

    while(1){
        wait(1);
        TMP102.read(addr, temp_read, 2);
        temperaturTmp = temp_read[0] << 8;
        absTemperatur = temperaturTmp + temp_read[1];
        temperatur = conversionFactor*(absTemperatur >> 4);

        pc.printf("Temp = %.2f degC\r\n", temperatur);
    }
}

*/
