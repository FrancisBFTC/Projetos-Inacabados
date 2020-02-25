package db.compile;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class PXDBServer extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path = new File("").getAbsolutePath();
	private String database = "";
	private String table = "";
	private int columns = 0;
	private JLabel typeLabel;
	private JLabel nameLabel;
	private JLabel sizeLabel;
	private JComboBox<String>[] typeBox;
	private JTextField[] nameField;
	private JTextField[] sizeField;
	private JButton saveColumns;
	private String memoryColumns = "";
	private int array = 0;
	private int array1 = 22;
	private String getType = "";
	private String getName = "";
	private String getSize = "";
	
	
	public PXDBServer(){
		
	
		
		this.setBounds(200, 200, 400, 200);
		this.setTitle("PlaxDb Generate Interface");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 200);
		this.add(panel);
		
		JLabel frame = new JLabel();
		frame.setText("<html><div style='width:400;height:200;'></div></html>");
		frame.setBounds(200, 200, 400, 200);
		panel.add(frame);
		
		JLabel databaseLabel = new JLabel();
		databaseLabel.setText("Criar banco de dados");
		databaseLabel.setBounds(20, 20, 150, 20);
		databaseLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		databaseLabel.setForeground(Color.BLUE);
		frame.add(databaseLabel);
		
		JLabel tableLabel = new JLabel();
		tableLabel.setText("Criar tabelas");
		tableLabel.setBounds(20, 50, 150, 20);
		tableLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tableLabel.setForeground(Color.BLUE);
		frame.add(tableLabel);
		
		JLabel columnsLabel = new JLabel();
		columnsLabel.setText("Criar colunas");
		columnsLabel.setBounds(20, 80, 150, 20);
		columnsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		columnsLabel.setForeground(Color.BLUE);
		frame.add(columnsLabel);
		
		JLabel dbLabel = new JLabel();
		dbLabel.setText("Nome:");
		dbLabel.setBounds(180, 20, 70, 20);
		dbLabel.setForeground(Color.black);
		dbLabel.setVisible(false);
		frame.add(dbLabel);
		
		JTextField dbField = new JTextField();
		dbField.setBounds(230, 20, 150, 20);
		dbField.setVisible(false);
		frame.add(dbField);
		
		JButton dbButton = new JButton();
		dbButton.setBounds(300, 50, 70, 20);
		dbButton.setText("Criar");
		dbButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dbButton.setVisible(false);
		frame.add(dbButton);
		
		JComboBox<String> dbSelect = new JComboBox<String>();
		dbSelect.setBounds(230, 20, 150, 20);
		dbSelect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dbSelect.setVisible(false);
		frame.add(dbSelect);
		
		JLabel tbLabel = new JLabel();
		tbLabel.setText("Tabela:");
		tbLabel.setBounds(180, 50, 90, 20);
		tbLabel.setForeground(Color.black);
		tbLabel.setVisible(false);
		frame.add(tbLabel);
		
		JTextField tbField = new JTextField();
		tbField.setBounds(230, 50, 150, 20);
		tbField.setVisible(false);
		frame.add(tbField);
		
		JButton tbButton = new JButton();
		tbButton.setBounds(300, 80, 70, 20);
		tbButton.setText("Criar");
		tbButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tbButton.setVisible(false);
		frame.add(tbButton);
		
		JComboBox<String> tbSelect = new JComboBox<String>();
		tbSelect.setBounds(230, 50, 150, 20);
		tbSelect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		tbSelect.setVisible(false);
		frame.add(tbSelect);
		
		JLabel quantLabel = new JLabel();
		quantLabel.setText("Quant.:");
		quantLabel.setBounds(180, 80, 90, 20);
		quantLabel.setForeground(Color.black);
		quantLabel.setVisible(false);
		frame.add(quantLabel);
		
		JTextField quantField = new JTextField();
		quantField.setBounds(230, 80, 150, 20);
		quantField.setVisible(false);
		frame.add(quantField);
		
		JButton clButton = new JButton();
		clButton.setBounds(300, 110, 70, 20);
		clButton.setText("Gerar");
		clButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clButton.setVisible(false);
		frame.add(clButton);
		
		this.setVisible(true);
		
		databaseLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				databaseLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				databaseLabel.setForeground(Color.green);
				if(dbLabel.isVisible() && dbLabel.getText().equals("Nome:")){
					dbLabel.setText("Nome:");
					dbLabel.setVisible(false);
					dbField.setVisible(false);
					dbButton.setVisible(false);
					dbSelect.setVisible(false);
					tbSelect.setVisible(false);
					tbField.setVisible(false);
					tbLabel.setVisible(false);
					tbButton.setVisible(false);
					quantLabel.setVisible(false);
					quantField.setVisible(false);
					clButton.setVisible(false);
				}else{
					dbLabel.setText("Nome:");
					dbLabel.setVisible(true);
					dbField.setVisible(true);
					dbButton.setVisible(true);
					dbSelect.setVisible(false);
					tbSelect.setVisible(false);
					tbField.setVisible(false);
					tbLabel.setVisible(false);
					tbButton.setVisible(false);
					quantLabel.setVisible(false);
					quantField.setVisible(false);
					clButton.setVisible(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				databaseLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				databaseLabel.setForeground(Color.orange);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		tableLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				tableLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				tableLabel.setForeground(Color.green);
				if(tbLabel.isVisible() && tbLabel.getText().equals("Tabela:")){
					dbLabel.setText("Nome:");
					tbLabel.setText("Tabela:");
					dbLabel.setVisible(false);
					dbField.setVisible(false);
					dbButton.setVisible(false);
					dbSelect.setVisible(false);
					tbSelect.setVisible(false);
					tbField.setVisible(false);
					tbLabel.setVisible(false);
					tbButton.setVisible(false);
					quantLabel.setVisible(false);
					quantField.setVisible(false);
					clButton.setVisible(false);
				}else{
					dbLabel.setText("Banco:");
					tbLabel.setText("Tabela:");
					dbLabel.setVisible(true);
					dbField.setVisible(false);
					dbButton.setVisible(false);
					dbSelect.setVisible(true);
					tbSelect.setVisible(false);
					tbField.setVisible(true);
					tbLabel.setVisible(true);
					tbButton.setVisible(true);
					quantLabel.setVisible(false);
					quantField.setVisible(false);
					clButton.setVisible(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				tableLabel.setForeground(Color.blue);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				tableLabel.setForeground(Color.orange);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});

		columnsLabel.addMouseListener(new MouseListener() {
	
			@Override
			public void mouseReleased(MouseEvent arg0) {
				columnsLabel.setForeground(Color.blue);
			}
	
			@Override
			public void mousePressed(MouseEvent arg0) {
				columnsLabel.setForeground(Color.green);
				if(tbSelect.isVisible()){
					dbLabel.setText("Nome:");
					tbLabel.setText("Tabela:");
					dbLabel.setVisible(false);
					dbField.setVisible(false);
					dbButton.setVisible(false);
					dbSelect.setVisible(false);
					tbSelect.setVisible(false);
					tbField.setVisible(false);
					tbLabel.setVisible(false);
					tbButton.setVisible(false);
					quantLabel.setVisible(false);
					quantField.setVisible(false);
					clButton.setVisible(false);
				}else{
					dbLabel.setText("Banco:");
					tbLabel.setText("Tabelas:");
					dbLabel.setVisible(true);
					dbSelect.setVisible(true);
					tbSelect.setVisible(true);
					tbLabel.setVisible(true);
					dbField.setVisible(false);
					dbButton.setVisible(false);
					tbField.setVisible(false);
					tbButton.setVisible(false);
					quantLabel.setVisible(true);
					quantField.setVisible(true);
					clButton.setVisible(true);
				}
			}
	
			@Override
			public void mouseExited(MouseEvent arg0) {
				columnsLabel.setForeground(Color.blue);
			}
	
			@Override
			public void mouseEntered(MouseEvent arg0) {
				columnsLabel.setForeground(Color.orange);
			}
	
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		dbButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				dbButton.setForeground(Color.black);
				dbButton.setBackground(null);
				
				database = dbField.getText();
				dbSelect.addItem(database);
				
				try {
					PrintWriter print = new PrintWriter(path+"\\compileddb\\file\\"+database+".java");
					print.println("package compileddb.file;");
					print.println("public class "+database+"{");
					print.println();
					print.print("}");
					print.close();
				} catch (FileNotFoundException e1) {}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				dbButton.setForeground(Color.orange);
				dbButton.setBackground(Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		tbButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				tbButton.setForeground(Color.black);
				tbButton.setBackground(null);
				
				database = (String) dbSelect.getSelectedItem();
				table = tbField.getText();
				tbSelect.addItem(table);
				String save = "";
				try {
					FileReader reader = new FileReader(path+"\\compileddb\\file\\"+database+".java");
					BufferedReader buffer = new BufferedReader(reader);
					String read = buffer.readLine();
					
					while(!read.contains("}")){
						save += read + "\r\n";
						read = buffer.readLine();
						if(read.contains("}") && save.contains("public void")){
							save += "		}\r\n";
						}
					}
					
					
					PrintWriter print = new PrintWriter(path+"\\compileddb\\file\\"+database+".java");
					print.println(save);
					print.println();
					print.println("		public void "+table+"(){");
					print.println();
					print.println("		}");
					print.println();
					if(!save.contains("public void")){
						save = "";
						save += "}\r\n";
					}else{
						save = "";
					}
					
					read = buffer.readLine();
					while(read != null){
						save += read + "\r\n";
						read = buffer.readLine();
					}
					print.println(save);
					print.close();
					buffer.close();
					save = "";
				} catch (FileNotFoundException e1) {} 
				catch (IOException e1) {}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				tbButton.setForeground(Color.orange);
				tbButton.setBackground(Color.blue);
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		clButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				clButton.setForeground(Color.black);
				clButton.setBackground(null);
			}
			
			@SuppressWarnings("unchecked")
			@Override
			public void mousePressed(MouseEvent arg0) {
				clButton.setForeground(Color.orange);
				clButton.setBackground(Color.blue);
				
				database = (String) dbSelect.getSelectedItem();
				table = (String) tbSelect.getSelectedItem();
				columns = Integer.parseInt(quantField.getText().trim());
				typeBox = new JComboBox[columns];
				nameField = new JTextField[columns];
				sizeField = new JTextField[columns];
				
				JFrame frameColumns = new JFrame();
				frameColumns.setBounds(200, 200, 500, 300);
				frameColumns.setTitle("Generate Columns - "+database+"\\"+table+"\\");
				
				JLabel labelFrame = new JLabel();
				labelFrame.setText("<html><div style='width:500;height:300;'></div></html>");
				labelFrame.setBounds(0, 0, 500, 300);
				
				JScrollPane scroll;
				scroll = new JScrollPane(labelFrame, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				frameColumns.getContentPane().add(scroll);
				
				typeLabel = new JLabel();
				typeLabel.setText("<html><div style='width:150;height:20;background:#00ccff;'>Tipo</div></html>");
				typeLabel.setBounds(0, 0, 150, 20);
				labelFrame.add(typeLabel);
				
				nameLabel = new JLabel();
				nameLabel.setText("<html><div style='width:150;height:20;background:#00ccff;'>Nome</div></html>");
				nameLabel.setBounds(160, 0, 150, 20);
				labelFrame.add(nameLabel);
				
				sizeLabel = new JLabel();
				sizeLabel.setText("<html><div style='width:150;height:20;background:#00ccff;'>Tamanho</div></html>");
				sizeLabel.setBounds(320, 0, 150, 20);
				labelFrame.add(sizeLabel);
				
				int i = 0;
				
				while(i < columns){
					int ind = array;
					int ind1 = array1;
					typeBox[ind] = new JComboBox<String>();
					typeBox[ind].setBounds(0, ind1, 150, 20);
					typeBox[ind].addItem("String");
					typeBox[ind].addItem("int");
					typeBox[ind].addItem("boolean");
					labelFrame.add(typeBox[ind]);
					
					nameField[ind] = new JTextField();
					nameField[ind].setBounds(160, ind1, 150, 20);
					labelFrame.add(nameField[ind]);
					
					sizeField[ind] = new JTextField();
					sizeField[ind].setBounds(320, ind1, 150, 20);
					labelFrame.add(sizeField[ind]);
					if(ind1 >= 240){
						labelFrame.setText("<html><div style='width:500;height:"+ind1+";'></div></html>");
						labelFrame.setBounds(0, 0, 500, 300);
					}
					i = i + 1;
					array = array + 1;
					array1 = array1 + 22;
				}
				
				labelFrame.setText("<html><div style='width:500;height:"+(array1+44)+";'></div></html>");
				
				saveColumns = new JButton();
				saveColumns.setText("Salvar");
				saveColumns.setBounds(390, array1+22, 70, 20);
				saveColumns.setCursor(new Cursor(Cursor.HAND_CURSOR));
				labelFrame.add(saveColumns);
				
				frameColumns.setVisible(true);
				array = 0;
				array1 = 0;
				
				saveColumns.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						saveColumns.setForeground(Color.black);
						saveColumns.setBackground(null);
						
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						saveColumns.setForeground(Color.orange);
						saveColumns.setBackground(Color.blue);
						
						int i = 0;
						while(i < columns){
							getType = (String)typeBox[i].getSelectedItem();
							getName = nameField[i].getText().trim();
							getSize = sizeField[i].getText().trim();
							memoryColumns += "	public "+getType+"[] "+database+"_"+table+"_"+getName+" = new "+getType+"["+getSize+"];"+"\r\n";
							i = i + 1;
						}
						String save = "";
						try {
							FileReader fileReader = new FileReader(path+"\\compileddb\\file\\"+database+".java");
							BufferedReader bufferReader = new BufferedReader(fileReader);
							String fileRead = bufferReader.readLine();
							save += fileRead + "\r\n";
							fileRead = bufferReader.readLine();
							save += fileRead + "\r\n";
							save += memoryColumns + "\r\n";
							fileRead = bufferReader.readLine();
							
							while(fileRead != null){
								save += fileRead + "\r\n";
								
								fileRead = bufferReader.readLine();
							}
							PrintWriter printWriter = new PrintWriter(path+"\\compileddb\\file\\"+database+".java");
							printWriter.println(save);
							printWriter.close();
							bufferReader.close();
						} catch (FileNotFoundException e1) {}
						catch (IOException e1) {}
						
						try {
							Runtime.getRuntime().exec("CMD /c javac compileddb\\file\\"+database+".java");
							Thread.sleep(3000);
							Runtime.getRuntime().exec("CMD /c jar -cfv dbPlax.jar compileddb\\file\\"+database+".class");
							
						} catch (IOException e1) {} 
						catch (InterruptedException e1) {}
						
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {}
					
					@Override
					public void mouseEntered(MouseEvent e) {}
					
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		
	}
	
	public static void main(String[] args){
		new PXDBServer();
		
	}
	
}

