package frames;
import graphisches.FrameDesigner;
import graphisches.PaintImageComponent;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import kartenSpiele.BigKingsCup;


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
public class BigKingsCupFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 5544433129796786941L;
	private JTextArea reportTextArea;
	private JButton ziehenButton;
	private BigKingsCup bigKingsCup;
	private JLabel klokarteLabel;
	private JButton klokarteEntfernenButton;
	private JProgressBar fuellstandProgressBar;
	private JLabel daumenMasterLabel;
	private JLabel questionMasterLabel;
	private JLabel fuellstandLabel;
	private ArrayList<String> klokartenBesitzer;
	private PaintImageComponent painter = new PaintImageComponent();
	private BufferedImage img = null;
	int karte = 0; //nur Testweise

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BigKingsCupFrame inst = new BigKingsCupFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BigKingsCupFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 380) / 2;
		    int left = (screenSize.width - 729) / 2;
		    this.setLocation(left, top);
			bigKingsCup = new BigKingsCup();
			klokartenBesitzer = new ArrayList<String>();
			getContentPane().add(painter);
			painter.setBounds(667, 268, 50, 84);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(729, 380));
			this.setTitle("Kings Cup");
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(217,153,48));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				reportTextArea = new JTextArea();
				getContentPane().add(reportTextArea);
				reportTextArea.setText("Herzlich willkommen zu Big King's Cup.\nKlicken sie auf den Button um zu starten");
				reportTextArea.setBounds(12, 12, 704, 218);
				reportTextArea.setMargin(new Insets(10, 10, 10, 10));
				reportTextArea.setBackground(new java.awt.Color(255,198,92));
				reportTextArea.setFont(new java.awt.Font("Bank Gothic",0,14));
			}
			{
				ziehenButton = new JButton();
				getContentPane().add(ziehenButton);
				ziehenButton.setText("ziehen");
				ziehenButton.setBounds(12, 236, 705, 27);
				ziehenButton.setBackground(new java.awt.Color(153,72,57));
				ziehenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ziehenButtonActionPerformed(evt);
					}
				});
			}
			{
				fuellstandLabel = new JLabel();
				getContentPane().add(fuellstandLabel);
				fuellstandLabel.setText("King's Cup Füllstand:");
				fuellstandLabel.setBounds(12, 274, 155, 15);
			}
			{
				klokarteLabel = new JLabel();
				getContentPane().add(klokarteLabel);
				klokarteLabel.setText("Im Besitz einer Klokarte: niemand");
				klokarteLabel.setBounds(12, 295, 476, 15);
			}
			{
				questionMasterLabel = new JLabel();
				getContentPane().add(questionMasterLabel);
				questionMasterLabel.setText("Question Master ist: niemand");
				questionMasterLabel.setBounds(12, 316, 476, 15);
			}
			{
				daumenMasterLabel = new JLabel();
				getContentPane().add(daumenMasterLabel);
				daumenMasterLabel.setText("Daumen Master ist: niemand");
				daumenMasterLabel.setBounds(12, 337, 476, 15);
			}
			{
				fuellstandProgressBar = new JProgressBar();
				getContentPane().add(fuellstandProgressBar);
				fuellstandProgressBar.setBounds(136, 275, 148, 14);
				fuellstandProgressBar.setBackground(new java.awt.Color(217,214,0));
			}
			{
				klokarteEntfernenButton = new JButton();
				getContentPane().add(klokarteEntfernenButton);
				klokarteEntfernenButton.setVisible(false);
				klokarteEntfernenButton.setText("Klokarte entfernen");
				klokarteEntfernenButton.setBounds(541, 270, 121, 22);
				klokarteEntfernenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						klokarteEntfernenButtonActionPerformed(evt);
					}
				});
			}
			
			JComponent[] comp = {reportTextArea, ziehenButton, klokarteEntfernenButton, fuellstandProgressBar, 
					daumenMasterLabel, questionMasterLabel, fuellstandLabel, klokarteLabel};
			FrameDesigner.setDesign(comp, getContentPane());
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ziehenButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for ziehenButton.actionPerformed
		reportTextArea.setText(bigKingsCup.karteZiehenUndAuswerten());
		
		if (reportTextArea.getText().contains("QUESTIONMASTER")) {
			questionMasterLabel.setText("Question Master ist: " + bigKingsCup.getSpieler().getAktuellerSpieler());
		}
		else if(reportTextArea.getText().contains("KLOKARTE")) {
			klokarteEntfernenButton.setVisible(true);
			klokartenBesitzer.add(bigKingsCup.getSpieler().getAktuellerSpieler());
			klokarteLabel.setText("Im Besitz einer Klokarte: ");
			for (int i = 0; i < klokartenBesitzer.size(); i++) {
				klokarteLabel.setText(klokarteLabel.getText() + klokartenBesitzer.get(i) + ", ");
			}
			klokarteLabel.setText(klokarteLabel.getText().substring(0, (klokarteLabel.getText().length() - 2)));
		}
		else if(reportTextArea.getText().contains("DAUMENMASTER")) {
			daumenMasterLabel.setText("Daumen Master ist: " + bigKingsCup.getSpieler().getAktuellerSpieler());
		}
		else if(reportTextArea.getText().contains("KING'S CUP")) {
			fuellstandProgressBar.setValue(fuellstandProgressBar.getValue() + 25);
			if(fuellstandProgressBar.getValue() == 100) {
				JOptionPane.showMessageDialog(null, "Ja " + bigKingsCup.getSpieler().getAktuellerSpieler() + 
						", es wurden alle Kaenige gezogen... UND JETZT TRINK!!!");
			}
		}
		else if(reportTextArea.getText().contains("Alle Karten wurden gezogen, Deck wird neu gemischt")) {
			fuellstandProgressBar.setValue(0);
		}
		
		bigKingsCup.getSpieler().incrementAktuellerSpieler();
		
		//Grafik laden
		img = bigKingsCup.aktuelleKarteGrafikLaden(0);
		//Grafik anzeigen bzw.erneuern
		painter.setImg(img);
		repaint();
	}
		
	
	private void klokarteEntfernenButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for klokarteEntfernenButton.actionPerformed
		String[] klokartenBesitzerArray = new String[klokartenBesitzer.size()];
		for (int i = 0; i < klokartenBesitzer.size(); i++) {
			klokartenBesitzerArray[i] = klokartenBesitzer.get(i);
		}
		int auswahl = JOptionPane.showOptionDialog(null, "Wer ist aufs Klo?", "Klokarte entfernen", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
				null, klokartenBesitzerArray, klokartenBesitzerArray[0]);
		klokartenBesitzer.remove(auswahl);
		klokarteLabel.setText("Im Besitz einer Klokarte: ");
		for (int i = 0; i < klokartenBesitzer.size(); i++) {
			klokarteLabel.setText(klokarteLabel.getText() + klokartenBesitzer.get(i) + ", ");
		}
		if (klokartenBesitzer.size() == 0)
			klokarteEntfernenButton.setVisible(false);
		klokarteLabel.setText(klokarteLabel.getText().substring(0, (klokarteLabel.getText().length() - 2)));
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		this.setVisible(false);
		new MainFrame().setVisible(true);
	}

}
