package frames;
import graphisches.FrameDesigner;
import graphisches.PaintImageComponent;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import kartenSpiele.KartenOrakel;

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
public class KartenOrakelFrame extends javax.swing.JFrame {

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
	private JLabel anzahlFalscheLabel;
	private JLabel anzahlRichtigeLabel;
	private JButton tieferButton;
	private JButton hoeherButton;
	private JTextPane reportPane;
	private KartenOrakel kartenOrakel;
	private PaintImageComponent painter = new PaintImageComponent();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				KartenOrakelFrame inst = new KartenOrakelFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public KartenOrakelFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			kartenOrakel = new KartenOrakel();
			getContentPane().add(painter);
			painter.setBounds(394, 9, 60, 76);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 185) / 2;
		    int left = (screenSize.width - 460) / 2;
		    this.setLocation(left, top); 
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			getContentPane().setLayout(null);
			this.setTitle("Karten Orakel");
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(460, 195
					));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, "North");
				jButton1.setText("ziehen");
				jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
				jButton1.setVerifyInputWhenFocusTarget(false);
				jButton1.setBounds(12, 140, 373, 25);
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
				reportPane.setText("Wilkommen zu Karten Orakel.\n" +
						"Klicken sie auf \"ziehen\" um das Spiel zu starten.");
				reportPane.setBounds(12, 9, 376, 104);
				reportPane.setEditable(false);
				reportPane.setBackground(new java.awt.Color(217,217,217));
				reportPane.setPreferredSize(new java.awt.Dimension(376, 104));
				reportPane.setMargin(new java.awt.Insets(10, 10, 3, 3));

			}
			{
				hoeherButton = new JButton();
				getContentPane().add(hoeherButton);
				hoeherButton.setText("haeher");
				hoeherButton.setBounds(209, 140, 176, 25);
				hoeherButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						hoeherButtonActionPerformed(evt);
					}
				});
			}
			{
				tieferButton = new JButton();
				getContentPane().add(tieferButton);
				tieferButton.setText("tiefer");
				tieferButton.setBounds(12, 140, 176, 25);
				tieferButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tieferButtonActionPerformed(evt);
					}
				});
			}
			{
				anzahlRichtigeLabel = new JLabel();
				getContentPane().add(anzahlRichtigeLabel);
				anzahlRichtigeLabel.setText("richtige:\r0");
				anzahlRichtigeLabel.setBounds(12, 118, 79, 20);
			}
			{
				anzahlFalscheLabel = new JLabel();
				getContentPane().add(anzahlFalscheLabel);
				anzahlFalscheLabel.setText("falsche:\n0");
				anzahlFalscheLabel.setBounds(97, 118, 82, 20);
			}
			
			JComponent[] comp = {tieferButton, hoeherButton, jButton1, anzahlRichtigeLabel, anzahlFalscheLabel, reportPane};
			FrameDesigner.setDesign(comp, getContentPane());
			
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		//TODO add your code for jButton1.actionPerformed
		
		if (kartenOrakel.getDeck().size() != 0) {
			reportPane.setText(kartenOrakel.spieleKartenOrakel(true));
			jButton1.setVisible(false);
		}
		else {
			reportPane.setText(reportPane.getText() + "Sie haben alle Karten durch, das Spiel wird beendet.\n");
			jButton1.setText("Beenden");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
					new MainFrame().setVisible(true);
				}
			});
		}
		//Grafik laden
		BufferedImage img = kartenOrakel.aktuelleKarteGrafikLaden(0);
		//Grafik anzeigen bzw.erneuern
		painter.setImg(img);
		repaint();
	}
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}
	
	private void hoeherButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for hoeherButton.actionPerformed
		reportPane.setText(kartenOrakel.spieleKartenOrakel(true));
		if (kartenOrakel.getDeck().size() == 0) {
			tieferButton.setVisible(false);
			hoeherButton.setVisible(false);
			jButton1.setVisible(true);
			jButton1ActionPerformed(evt);
		}
		
		//Trefferanzahl aktualisieren
		anzahlRichtigeLabel.setText("Richtige:\n" + kartenOrakel.getAnzahlRichtigeTreffer());
		anzahlFalscheLabel.setText("Falsche:\n" + kartenOrakel.getAnzahlFalscheTreffer());
		
		//Grafik laden
		BufferedImage img = kartenOrakel.aktuelleKarteGrafikLaden(0);
		//Grafik anzeigen bzw.erneuern
		painter.setImg(img);
		repaint();
			
	}
	
	private void tieferButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for tieferButton.actionPerformed
		reportPane.setText(kartenOrakel.spieleKartenOrakel(false));
		if (kartenOrakel.getDeck().size() == 0) {
			tieferButton.setVisible(false);
			hoeherButton.setVisible(false);
			jButton1.setVisible(true);
			jButton1ActionPerformed(evt);
		}
		
		//Trefferanzahl aktualisieren
		anzahlRichtigeLabel.setText("Richtige:\n" + kartenOrakel.getAnzahlRichtigeTreffer());
		anzahlFalscheLabel.setText("Falsche:\n" + kartenOrakel.getAnzahlFalscheTreffer());
		
		//Grafik laden
		BufferedImage img = kartenOrakel.aktuelleKarteGrafikLaden(0);
		//Grafik anzeigen bzw.erneuern
		painter.setImg(img);
		repaint();
	}

}
