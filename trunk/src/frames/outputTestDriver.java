package frames;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class outputTestDriver 
{
	public static void main (String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		String fileName = "src/txt/out.txt";
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		
		
		try {
				outputStream = new PrintWriter(new FileOutputStream(fileName, true));
		}
		catch(FileNotFoundException e) {}
		String line = JOptionPane.showInputDialog("eingabe");
		outputStream.println(line);
		outputStream.close();
		
		
		try {
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e) {}
		while (inputStream.hasNextLine()) {
			list.add(inputStream.nextLine());
		}
		inputStream.close();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
