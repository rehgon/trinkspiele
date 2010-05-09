package sonstiges;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SimonSays {

	private ArrayList<String> simonSaysList;
	
	private File fileName;
	PrintWriter outputStream = null;
	Scanner inputStream;
	
	public SimonSays()
	{
		initializeSimonSays();
	}
	private void initializeSimonSays()
	{
		fileName = new File("src/txt/simonSays.txt");
		
		simonSaysList = new ArrayList<String>();
		if (fileName.exists()) {
			try {
				inputStream = new Scanner(fileName);
			} catch (FileNotFoundException e) {
				System.out.println("Error");
			}
			while(inputStream.hasNextLine())
				setSimonsList(inputStream.nextLine());
			inputStream.close();
			simonSaysList.toString();
		}
		else {
			setNewPhraseToTxt("Ich war noch nie in Paris");
		}
	}
	
	public void setSimonsList(String newPhrase)
	{
		simonSaysList.add(newPhrase);
	}
	
	public ArrayList<String> getSimonSaysList() {
		return simonSaysList;
	}
	
	public String getSimonsListAt(int index) {
		return simonSaysList.get(index);
	}
	public String getRandomPhrase()
	{
		Random neueZahl = new Random();
		int zahl = neueZahl.nextInt(simonSaysList.size());
		return getSimonsListAt(zahl);
		
	}
	public void setNewPhraseToTxt(String phrase)
	{
		try{
			 outputStream = new PrintWriter(new FileOutputStream(fileName, true));
		}
		catch(FileNotFoundException e){
			System.out.println("Error" + fileName);
		}
		outputStream.println(phrase);
		outputStream.close();
	}
}
