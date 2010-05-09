package wuerfelSpiele;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public abstract class Wuerfelspiel {
	
	private Random wuerfelGenerator;
	private int[] wuerfelZahl;
	private int ergebnis;
	
	public Wuerfelspiel() {
		wuerfelGenerator = new Random();
		wuerfelZahl = new int[10];
		ergebnis = 0;
	}

	public int getWuerfelZahl(int welcherWuerfel) {
		return wuerfelZahl[welcherWuerfel];
	}
	public void setWürfelZahl(int wert, int welcherWürfel) {
		if (wert > 6 || wert < 1)
			JOptionPane.showMessageDialog(null, "Error, es sind nur Zahlen von 1 bis 6 erlaubt");
		else
			wuerfelZahl[welcherWürfel] = wert;
	}
	public int getErgebnis() {
		return ergebnis;
	}
	public void setErgebnis(int ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	public void wuerfeln(int anzahlWuerfel) {
		ergebnis = 0;
		wuerfelZahl = new int[anzahlWuerfel];
		for (int i = 0; i < wuerfelZahl.length; i++) {
			wuerfelZahl[i] = wuerfelzahlGenerieren();
			ergebnis += wuerfelZahl[i];
		}
	}
	private int wuerfelzahlGenerieren() {
		return wuerfelGenerator.nextInt(6) + 1;
	}

	public boolean istGerade(int wert) {
		if (wert % 2 == 0)
			return true;
		else
			return false;
	}
	
	public BufferedImage aktuelleGrafikLadenUndAnzeigen(int welche) {
		
		File wuerfelFile;
		if (getWuerfelZahl(welche) == 0)
			wuerfelFile = new File("src/images/w" + wuerfelzahlGenerieren() + ".png");
		else
			wuerfelFile = new File("src/images/w" + getWuerfelZahl(welche) + ".png");
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(wuerfelFile);
		} catch (IOException e) { }
		return img;
	}
}

