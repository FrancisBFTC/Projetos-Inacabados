package suzy;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SuzyNature extends JFrame{
	public JLabel labelImg;
	public boolean mudançaCor = false;
	public boolean green = false;
	public boolean white = false;
	public boolean blue = false;
	public boolean red = false;
	public static void main(String[] girl){
		SuzyNature suzy = new SuzyNature();
		suzy.setVisible(true);
		
	}
	
	public SuzyNature(){
		this.setBounds(500, 200, 400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("A natureza da suzy");
		
		JLabel labelPanel = new JLabel();
		labelPanel.setText("<html><div width='400' height='500' style='background-color:#00ffff;'></div></html>");
		labelPanel.setBounds(500, 150, 400, 500);
		JPanel panel = new JPanel();
		this.add(panel);
		panel.add(labelPanel);
		
		//ícones menus
		ImageIcon simbolRoupa = new ImageIcon(getClass().getResource("/simbolos/roupa.jpg"));
		//menina
		ImageIcon menina1 = new ImageIcon(getClass().getResource("/menina/menina1.jpg"));
		ImageIcon menina2 = new ImageIcon(getClass().getResource("/menina/menina2.jpg"));
		ImageIcon menina3 = new ImageIcon(getClass().getResource("/menina/menina3.jpg"));
		ImageIcon menina4 = new ImageIcon(getClass().getResource("/menina/menina4.jpg"));
		
		//menina conversando
		ImageIcon meninaConv1 = new ImageIcon(getClass().getResource("/conversando/meninaConvBranco1.jpg"));
		ImageIcon meninaConv2 = new ImageIcon(getClass().getResource("/conversando/meninaConvBranco2.jpg"));
		ImageIcon meninaConv3 = new ImageIcon(getClass().getResource("/conversando/meninaConvBranco3.jpg"));
		ImageIcon meninaConv4 = new ImageIcon(getClass().getResource("/conversando/meninaConvBranco4.jpg"));
		
		//menina piscando
		ImageIcon piscBranco1 = new ImageIcon(getClass().getResource("/piscando/pisc1.jpg"));
		ImageIcon piscBranco2 = new ImageIcon(getClass().getResource("/piscando/pisc2.jpg"));
		ImageIcon piscBranco3 = new ImageIcon(getClass().getResource("/piscando/pisc3.jpg"));
		ImageIcon piscBranco4 = new ImageIcon(getClass().getResource("/piscando/pisc4.jpg"));
		ImageIcon piscAzul1 = new ImageIcon(getClass().getResource("/piscando/piscAzul1.jpg"));
		ImageIcon piscAzul2 = new ImageIcon(getClass().getResource("/piscando/piscAzul2.jpg"));
		ImageIcon piscAzul3 = new ImageIcon(getClass().getResource("/piscando/piscAzul3.jpg"));
		ImageIcon piscAzul4 = new ImageIcon(getClass().getResource("/piscando/piscAzul4.jpg"));
		ImageIcon piscVerde1 = new ImageIcon(getClass().getResource("/piscando/piscVerde1.jpg"));
		ImageIcon piscVerde2 = new ImageIcon(getClass().getResource("/piscando/piscVerde2.jpg"));
		ImageIcon piscVerde3 = new ImageIcon(getClass().getResource("/piscando/piscVerde3.jpg"));
		ImageIcon piscVerde4 = new ImageIcon(getClass().getResource("/piscando/piscVerde4.jpg"));
		ImageIcon piscVermelho1 = new ImageIcon(getClass().getResource("/piscando/piscVermelho1.jpg"));
		ImageIcon piscVermelho2 = new ImageIcon(getClass().getResource("/piscando/piscVermelho2.jpg"));
		ImageIcon piscVermelho3 = new ImageIcon(getClass().getResource("/piscando/piscVermelho3.jpg"));
		ImageIcon piscVermelho4 = new ImageIcon(getClass().getResource("/piscando/piscVermelho4.jpg"));
		
		labelImg = new JLabel();
		labelImg.setIcon(menina1);;
		labelImg.setBounds(25, 60, 350, 400);
		labelPanel.add(labelImg);
		
		//Simbolo roupa
		JLabel roupa = new JLabel();
		roupa.setIcon(simbolRoupa);
		roupa.setBounds(2, 0, 150, 50);
		labelPanel.add(roupa);
		
		JLabel painelSimbolos = new JLabel();
		painelSimbolos.setText("<html><div width='300' height='50' bgcolor='white'></div></html>");
		painelSimbolos.setBounds(30, 45, 300, 20);
		painelSimbolos.setVisible(false);
		labelPanel.add(painelSimbolos);
		
		JLabel colorGreen = new JLabel();
		colorGreen.setText("<html><div width='50' height='15' bgcolor='green'></div></html>");
		colorGreen.setBounds(5, 2, 20, 16);
		painelSimbolos.add(colorGreen);
		
		JLabel colorRed = new JLabel();
		colorRed.setText("<html><div width='50' height='15' bgcolor='red'></div></html>");
		colorRed.setBounds(30, 2, 20, 16);
		painelSimbolos.add(colorRed);
		
		JLabel colorBlue = new JLabel();
		colorBlue.setText("<html><div width='50' height='15' bgcolor='blue'></div></html>");
		colorBlue.setBounds(55, 2, 20, 16);
		painelSimbolos.add(colorBlue);
		
		JLabel colorWhite1 = new JLabel();
		colorWhite1.setText("<html><div width='50' height='15' bgcolor='black'></div></html>");
		colorWhite1.setBounds(80, 2, 20, 16);
		painelSimbolos.add(colorWhite1);
		
		JLabel colorWhite = new JLabel();
		colorWhite.setText("<html><div width='18' height='13' bgcolor='white'></div></html>");
		colorWhite.setBounds(1, 2, 18, 13);
		colorWhite1.add(colorWhite);
		
		colorRed.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				red = true;
				green = false;
				blue = false;
				white = false;
				mudançaCor = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		colorBlue.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				red = false;
				green = false;
				blue = true;
				white = false;
				mudançaCor = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		colorGreen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				red = false;
				green = true;
				blue = false;
				white = false;
				mudançaCor = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		colorWhite1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				red = false;
				green = false;
				blue = false;
				white = true;
				mudançaCor = true;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
				
		roupa.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				painelSimbolos.setVisible(true);
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
				
		new Thread(new Runnable(){
			@Override
			public void run(){
				
				for(int thread = 1; thread <= 3; thread++){
					if(thread == 1){
						
						//Primeira Thread
						new Thread(new Runnable(){
							@Override
							public void run(){
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {}
								for(int a = 1; a <= 45; a++){
									try {
										Thread.sleep(70);
									} catch (InterruptedException e) {}
									
									if(a == 1){labelImg.setIcon(menina1);}
									if(a == 2){labelImg.setIcon(menina2);}
									if(a == 3){labelImg.setIcon(menina3);}
									if(a == 4){labelImg.setIcon(menina4);}
									if(a == 5){labelImg.setIcon(menina3);}
									if(a == 6){labelImg.setIcon(menina2);}
									if(a == 7){labelImg.setIcon(menina3);}
									if(a == 8){labelImg.setIcon(menina4);}
									if(a == 9){labelImg.setIcon(menina3);}
									if(a == 10){labelImg.setIcon(menina2);}
									if(a == 11){labelImg.setIcon(menina4);}
									if(a == 12){labelImg.setIcon(menina2);}
									if(a == 13){labelImg.setIcon(menina1); 
									try {
										Thread.sleep(250);
									} catch (InterruptedException e) {}}
									if(a == 14){labelImg.setIcon(menina2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 15){labelImg.setIcon(menina4);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}				
									if(a == 16){labelImg.setIcon(menina2);
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {}}
									if(a == 17){labelImg.setIcon(menina1);
									try {
										Thread.sleep(200);
									} catch (InterruptedException e) {}}
									if(a == 18){labelImg.setIcon(meninaConv2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 19){labelImg.setIcon(meninaConv3);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 20){labelImg.setIcon(meninaConv4);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 21){labelImg.setIcon(meninaConv3);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 22){labelImg.setIcon(meninaConv4);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 23){labelImg.setIcon(meninaConv3);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 24){labelImg.setIcon(meninaConv2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 25){labelImg.setIcon(meninaConv3);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 26){labelImg.setIcon(meninaConv2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 27){labelImg.setIcon(meninaConv4);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 28){labelImg.setIcon(meninaConv3);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 29){labelImg.setIcon(meninaConv2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 30){labelImg.setIcon(meninaConv4);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 31){labelImg.setIcon(meninaConv2);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {}}
									if(a == 32){labelImg.setIcon(meninaConv4);
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {}}
									if(a == 33){labelImg.setIcon(menina1);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 34){labelImg.setIcon(menina1);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 35){labelImg.setIcon(menina2);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 36){labelImg.setIcon(menina3);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 37){labelImg.setIcon(menina4);}
									if(a == 38){labelImg.setIcon(menina3);}
									if(a == 39){labelImg.setIcon(menina4);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 40){labelImg.setIcon(menina3);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 41){labelImg.setIcon(menina2);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 42){labelImg.setIcon(menina3);
									try {
										Thread.sleep(80);
									} catch (InterruptedException e) {}}
									if(a == 43){labelImg.setIcon(menina2);}
									if(a == 44){labelImg.setIcon(menina3);}
									if(a == 45){labelImg.setIcon(menina4);
									try {
										Thread.sleep(250);
									} catch (InterruptedException e) {}}
								}
							}
						}).start();
						
					}
					
					if(thread == 2){
						
						while(mudançaCor == false){
							
							for(int b = 1; b <= 26; b++){
								
								if(mudançaCor==true){break;}
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {}
								if(b == 1){labelImg.setIcon(piscBranco4);}
								if(b == 2){labelImg.setIcon(piscBranco3);}
								if(b == 3){labelImg.setIcon(piscBranco2);}
								if(b == 4){labelImg.setIcon(piscBranco1);
								if(mudançaCor==true){break;}
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								if(b == 5){labelImg.setIcon(piscBranco4);}
								if(b == 6){labelImg.setIcon(piscBranco3);}
								if(b == 7){labelImg.setIcon(piscBranco2);}
								if(b == 8){labelImg.setIcon(piscBranco1);
								if(mudançaCor==true){break;}
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								if(b == 9){labelImg.setIcon(piscBranco4);}
								if(b == 10){labelImg.setIcon(piscBranco3);}
								if(b == 11){labelImg.setIcon(piscBranco2);}
								if(b == 12){labelImg.setIcon(piscBranco1);
								if(mudançaCor==true){break;}
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								if(mudançaCor==true){break;}
								if(b == 13){labelImg.setIcon(meninaConv1);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {}}
								if(b == 14){labelImg.setIcon(meninaConv2);}
								if(b == 15){labelImg.setIcon(meninaConv3);}
								if(b == 16){labelImg.setIcon(meninaConv4);}
								if(b == 17){labelImg.setIcon(meninaConv3);}
								if(b == 18){labelImg.setIcon(meninaConv2);}
								if(b == 19){labelImg.setIcon(meninaConv3);}
								if(b == 20){labelImg.setIcon(meninaConv4);}
								if(b == 21){labelImg.setIcon(meninaConv3);}
								if(b == 22){labelImg.setIcon(meninaConv2);}
								if(b == 23){labelImg.setIcon(meninaConv3);}
								if(b == 24){labelImg.setIcon(meninaConv4);}
								if(b == 25){labelImg.setIcon(meninaConv4);}
								if(b == 26){labelImg.setIcon(meninaConv4);}
							}
						}
					}
					
					if(thread == 3){
						while(true){
						if(green == true){
							while(green){
								for(int c = 0; c <= 12; c++){
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {}
								if(c == 1){labelImg.setIcon(piscVerde4);}
								if(c == 2){labelImg.setIcon(piscVerde3);}
								if(c == 3){labelImg.setIcon(piscVerde2);}
								if(c == 4){labelImg.setIcon(piscVerde1);
							
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								if(c == 5){labelImg.setIcon(piscVerde4);}
								if(c == 6){labelImg.setIcon(piscVerde3);}
								if(c == 7){labelImg.setIcon(piscVerde2);}
								if(c == 8){labelImg.setIcon(piscVerde1);
								
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								if(c == 9){labelImg.setIcon(piscVerde4);}
								if(c == 10){labelImg.setIcon(piscVerde3);}
								if(c == 11){labelImg.setIcon(piscVerde2);}
								if(c == 12){labelImg.setIcon(piscVerde1);
								
								try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {}}
								}
								
							}
						}
						if(red == true){
							while(red){
								
								for(int d = 0; d <= 12; d++){
									try {
										Thread.sleep(100);
									} catch (InterruptedException e) {}
									if(d == 1){labelImg.setIcon(piscVermelho4);}
									if(d == 2){labelImg.setIcon(piscVermelho3);}
									if(d == 3){labelImg.setIcon(piscVermelho2);}
									if(d == 4){labelImg.setIcon(piscVermelho1);
								
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {}}
									if(d == 5){labelImg.setIcon(piscVermelho4);}
									if(d == 6){labelImg.setIcon(piscVermelho3);}
									if(d == 7){labelImg.setIcon(piscVermelho2);}
									if(d == 8){labelImg.setIcon(piscVermelho1);
									
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {}}
									if(d == 9){labelImg.setIcon(piscVermelho4);}
									if(d == 10){labelImg.setIcon(piscVermelho3);}
									if(d == 11){labelImg.setIcon(piscVermelho2);}
									if(d == 12){labelImg.setIcon(piscVermelho1);
									
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e) {}}
									}
								
								
							}
						}
						if(blue == true){
							while(blue){
								
								for(int f = 0; f <= 12; f++){
									try {
										Thread.sleep(100);
									} catch (InterruptedException e1) {}
									if(f == 1){labelImg.setIcon(piscAzul4);}
									if(f == 2){labelImg.setIcon(piscAzul3);}
									if(f == 3){labelImg.setIcon(piscAzul2);}
									if(f == 4){labelImg.setIcon(piscAzul1);
								
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e1) {}}
									if(f == 5){labelImg.setIcon(piscAzul4);}
									if(f == 6){labelImg.setIcon(piscAzul3);}
									if(f == 7){labelImg.setIcon(piscAzul2);}
									if(f == 8){labelImg.setIcon(piscAzul1);
									
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e1) {}}
									if(f == 9){labelImg.setIcon(piscAzul4);}
									if(f == 10){labelImg.setIcon(piscAzul3);}
									if(f == 11){labelImg.setIcon(piscAzul2);}
									if(f == 12){labelImg.setIcon(piscAzul1);
									
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e1) {}}
									}
								
								
							}
						}
						if(white == true){
							while(white){
								
								
							}
						}
						}
					}
					
				
				}//Final loop thread
			}
		}).start();
		
		
		
		
		
		
	
		
		
		
		
	}
}
