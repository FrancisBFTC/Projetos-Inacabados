package br.akls.javaspeech.recognizer;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import br.akls.javaspeech.sintetizer.Sintetizador;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;
 
public class OpenConnection {
  private OutputStream serialOut;
  private int taxa;
  private String portaCOM;
  private SerialPort port;
  public boolean notFound = false;
 
  /**
   * Construtor da classe ControlePorta
   * @param portaCOM - Porta COM que será utilizada para enviar os dados para o arduino
   * @param taxa - Taxa de transferência da porta serial geralmente é 9600
   */
  public OpenConnection(String portaCOM, int taxa) {
    this.portaCOM = portaCOM;
    this.taxa = taxa;
    this.initialize();
  }     
 
  /**
   * Médoto que verifica se a comunicação com a porta serial está ok
   */
  private void initialize() {
	 
    try {
      //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
      CommPortIdentifier portId = null;
      try {
        //Tenta verificar se a porta COM informada existe
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
        notFound = false;
      }catch (NoSuchPortException npe) {
        //Caso a porta COM não exista será exibido um erro 
        JOptionPane.showMessageDialog(null, "Porta "+this.portaCOM+" não foi encontrada.",
                  "Porta COM", JOptionPane.PLAIN_MESSAGE);
    
        notFound = true;
        port.close();
        serialOut.close();
      }
      //Abre a porta COM 
      port = (SerialPort) portId.open("Comunicação serial", this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
    }catch (Exception e) {
      e.printStackTrace();
    }
}
 
  /**
   * Método que fecha a comunicação com a porta serial
   */
  public void close() {
    try {
    	port.close();
        serialOut.close();
        System.out.println("A conexão foi fechada!");
    }catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Não foi possível fechar a porta "+this.portaCOM+".",
                "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);

    }
  }
 
  /**
   * método de enviar Strings para o arduino
   */
  public void sendString(String opcao){
    try {
      serialOut.write(opcao.getBytes());//escreve o valor na porta serial para ser enviado
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
    
    }
  } 
  
  /**
   * método de enviar Inteiros para o arduino
   */
  public void sendInt(int numbers){
	    try {
	      serialOut.write(numbers);//escreve o valor na porta serial para ser enviado
	    } catch (IOException ex) {
	        JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. ",
	                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
	
	    }
	  } 
}
