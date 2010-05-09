package wuerfelSpiele;
import java.util.Random;

import javax.swing.JOptionPane;

import spieler.Spieler;


public class Meier extends Wuerfelspiel{
	
	private int wuerfel1, wuerfel2,  vorigeZahl, gelogeneZahl;
	private Random zufallsZahl = new Random();
	private Spieler spieler;
	
	public Meier() {
		super();
		wuerfel1 = 0;
		wuerfel2 = 0;
		vorigeZahl = 0;
		gelogeneZahl = 0;
		spieler = new Spieler("Meier");
		spieler.spielerSetzen();
		spielen();
	}
	
	public Spieler getSpieler() {
		return spieler;
	}
	public int getVorigeZahl() {
		return vorigeZahl;
	}
	public void setVorigeZahl(int vorigeZahl) {
		this.vorigeZahl = vorigeZahl;
	}
	public int getGelogeneZahl() {
		return gelogeneZahl;
	}
	public void setGelogeneZahl(int zahl) {
		gelogeneZahl = zahl;
	}
	
	public void wuerfeln() {
		vorigeZahl = getErgebnis();
		wuerfel1 = wuerfelzahlGenerieren();
		wuerfel2 = wuerfelzahlGenerieren();
		if (wuerfel1 >= wuerfel2)
			setErgebnis((wuerfel1 * 10) + wuerfel2);
		else
			setErgebnis((wuerfel2 * 10) + wuerfel1);
	}
	
	public boolean hatGelogen() {
		 	if(!istHoeher())
		 		return true;
		 	else
		 		return false;
	 }
	 
	public boolean istHoeher() {
		 if (istPaschOderMeier(getErgebnis()) == true && istPaschOderMeier(vorigeZahl) == true) { //2x Pasch
			 if (vorigeZahl == 21)
				 return false;
			 else if (getErgebnis() == 21) //if Ergebnis == Meier
				 return true;
			 else if (getErgebnis() > vorigeZahl)
				 return true;
			 else //ergebnis <= vorigeZahl
				 return false;
		 }
		 else if (istPaschOderMeier(getErgebnis()) == true && istPaschOderMeier(vorigeZahl) == false)
			 return true;
		 else if (istPaschOderMeier(getErgebnis()) == false && istPaschOderMeier(vorigeZahl) == true)
			 return false;
		 else {
			 if (getErgebnis() > vorigeZahl)
				 return true;
			 else
				 return false;
		 } 
	 }
	 
	private int wuerfelzahlGenerieren() {
		return zufallsZahl.nextInt(6) + 1;
	}
	
	public boolean istPaschOderMeier(int zahl) {
		if (zahl == 21)
			return true;
		else if ((zahl / 10) == (zahl % 10))
			return true;
		else 
			return false;
	}
	
	// Wird nur zu Beginn einer neuen Runde ausgeführt
	private void ersterZugPane() throws Exception {
		wuerfeln();
		if (getErgebnis() == 21)
			throw new Exception("Meier Exception");
		int yON = JOptionPane.showConfirmDialog(null, spieler.getAktuellerSpieler() + 
				" hat " + getErgebnis() + " gewürfelt\n" + 
				"Maechten sie gleich zu Beginn lügen?", "Trotzdem lügen?", JOptionPane.YES_NO_OPTION);
		if (yON == 0)
			gelogeneZahlEingeben();
	}
	
	//gibt true zurück, solange weitergewürfelt werden soll
	private void weitererZugPane() throws Exception  {
		if (gelogeneZahl > 0)
			setErgebnis(gelogeneZahl);
		wuerfeln();
		if (getErgebnis() == 21)
			throw new Exception("Meier Exception");
		JOptionPane.showMessageDialog(null, "Sie haben " + getErgebnis() + " gewürfelt");
		if(!istHoeher()) {
			String input = JOptionPane.showInputDialog("Leider ist ihre Zahl tiefer, als die ihres Gegners, sie müssen Lügen.\n" +
					"Geben sie eine gedachte Zahl, haeher als " + getVorigeZahl() + " ein: ");
			gelogeneZahl = Integer.parseInt(input);
			if (gelogeneZahl == 21) {
				JOptionPane.showMessageDialog(null, "Sie haben Meier angesagt und gelogen, also müssen sie trinken");
				throw new Exception("no Meier Eception");
			}
			while ((gelogeneZahl <= vorigeZahl)  || ((gelogeneZahl != 21) && ((gelogeneZahl / 10) < (gelogeneZahl % 10)) 
					&& ((gelogeneZahl % 10) != (gelogeneZahl / 10)))) {
				input = JOptionPane.showInputDialog("Diese Zahl ist ungültig. Ihre Eingabe muss haeher als " + getVorigeZahl() + " sein" +
						"\nund die Zehnerstelle muss haeher als die Einerstelle sein (ausser bei Pasch)");
				gelogeneZahl = Integer.parseInt(input);
			}
		}
		else {
			int yON = JOptionPane.showConfirmDialog(null, "Maechten sie trotzdem lügen?", "Lügen?", JOptionPane.YES_NO_OPTION);
			if (yON == 0) {
				gelogeneZahlEingeben();
			}
		}
	}
	
