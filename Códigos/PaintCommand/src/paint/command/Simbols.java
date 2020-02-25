package paint.command;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Simbols implements NativeKeyListener{
	public int keyboard;
	public String chars = "";
	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		keyboard = key.getKeyCode();
		if(keyboard == NativeKeyEvent.VK_0){
			chars += "0";
		}else{
			if(keyboard == NativeKeyEvent.VK_1){
				chars += "1";
			}
		}
		if(keyboard == NativeKeyEvent.VK_ENTER){
		if(chars.equals("0101")){
			command("0101");
		}else{
		if(chars.equals("0111")){
			command("0111");
		}else{
		if(chars.equals("01010111")){
			command("01010111");
		}else{
		if(chars.equals("101")){
			command("101");
		}
			chars = "";
		}
			
		}
		}
			
		}
		
		}

	@Override
	public void nativeKeyReleased(NativeKeyEvent key) {}

	@Override
	public void nativeKeyTyped(NativeKeyEvent key) {}
	
	//Comandos para cada tipo de desenho
	public void command(String command){
		if(command.equals("0101")){
			chars = "";
			print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			print("■    █      █   █████   █        █         █████  ■");
			print("■    █▄▄ █   █             █        █         █       █   ■");
			print("■    █       █   ▀▀▀▀▀   █        █         █        █   ■");
			print("■     █       █   █▄▄▄▄   ▀▄▄▄ ▀▄▄▄ ▄▄▄▄█  ■");
			print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		}else{
			if(command.equals("0111")){
				chars = "";
				   /*y*/print("                     █▀▄▀▄▀▄▀▄▀▄▀▀█");
				   /*y*/print("                     █                              █");
				   /*y*/print("                 ▄▀    ▀▄▄          ▄▄▀    ▀▄");
						print("            ▄▀            ▄▄ ▀  ▀ ▄▄            ▀▄");
						print("           █                        ██                       █");
						print("            ▀▄       ▀▄                    ▄▀     ▄▀");
						print("                 ▀▄       ▀▄▄▄▄▄▄▀     ▄▀");
						print("                      ▀▄          ▄▄       ▄▀");
						print("                            █▀▀▀▀▀▀█");
						print("                               ▀▄▄▄▄▀");
			}else{
				if(command.equals("01010111")){
					chars = "";
					print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					print("■    █      █   █████   █        █         █████  ■");
					print("■    █▄▄ █   █             █        █         █       █   ■");
					print("■    █       █   ▀▀▀▀▀   █        █         █        █   ■");
					print("■     █       █   █▄▄▄▄   ▀▄▄▄ ▀▄▄▄ ▄▄▄▄█  ■");
					print("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					   /*y*/print("                     █▀▄▀▄▀▄▀▄▀▄▀▀█");
					   /*y*/print("                     █                              █");
					   /*y*/print("                 ▄▀    ▀▄▄          ▄▄▀    ▀▄");
							print("            ▄▀            ▄▄ ▀  ▀ ▄▄            ▀▄");
							print("           █                        ██                       █");
							print("            ▀▄       ▀▄                    ▄▀     ▄▀");
							print("                 ▀▄       ▀▄▄▄▄▄▄▀     ▄▀");
							print("                      ▀▄          ▄▄       ▄▀");
							print("                            █▀▀▀▀▀▀█");
							print("                               ▀▄▄▄▄▀");
				}else{
					if(command.equals("101")){
						chars = "";
						print("                               ▄▀▀▀▀▀▀▀▀▄                     ▄▀▀▀▀▀▀▀▀▄");
						print("                          ▄▀                         ▀▄          ▄▀                          ▀▄");
						print("                     ▄▀                                   ▀▄▄▀                                    ▀▄");
						print("                ▄▀       ▄▄▄▄▄▄   ▄▄▄▄▄▄   ▄▄▄▄▄▄  ▄          ▄                ▀▄");
						print("               █                    ▄▀   █▀▄      █   █                ▀▄▄▀                      █");
						print("               █                ▄▀       █      ▀▄█   █▀▀▀▀          █                          █");
						print("               █            ██▄▄▄▄  █▄▄▄▄█   █▄▄▄▄▄       █                          █");
						print("                ▀▄                                                                                        ▄▀");
						print("                     ▀▄                                                                              ▄▀");
						print("                          ▀▄                                                                   ▄▀");
						print("                               ▀▄                                                         ▄▀");
						print("                                    ▀▄                                               ▄▀");
						print("                                         ▀▄                                      ▄▀");
						print("                                              ▀▄                            ▄▀");
						print("                                                  ▀▄                    ▄▀");
						print("                                                       ▀▄          ▄▀");
						print("                                                            ▀▄▄▀");
					}
				}
			}
		}
		
		
		
	}
	//Funcao que identifica e escreve os caracteres
	public void paintString(char paint){
		
		
		try {
			Robot write = new Robot();
			
			if(paint == '■'){
				write.keyPress(KeyEvent.VK_ALT);
				write.keyPress(KeyEvent.VK_NUMPAD2);
				write.keyRelease(KeyEvent.VK_NUMPAD2);
				write.keyPress(KeyEvent.VK_NUMPAD5);
				write.keyRelease(KeyEvent.VK_NUMPAD5);
				write.keyPress(KeyEvent.VK_NUMPAD4);
				write.keyRelease(KeyEvent.VK_NUMPAD4);
				write.keyRelease(KeyEvent.VK_ALT);
			}else{
				if(paint == ' '){
					write.keyPress(KeyEvent.VK_ALT);
					write.keyPress(KeyEvent.VK_NUMPAD2);
					write.keyRelease(KeyEvent.VK_NUMPAD2);
					write.keyPress(KeyEvent.VK_NUMPAD5);
					write.keyRelease(KeyEvent.VK_NUMPAD5);
					write.keyPress(KeyEvent.VK_NUMPAD5);
					write.keyRelease(KeyEvent.VK_NUMPAD5);
					write.keyRelease(KeyEvent.VK_ALT);
				}else{
					if(paint == '█'){
						write.keyPress(KeyEvent.VK_ALT);
						write.keyPress(KeyEvent.VK_NUMPAD2);
						write.keyRelease(KeyEvent.VK_NUMPAD2);
						write.keyPress(KeyEvent.VK_NUMPAD1);
						write.keyRelease(KeyEvent.VK_NUMPAD1);
						write.keyPress(KeyEvent.VK_NUMPAD9);
						write.keyRelease(KeyEvent.VK_NUMPAD9);
						write.keyRelease(KeyEvent.VK_ALT);
					}else{
						if(paint == '▄'){
							write.keyPress(KeyEvent.VK_ALT);
							write.keyPress(KeyEvent.VK_NUMPAD2);
							write.keyRelease(KeyEvent.VK_NUMPAD2);
							write.keyPress(KeyEvent.VK_NUMPAD2);
							write.keyRelease(KeyEvent.VK_NUMPAD2);
							write.keyPress(KeyEvent.VK_NUMPAD0);
							write.keyRelease(KeyEvent.VK_NUMPAD0);
							write.keyRelease(KeyEvent.VK_ALT);
						}else{
							if(paint == '▀'){
								write.keyPress(KeyEvent.VK_ALT);
								write.keyPress(KeyEvent.VK_NUMPAD2);
								write.keyRelease(KeyEvent.VK_NUMPAD2);
								write.keyPress(KeyEvent.VK_NUMPAD2);
								write.keyRelease(KeyEvent.VK_NUMPAD2);
								write.keyPress(KeyEvent.VK_NUMPAD3);
								write.keyRelease(KeyEvent.VK_NUMPAD3);
								write.keyRelease(KeyEvent.VK_ALT);
							}else{
								if(paint == 'e'){
									write.keyPress(KeyEvent.VK_ENTER);
									write.keyRelease(KeyEvent.VK_ENTER);
								}
							}
							
						}
						
					}
				}
			}
		} catch (AWTException e) {}
		
	}
	
	//Função que identifica e pega caracteres de uma linha toda
	public void print(String characters){
		char[] arrayChars = characters.toCharArray();
		for(int j = 0; j < characters.length(); j++){
			paintString(arrayChars[j]);
		}
		paintString('e');
	}
	
	public Simbols(){
		
	}
	
	public static void main(String[] args){
		try {
            GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
		}
		
		Simbols simb = new Simbols();
		GlobalScreen.getInstance().addNativeKeyListener(simb);
	}

	
}
