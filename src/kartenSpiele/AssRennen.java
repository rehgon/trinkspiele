package kartenSpiele;

public class AssRennen extends KartenSpiel {
	
	private int aceCounter;

	public AssRennen() {
		super.geordnetesDeckGenerieren();
		super.deckMischen();
		aceCounter = 0;
	}
	
	public int getAceCounter() {
		return aceCounter;
	}
	
	public String assRennenkarteZiehen() {
		String ausgabe = "";
		
		while (aceCounter < 4) {
			String[] karte = super.kartenZiehen(1);
			if(karte[0].contains("Ass")) {
				aceCounter++;
				String[] welchesAss = { "erste", "zweite", "dritte", "vierte" };
				ausgabe += "Sie haben \"" + karte[0] + "\" gezogen.\nDies ist das " + welchesAss[aceCounter - 1] + " Ass.\nEs muss " + aceCounter + "/4 getrunken werden.\n";
				if (aceCounter == 4)
					ausgabe += "Es wurden alle Asse aus dem Deck gezogen\nDas Spiel wird beendet";		
			}
			else
				ausgabe += "Sie haben \"" + karte[0] + "\" gezogen\nNichts passiert und der naechste Spieler ist dran";
			return ausgabe;
		}
		
		return ausgabe;
	}
}
