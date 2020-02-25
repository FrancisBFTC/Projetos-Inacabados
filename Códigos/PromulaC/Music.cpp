#include <conio.h>
#include "sound.h"

int main()
{
printf("Utilizando Biblioteca sound.h ...");

BPM(120);
Compass("BINARY");

int times = 1000;

Play('C', times);
Play('E', times);
Play('D', times);
Play('F', times);
Play('E', times);
Play('G', times);
Play('F', times);
Play('A', times);
Play('G', times);
Play('B', times);
Play('C', times);

getch();
}
