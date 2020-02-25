package simple.browser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
public class SimpleBrowser extends JFrame implements HyperlinkListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JEditorPane display;
	private JTextField searchField;
	private JLabel back, forward, refresh;
	private String server, proxy, port;
	private URL link;
	private String[] arrayPages = new String[1000];
	private int n = 0;
	@Override
	public void hyperlinkUpdate(HyperlinkEvent event) {
		HyperlinkEvent.EventType eventType = event.getEventType();
		
		
        if (eventType == HyperlinkEvent.EventType.ACTIVATED) {
            if (event instanceof HTMLFrameHyperlinkEvent) {
                HTMLFrameHyperlinkEvent linkEvent =
                        (HTMLFrameHyperlinkEvent) event;
                HTMLDocument document =
                        (HTMLDocument) display.getDocument();
                document.processHTMLFrameHyperlinkEvent(linkEvent);
            } else {
                try {
                	searchField.setText(""+event.getURL());
					display.setPage(event.getURL());
					arrayPages[n] = searchField.getText();
					n++;
				} catch (IOException e) {}
            }
        }
        
        
		
	}
	
	public SimpleBrowser(){
		this.setTitle("Zoorbitel Browser");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolKit.getScreenSize();
		
		int width = dimension.width;
		int height = dimension.height;
		this.setBounds(0, 0, width, height);
		
		JLabel body = new JLabel();
		body.setText("<html><div style='background:black;width:"+width+";height:"+height+";'></div></html>");
		body.setBounds(0, 0, width, height);
		this.add(body);
		
		back = new JLabel("<<");
		back.setBounds(5, 10, 20, 20);
		back.setForeground(Color.white);
		back.setFont(new Font("Arial", 1, 15));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		body.add(back);
		
		forward = new JLabel(">>");
		forward.setBounds(30, 10, 20, 20);
		forward.setForeground(Color.white);
		forward.setFont(new Font("Arial", 1, 15));
		forward.setCursor(new Cursor(Cursor.HAND_CURSOR));
		body.add(forward);
		
		int widthSearch = width - 100;
		searchField = new JTextField();
		searchField.setBounds(70, 5, widthSearch, 25);
		searchField.setBorder(BorderFactory.createLineBorder(Color.green));
		searchField.setText("http://");
		body.add(searchField);
		
		
		display = new JEditorPane();
		display.setContentType("text/html");
		display.setEditable(false);
		display.addHyperlinkListener(this);
		body.add(display);
		

		
		JScrollPane scrollMail = new JScrollPane(display);
		scrollMail.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMail.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollMail.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		scrollMail.setBounds(0, 40, width-10, height-40);
		body.add(scrollMail);
		
		searchField.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@Override
			public void keyPressed(KeyEvent key) {
				int code = key.getKeyCode();
				
				if(code == KeyEvent.VK_ENTER){
					body.setCursor(new Cursor(Cursor.WAIT_CURSOR));
					
					String url;
					String html = "";
					url = searchField.getText();
					arrayPages[n] = url;
					n++;
					
					
					server = url;
					proxy = "89.40.48.186";
					port = "8080";
					
					try {
						link = new URL(server);
						Properties systemProperties = System.getProperties();
						systemProperties.setProperty("http.proxyHost",proxy);
						systemProperties.setProperty("http.proxyPort",port);
						HttpURLConnection httpcon = (HttpURLConnection) link.openConnection(); 

						httpcon.connect();
					
						
						display.setPage(link);
						
					} catch (MalformedURLException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
			            // Retorna para o cursor padrão.
			            body.setCursor(null);
			            display.setCursor(null);
			        }
					
				}
				
			}
		});
		
		back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				back.setForeground(Color.white);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				back.setForeground(Color.green);
				n--;
				try {
					link = new URL(arrayPages[n]);
					Properties systemProperties = System.getProperties();
					systemProperties.setProperty("http.proxyHost",proxy);
					systemProperties.setProperty("http.proxyPort",port);
					HttpURLConnection httpcon = (HttpURLConnection) link.openConnection(); 

					httpcon.connect();
				
					
					display.setPage(link);
					searchField.setText(arrayPages[n]);
					
				} catch (MalformedURLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
		            // Retorna para o cursor padrão.
		            body.setCursor(null);
		            display.setCursor(null);
		        }
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		forward.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				forward.setForeground(Color.white);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				forward.setForeground(Color.green);
				n++;
				try {
					link = new URL(arrayPages[n]);
					Properties systemProperties = System.getProperties();
					systemProperties.setProperty("http.proxyHost",proxy);
					systemProperties.setProperty("http.proxyPort",port);
					HttpURLConnection httpcon = (HttpURLConnection) link.openConnection(); 

					httpcon.connect();
				
					
					display.setPage(link);
					searchField.setText(arrayPages[n]);
					
				} catch (MalformedURLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
		            // Retorna para o cursor padrão.
		            body.setCursor(null);
		            display.setCursor(null);
		        }
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
		SimpleBrowser browser = new SimpleBrowser();
		browser.setVisible(true);
	}


}
