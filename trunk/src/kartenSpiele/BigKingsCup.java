package kartenSpiele;

import spieler.Spieler;

public class BigKingsCup extends KartenSpiel {
	
	Spieler spieler;
	
	public BigKingsCup() {
		geordnetesDeckGenerieren();
		deckMischen();
		spieler = new Spieler("Big King's Cup");
		spieler.spielerSetzen();
	}
	
	public Spieler getSpieler() {
		return spieler;
	}

	public String karteZiehenUndAuswerten() {
		
		
		String ausgabe = "";
		String[] wertArray = zufaelligeKarten(1);
		String karte = wertArray[0];
		if (wertArray[0].equals("Deck enthaelt zuwenig Karten")) {
			ausgabe = "Alle Karten wurden gezogen, Deck wird neu gemischt";
			geordnetesDeckGenerieren();
			deckMischen();
			return ausgabe;
		}
			
		ausgabe += spieler.getAktuellerSpieler() + " hat " + wertArray[0] + " gezogen, das bedeutet: ";
		int wert = kartenWertBestimmen(karte);
		
		if (wert == 2) {
			ausgabe += "KATEGORIE\n\n" +
					"Der Spieler sucht sich ein Genre aus (z.B. Obstarten, Getraenkemarken, Zigaretten)\n" +
					"nennt einen Begriff daraus. Nun muss reihum jeweils ein weiterer genannt werden,\n" +
					"solange bis einem Spieler kein Begriff mehr einfaellt, einen bereits genannten\n" +
					"Begriff noch einmal nennt oder sich sonstwie vertut. Dieser muss dann trinken.";
		}
		else if (wert == 3) {
			ausgabe += "REIM\n\n" +
					"Der Spieler sucht sich ein beliebiges Wort aus (z.B. Tisch) und nun geht es wieder\n" +
					"reihum. Jeder muss ein sich darauf reimendes Wort (z.B. Fisch,..) nennen. Der erste,\n" +
					"dem keins mehr einfaellt trinkt";
		}
		else if (wert == 4) {
			ausgabe += "QUESTIONMASTER\n\n" +
					"Dem Spieler, der eine 4 zieht, dürfen keine Fragen mehr beantwortet werden ü egal\n" +
					"welcher Art. Dies kann und soll er natürlich ausnutzen, um die anderen zum\n" +
					"Trinken zu bringen, denn wer antwortet, muss trinken. Der Spieler hat den\n" +
					"Status üQuestionmaster solange, bis ein anderer Spieler eine weitere 4 zieht.";
		}
		else if (wert == 5) {
			ausgabe += "COUNTER\n\n" +
					"Der Spieler sucht sich eine Zahl zwischen 3 und 9 aus. Nun geht es reihum und es\n" +
					"wird gezaehlt. Jedoch muss bei jeder Zahl, welche durch die ausgewaehlte teilbar\n" +
					"ist oder in der diese Ziffer vorkommt, nicht die Zahl sondern ein vorher\n" +
					"festzulegendes Wort genannt werden (Empfehlung: FICKEN). Das sieht dann\n" +
					"folgendermaüen aus (bei der gewaehlten Zahl 3): 1, 2, ficken, 4, 5,\n" +
					"ficken, 7, 8, ficken, 10, 11, ficken, ficken, 14ü usw. Wer sich vertut,\n" +
					"inwiefern auch immer, muss trinken.";
		}
		else if (wert == 6) {
			ausgabe += "KLOKARTE\n\n" +
					"Da vor allem Bier gut auf die Blase geht, ist es sehr nützlich, sich auf der Toilette\n" +
					"dem Harndrangs zu entledigen. Dies ist aber nur im Besitz einer Klokarte erlaubt.";
		}
		else if (wert == 7) {
			ausgabe += "FETTNüPFCHEN\n\n" +
					"Trinke selber.";
		}
		else if (wert == 8) {
			ausgabe += "DAUMENMASTER\n\n" +
					"Der Spieler ist nun analog zum Questionmaster der Thumbmaster. Dies bedeutet,\n" +
					"dass er beliebig oft und nach Lust und Laune seinen Daumen auf die Tischkante\n" +
					"legen kann. Nun müssen alle anderen ebenfalls ihren Daumen auf die Tischkante\n" +
					"legen. Der letzte, der es checkt, muss trinken.";
		}
		else if (wert == 9) {
			ausgabe += "REGEL AUSDENKEN\n\n" +
					"Die 9 ist mit die beliebteste Karte, denn hier darf sich der Spieler selbst eine\n" +
					"beliebige Regel ausdenken, die dann das gesamte restliche Spiel über gilt.\n" +
					"Sehr zu empfehlende Vorschlaege sind:\n" +
					"- Man darf generell keine Namen mehr nennen oder alle Leute heiüen McLovin\n" +
					"- Man darf auf niemanden mehr zeigen\n" +
					"- Man darf das Wort ütrinkenü nicht mehr sagen\n" +
					"- (beliebig ausbaufaehig)";
		}
		else if (wert == 10) {
			ausgabe += "10 SCHLüCKE VERTEILEN\n\n" +
					"Der Spieler darf an die übrigen Mitspieler zehn Schlücke verteilen.";
		}
		else if (wert == 11) {
			ausgabe += "MüNNER TRINKEN\n\n" +
					"Alle Kerle müssen trinken.";
		}
		else if (wert == 12) {
			ausgabe += "MüDELS TRINKEN\n\n" +
					"Alle Maedels müssen trinken.";
		}
		else if (wert == 13) {
			ausgabe += "KING'S CUP\n\n" +
					"Der Spieler füllt das groüe Glas in der Mitte mit einem beliebigen Getraenk seiner\n" +
					"Wahl, so dass es im Anschluss zu einem Viertel gefüllt ist. Der Spieler, welcher\n" +
					"den zweiten Kaenig zieht, füllt das Glas bis zur Haelfte, der dritte zu drei\n" +
					"Vierteln. Der vierte Kaenig muss seinen eigenen Glasinhalt dazukippen und das\n" +
					"groüe Glas (den Big Kingüs Cup) leer-exen! PROST!";
		}
		else if (wert == 1) {
			ausgabe += "ALLE TRINKEN\n\n" +
					"Schlichtes Hochpuschen des Kollektivpegels.";
		}
		else {
			ausgabe += "CRITICAL ERROR";
		}
		ausgabe += "\n\nAls naechstes ist " + spieler.getNaechsterSpieler() + " dran";
		return ausgabe;
	}
}
