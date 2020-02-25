package br.akls.javaspeech.sintetizer;

import javax.speech.*;
import javax.speech.synthesis.*;

import br.akls.javaspeech.recognizer.OpenConnection;
 

public class Sintetizador {
	
	public static OpenConnection arduino = null;
	public static String port = "COM3";
	public static boolean connection = false;
	static Synthesizer synthesizer;
	static EngineListener engineListener = new EngineAdapter() {
		public void engineError(EngineErrorEvent e) {
			System.out.println(
				"Engine error: " + e.getEngineError().getMessage());
		}
	};	

	public Sintetizador() {
		try {
			synthesizer = Central.createSynthesizer(null);
			if (synthesizer != null) {
				synthesizer.allocate();
				synthesizer.addEngineListener(engineListener);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void speak(String s) {
		
		if (synthesizer != null) {
			try {
				synthesizer.speak(s, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(s);
		} 
	}
	
	public static void main(String[] args) {
		new Sintetizador();
		arduino = new OpenConnection(port, 9600);
	
		
			//Sintetizador.speak("Conex�o efetuada!");
			connection = true;
		
			arduino.sendString("ligar led azul");
	/*	while(true){
		
			if((!arduino.notFound) && (connection))
				arduino.sendString("ligar l�d azul");
				Sintetizador.speak("ligando l�d azul");
				for(int i=0;i<500000;i++){}
				arduino.sendString("desligar l�d azul");
				Sintetizador.speak("desligando l�d azul");
				for(int i=0;i<500000;i++){}
				
				arduino.sendString("ligar l�d verde");
				Sintetizador.speak("ligando l�d verde");
				for(int i=0;i<500000;i++){}
				arduino.sendString("desligar l�d verde");
				Sintetizador.speak("desligando l�d verde");
				for(int i=0;i<500000;i++){}
				
				arduino.sendString("ligar l�d laranja");
				Sintetizador.speak("ligando l�d laranja");
				for(int i=0;i<300000;i++){}
				arduino.sendString("desligar l�d laranja");
				Sintetizador.speak("desligando l�d laranja");
				for(int i=0;i<300000;i++){}
		}*/
		
	}
	
	

}
