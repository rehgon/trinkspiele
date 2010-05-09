package frames;
import graphisches.FrameDesigner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
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
public class MainFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private static MainFrame inst;
	private JList spieleList;
	private JButton auswahlButton;
	private JMenuItem schwarzDesignMenuItem;
	private JMenuItem bierDesignMenuItem;
	private JMenuItem weissMenuItem;
	private JMenu designMenu;
	private JMenuBar menuBar;
	private JMenu hilfeMenu;
	private JMenuItem ueberMenuItem;
	private JMenuItem sonstigesMenuItem;
	private JScrollPane scrollPane;
	private JMenuItem alleSpieleMenuItem;
	private JMenuItem kartenSpieleMenuItem;
	private JMenuItem wuerfelSpieleMenuItem;
	private JMenu jMenu1;
	private JLabel titelLabel;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int top = (screenSize.height - 301) / 2;
		    int left = (screenSize.width - 222) / 2;
		    this.setLocation(left, top); 
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setPreferredSize(new java.awt.Dimension(222, 301));
			getContentPane().setLayout(null);
			this.setTitle("Hauptmenü");
			this.setResizable(false);
			this.setFocusable(false);
			getContentPane().setBackground(new java.awt.Color(251,255,221));
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				menuBar.setBackground(new java.awt.Color(253,255,251));
				{
					jMenu1 = new JMenu();
					menuBar.add(jMenu1);
					jMenu1.setText("Spiele");
					{
						alleSpieleMenuItem = new JMenuItem();
						jMenu1.add(alleSpieleMenuItem);
						alleSpieleMenuItem.setText("Alle Spiele");
						alleSpieleMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								alleSpieleMenuItemActionPerformed(evt);
							}
						});
					}
					{
						kartenSpieleMenuItem = new JMenuItem();
						jMenu1.add(kartenSpieleMenuItem);
						kartenSpieleMenuItem.setText("Kartenspiele");
						kartenSpieleMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								kartenSpieleMenuItemActionPerformed(evt);
							}
						});
					}
					{
						wuerfelSpieleMenuItem = new JMenuItem();
						jMenu1.add(wuerfelSpieleMenuItem);
						wuerfelSpieleMenuItem.setText("Würfelspiele");
						wuerfelSpieleMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								wuerfelSpieleMenuItemActionPerformed(evt);
							}
						});
					}
					{
						sonstigesMenuItem = new JMenuItem();
						jMenu1.add(sonstigesMenuItem);
						sonstigesMenuItem.setText("Sonstiges");
						sonstigesMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								sonstigesMenuItemActionPerformed(evt);	
							}
						});
					}
				}
				{
					designMenu = new JMenu();
					menuBar.add(designMenu);
					designMenu.setText("Design");
					{
						weissMenuItem = new JMenuItem();
						designMenu.add(weissMenuItem);
						weissMenuItem.setText("Weiss");
						weissMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								grauMenuItemActionPerformed(evt);
							}
						});
					}
					{
						bierDesignMenuItem = new JMenuItem();
						designMenu.add(bierDesignMenuItem);
						bierDesignMenuItem.setText("Bier");
						bierDesignMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								bierDesignMenuItemActionPerformed(evt);
							}
						});
					}
					{
						schwarzDesignMenuItem = new JMenuItem();
						designMenu.add(schwarzDesignMenuItem);
						schwarzDesignMenuItem.setText("Schwarz");
						schwarzDesignMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								schwarzDesignMenuItemActionPerformed(evt);
							}
						});
					}

				}
				{
					hilfeMenu = new JMenu();
					menuBar.add(hilfeMenu);
					hilfeMenu.setText("Hilfe");
					{
						ueberMenuItem = new JMenuItem();
						hilfeMenu.add(ueberMenuItem);
						ueberMenuItem.setText("Über");
						ueberMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								ueberMenuItemActionPerformed(evt);
							}
						});
					}
				}
			}
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				auswahlButton = new JButton();
				getContentPane().add(auswahlButton);
				auswahlButton.setText("Spielen");
				auswahlButton.setBounds(12, 213, 199, 30);
				auswahlButton.setBackground(new java.awt.Color(243,215,0));
				auswahlButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						auswahlButtonActionPerformed(evt);
					}
				});
			}
			{
				titelLabel = new JLabel();
				getContentPane().add(titelLabel);
				titelLabel.setText("Trinkspiele");
				titelLabel.setBounds(12, 12, 183, 20);
				titelLabel.setFont(new java.awt.Font("Bank Gothic",1,24));
			}
			{
				scrollPane = new JScrollPane(spieleList);
				getContentPane().add(scrollPane);
				scrollPane.setBounds(12, 35, 199, 175);
				scrollPane.setFocusable(false);
			}
			{
				ListModel spieleListModel = new DefaultComboBoxModel(new String[] { "Kategorie wählen..." });
				spieleList = new JList();
				scrollPane.setViewportView(spieleList);
				spieleList.setModel(spieleListModel);
				spieleList.setBounds(0, 0, 199, 176);
				spieleList.setAutoscrolls(true);
				spieleList.setSelectedIndex(0);
				spieleList.setFocusable(false);
				spieleList.setBackground(new java.awt.Color(244,219,0));
			}
			
			JComponent[] comp = {titelLabel, spieleList, auswahlButton};
			FrameDesigner.setDesign(comp, getContentPane());
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void auswahlButtonActionPerformed(ActionEvent evt) {
		//TODO add your code for auswahlButton.actionPerformed
		if (spieleList.getSelectedValue().equals("Kategorie wählen...")) { //Zuerst auswählen
			JOptionPane.showMessageDialog(null, "Wählen sie zuerst eine Kategorie\naus dem Menü aus");
		}
		
		if (spieleList.getSelectedValue().equals("Meier")) { //Meier
			this.setVisible(false);
			new Meier();
			
		}
		if (spieleList.getSelectedValue().equals("Woody")) { //Woody
			this.setVisible(false);
			new WoodyFrame();
		}
		if (spieleList.getSelectedValue().equals("Sieben säuft")) { //7 säuft
			this.setVisible(false);
			new SiebenSaeuftFrame();
		}
		if(spieleList.getSelectedValue().equals("Ass Rennen")) { //Ass Rennen
			this.setVisible(false);
			new AssRennenFrame().setVisible(true);
		}
		if(spieleList.getSelectedValue().equals("Karten Orakel")) { //Karten Orakel
			this.setVisible(false);
			new KartenOrakelFrame().setVisible(true);
		}
		if(spieleList.getSelectedValue().equals("Simon says")) { //Simon says
			this.setVisible(false);
			new SimonSaysFrame().setVisible(true);
		}
		if(spieleList.getSelectedValue().equals("Big King's Cup")) { //Simon says
			this.setVisible(false);
			new BigKingsCupFrame().setVisible(true);
		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		//TODO add your code for this.windowClosed
		System.exit(0);
	}
	
	public void setBackground() {
		inst.setBackground(new Color(255, 255, 255));
	}
	
	private void wuerfelSpieleMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for wuerfelSpieleMenuItem.actionPerformed
		spieleList.setListData(new Object[] { "Meier", "Woody", "Sieben säuft"});
		spieleList.setSelectedIndex(0);
	}
	
	private void kartenSpieleMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for kartenSpieleMenuItem.actionPerformed
		spieleList.setListData(new Object[] { "Ass Rennen", "Big King's Cup", "Karten Orakel"});
		spieleList.setSelectedIndex(0);
	}
	
	private void sonstigesMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for alleSpieleMenuItem.actionPerformed
		spieleList.setListData(new Object[] { "Simon says" });
		spieleList.setSelectedIndex(0);
	}
	
	private void alleSpieleMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for alleSpieleMenuItem.actionPerformed
		spieleList.setListData(new Object[] { "Ass Rennen", "Big King's Cup", "Karten Orakel", "Meier", "Sieben säuft", "Simon says", "Woody" });
		spieleList.setSelectedIndex(0);
	}
	
	private void ueberMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for ueberMenuItem.actionPerformed
		JOptionPane.showMessageDialog(null, "Dieses Programm wurde entworfen von:\n- Rehgon\n- Raffyou\n- Noze");
	}
	
	private void grauMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for grauMenuItem.actionPerformed
		getContentPane().setBackground(new Color(255, 255, 255));
		FrameDesigner.white(titelLabel);
		FrameDesigner.white(spieleList);
		FrameDesigner.white(auswahlButton);
	}
	
	private void bierDesignMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for bierDesignMenuItem.actionPerformed
		getContentPane().setBackground(new Color(251,255,221));
		FrameDesigner.bier(titelLabel);
		FrameDesigner.bier(spieleList);
		FrameDesigner.bier(auswahlButton);
	}
	
	private void schwarzDesignMenuItemActionPerformed(ActionEvent evt) {
		//TODO add your code for schwarzDesignMenuItem.actionPerformed
		getContentPane().setBackground(new Color(0, 0, 0));
		FrameDesigner.black(titelLabel);
		FrameDesigner.black(spieleList);
		FrameDesigner.black(auswahlButton);
	}
}
