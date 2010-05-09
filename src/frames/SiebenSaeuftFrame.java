package frames;
import graphisches.PaintImageComponent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import wuerfelSpiele.SiebenSaeuft;



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
public class SiebenSaeuftFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JTextPane reportPane;
	private SiebenSaeuft siebenSaeuft;
	private PaintImageComponent painter1 = new PaintImageComponent();
	private PaintImageComponent painter2 = new PaintImageComponent();
	private BufferedImage Wuerfel1Img;
	private BufferedImage Wuerfel2Img;
	private File Wuerfel1File;
	private File Wuerfel2File;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SiebenSaeuftFrame inst = new SiebenSaeuftFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SiebenSaeuftFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			getContentPane().add(painter1);
			painter1.setBounds(12, 12, 243, 243);
			getContentPane().add(painter2);
			painter2.setBounds(257, 12, 243, 243);
			Wuerfel1File = new File("src/images/w6.png"); 	//
			Wuerfel2File = new File("src/images/w6.png"); 	//
			try { 											//
				Wuerfel1Img = ImageIO.read(Wuerfel1File); 	//
				Wuerfel2Img = ImageIO.read(Wuerfel2File); 	//
			} catch (IOException e) { }
			painter1.setImg(Wuerfel1Img);
			painter2.setImg(Wuerfel2Img);
			repaint();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 185) / 2;
		    int left = (screenSize.width - 400) / 2;
		    this.setLocation(left, top); 
			siebenSaeuft = new SiebenSaeuft();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			getContentPane().setLayout(null);
			this.setTitle("Sieben saeuft");
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(515, 437));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, "North");
				jButton1.setText("Würfeln");
				jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
				jButton1.setVerifyInputWhenFocusTarget(false);
				jButton1.setBounds(12, 375, 489, 30);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				reportPane = new JTextPane();
				getContentPane().add(reportPane, "Center");
				BorderLayout reportPaneLayout = new BorderLayout();
				reportPane.setLayout(reportPaneLayout);
				reportPane.setText("Wilkommen zu 7 saeuft.\n" +
						"Klicken sie auf den Button um zu starten");
				reportPane.setBounds(12, 259, 488, 110);
				reportPane.setEditable(false);
				reportPane.setBackground(new java.awt.Color(217,217,217));
				reportPane.setMargin(new java.awt.Insets(10, 10, 3, 3));

			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		//TODO add your code for jButton1.actionPerformed
		reportPane.setText(siebenSaeuft.chat());
		
		//WürfelGrafik anzeigen
		Wuerfel1File = new File("src/images/w" + siebenSaeuft.getWuerfelZahl(0) + ".png");
		Wuerfel2File = new File("src/images/w" + siebenSaeuft.getWuerfelZahl(1) + ".png");
		try {
			Wuerfel1Img = ImageIO.read(Wuerfel1File);
			Wuerfel2Img = ImageIO.read(Wuerfel2File);
		} catch (IOException e) { }
		painter1.setImg(Wuerfel1Img);
		painter2.setImg(Wuerfel2Img);
		repaint();
		
		if (siebenSaeuft.getGesamtErgebnis() > 100) {
			jButton1.setText("Beenden");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
					setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					MainFrame main = new MainFrame();
					main.setVisible(true);
				}
			});
		}
	}
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		this.setVisible(false);
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}

}
