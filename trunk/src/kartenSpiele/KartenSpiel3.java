package kartenSpiele;

import java.util.Random;

public class KartenSpiel3 {

	private  String[] pik = new String[13];
	private  String[] kreuz = new String[13];
	private  String[] herz = new String[13];
	private  String[] karo = new String[13];
	public  String[] deck = new String[52];
	private  int[] placeHolder = new int[52];
	private  int[] pHolderCards = new int[13];
	private  int freecardplace = 0;
	private  boolean cardWasTaken = false;  
	private  boolean isFree = false;
	private  int j = 0;
	private  void setPik()
	{
		pik[0] = "Pik Ass";		pik[1] = "Pik 2";	pik[2] = "Pik 3";
		pik[3]	= "Pik 4";		pik[4] = "Pik 5"; 	pik[5] = "Pik 6";		
		pik[6]	= "Pik 7" ;		pik[7] = "Pik 8";	pik[8] = "Pik 9";   
		pik[9]	= "Pik 10";		pik[10] = "Pik Bube";    pik[11] = "Pik Dame";
		pik[12] = "Pik Kaenig";				      					             		    
	}
	private void setKreuz()
	{
		kreuz[0] = "Kreuz Ass";		kreuz[1] = "Kreuz 2";	kreuz[2] = "Kreuz 3";
		kreuz[3] = "Kreuz 4";		kreuz[4] = "Kreuz 5"; 	kreuz[5] = "Kreuz 6";		
		kreuz[6]	= "Kreuz 7" ;	kreuz[7] = "Kreuz 8";	kreuz[8] = "Kreuz 9";   
		kreuz[9]	= "Kreuz 10";	kreuz[10] = "Kreuz Bube";    kreuz[11] = "Pik Dame";
		kreuz[12] = "Kreuz Kaenig";				
	}
	private  void setHerz()
	{
		herz[0] = "Herz Ass";	herz[1] = "Herz 2";		herz[2] = "Herz 3";
		herz[3]	= "Herz 4";		herz[4] = "Herz 5"; 	herz[5] = "Herz 6";		
		herz[6]	= "Herz 7" ;	herz[7] = "Herz 8";		herz[8] = "Herz 9";   
		herz[9]	= "Herz 10";	herz[10] = "Herz Bube";    herz[11] = "Herz Dame";
		herz[12] = "Herz Kaenig";				
	}
	private void setKaro()
	{
		karo[0] = "Karo Ass";		karo[1] = "Karo 2";	 	karo[2] = "Karo 3";
		karo[3]	= "Karo 4";			karo[4] = "Karo 5"; 	karo[5] = "Karo 6";		
		karo[6]	= "Karo 7" ;		karo[7] = "Karo 8";		karo[8] = "Karo 9";   
		karo[9]	= "Karo 10";		karo[10] = "Karo Bube";    karo[11] = "Karo Dame";
		karo[12] = "Karo Kaenig";				
	}
	private void shufflePik(String[] pik, String newDeck[])
	{
		//System.out.println("Shuffle Pik");
		Random shuffler = new Random();
		int i,k= 0, zufallsZahl;
		boolean progress = true;
		while((progress == true)&& ( k < 13))
		{
			//System.out.println("will shuffle now");
			zufallsZahl = shuffler.nextInt(13);
			//System.out.println("zufaelllige zahl = " + zufallsZahl);
			i = shuffler.nextInt(52);
			
			
				checkIfCardisAllreadyTaken(zufallsZahl, pHolderCards);
				checkPlaceForCardPlace(i,placeHolder);
				if((cardWasTaken == false)&&(isFree == false))
				{
					pHolderCards[k]= zufallsZahl;
					placeHolder[j] = i;
					k++;
					j++;
					newDeck[i] = pik[zufallsZahl];
					//System.out.println("Karte wurde an " + j + " plaziert und es wurde " + pik[zufallsZahl] + " gewaehlt");
					
					
					
				}
				else{
					
					progress = true;
					}
			
			}
		resetPHolderCards();
			
		}
	private void shuffleKreuz(String[] karo, String[] newDeck)
	{
		//System.out.println("shuffle kreuz");
		Random shuffler = new Random();
		
		int i,k= 0, zufallsZahl;
		boolean progress = true;
		while((progress == true)&& ( k < 13))
		{
			zufallsZahl = shuffler.nextInt(13);
			i = shuffler.nextInt(52);
			
				checkPlaceForCardPlace(i,placeHolder);
				checkIfCardisAllreadyTaken(zufallsZahl, pHolderCards);
				if((cardWasTaken == false)&&(isFree == false))
				{
					pHolderCards[k]= zufallsZahl;
					placeHolder[j] = i;
					k++;
					j++;
					
					newDeck[i] = karo[zufallsZahl];
					
					
					
				}
				else{
					
					progress = true;
				}
			}
		resetPHolderCards();
	}
	
