package br.akls.javaspeech.recognizer;

import java.io.IOException;

import br.akls.javaspeech.sintetizer.Sintetizador;

public class Responses {
	
	
	private int var1 = 0, var2 = 0;
	public int result;
	private boolean resultBool;
	private int resultAux;
	private String[] ft = new String[3];
	public Responses() throws IOException{
		new Sintetizador();
	}
	
	public void Resp(String mensages) throws IOException{
		
		
		if(mensages.contains("Ol�"))
			Sintetizador.speak("Ol�, como vai?");
		else if(mensages.contains("Ea�"))
			Sintetizador.speak("Ea� cara, como est�?");
		else if(mensages.contains("Oi"))
			Sintetizador.speak("Oi");
		else if(mensages.contains("Como vai"))
			Sintetizador.speak("Eu vou bem e vo��?");
		else if(mensages.contains("Oi Como vai"))
			Sintetizador.speak("Oi, Estou bem e vo��?");
		else if(mensages.contains("Como est�"))
			Sintetizador.speak("Ol�, Estou bem e vo��?");
		
		if(mensages.contains("Vou bem e vo��"))
			Sintetizador.speak("Que bom, estou bem.");
		if(mensages.contains("B�rnard"))
			Sintetizador.speak("O que o senhor manda");
		if(mensages.contains("Estou bem"))
			Sintetizador.speak("Muito bom, continue assim.");
		if(mensages.contains("Pode fazer uma coisa pra mim"))
			Sintetizador.speak("Sim, pode dizer!");
		
		if(mensages.contains("Obrigado"))
			Sintetizador.speak("de nada");
		
		if(mensages.contains("Qual � o seu nome") || mensages.contains("Me diga seu nome") || 
				mensages.contains("Fale o seu nome") || mensages.contains("Como se chama") ||
				mensages.contains("e o seu nome"))
			Sintetizador.speak("Meu nome � B�rnard");
		
		if(mensages.contains("Qual � a sua idade") || mensages.contains("Quantos anos") || 
				mensages.contains("Vo�� tem") || mensages.contains("anos e vo��") ||
				mensages.contains("anos e a sua"))
			Sintetizador.speak("Eu fui criado dia 13 de outubro de 2018 e vo��?");
		
		
		String code = "";
		String process = "";
		String processClose = "";
		String action = "";
		String programa = "";
		if(mensages.contains("abrir")){
			process = mensages.substring(mensages.indexOf("abrir")+5, mensages.length());
			code = "start";
			action = "abrir";
			
		}else{
			
			if(mensages.contains("fechar")){
				action = "fechar";
				process = mensages.substring(mensages.indexOf("fechar")+5, mensages.length());
				code = "taskkill -f -im";
			}
		}
		
		if(process.contains("bloco de notas")){
			process = "notepad.exe";
			processClose = "notepad.exe";
			programa = "bloco de notas";
		}
		if(process.contains("g�gou")){
			process = "www.google.com.br";
			processClose = "chrome.exe";
			programa = "g�gou";
		}
		if(process.contains("f�icibuk")){
			process = "www.facebook.com.br";
			processClose = "chrome.exe";
			programa = "f�icibuk";
		}
		if(process.contains("eclipse")){
			process = "C:\\Users\\Cida\\Desktop\\Eclipse.lnk";
			processClose = "eclipse.exe";
			programa = "Eclipse";
		}
		if(process.contains("t�r")){
			process = "C:\\Users\\Cida\\Desktop\\StartTorBrowser.lnk";
			processClose = "firefox.exe";
			programa = "T�r Br�uzer";
		}
		if(process.contains("ut�urent")){
			process = "C:\\Users\\Cida\\AppData\\Roaming\\uTorrent\\uTorrent.exe";
			processClose = "uTorrent.exe";
			programa = "ut�urent";
		}
		if(process.contains("arduino")){
			process = "C:\\Users\\Cida\\Desktop\\Arduino.lnk";
			processClose = "arduino.exe";
			programa = "arduino";
		}
		if(process.contains("imvu")){
			process = "C:\\Users\\Cida\\AppData\\Roaming\\IMVUClient\\IMVUQualityAgent.exe";
			processClose = "IMVUClient.exe";
			Runtime.getRuntime().exec("CMD /c taskkill -f -im IMVUQualityAgent.exe");
			programa = "imvu na �rea de trabalho.";
		}
		if(process.contains("saite imvu")){
			process = "https://pt.secure.imvu.com/welcome/login/";
			processClose = "chrome.exe";
			programa = "saite imvu";
		}
		if(process.contains("i� ueive")){
			process = "C:\\Users\\Cida\\Desktop\\YouWaveAndroid.lnk";
			processClose = "YouWaveAndroid.exe";
			programa = "i� ueive";
		}
		if(process.contains("i� tube")){
			process = "www.youtube.com.br";
			processClose = "chrome.exe";
			programa = "i� tube";
		}
		if(process.contains("word")){
			process = "C:\\Users\\Cida\\Desktop\\things\\MicrosoftOfficeWord2007.lnk";
			processClose = "WINWORD.exe";
			programa = "Maicros�ft Uord";
		}
		if(action.equals("abrir")){
			Sintetizador.speak("Abrindo "+programa);
			try {
				Runtime.getRuntime().exec("CMD /c "+code+" "+process);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			if(action.equals("fechar")){
				Sintetizador.speak("Fechando "+programa);
				try {
					Runtime.getRuntime().exec("CMD /c "+code+" "+processClose);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(mensages.contains("Quanto que � ") || mensages.contains("calcule") || mensages.contains("vezes")
				|| mensages.contains("mais") || mensages.contains("menos") || mensages.contains("dividido") 
				|| mensages.contains("� menor que") || mensages.contains("� maior que") || mensages.contains("� diferente de")
				|| mensages.contains("� igual a")){
			int j = 0;
			int k = 0;
			
			if(mensages.contains("Quanto que � "))
				k = 13;
			else if(mensages.contains("calcule"))
				k = 8;
			else 
				k = 0;
			char[] charac = mensages.toCharArray();
			for(int n = 0; n < ft.length; n++){
				ft[n] = "0";
			}
			for(int i = k; i < charac.length; i++){
				if((charac[i]>='0') && (charac[i]<='9')){
					ft[j] += charac[i];
					ft[j] = ft[j].replace("null", "");
					
				}
			
				if((charac[i]=='e') && (charac[i-1]==' ') && (charac[i+1]==' ')){
					j = j + 1;
				}
				
				if(charac[i]=='m' || charac[i]=='v' || charac[i]=='d'){
					for(int n = 0; n < ft.length; n++){
						var1 = var1 + Integer.parseInt(ft[n]);
						ft[n] = "0";
					}
					j = 0;
					
				}
				
			}
			
			for(int n = 0; n < ft.length; n++){
				var2 = var2 + Integer.parseInt(ft[n]);
				ft[n] = "0";
			}
		
			
			if(mensages.contains(" mais ")){
				resultAux = result;
				if(!mensages.contains("resultado mais")){ 
					result = var1 + var2;
					Sintetizador.speak(""+var1+" mais "+var2+" � igual a "+result);
				}else{
					result = result + var2;
					Sintetizador.speak(""+resultAux+" mais "+var2+" � igual a "+result);
				}
			}else{
				if(mensages.contains(" menos ")){
					resultAux = result;
					if(!mensages.contains("resultado menos")){ 
						result = var1 - var2;
						Sintetizador.speak(""+var1+" menos "+var2+" � igual a "+result);
					}else{
						result = result - var2;
						Sintetizador.speak(""+resultAux+" menos "+var2+" � igual a "+result);
					}
				}else{
					if(mensages.contains(" vezes ")){
						resultAux = result;
						if(!mensages.contains("resultado vezes")){ 
							result = var1 * var2;
							Sintetizador.speak(""+var1+" vezes "+var2+" � igual a "+result);
						}else{
							result = result * var2;
							Sintetizador.speak(""+resultAux+" vezes "+var2+" � igual a "+result);
						}
					}else{
						if(mensages.contains(" dividido por ")){
							resultAux = result;
							if(!mensages.contains("resultado")){ 
								result = var1 / var2;
								Sintetizador.speak(""+var1+" dividido por "+var2+" � igual a "+result);
							}else{
								result = result / var2;
								Sintetizador.speak(""+resultAux+" dividido por "+var2+" � igual a "+result);
							}
						}else{
							if(mensages.contains(" � menor que ")){
								if(!mensages.contains("resultado")){ 
									resultBool = var1 < var2;
									if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
									else Sintetizador.speak("condi��o falsa");
								}else{
									resultBool = result < var2;
									if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
									else Sintetizador.speak("condi��o falsa");
								}
								
							}else{
								if(mensages.contains(" � maior que ")){
									if(!mensages.contains("resultado")){ 
										resultBool = var1 > var2;
										if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
										else Sintetizador.speak("condi��o falsa");
									}else{
										resultBool = result > var2;
										if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
										else Sintetizador.speak("condi��o falsa");
									}
									
								}else{
									if(mensages.contains(" � igual a ")){
										if(!mensages.contains("resultado")){ 
											resultBool = var1 == var2;
											if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
											else Sintetizador.speak("condi��o falsa");
										}else{
											resultBool = result == var2;
											if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
											else Sintetizador.speak("condi��o falsa");
										}
										
									}else{
										if(mensages.contains(" � diferente de ")){
											if(!mensages.contains("resultado")){ 
												resultBool = var1 != var2;
												if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
												else Sintetizador.speak("condi��o falsa");
											}else{
												resultBool = result != var2;
												if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
												else Sintetizador.speak("condi��o falsa");
											}
											
										}else{
											if(mensages.contains(" � diferente de ")){
												if(!mensages.contains("resultado")){ 
													resultBool = var1 != var2;
													if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
													else Sintetizador.speak("condi��o falsa");
												}else{
													resultBool = result != var2;
													if(resultBool) Sintetizador.speak("condi��o verdadeira"); 
													else Sintetizador.speak("condi��o falsa");
												}
												
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			var1 = 0;
			var2 = 0;
		}
		
		
	}
}
