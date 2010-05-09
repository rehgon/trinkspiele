package frames;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import kartenSpiele.AssRennen;


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
public class AssRennenFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JTextPane reportPane;
	private JButton ziehenButton;
	private JLabel spielFortschrittLabel;
	private JProgressBar progress;
	AssRennen assRennenTest = new AssRennen();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AssRennenFrame inst = new AssRennenFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AssRennenFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 160) / 2;
		    int left = (screenSize.width - 400) / 2;
		    this.setLocation(left, top);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(400, 160));
			this.setTitle("Ass Rennen");
		    this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				reportPane = new JTextPane();
				getContentPane().add(reportPane);
				reportPane.setText("Willkommen bei Ass Rennen\nDrücken sie auf \"ziehen\" um zu starten\n");
				reportPane.setBounds(12, 12, 376, 80);
				reportPane.setEditable(false);
			}
			{
				ziehenButton = new JButton();
				getContentPane().add(ziehenButton);
				ziehenButton.setText("ziehen");
				ziehenButton.setBounds(295, 97, 94, 30);
				ziehenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ziehenButtonActionPerformed(evt);
					}
				});
			}
			{
				spielFortschrittLabel = new JLabel();
				getContentPane().add(spielFortschrittLabel);
				spielFortschrittLabel.setText("Spielfortschritt:");
				spielFortschrittLabel.setBounds(12, 98, 148, 15);
			}
			{
				progress = new JProgressBar();
				getContentPane().add(getProgress());
				progress.setBounds(12, 113, 148, 14);
			}
			pack();
			this.setSize(400, 160);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ziehenButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for ziehenButton.actionPerformed
		reportPane.setText(assRennenTest.assRennenkarteZiehen());
		progress.setValue(assRennenTest.getAceCounter() * 25);
		
		if (reportPane.getText().contains("Es wurden alle Asse aus dem Deck gezogen\nDas Spiel wird beendet")) {
			ziehenButton.setText("Beenden");
			ziehenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					ziehenButtonActionPerformed2(evt);
				}
			});
		}
	}
	
	private void ziehenButtonActionPerformed2(ActionEvent evt) {
		//TODO add your code for ziehenButton.actionPerformed
		this.setVisible(false);
		new MainFrame().setVisible(true);
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		this.setVisible(false);
		new MainFrame().setVisible(true);
	}
	
	public JProgressBar getProgress() {
		return progress;
	}
}
