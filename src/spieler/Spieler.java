package spieler;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import frames.MainFrame;

public class Spieler {

	private String nameDesSpiels;
	private int welcherSpielerAlsNaechstes;
	private int aktuellerSpielerIndex;
	private ArrayList<String> spielerName;
	
	public Spieler(String nameDesSpiels) {
		this.nameDesSpiels = nameDesSpiels;
		welcherSpielerAlsNaechstes = 0;
		aktuellerSpielerIndex = 0;
		spielerName = new ArrayList<String>();
	}
	
	public String getNameDesSpiels() {
		return nameDesSpiels;
	}
	public void setNameDesSpiels(String name) {
		this.nameDesSpiels = name;
	}
	public int getWelcherSpielerAlsNaechstes() {
		return welcherSpielerAlsNaechstes;
	}	
	public void setWelcherSpielerAlsNaechstes(int spielerIndex) {
		this.welcherSpielerAlsNaechstes = spielerIndex;
	}
	public String getAktuellerSpieler() {
		return getSpielerName(getAktuellerSpielerIndex());
	}
	public int getAktuellerSpielerIndex() {
		return aktuellerSpielerIndex;
	}
	public void setAktuellerSpielerIndex(int spielerIndex) {
		this.aktuellerSpielerIndex = spielerIndex;
	}
	public ArrayList<String> getSpielerName() {
		return spielerName;
	}
	public String getSpielerName(int spielerIndex) {
		return spielerName.get(spielerIndex);
	}
	public void setSpielerName(ArrayList<String> namensListe) {
		this.spielerName = namensListe;
	}
	public void setSpielerName(String name) {
		spielerName.add(name);
	}
	public void incrementAktuellerSpieler() {
		if (aktuellerSpielerIndex == (spielerName.size() - 1))
			this.aktuellerSpielerIndex = 0;
		else
			aktuellerSpielerIndex++;
	}
	
	public String getVorigerSpieler() {
		if (getAktuellerSpielerIndex() != 0)
			return getSpielerName(getAktuellerSpielerIndex() - 1);
		else
			return getSpielerName(getSpielerName().size());	
	}	
	public String getNaechsterSpieler() {
		if (getAktuellerSpielerIndex() == (getSpielerName().size() - 1))
			return getSpielerName(0);
		else {
			return getSpielerName(getAktuellerSpielerIndex() + 1);
		}
	}
	
	
	
	public String naechsterSpieler() {
		int tmp = welcherSpielerAlsNaechstes; //tmp speichert den Wert von "welcherSpieler" um diesen dann unveraendert returnen zu kaennen
		if (welcherSpielerAlsNaechstes == getSpielerName().size() - 1)
			welcherSpielerAlsNaechstes = 0;
		else
			welcherSpielerAlsNaechstes++;
		return (getSpielerName().get(tmp) + ":");
	}

	public boolean spielerSetzen() {
		boolean noException = true;
		try {
			String[] zahlen = new String[9];
			for (int i = 0; i < zahlen.length; i++) {
				zahlen[i] = "" + (i + 2);
			}
			String wievieleSpielerString = (String)JOptionPane.showInputDialog(null, "Herzlich Willkommen bei " + getNameDesSpiels() + "!!!\nBevor sie starten kaennen müssen sie " +
					" zuerst einige Angaben machen.\nGeben sie als erstes die Anzahl Spieler ein:", getNameDesSpiels(), JOptionPane.QUESTION_MESSAGE, null,
					zahlen, zahlen[0]);
			int wievieleSpieler = 0;
			wievieleSpieler = Integer.parseInt(wievieleSpielerString);

			int spielercount = 1;
			for (int i = 0; i < wievieleSpieler; i++) {
				spielerName.add((String) JOptionPane.showInputDialog(null, "Geben sie den Namen für Spieler " + spielercount + " ein:", "Namenseigabe", JOptionPane.DEFAULT_OPTION,
						null, null, null));
				spielercount++;
				if (spielerName.get(i) == null)
					throw new Exception();
			}
			JOptionPane.showMessageDialog(null, "So, viel Spass.\nWir starten mit " + spielerName.get(0));
		}
		catch (Exception e) {
			noException = false;
			MainFrame main = new MainFrame();
			main.setVisible(true);
		}
		return noException;
	}
	
	public String[] convertArrayListToArray() {
		String[] spielerNameArray = new String[spielerName.size()];
		for (int i = 0; i < spielerName.size(); i++) {
			spielerNameArray[i] = spielerName.get(i);
		}
		return spielerNameArray;
	}
}


