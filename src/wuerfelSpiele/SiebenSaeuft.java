package wuerfelSpiele;

public class SiebenSaeuft extends Wuerfelspiel {

	private int quersumme, maxPunkteBisEnde, ergebnissWurf, gesamtErgebnis;
	boolean saufen = false;
	public SiebenSaeuft()
	{
		super();
		quersumme = 0;
		ergebnissWurf = 0;
		maxPunkteBisEnde = 100;
		gesamtErgebnis = 0;
	}
	
	public int getQuersumme()
	{
		return quersumme;
	}
	public int getGesamtErgebnis() {
		return gesamtErgebnis;
	}
	
	public void setErgebnis(int ergebnis)
	{
		ergebnis = getErgebnis() + getCalculate();
		setErgebnis(ergebnis);
	}

	public  String prüfeObdurch7teilbar(int ergebnis)
	{
		String ausgabe = "";
		if(ergebnis % 7 == 0)
		{
			ausgabe += "Die Zahl ist durch 7 teilbar, es muss getrunken werden.\n";
		}
		else
		{
			ausgabe += "Die Zahl ist nicht durch 7 teilbar, es muss nicht getrunken werden\n";
		}
		return ausgabe;
	}
	public void prüfeQuersumme(int ergebnis)
	{
		int quersumme = 0;
		while(ergebnis > 0)
		{
			quersumme += ergebnis % 10;
			ergebnis = ergebnis/10;
		}
		this.quersumme = quersumme;
	}		
	
	public void calculate(int würfel1, int würfel2)
	{
		ergebnissWurf = würfel1 + würfel2;
	}
	public int getCalculate()
	{
		return ergebnissWurf;
	}
	public String saufOmat(int ergebnisWurf, int quersumme)
	{
		String ausgabe = "";
		if(ergebnisWurf == 7)
		{
			saufen = true;
			ausgabe += "Es wurde eine 7 geworfen!\n";
		}
		else if(quersumme == 7)
		{
			saufen = true;
			ausgabe += "Quersumme ist 7\n!";
		}
		else 
		{
			saufen = false;
		}
		return ausgabe;
	}
	public boolean getSaufOmat()
	{
		return saufen;
	}
	
	public void mussGesoffenWerden(boolean saufen)
	{
		String ausgabe = "";
		if(saufen == true)
		{
			ausgabe += " Es muss Gesoffen werden\n";
			
		}
	}
	public String chat()
	{
		String ausgabe = "";
		wuerfeln(2);
		calculate(getWuerfelZahl(0), getWuerfelZahl(1));
		ausgabe += "Es wurde eine " + getCalculate() + " geworfen.\n";
		gesamtErgebnis += getWuerfelZahl(0) + getWuerfelZahl(1);
		ausgabe +="Punkte Stand zur Zeit: " + getGesamtErgebnis() + "\n";
		ausgabe += prüfeObdurch7teilbar(getErgebnis());
		prüfeQuersumme(getErgebnis());
		saufOmat(getCalculate(), getQuersumme());
		mussGesoffenWerden(getSaufOmat());
		ausgabe += "bitte Würfeln\n";

		if (maxPunkteBisEnde <= getGesamtErgebnis()) {
			ausgabe = "Spiel zu Ende\nDanke fürs spielen";
		}
		return ausgabe;
	}
	
	
}
	


