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
	
		
			//Sintetizador.speak("Conexão efetuada!");
			connection = true;
		
			arduino.sendString("ligar led azul");
	/*	while(true){
		
			if((!arduino.notFound) && (connection))
				arduino.sendString("ligar léd azul");
				Sintetizador.speak("ligando léd azul");
				for(int i=0;i<500000;i++){}
				arduino.sendString("desligar léd azul");
				Sintetizador.speak("desligando léd azul");
				for(int i=0;i<500000;i++){}
				
				arduino.sendString("ligar léd verde");
				Sintetizador.speak("ligando léd verde");
				for(int i=0;i<500000;i++){}
				arduino.sendString("desligar léd verde");
				Sintetizador.speak("desligando léd verde");
				for(int i=0;i<500000;i++){}
				
				arduino.sendString("ligar léd laranja");
				Sintetizador.speak("ligando léd laranja");
				for(int i=0;i<300000;i++){}
				arduino.sendString("desligar léd laranja");
				Sintetizador.speak("desligando léd laranja");
				for(int i=0;i<300000;i++){}
		}*/
		
	}
	
	

}
