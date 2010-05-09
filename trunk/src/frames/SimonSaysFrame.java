package frames;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import sonstiges.SimonSays;


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
public class SimonSaysFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 8994079846978564662L;
	private JTextArea SimonSaysOutputField;
	private JButton newSimonButton;
	private JButton SimonSaysButton;
	private SimonSays simonSays;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SimonSaysFrame inst = new SimonSaysFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SimonSaysFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			simonSays = new SimonSays();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 160) / 2;
		    int left = (screenSize.width - 210) / 2;
		    this.setLocation(left, top); 
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Simon Says");
			this.setPreferredSize(new Dimension(210, 160));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				SimonSaysOutputField = new JTextArea();
				getContentPane().add(SimonSaysOutputField);
				SimonSaysOutputField.setBounds(12, 12, 184, 56);
				SimonSaysOutputField.setLayout(null);
				SimonSaysOutputField.setEditable(false);
				SimonSaysOutputField.setText("Herzlich Willkommen\nzu Simon says");
			}
			{
				SimonSaysButton = new JButton();
				getContentPane().add(SimonSaysButton);
				SimonSaysButton.setText("Simon says");
				SimonSaysButton.setBounds(32, 80, 148, 21);
				SimonSaysButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SimonSaysButtonActionPerformed(evt);
					}
				});
			}
			{
				newSimonButton = new JButton();
				getContentPane().add(newSimonButton);
				newSimonButton.setText("new");
				newSimonButton.setBounds(69, 106, 71, 21);
				newSimonButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						newSimonButtonActionPerformed(evt);
					}
				});
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void SimonSaysButtonActionPerformed(ActionEvent evt) {
		System.out.println("SimonSaysButton.actionPerformed, event="+evt);
		//TODO add your code for SimonSaysButton.actionPerformed
		SimonSaysOutputField.setText("Simon says:\n" + simonSays.getRandomPhrase());
	}
	
	private void newSimonButtonActionPerformed(ActionEvent evt) {
		System.out.println("newSimonButton.actionPerformed, event="+evt);
		//TODO add your code for newSimonButton.actionPerformed
		simonSays.setSimonsList(JOptionPane.showInputDialog("neues Statement:"));
		simonSays.setNewPhraseToTxt(simonSays.getSimonsListAt(simonSays.getSimonSaysList().size()-1));
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		this.setVisible(false);
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}
}
