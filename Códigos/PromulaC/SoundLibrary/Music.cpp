#include <conio.h>
#include "sound.h"

int main()
{
    printf("Utilizando Biblioteca sound.h ...");

    BPM(60);
    Compass("QUARTERNARY");
    
    Scale("MINOR", "ASC", _SM);
    Scale("MINOR", "DES", _C);
    Scale("MAJOR", "ASC", _SM);
    Scale("MAJOR", "DES", _C);
    Scale("CHROMATIC", "ASC", _SC);
    Scale("CHROMATIC", "DES", _SC);

    int quant = QuantTones();
    
    printf("\nForam tocadas %d notas!\n", quant);
    getch();
}
