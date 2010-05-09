package graphisches;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class FrameDesigner {
	
	private static String welchesDesign = "bier";
	
	public static String getWelchesDesign() {
		return welchesDesign;
	}
	
	public static void setWelchesDesign(String newDesign) {
		welchesDesign = newDesign;
	}
	
	public static void white(JComponent component) {
		
		component.setForeground(new Color(0, 0, 0));
		component.setBackground(new Color(255, 255, 255));
		
		setWelchesDesign("white");
	}
	
	public static void black(JComponent component) {
		
		component.setForeground(new Color(255, 255, 255));
		component.setBackground(new Color(0, 0, 0));
		
		setWelchesDesign("black");
	}
	
	public static void bier(JComponent component) {
		
		component.setForeground(new Color(0, 0, 0));

		if (component instanceof JButton)
			component.setBackground(new Color(243,215,0));
		else if (component instanceof JList) 
			component.setBackground(new Color(244,219,0));
		else if (component instanceof JProgressBar) {
			component.setBackground(new Color(251, 255, 221));
			component.setForeground(new Color(243,215,0));
		}
		else
			component.setBackground(new Color(243,215,0));
		
		setWelchesDesign("bier");
	}
	
	
	public static void setDesign(JComponent[] comp, Container pane) {
		
		for (JComponent actcomp : comp) {
			if (getWelchesDesign().equals("bier")) {
				bier(actcomp);
				pane.setBackground(new Color(251,255,221));
			}
			else if (FrameDesigner.getWelchesDesign().equals("white")) {
				white(actcomp);
				pane.setBackground(new Color(255,255,255));
			}
			else if (FrameDesigner.getWelchesDesign().equals("black")) {
				black(actcomp);
				pane.setBackground(new Color(0,0,0));
			}	

		}	
			
	}
	
}
