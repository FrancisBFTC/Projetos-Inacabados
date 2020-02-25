package video.software;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VIDSoft extends JFrame{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String getPath = new File("").getAbsolutePath();
	private Toolkit toolkit;
	private Dimension dimension;
	private JPanel panel;
	private JLabel frame;
	Container container;
	private JLabel grave, stop, play, pause;
	private JLabel imgVideo;
	private boolean graveBool, stopBool, playBool, pauseBool;
	private boolean playing = false;
	private int num = 0;
	public VIDSoft(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		
		toolkit = Toolkit.getDefaultToolkit();
		dimension = toolkit.getScreenSize();
		
		this.setBounds(0, 0, dimension.width, dimension.height);
		
		container = new Container();
		container.setLayout(new GridLayout());
		this.getContentPane().add(container);
		
		ImageIcon imgGrave = new ImageIcon(getClass().getResource("/recurses/grave.jpg"));
		ImageIcon imgStop = new ImageIcon(getClass().getResource("/recurses/stop.jpg"));
		ImageIcon imgPlay = new ImageIcon(getClass().getResource("/recurses/play.jpg"));
		ImageIcon imgPause = new ImageIcon(getClass().getResource("/recurses/pause.jpg"));
		
		panel = new JPanel();
		container.add(panel);
		panel.setBackground(Color.black);
		
		frame = new JLabel();
		frame.setBounds(0, 30, dimension.width, dimension.height);
		frame.setText("<html><div style='background:red;width:"+dimension.width+";height:"+dimension.height+";'></div></html>");
		panel.add(frame, Component.CENTER_ALIGNMENT);
		
		grave = new JLabel();
		grave.setBounds(10, 5, 20, 20);
		grave.setToolTipText("Gravar");
		grave.setIcon(imgGrave);
		grave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.add(grave);
		
		stop = new JLabel();
		stop.setBounds(30, 5, 20, 20);
		stop.setToolTipText("Parar");
		stop.setIcon(imgStop);
		stop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.add(stop);
		
		play = new JLabel();
		play.setBounds(50, 5, 20, 20);
		play.setToolTipText("Começar");
		play.setIcon(imgPlay);
		play.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.add(play);
		
		pause = new JLabel();
		pause.setBounds(70, 5, 20, 20);
		pause.setToolTipText("Pausar");
		pause.setIcon(imgPause);
		pause.setCursor(new Cursor(Cursor.HAND_CURSOR));
		frame.add(pause);
		
		imgVideo = new JLabel();
		imgVideo.setBounds(0, 30, dimension.width-5, dimension.height-30);
		frame.add(imgVideo);
		
		actions(grave, stop, play, pause);
		
	}
	
	public void actions(JLabel graves, JLabel stops, JLabel plays, JLabel pauses){
		
		graveBool = false;
		stopBool = true;
		playBool = false;
		pauseBool = false;
		graves.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evn1) {}
			
			@Override
			public void mousePressed(MouseEvent evn1) {
				
				new Thread(new Runnable(){
					@Override
					public void run(){
						graveBool = true;
						stopBool = false;
						pauseBool = false;
						playBool = false;
						graves.setToolTipText("gravando...");
						pauses.setToolTipText("Pausar");
						
						Robot robot;
						BufferedImage bufferImg;
						while(graveBool){
							if(!pauseBool){
								try {
									robot = new Robot();
									bufferImg = robot.createScreenCapture(new Rectangle(0, 0, dimension.width, dimension.height));
									ImageIO.write(bufferImg, "JPEG", new File(getPath+"/screens/#"+num+"screen.JPEG"));
									
								} catch (AWTException e) {} 
								catch (IOException e) {
									e.printStackTrace();
								}
								num++;
							}
							
						}
						num = 0;
						graves.setToolTipText("Gravar");
					}
				}).start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent evn1) {
				graves.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent evn1) {
				graves.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evn1) {}
		});
		
		stops.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evn2) {}
			
			@Override
			public void mousePressed(MouseEvent evn2) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						graveBool = false;
						stopBool = true;
						pauseBool = false;
						playBool = false;
					}
				}).start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent evn2) {
				stops.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent evn2) {
				stops.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent evn2) {}
		});
		
		plays.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evn3) {}
			
			@Override
			public void mousePressed(MouseEvent evn3) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						playBool = true;
						
						if(!playing){
							playing = true;
							if(stopBool){
								
								File files = new File(getPath+"/screens/");
								File arrayFiles[] = files.listFiles();
								int i = 0;
								int j = 0;
								j = arrayFiles.length;
								i = 0;
								ImageIcon video;
								while(i < j){
									if(playBool){
										video = new ImageIcon(getPath+"/screens/#"+i+"screen.JPEG");							
										imgVideo.setIcon(video);
										i++;
										try {
											Thread.sleep(300);
										} catch (InterruptedException e) {}
									}
									
								}
								
								playing = false;
								
							}
						}
						
						
						
					}
				}).start();
			}
			
			@Override
			public void mouseExited(MouseEvent evn3) {
				plays.setBorder(null);
				
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent evn3) {
				plays.setBorder(BorderFactory.createLineBorder(Color.red));
			}
			
			@Override
			public void mouseClicked(MouseEvent evn3) {}
		});
		
		pauses.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent evn4) {}
			
			@Override
			public void mousePressed(MouseEvent evn4) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						pauseBool = true;
						graveBool = true;
						if(playBool){
							playBool = false;
							graveBool = false;
						}else{
							playBool = true;
							graveBool = true;
						}
						
						pauses.setToolTipText("pausado...");
						graves.setToolTipText("Retornar");
					}
				}).start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent evn4) {
				pauses.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent evn4) {
				pauses.setBorder(BorderFactory.createLineBorder(Color.red));
			}
			
			@Override
			public void mouseClicked(MouseEvent evn4) {}
		});
		
	}
	
		public static void main(String[] main){
			VIDSoft VideoWare = new VIDSoft();
			VideoWare.setVisible(true);
		}
}
