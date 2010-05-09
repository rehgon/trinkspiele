package kartenSpiele;

public class KartenOrakel extends KartenSpiel {
	
	private boolean keinFrischesSpiel;
	private String[] karten;
	private int anzahlRichtigeTreffer;
	private int anzahlFalscheTreffer;
	
	public KartenOrakel() {
		super();
		keinFrischesSpiel = false;
		karten = new String[2];
		anzahlRichtigeTreffer = 0;
		anzahlFalscheTreffer = 0;
		super.geordnetesDeckGenerieren();
		super.deckMischen();
	}
	
	public int getAnzahlRichtigeTreffer() {
		return anzahlRichtigeTreffer;
	}
	public int getAnzahlFalscheTreffer() {
		return anzahlFalscheTreffer;
	}
	
	public String spieleKartenOrakel(boolean haeher) {
		String ausgabe = "";
		String[] tmpKarte = super.zufaelligeKarten(1);
		karten[0] = karten[1];
		karten[1] = tmpKarte[0];
				
		ausgabe += "Sie haben \"" + karten[1] + "\" gezogen.\n\n";
		if (keinFrischesSpiel) {
			if (haeher) {
				if (super.istHoeher(karten[1], karten[0])) {
					ausgabe += "Die Karte ist tatsaechlich haeher, sie lagen richtig.\n";
					anzahlRichtigeTreffer++;
				}
				else {
					ausgabe += "Die Karte ist leider tiefer, sie lagen falsch.\n";
					anzahlFalscheTreffer++;
				}
			}
			else {
				if (!super.istHoeher(karten[1], karten[0])) {
					ausgabe += "Die Karte ist tatsaechlich tiefer, sie lagen richtig.\n";
					anzahlRichtigeTreffer++;
				}
				else {
					ausgabe += "Die Karte ist leider haeher, sie lagen falsch.\n";
					anzahlFalscheTreffer++;
				}
			}
		}
		keinFrischesSpiel = true;
		if (super.getDeck().size() != 0) {
			ausgabe += "Glauben sie die naechste Karte, die sie ziehen " + 
				" wird haeher oder tiefer sein als diese?\n";
		}
		return ausgabe;
	}	
}
