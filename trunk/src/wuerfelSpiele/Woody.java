package wuerfelSpiele;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import spieler.Spieler;

public class Woody extends Wuerfelspiel {

	private String werIstWoody;
	private ImageIcon dices;
	private Spieler spieler;
	
	public Woody() {
		super();
		werIstWoody = "";
		dices = new ImageIcon("src/images/dices.jpg");
		spieler = new Spieler("Woody");
	}
	
	public String getWerIstWoody() {
		return werIstWoody;
	}
	public Spieler getSpieler() {
		return spieler;
	}
	
	//Bevor das Frame erscheint müssen die Spieler ihre Namen eingeben
	public boolean spielStarten() {
		spieler.setNameDesSpiels("Woody");
		boolean tOF = spieler.spielerSetzen();
		neuenWoodyBestimmen();
		return tOF;
	}
	
	//Wertet den Wurf aus und liefert die Ausgabe als String zurück
	public String auswerten(int ergebnis) {
		
		String ausgabe = "";
		String WoodyMussTrinken = "Der Woody(" + getWerIstWoody() + ") muss trinken";
		String nichtsPassiert = "Nichts passiert, du musst weitergeben";
		String neuerWoody = "Es gibt einen neuen Woody";
		String pasch = super.getWuerfelZahl(0) + "er Pasch, du darfst " + super.getWuerfelZahl(0) + " Schlücke verteilen";
		
		switch (ergebnis) {
			case 2:
				ausgabe = pasch; 
				break;
			case 3:
				if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
				{	
					neuenWoodyBestimmen();
					ausgabe = neuerWoody;
				} 
				else
					ausgabe = WoodyMussTrinken; 
				break;
			case 4:
				if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
					{
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else 
					{ 
						ausgabe = WoodyMussTrinken; 
					}
				} 
				else { ausgabe = pasch; } break;
			case 5:
				if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) {
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) {
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else 
					ausgabe = WoodyMussTrinken;
				} 
				else 
				{
					ausgabe = nichtsPassiert;
					spieler.incrementAktuellerSpieler(); 
				} 
				break;
			case 6:
				if (getWuerfelZahl(0) == 3 && getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) {
						ausgabe = pasch;
						neuenWoodyBestimmen();
						ausgabe = "3er Pasch, und es gibt einen neuen Woody";
					}
					else 
						ausgabe = "3er Pasch, und der Woody(" + getWerIstWoody() + ") muss einen trinken";
				}
				else if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
					{
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else
						ausgabe = WoodyMussTrinken;
				} 
				else 
				{
					ausgabe = nichtsPassiert;
					spieler.incrementAktuellerSpieler(); 
				} 
				break;
			case 7:
				if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
					{
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else 
					{
						ausgabe = "Dein linker Nachbar und der Woody(" + werIstWoody + ") müssen trinken"; 
					}
				} 
				else
					ausgabe = "Dein linker Nachbar muss einen trinken";
				break;
			case 8:
				if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
					{
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else
						ausgabe = WoodyMussTrinken;
				} 
				else if (getWuerfelZahl(0) == 4 && getWuerfelZahl(1) == 4)
					ausgabe = pasch;
				else 
				{
					ausgabe = nichtsPassiert;
					spieler.incrementAktuellerSpieler(); 
				} 
				break;
			case 9:
				if (getWuerfelZahl(0) == 3 || getWuerfelZahl(1) == 3) 
				{
					if (spieler.getAktuellerSpieler().equals(werIstWoody)) 
					{
						neuenWoodyBestimmen();
						ausgabe = neuerWoody;
					} 
					else 
						ausgabe = "Dein rechter Nachbar und der Woody(" + getWerIstWoody() + ") müssen trinken";
				} 
				else 
					ausgabe = "Dein rechter Nachbar muss einen trinken";
				break;
			case 10:
				if (getWuerfelZahl(0) == 5 && getWuerfelZahl(1) == 5)
					ausgabe = "5er Pasch, und alle nehmen einen Schluck";
				else
					ausgabe = "Alle nehmen einen Schluck... Cheers!!!";
				break;
			case 11:
				ausgabe = nichtsPassiert;
				spieler.incrementAktuellerSpieler(); break;
			case 12:
				ausgabe = "JACKPOT!!!, du darfst 12 Schlücke verteilen"; 
				break;
			default:
				ausgabe = "Critical Error!!!"; 
				break;
		} return ausgabe;
	}
	
	public String neuenWoodyBestimmen() {
		
		String s, s2;
		if (werIstWoody.equals("")) { s = ""; s2 = "";}
		else { s = "neuer"; s2 = "\nman darf natürlich auch sich selbst waehlen.";}
		
		int auswahl = JOptionPane.showOptionDialog(null, "Es muss ein " + s + " Woody gewaehlt werden;\n" +
				"Wer soll es sein?" + s2, "Wer wird " + s + " Woody?", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, dices, spieler.convertArrayListToArray(), spieler.getSpielerName(0));
		werIstWoody = spieler.getSpielerName(auswahl);
		return werIstWoody;
	}
}

