package pack.server.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BaseHost {
	
	private static boolean loop = true;
	public static void main(String[] args) throws IOException{
		
		while(loop){
			/*Cria um servidor abrindo conexão com a porta 7171
			*e aguarda uma solicitação de outro servidor
			*/
			ServerSocket server = new ServerSocket(7171);
			Socket socket = server.accept();
			
			//Pega dados em byte recebidos do servidor
			byte[] getData = new byte[socket.getReceiveBufferSize()];
			String hostfile = "hostfile.host";
			
			//Escreve um arquivo com os bytes recebido
			FileOutputStream writeData = new FileOutputStream(hostfile);
			writeData.write(getData);
			
			//fecha conexão do servidor(server) aberto
			writeData.close();
			socket.close();
			server.close();
			
			//Ler os bytes recebidos no arquivo
			FileReader readDatas = new FileReader(hostfile);
            BufferedReader bufferReader = new BufferedReader(readDatas);
            String hostLine = bufferReader.readLine();
            
			//Se for esta solicitação, executa meios apropriados
			//pra chamar os dados da base
            if(hostLine.contains("call data")){
            	loop = false;
            }
			
		}
		
	}
}
