package frames;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import graphisches.FrameDesigner;


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
public class helpFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = -3069574752506233077L;
	private JTextArea helpTextArea;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				helpFrame inst = new helpFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public helpFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("hilfe");
			this.setResizable(false);
			{
				helpTextArea = new JTextArea();
				getContentPane().add(getHelpTextArea());
				helpTextArea.setBounds(12, 12, 376, 254);
				helpTextArea.setEditable(false);
				helpTextArea.setBackground(new java.awt.Color(217,217,217));
			}
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			
			JComponent[] comp = {helpTextArea};
			FrameDesigner.setDesign(comp, getContentPane());
			
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		System.exit(0);
	}
	
	public JTextArea getHelpTextArea() {
		return helpTextArea;
	}
	public void setHelpTextAreaText(String text) {
		helpTextArea.setText(text);
	}

}
