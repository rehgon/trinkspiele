package graphisches;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

public class PaintImageComponent extends JComponent{

	private static final long serialVersionUID = 986478723110019879L;
	Image img;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(img!=null) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.drawImage(img, 0, 0, null);
		}
	}
		
	public void setImg(Image img) {
		this.img = img;
	}
}