	private void shuffleHerz(String[] herz, String newDeck[])
	{
		//System.out.println("Shuffle herz");
		Random shuffler = new Random();
		
		int i,k= 0, zufallsZahl;
		boolean progress = true;
		while((progress == true)&& ( k < 13))
		{
			zufallsZahl = shuffler.nextInt(13);
			i = shuffler.nextInt(52);
			//System.out.println("checking if card was allready taken");
			checkIfCardisAllreadyTaken(zufallsZahl, pHolderCards);
			checkPlaceForCardPlace(i,placeHolder);
				if((cardWasTaken == false)&&(isFree == false))
				{
					//System.out.println("card was not taken");
					pHolderCards[k]= zufallsZahl;
					placeHolder[j] = i;
					k++;
					j++;
					
					newDeck[i] = herz[zufallsZahl];
					
					
					
				}
				else{
					
					progress = true;
				}
			}
			
		resetPHolderCards();
		}		
		
	private void shuffleKaro(String[] karo, String newDeck[])
	{
		//System.out.println("Shuffle karo");
		Random shuffler = new Random();
		
		int i,k= 0, zufallsZahl;
		boolean progress = true;
		while((progress == true)&& ( k < 13))
		{
			zufallsZahl = shuffler.nextInt(13);
			i = shuffler.nextInt(52);
			
			
				checkIfCardisAllreadyTaken(zufallsZahl, pHolderCards);
				checkPlaceForCardPlace(i,placeHolder);
				if((cardWasTaken == false)&&(isFree == false))
				{
					pHolderCards[k]= zufallsZahl;
					placeHolder[j] = i;
					k++;
					j++;
					
					newDeck[i] = karo[zufallsZahl];
					
					
					
				}
				else{
					
					progress = true;
				}
			}
			
		resetPHolderCards();
		}
	
	private void resetPlaceHolders()
	{
		j = 0;
		for (int i = 0; i < placeHolder.length; i++) 
		{
			placeHolder[i] = 99;
		}
		for (int i = 0; i < pHolderCards.length; i++) {
			pHolderCards[i] = 99;
		}
	}
	private boolean checkPlaceForCardPlace(int number, int [] anArray)
	{
		 isFree = false;
		 for (int j = 0; j < anArray.length; j++) 
		 {
			if(number == anArray[j])
			{
				
				isFree = true;
			}
		}
		  return isFree;
	}
	private void resetPHolderCards()
	{
		for (int i = 0; i < pHolderCards.length; i++) 
		{
			pHolderCards[i] = 99;
		}
	}
  public int returnWhereFree()
  {
	  //System.out.println("Freecardplace at " + freecardplace);
	  return freecardplace;
	  
  }
  private boolean checkIfCardisAllreadyTaken(int number, int[] anArray)
  {
	  
	  cardWasTaken = false;
	 for (int j = 0; j < anArray.length; j++) 
	 {
		if(number == anArray[j])
		{
			//System.out.println("card was allready taken");
			cardWasTaken = true;
		}
	}
	  return cardWasTaken;
  }
  public  void shuffle()
  {
	  setHerz();
	  setKaro();
	  setKreuz();
	  setPik();
	  resetPlaceHolders();
	  shuffleHerz(herz, deck);
	  shuffleKaro(karo, deck);
	  shuffleKreuz(kreuz, deck);
	  shufflePik(pik, deck);
		//for (int l = 0; l < pHolderCards.length; l++) {
		//	System.out.println(pHolderCards[l]);
			
		//}
  }
  public  void printOutDeck()
  {
	  for (int i = 0; i < deck.length; i++) {
		System.out.println(deck[i]);
	}
  }
  
 }