	private void gelogeneZahlEingeben() throws Exception {
		String input = JOptionPane.showInputDialog("Geben sie eine gedachte Zahl ein:");
		gelogeneZahl = Integer.parseInt(input);
		if (gelogeneZahl == 21) {
			JOptionPane.showMessageDialog(null, "Sie haben Meier angesagt und gelogen, also müssen sie trinken");
			throw new Exception("no Meier Eception");
		}
		while(((gelogeneZahl / 10) < (gelogeneZahl % 10)) && (gelogeneZahl % 10 != gelogeneZahl / 10) && (gelogeneZahl != 21)) {
			input = JOptionPane.showInputDialog("Diese Zahl ist ungültig. Die Zehnerstelle " + 
						" muss haeher als die Einerstelle sein (ausser bei Pasch)");
				gelogeneZahl = Integer.parseInt(input);
		}
		if (gelogeneZahl < getErgebnis()) {
			setErgebnis(gelogeneZahl);
			gelogeneZahl = 0;
		}
	}
	
	// Wenn nicht gelogen wurde wird 1 ausgegeben, sonst 0
	private boolean luegtOderNichtPane() {
		int eingabe;
		boolean rundeBeenden = false;
		if (gelogeneZahl > 0) { 
			eingabe = JOptionPane.showConfirmDialog(null, "Glauben sie dem vorigen Spieler, dass er " + getGelogeneZahl() + " gewürfelt hat?",
					"Glauben sie dem Spieler?", JOptionPane.YES_NO_OPTION);
		}
		else {
			eingabe = JOptionPane.showConfirmDialog(null, "Glauben sie dem vorigen Spieler, dass er " + getErgebnis() + " gewürfelt hat?",
					"Glauben sie dem Spieler?", JOptionPane.YES_NO_OPTION);
		}
		if (eingabe == 1) {
			rundeBeenden = true;
			if (getGelogeneZahl() > 0)
				JOptionPane.showMessageDialog(null, "Sie hatten Recht, " + spieler.getSpielerName(spieler.getAktuellerSpielerIndex() - 1) + 
						" hatte nur " + getErgebnis() + ". Er muss trinken");
			else
				JOptionPane.showMessageDialog(null, "Sie hatten Unrecht, " + spieler.getSpielerName(spieler.getAktuellerSpielerIndex() - 1) + 
						" hatte wirklich " + getErgebnis() + "\nSie müssen trinken");
		}
		return rundeBeenden;
	}
	
	private void naechsterSpielerDranPane() {
		spieler.incrementAktuellerSpieler();
		JOptionPane.showMessageDialog(null, spieler.getSpielerName(spieler.getAktuellerSpielerIndex()) + " ist dran");	
	}
	
	private boolean FrageNachNochEinerRunde() {
		boolean rundeBeenden = false;
		int eingabe = JOptionPane.showConfirmDialog(null, "Maechten sie noch eine Runde spielen?", "Noch ne Runde?", JOptionPane.YES_NO_OPTION);
		if (eingabe == 1)
			rundeBeenden = true;
		return rundeBeenden;
	}

	
	public void spielen() 
	{
		boolean rundeBeenden = false;
		
		do {
			try {
				if (getVorigeZahl() == 0) {
					ersterZugPane();
					naechsterSpielerDranPane();
					luegtOderNichtPane();
				}
				while (!rundeBeenden) {
					weitererZugPane();
					if (luegtOderNichtPane())
						rundeBeenden = FrageNachNochEinerRunde();
					naechsterSpielerDranPane();
				}
				setVorigeZahl(0);
				setErgebnis(0);
				setGelogeneZahl(0);
				System.out.println("ende"); //test
			} catch (Exception e) {}
		} while (!rundeBeenden);
	}
}
