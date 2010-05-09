package frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import wuerfelSpiele.Woody;
import graphisches.FrameDesigner;
import graphisches.PaintImageComponent;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class WoodyFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private static WoodyFrame inst;
	private JTextField ausgabeFeld;
	private JLabel spielerLabel;
	private JButton wuerfelnButton;
	private JLabel woodyIstLabel;
	private boolean vorigerWarWeitergeben = false;
	Woody woody = new Woody();
	helpFrame help;
	private JButton helpButton;
	private PaintImageComponent Wuerfel1Painter = new PaintImageComponent();
	private PaintImageComponent Wuerfel2Painter = new PaintImageComponent();
	private BufferedImage Wuerfel1Img;
	private BufferedImage Wuerfel2Img;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new WoodyFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(false);
			}
		});
	}
	
	public WoodyFrame() {
		super();
		initGUI();
	}
	
	public void initGUI() {
		try {	
			woody.spielStarten();
			help = new helpFrame();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(Wuerfel1Painter); 
			getContentPane().add(Wuerfel2Painter); 
			Wuerfel1Img = woody.aktuelleGrafikLadenUndAnzeigen(0);
			Wuerfel2Img = woody.aktuelleGrafikLadenUndAnzeigen(1);
			Wuerfel1Painter.setImg(Wuerfel1Img); 
			Wuerfel2Painter.setImg(Wuerfel2Img);
			repaint();						
			Wuerfel1Painter.setBounds(16, 10, 257, 242);
			Wuerfel1Painter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					Wuerfel1PainterMouseClicked(evt);
				}
			});
			Wuerfel2Painter.setBounds(274, 10, 255, 242);
			Wuerfel2Painter.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					Wuerfel2PainterMouseClicked(evt);
				}
			});
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(251,255,189));
			this.setPreferredSize(new java.awt.Dimension(530, 367));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 367) / 2;
		    int left = (screenSize.width - 530) / 2;
		    this.setLocation(left, top); 
			this.setTitle("Woody!!!");
			this.setVisible(true);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				wuerfelnButton = new JButton();
				getContentPane().add(wuerfelnButton);
				wuerfelnButton.setText("würfeln");
				wuerfelnButton.setBounds(12, 313, 462, 22);
				wuerfelnButton.setBackground(new java.awt.Color(139,177,205));
				wuerfelnButton.setSelected(true);
				rootPane.setDefaultButton(wuerfelnButton);
				wuerfelnButton.addActionListener(new ActionListener() {
					//Bei Klick auf den Button: naechster Spielzug
					public void actionPerformed(ActionEvent evt) {	
						wuerfelAktionAusfuehren();
						grafikAktualisieren();
					}
				});
			}
			{
				woodyIstLabel = new JLabel();
				getContentPane().add(woodyIstLabel);
				woodyIstLabel.setText("Woody ist: " + woody.getWerIstWoody());
				woodyIstLabel.setBounds(12, 297, 165, 15);
			}
			{
				helpButton = new JButton();
				getContentPane().add(helpButton);
				helpButton.setText("Hilfe");
				helpButton.setBounds(477, 313, 44, 22);
				helpButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//TODO add your code for helpButton.actionPerformed
						help.setBounds(12, 12, 574, 480);
						help.getHelpTextArea().setBounds(12, 12, 550, 436);
						help.setHelpTextAreaText("");
						help.setVisible(true);
						{
							Scanner input = null;
							try {
								input = new Scanner(new File("src/txt/woodyHelp.txt"));
							} catch (FileNotFoundException e) {
								JOptionPane.showMessageDialog(null, "Critical error, schliesse Anwendung");
								System.exit(0);
							}
							String line = "";
							while(input.hasNextLine())
								line += input.nextLine() +"\n";
							input.close();
							help.setHelpTextAreaText(line);
						}
					}
				});
			}
			{
				ausgabeFeld = new JTextField();
				getContentPane().add(ausgabeFeld);
				ausgabeFeld.setBounds(12, 275, 507, 21);
				ausgabeFeld.setEditable(false);
				ausgabeFeld.setBackground(new java.awt.Color(239,251,233));
				ausgabeFeld.setFont(new java.awt.Font("Andale Mono",0,12));
				ausgabeFeld.setForeground(new java.awt.Color(0,0,0));
			}
			{
				spielerLabel = new JLabel();
				getContentPane().add(spielerLabel);
				spielerLabel.setText("los gehts, drücke auf würfeln!!!");
				spielerLabel.setBounds(13, 260, 506, 15);
			}
			
			
			JComponent[] comp = {ausgabeFeld, helpButton, spielerLabel, woodyIstLabel, wuerfelnButton};
			FrameDesigner.setDesign(comp, getContentPane());
			
			pack();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		new MainFrame().setVisible(true);
	}
	
	private void Wuerfel1PainterMouseClicked(MouseEvent evt) {
		//TODO add your code for Wuerfel1Painter.mouseClicked
		wuerfelAktionAusfuehren();
		grafikAktualisieren();
	}
	
	private void wuerfelAktionAusfuehren() {
		
		woody.wuerfeln(2);
		String ausgabe = woody.auswerten(woody.getErgebnis());
		ausgabeFeld.setText(woody.getWuerfelZahl(0) + " + " + woody.getWuerfelZahl(1) 
				+ " = " + woody.getErgebnis() + ": " + ausgabe);
		if(spielerLabel.getText().equals("los gehts, drücke auf würfeln!!!"))
			spielerLabel.setText(woody.getSpieler().naechsterSpieler());
		
		if(vorigerWarWeitergeben)
			spielerLabel.setText(woody.getSpieler().naechsterSpieler());
		if(ausgabe.equals("Nichts passiert, du musst weitergeben"))
			vorigerWarWeitergeben = true;
		else
			vorigerWarWeitergeben = false;
		
		woodyIstLabel.setText("Woody ist: " + woody.getWerIstWoody());
	}
	
	private void grafikAktualisieren() {
		
		//WürfelGrafik anzeigen
		Wuerfel1Img = woody.aktuelleGrafikLadenUndAnzeigen(0);
		Wuerfel2Img = woody.aktuelleGrafikLadenUndAnzeigen(1);
		Wuerfel1Painter.setImg(Wuerfel1Img);
		Wuerfel2Painter.setImg(Wuerfel2Img);
		repaint();
	}
	
	private void Wuerfel2PainterMouseClicked(MouseEvent evt) {
		//TODO add your code for Wuerfel2Painter.mouseClicked
		wuerfelAktionAusfuehren();
		grafikAktualisieren();
	}
	
	
}

