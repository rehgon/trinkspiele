package kartenSpiele;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class KartenSpiel {
	
	private Random generator = new Random();
	private ArrayList<String> deck;
	private File[] imgFiles;
	private BufferedImage[] img;
	private String[] kartenSymbole;
	private String[] kartenWerte;
	private String[] aktuellGezogeneKarten;
	
	public KartenSpiel() {
		
		generator = new Random();
		deck = new ArrayList<String>();
		kartenSymbole = new String[] { "Karo", "Kreuz", "Herz", "Pik" };
		kartenWerte = new String[] { "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "Bube", "Dame", "Kaenig", "Ass"};
		//Grafiken laden
		imgFiles = new File[52];
		img = new BufferedImage[52];
		
		geordnetesDeckGenerieren();
	}
	
	public ArrayList<String> getDeck() {
		return deck;
	}
	//Gibt die aktuell gezogenen Karten zurück
	public String[] getAktuellGezogeneKarten() {
		return aktuellGezogeneKarten;
	}
	//Gibt die aktuell gezogene Karte zurück
	public String getAktuellGezogeneKarten(int welche) {
		return aktuellGezogeneKarten[welche];
	}
	public void setDeck(ArrayList<String> neuesDeck) {
		this.deck = neuesDeck;
	}
	//Gibt die Karte als String an der gewünschten Position zurück
	public String getKarte(int index) {
		return deck.get(index);
	}
	public BufferedImage getImg(int position) {
		return img[position];
	}
	//Gibt die Position einer Karte im Deck als int zurück
	public int getPositionOfKarte(String karte) {
		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i).equals(karte))
					return i;
		}
		return -1;
	}
	
	//Generiert ein neues Deck, welches sortiert ist von Karo 2 bis Pik Ass
	public void geordnetesDeckGenerieren() {
		deck.removeAll(deck);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				deck.add(kartenSymbole[i] + " " + kartenWerte[j]);
				imgFiles[i] = new File("src/images/pokerkarten_klein/" + kartenSymbole[i] + kartenWerte[j] + ".gif");
				try {
					img[i] = ImageIO.read(imgFiles[i]);
				} catch (IOException e) {}
			}
		}
		for (int i = 0; i <= 51; i++) {
			
		}
	}
	
	//Mischt ein Deck
	public void deckMischen() {
		ArrayList<String> tmpDeck = new ArrayList<String>();
		for (int i = 0; i < 52; i++) {
			int m = generator.nextInt(deck.size());
			tmpDeck.add(deck.get(m));
			deck.remove(m);
		}
		deck = tmpDeck;
	}
	
	//Gibt das ganze Deck von Oben nach Unten als String aus
	public String deckAuslesen() {
		String output = "";
		for (int i = 0; i < deck.size(); i++) {
			output += deck.get(i);
			if (i != deck.size() -1 )
				output += ", ";
		}
		return output;
	}
	
	//Zieht irgendwo aus dem Deck eine bestimmte Anzahl zufaelliger Karten
	public String[] zufaelligeKarten(int wieviele) {
		String[] dieHand = new String[wieviele];
		if (deck.size() == 0 || deck.size() < wieviele) {
			dieHand = new String[]{ "Deck enthaelt zuwenig Karten" };
			return dieHand;
		}
		for (int i=0; i<dieHand.length; i++) {
			int zufall = generator.nextInt(deck.size());
			dieHand[i] = deck.get(zufall);
			deck.remove(zufall);
		}
		aktuellGezogeneKarten = dieHand;
		return dieHand;
	}
	
	//Zieht von oben eine bestimmte Anzahl Karten
	public String[] kartenZiehen(int wieviele) {
		String[] karte = { "Deck enthaelt zu wenig Karten" };
		if (wieviele > deck.size())
			karte = new String[wieviele];
		for (int i = 0; i < karte.length; i++) {
			karte[i] = deck.get(i);
			deck.remove(i);
		}
		aktuellGezogeneKarten = karte;
		return karte;
	}
	
	//Gibt das die gezogene Hand als String aus
	public String handAuslesen(String[] dieHand) {
		String output = "";
		for (int i = 0; i < dieHand.length; i++) {
			output += dieHand[i];
			if (i != dieHand.length - 1)
				output += ", ";
		}
		return output;
	}
	
	//Bestimmt den Wert einer Karte, Zahlen=Zahlenwert, Bube=11, Dame=12, Kaenig=13, Ass=1
	public int kartenWertBestimmen(String karte) {
		String wert = karte.substring(karte.indexOf(" ") + 1);
		
		if (wert.equals(kartenWerte[9]))
			return 11;
		else if (wert.equals(kartenWerte[10]))
			return 12;
		else if (wert.equals(kartenWerte[11]))
			return 13;
		else if (wert.equals(kartenWerte[12]))
			return 1;
		else
			return Integer.parseInt(wert);
	}
	
	//Bestimmt, ob die erste Karte Haeher ist, als die zweite
	public boolean istHoeher(String wertKarte1, String wertKarte2) {
		
		int karte1 = 0, karte2 = 0;
		String karteString1 = wertKarte1.trim().substring(wertKarte1.indexOf(" ") + 1);
		String karteString2 = wertKarte2.trim().substring(wertKarte2.indexOf(" ") + 1);
		
		if (karteString1.equals(kartenWerte[12]))
			karte1 = 1;
		if (karteString2.equals(kartenWerte[12]))
			karte2 = 1;
			
		for (int i = 0; i < 3; i++) {
			if (karteString1.equals(kartenWerte[i + 9]))
				karte1 = (i + 11);
			if (karteString2.equals(kartenWerte[i + 9]))
				karte2 = (i + 11);
		}
		
		if (karte1 == 0)
			karte1 = Integer.parseInt(karteString1);
		if (karte2 == 0)
			karte2 = Integer.parseInt(karteString2);
		
		if (karte1 > karte2)
			return true;
		else
			return false;
	}
	
	public BufferedImage aktuelleKarteGrafikLaden(int welche) {
		BufferedImage img = null;
		File imgFile = new File("src/images/pokerkarten_klein/" + getAktuellGezogeneKarten(welche) + ".gif");
		try {
			img = ImageIO.read(imgFile);
		} catch (IOException e) {}
		return img;
	}
	
	public static void main (String[] args) {
		KartenSpiel k = new KartenSpiel();
		k.geordnetesDeckGenerieren();
		System.out.println("Die Karten ungemischt: " + k.deckAuslesen());
		k.deckMischen();
		System.out.println("Die Karten gemischt: " + k.deckAuslesen());
		String[] s = k.zufaelligeKarten(2);
		System.out.println("Meine zufaellige Hand aus zwei Karten: " + k.handAuslesen(s));
		k.geordnetesDeckGenerieren();
		System.out.println("wieder geordnet: " + k.deckAuslesen());
	}
}
