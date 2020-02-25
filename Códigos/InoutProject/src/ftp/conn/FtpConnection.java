package ftp.conn;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpConnection {
	
	public static FTPClient ftp;
	public static boolean connected = false;
	public static String systemCrypt;
	public static String msgConn;
	public static int Connections = 3;
	
	public FtpConnection() throws IOException{
		ftp = new FTPClient();
		FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
		 //        conf.setServerTimeZoneId("America/Denver");
		         ftp.configure(conf);
		         
	    try {
	      int reply;
	      String server = "f15-preview.eohost.com";
	      String user = "2163708";
	      String pass = "1324354657687980sitedoprojeto";
	      ftp.connect(server);
	      System.out.println("Conectado à " + server + ".");
	      System.out.print(ftp.getReplyString());
	      ftp.enterLocalPassiveMode();
	     
	      reply = ftp.getReplyCode();
	      
	      
	      if(FTPReply.isPositiveCompletion(reply)) {
	    	ftp.login(user, pass);
	    	  InetAddress localAddress = ftp.getLocalAddress();
	    	  String status = ftp.getStatus();
	    	 
	    		 System.out.println("O login está correto!");
	    		 System.out.println("Usuário: "+user
	    				 +"\nSenha: "+pass);
	    		System.out.println("Endereço Local: "+localAddress);
	    		System.out.println("status de conexão: \n"
	    				+ "________________________________\n"
	    				+status
	    				+ "________________________________");
	    	
	    	
	      }
	     
	     FTPFile[] files = ftp.listFiles();
	     
	      for(int i = 0;i<files.length;i++){
	    	  System.out.println(files[i].getName());
	      }
	      
	     } catch(IOException e) {
	    	System.err.println("A conexão FTP não foi bem sucedida!\n"
	    			+ "Verifique o host ou a conexão com a internet.");
	    	System.exit(1);
	        ftp.logout();
	        ftp.disconnect();
	        e.printStackTrace();
	    }
	}
	
	/*Method to download files in computer, passing as param the download file, 
	the file renamed and directory*/
	public void download(String download, String renameFileDown, String directory) throws IOException{
		 /*String renameFileDown = "material.php";
	      String download = "materialcode.php";*/
	      
	      FileOutputStream UFR = new FileOutputStream(directory+renameFileDown);
	      if(ftp.retrieveFile(download, UFR)){
	    	  System.out.println("O download de '"+download+"' foi efetuado com sucesso!");
	      }else{
	    	  System.err.println("falha ao efetuar o download de '"+download+"'!");
	      }
	}
	
	/*Method to upload files in server, passing as param the upload file, the file renamed
	and Directory*/
	public void upload(String upload, String renameFileUp, String directory) throws IOException{
		 /*tring renameFileUp = "shutdowns.x";
	      String upload = "shutdown.x";*/
	      
	      FileInputStream UFS = new FileInputStream(directory+upload);
	      if(ftp.storeFile(renameFileUp, UFS)){
	    	  System.out.println("O upload de '"+upload+"' foi efetuado com sucesso!");
	      }else{
	    	  System.out.println("Falha ao efetuar o upload! '"+upload+"'");
	      }
	}
	
	/*Method to get files in directory passed and 
	showing every files in console*/
	public void getFiles(String directory) throws IOException{
		
		 ftp.changeWorkingDirectory(directory);
	      
	      System.out.println("Lista de arquivos: \n");
	      
	      String[] arqs = ftp.listNames();
	      
	      for(String filedir : arqs){
	    	  if(!filedir.contains(".")){
	    		  System.out.println(filedir+" - pasta");
	    	  }else{
	    		  System.out.println(filedir+" - arquivo");
	    	  }
	    	
	      }
	}
	
	public void disconnect() throws IOException{
		if(ftp.isConnected()){
			ftp.logout();
			ftp.disconnect();
		}
	}
	
	/*Method to connect in Server login showing informations
	of localAddress,status and server*/
	public static void serverLogin(String server, String user, String pass) throws IOException{
			
		 ftp = new FTPClient();
		   
		 	
				try {
				      int reply;
				      ftp.connect(server);
				      
				      ftp.enterLocalPassiveMode();
				      
				      reply = ftp.getReplyCode();
				      
				      
				      if(FTPReply.isPositiveCompletion(reply)) {
				    	  boolean login = ftp.login(user, pass);
				    	  InetAddress localAddress = ftp.getLocalAddress();
				    	 
				    	  String status = ftp.getStatus();
				    	 if(login == true){
				    		 Connections = 1;
				    		 System.out.println("O login está correto!");
				    		 System.out.println("Usuário: "+user
				    				 +"\nSenha: "+pass);
				    		System.out.println("Endereço Local: "+localAddress);
				    		System.out.println("status de conexão: \n"
				    				+ "________________________________\n"
				    				+status
				    				+ "________________________________");
				    		
				    	 }else{
				    		 Connections = 0;
				    		 System.err.println("O login está incorreto!tente novamente!");
				    	 }
				    	
				      }
				      
				      
				    } catch(IOException e) {
				    	
				    	msgConn = "Connectado à " + systemCrypt + ".";
				    	System.err.println("A conexão FTP não foi bem sucedida!\n"
				    			+ "Verifique o host ou a conexão com a internet.");
				    	System.exit(1);
				        ftp.logout();
				        ftp.disconnect();
				        e.printStackTrace();
				    }
				
			}
	
		     
	/*public static void main(String[] args) throws IOException{
		
		
			System.out.println("Conectando ftp...");
			serverLogin("f15-preview.eohost.com", "2163708", "1324354657687980sitedoprojeto");
		
	*/
	
}
	
	

