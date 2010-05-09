package frames;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import wuerfelSpiele.Meier;

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
public class MeierFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JButton jButton1;
	private JTextPane reportPane;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MeierFrame inst = new MeierFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MeierFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			new Meier();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 185) / 2;
		    int left = (screenSize.width - 400) / 2;
		    this.setLocation(left, top); 
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			getContentPane().setLayout(null);
			this.setTitle("Meier");
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(400, 185));
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
				jButton1.setBounds(12, 125, 377, 30);
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
				reportPane.setText("Klicken sie auf den Button um zu starten");
				reportPane.setBounds(12, 9, 376, 104);
				reportPane.setEditable(false);
				reportPane.setBackground(new java.awt.Color(217,217,217));
				reportPane.setPreferredSize(new java.awt.Dimension(376, 104));
				reportPane.setMargin(new java.awt.Insets(10, 10, 3, 3));

			}
			pack();
			this.setSize(400, 185);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		//TODO add your code for jButton1.actionPerformed
	}
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		this.setVisible(false);
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}

}
