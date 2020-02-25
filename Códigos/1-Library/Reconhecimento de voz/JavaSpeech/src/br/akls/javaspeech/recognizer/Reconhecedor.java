/*
 * Created on 10/05/2005
 *  
 */
package br.akls.javaspeech.recognizer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.speech.recognition.RuleGrammar;

import br.akls.javaspeech.sintetizer.Sintetizador;

public class Reconhecedor extends ResultAdapter {
	public static Recognizer rec;
	private String url;
	private String gramatica;
	private Command command;
	private Responses response;
	public Reconhecedor(String url, String gram) {
		this.url = url;
		gramatica = gram;
		try {
		response = new Responses();
			
		} catch (IOException e1) {}
	}
	
	public void setCommand(Command com) {
		command = com;
	}
	
	public Command getCommand() {
		return command;
	}

	// Receives RESULT_ACCEPTED event: print it, clean up, exit
	public void resultAccepted(ResultEvent e) {
		Result r = (Result) (e.getSource());
		ResultToken tokens[] = r.getBestTokens();
		String frase = "";
		for (int i = 0; i < tokens.length; i++) {
			frase = frase.concat(tokens[i].getSpokenText() + " ");
		}
	
		System.out.println(frase);
		if(command!=null)
			command.commandSaid(frase);
		
		try {
			response.Resp(frase);
		} catch (IOException e1) {}
		
		
		
		
		if ((tokens[0].getSpokenText()).equals("terminar")) {
			try {
				rec.deallocate();
				System.out.println("SAINDO DO PROGRAMA");
				System.exit(0);
			} catch (Exception exp) {
				System.out.println("Deu pau! " + exp.toString());
			}
		}
		
	}

	public void iniciar() {
		try {
			// Create a recognizer that supports Portuguese.
			rec = Central.createRecognizer(new EngineModeDesc(new Locale("pt",
					"BR")));
			System.out.println("passou 1: " + rec);
			
			rec.allocate();
			System.out.println("passou 2:");
		
			FileReader reader = new FileReader(url+"\\"+gramatica);
            RuleGrammar gram = rec.loadJSGF(reader);
			gram.setEnabled(true);
			System.out.println("passou 3:");
		
			rec.addResultListener(this);

		
			rec.commitChanges();
			System.out.println("passou 4:");
			
			rec.requestFocus();
			rec.resume();
			
		
			
		} catch (Exception e) {
			System.out.println("Reconhecedor - Error 1: " + e.toString());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		String path = new File("").getAbsolutePath();
		Reconhecedor reconhecedor = new Reconhecedor(path, "gramatica.gram");
		reconhecedor.iniciar();
		
	}
}

