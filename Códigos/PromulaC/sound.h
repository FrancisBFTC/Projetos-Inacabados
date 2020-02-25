#include <iostream>
#include <windows.h>
#include <stdio.h>


using namespace std;

int Bpm;
int Compass;

struct Notas{
      int C;
      int D;  
      int E;
      int F;
      int G;
      int A;
      int B;     
};

int Nota(char n)
{
     Notas nota;
     int sound = 0;
     nota.C = 265;
     nota.D = 305;
     nota.E = 340;
     nota.F = 360;
     nota.G = 406;
     nota.A = 452;
     nota.B = 500;
     switch(n){
         case 'C': sound = nota.C;
                   break;
         case 'D': sound = nota.D;
                   break;
         case 'E': sound = nota.E;
                   break;
         case 'F': sound = nota.F;
                   break;
         case 'G': sound = nota.G;
                   break;
         case 'A': sound = nota.A;
                   break;
         case 'B': sound = nota.B;
                   break;  
     }
     
     return sound;
}


void Play(char c, int t){
     
     if(Compass == 2){
          switch(t){
          case 1:
          case 2:
          case 3:
                    
          }
     }else{
           if(Compass == 3){
                
           }else{
                 
           }     
     }
     
     //Beep(Nota(c), t);
}

void BPM(int bpm){
     printf("\nVelocidade da Musica : %d bpm\n", bpm);
     Bpm = bpm;
}

void Compass(std::string compass){
     if(compass == "BINARY"){
            printf("Musica em compasso Binario!\n");
            Compass = 2;
     }else{
            if(compass == "TERNARY"){
                  printf("Musica em compasso Ternario!\n");
                  Compass = 3;
            }else{
                  if(compass == "QUARTERNARY"){
                       printf("Musica em compasso Quarternario!\n");
                       Compass = 4;
                  }
            }
     }
}
