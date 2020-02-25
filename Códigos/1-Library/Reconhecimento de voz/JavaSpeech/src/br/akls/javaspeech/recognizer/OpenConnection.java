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
   * @param portaCOM - Porta COM que ser� utilizada para enviar os dados para o arduino
   * @param taxa - Taxa de transfer�ncia da porta serial geralmente � 9600
   */
  public OpenConnection(String portaCOM, int taxa) {
    this.portaCOM = portaCOM;
    this.taxa = taxa;
    this.initialize();
  }     
 
  /**
   * M�doto que verifica se a comunica��o com a porta serial est� ok
   */
  private void initialize() {
	 
    try {
      //Define uma vari�vel portId do tipo CommPortIdentifier para realizar a comunica��o serial
      CommPortIdentifier portId = null;
      try {
        //Tenta verificar se a porta COM informada existe
        portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
        notFound = false;
      }catch (NoSuchPortException npe) {
        //Caso a porta COM n�o exista ser� exibido um erro 
        JOptionPane.showMessageDialog(null, "Porta "+this.portaCOM+" n�o foi encontrada.",
                  "Porta COM", JOptionPane.PLAIN_MESSAGE);
    
        notFound = true;
        port.close();
        serialOut.close();
      }
      //Abre a porta COM 
      port = (SerialPort) portId.open("Comunica��o serial", this.taxa);
      serialOut = port.getOutputStream();
      port.setSerialPortParams(this.taxa, //taxa de transfer�ncia da porta serial 
                               SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                               SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                               SerialPort.PARITY_NONE); //receber e enviar dados
    }catch (Exception e) {
      e.printStackTrace();
    }
}
 
  /**
   * M�todo que fecha a comunica��o com a porta serial
   */
  public void close() {
    try {
    	port.close();
        serialOut.close();
        System.out.println("A conex�o foi fechada!");
    }catch (IOException e) {
      JOptionPane.showMessageDialog(null, "N�o foi poss�vel fechar a porta "+this.portaCOM+".",
                "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);

    }
  }
 
  /**
   * m�todo de enviar Strings para o arduino
   */
  public void sendString(String opcao){
    try {
      serialOut.write(opcao.getBytes());//escreve o valor na porta serial para ser enviado
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "N�o foi poss�vel enviar o dado. ",
                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
    
    }
  } 
  
  /**
   * m�todo de enviar Inteiros para o arduino
   */
  public void sendInt(int numbers){
	    try {
	      serialOut.write(numbers);//escreve o valor na porta serial para ser enviado
	    } catch (IOException ex) {
	        JOptionPane.showMessageDialog(null, "N�o foi poss�vel enviar o dado. ",
	                "Enviar dados", JOptionPane.PLAIN_MESSAGE);
	
	    }
	  } 
}
