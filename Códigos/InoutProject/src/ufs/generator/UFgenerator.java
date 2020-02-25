package ufs.generator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UFgenerator {
	
	private BufferedReader bufferedReader;
	private FileWriter fileWriter;

	public UFgenerator(){}
	
	/*Método gerador de arquivo com hash criadas
	pela interface Inout*/
	//Na string hash fica a hash gerada pelo Inout
	public void generateHash(String fileHash, String hash, String directory) throws IOException{
		String hashFile = fileHash+".hash";
		String dir = directory.trim()+"//"+hashFile;
		File file = new File(dir);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(hash);
		fileWriter.close();
	}
	
	/*Método que faz a leitura do arquivo .hash e retorna
	uma string nela mesmo como a hash que foi capturada*/
	public String getHash(String fileHash, String directory) throws IOException, FileNotFoundException{
		String hashFile = fileHash+".hash";
		String dir = directory.trim()+"//"+hashFile;
		File file = new File(dir);
		FileReader fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String readLine = bufferedReader.readLine();
		bufferedReader.close();
		return readLine;
		
	}
	
	public String getDirInit() throws IOException, InterruptedException{
		Runtime.getRuntime().exec("CMD /c echo %AppData% > appData.txt");
		Thread.sleep(500);
		FileReader fileReader = new FileReader("appData.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String getAppData = bufferedReader.readLine();
		Runtime.getRuntime().exec("CMD /c del appData.txt");
		bufferedReader.close();
		return getAppData;
		
				
	}
	
	
	/*Método gerador de arquivo.out UFS (Unique File Send),
	Arquivos com informações do pc, renomeado com a hash*/
	//Na string name fica o nome do arquivo que seria a hash
	//Na string informations fica as informações capturadas
	public void generateUfs(String name, String informations, String directory) throws IOException{
		String outputFile = name+".out";
		String dir = directory.trim()+"//"+outputFile;
		File file = new File(dir);
		fileWriter = new FileWriter(file);
		fileWriter.write("Informações do pc...\r\n"
				+ informations);
		fileWriter.close();
	}
	

	/*Método gerador de arquivo.in UFR (Unique File Receive),
	Arquivos com códigos executores, renomeado com a hash*/
	//Na string name fica o nome do arquivo que seria a hash
	//Na string informations fica os códigos digitados
	public void generateUfr(String name, String informations, String directory) throws IOException{
		String outputFile = name+".in";
		String dir = directory.trim()+"//"+outputFile;
		File file = new File(dir);
		fileWriter = new FileWriter(file);
		fileWriter.write(informations);
		fileWriter.close();
	}
	
	/*Método que faz a leitura do arquivo .out e lendo 
	 * as informações e retornando nela mesma. 
	 * */
	public String getUFS(String fileUFS, String directory) throws IOException, FileNotFoundException{
		String memory = "";
		String ufsfile = fileUFS+".out";
		String dir = directory.trim()+"//"+ufsfile;
		File file = new File(dir);
		FileReader fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String readLine = bufferedReader.readLine();
		
		while(readLine != null){
			memory += readLine + "<br>";
			readLine = bufferedReader.readLine();
		}
		bufferedReader.close();
		return memory;
		
	}
	
}
