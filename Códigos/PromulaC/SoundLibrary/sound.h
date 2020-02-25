#include <iostream>
#include <windows.h>
#include <stdio.h>

#define _SB       1
#define _M        2
#define _SM       4
#define _C        8
#define _SC       16
#define _F        32
#define _SF       64

using namespace std;

int Bpm;
int CompassAtual;
int Sec;
int Cont = 0;

struct Notas{
      int C;
      int D;  
      int E;
      int F;
      int G;
      int A;
      int B; 
      int CS;
      int DS;
      int ES;
      int FS;
      int GS;
      int AS;
      int BS;   
};

int Nota(char *str)
{
     char n;
     Notas nota;
     int sound = 0;
     nota.C  = 273; nota.CS = 290;               
     nota.D  = 310; nota.DS = 327;                       
     nota.E  = 347; nota.ES = 363;                   
     nota.F  = 363; nota.FS = 390;
     nota.G  = 412; nota.GS = 430;
     nota.A  = 462; nota.AS = 483;
     nota.B  = 512; nota.BS = 537;
      
     if(strcmp(str, "C") == 0)
          n = 1;
     else if(strcmp(str, "D") == 0)
          n = 2;
     else if(strcmp(str, "E") == 0)
          n = 3;
     else if(strcmp(str, "F") == 0)
          n = 4;
     else if(strcmp(str, "G") == 0)
          n = 5;
     else if(strcmp(str, "A") == 0)
          n = 6;
     else if(strcmp(str, "B") == 0)
          n = 7;
     else if(strcmp(str, "CS") == 0)
          n = 8;
     else if(strcmp(str, "DS") == 0)
          n = 9;
     else if(strcmp(str, "ES") == 0)
          n = 10;
     else if(strcmp(str, "FS") == 0)
          n = 11;
     else if(strcmp(str, "GS") == 0)
          n = 12;
     else if(strcmp(str, "AS") == 0)
          n = 13;
     else if(strcmp(str, "BS") == 0)
          n = 14; 
                 
     switch(n){
         case 1:  sound = nota.C;
                  break;
         case 2:  sound = nota.D;
                  break;
         case 3:  sound = nota.E;
                  break;
         case 4:  sound = nota.F;
                  break;
         case 5:  sound = nota.G;
                  break;
         case 6:  sound = nota.A;
                  break;
         case 7:  sound = nota.B;
                  break;
         case 8:  sound = nota.CS;
                  break;
         case 9:  sound = nota.DS;
                  break;
         case 10: sound = nota.ES;
                  break;
         case 11: sound = nota.FS;
                  break;
         case 12: sound = nota.GS;
                  break;
         case 13: sound = nota.AS;
                  break;
         case 14: sound = nota.BS;
                  break;
           
     }
     
     return sound;
}


void Play(char *c, int t){
     Sec = 1000;
     t = ((CompassAtual * (Sec / t)) / Bpm);
     Beep(Nota(c), t);
     Cont++;
}

int QuantTones(){
    return Cont;    
}

void BPM(int bpm){
     printf("\nVelocidade da Musica : %d bpm\n", bpm);
     Bpm = (bpm / 60);
}

void Compass(std::string compass){
     if(compass == "BINARY"){
            printf("Musica em compasso Binario!\n");
            CompassAtual = 2;
     }else{
            if(compass == "TERNARY"){
                  printf("Musica em compasso Ternario!\n");
                  CompassAtual = 3;
            }else{
                  if(compass == "QUARTERNARY"){
                       printf("Musica em compasso Quarternario!\n");
                       CompassAtual = 4;
                  }
            }
     }
}

void Scale(char *type, char *order, int time){
     printf("\nRitmo da Escala : %d/%d", time, CompassAtual);
     if(strcmp(order, "ASC") == 0){
         if(strcmp(type, "CHROMATIC") == 0){
               Play("C", time);
               Play("CS", time);
               Play("D", time);
               Play("DS", time);
               Play("E", time);
               Play("F", time);
               Play("FS", time);
               Play("G", time);
               Play("GS", time);
               Play("A", time);
               Play("AS", time);
               Play("B", time);
               Play("C", time);         
         }else{
               if(strcmp(type, "MAJOR") == 0){
                       Play("C", time);
                       Play("D", time);
                       Play("E", time);
                       Play("F", time);
                       Play("G", time);
                       Play("A", time);
                       Play("B", time);
                       Play("C", time);                    
               }else{
                     if(strcmp(type, "MINOR") == 0){
                         Play("C", time);
                         Play("D", time);
                         Play("DS", time);
                         Play("F", time);
                         Play("G", time);
                         Play("GS", time);
                         Play("AS", time);
                         Play("C", time);                          
                     }      
               }      
         } 
     }
     
     if(strcmp(order, "DES") == 0){
         if(strcmp(type, "CHROMATIC") == 0){
                Play("C", time);
                Play("B", time);
                Play("AS", time);
                Play("A", time);
                Play("GS", time);
                Play("G", time);
                Play("FS", time);
                Play("F", time);
                Play("E", time);
                Play("DS", time);
                Play("D", time);
                Play("CS", time);
                Play("C", time);         
         }else{
               if(strcmp(type, "MAJOR") == 0){
                       Play("C", time); 
                       Play("B", time);
                       Play("A", time);
                       Play("G", time);
                       Play("F", time);
                       Play("E", time);
                       Play("D", time);
                       Play("C", time);                    
               }else{
                     if(strcmp(type, "MINOR") == 0){
                         Play("C", time);
                         Play("AS", time);
                         Play("GS", time);
                         Play("G", time);
                         Play("F", time);
                         Play("DS", time);
                         Play("D", time);
                         Play("C", time);
                     }      
               }      
         }          
     }
}
