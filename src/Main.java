import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main 
{
	
	static int count =0;
	static int iteration = 0;
	
	static int hotY = 0;
	static int hotN = 0;
	static int normalY = 0;
	static int normalN = 0;
	static int coldY = 0;
	static int coldN = 0;
	static int coolY = 0;
	static int coolN = 0;
	
	static int achesYy = 0;
	static int achesYn = 0;
	static int achesNn = 0;
	static int achesNy = 0;
	
	static int coughY = 0;
	static int coughYn = 0;
	static int coughN = 0;
	static int coughNy = 0;
	
	static int sorethroatY = 0;
	static int sorethroatN = 0;
	static int sorethroatYn = 0;
	static int sorethroatNy = 0;
	
	static int dangerzoneY = 0;
	static int dangerzoneN = 0;
	static int dangerzoneYn = 0;
	static int dangerzoneNy = 0;
	
	static double covidY = 0;
	static double covidN = 0;
	
	static double probability = 0;

	
	public static void main(String[] args)
	{

		int datarows = getRows();		
		String[][] datad = getData(datarows);
		processData(datad);
			
		}
	    
	
	
	public static int getRows() {
		int datarows = 0;
		iteration=1;
		try (BufferedReader br = new BufferedReader(new FileReader("src/MLdata.csv"));)
		{
			String line;
			
			
			try {
				while ((line = br.readLine()) != null) {
					if(!(count>=3)) {
						count++;
						continue;
					}
					iteration++;
					datarows = (int) (iteration*0.7);
					System.out.println(datarows);
					
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			

} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		return datarows;
	
}
	
	
	public static String[][] getData(int datarows)
	{
		
		String[][] datad = new String[datarows][6];
		
		
		int row = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/MLdata.csv")))
		{
			String line;
			count=0;
			while (row != 53) {
				if(!(count>=3)) {
					count++;
					line=br.readLine();
					System.out.println(line);
					continue;
				}
				
				
				line=br.readLine();
				String [] data = line.split(",");
				datad[row][0] = data[0];
				datad[row][1] = data[1];
				datad[row][2] = data[2];
				datad[row][3] = data[3];
				datad[row][4] = data[4];
				datad[row][5] = data[5];
								
				System.out.println(row);
				System.out.println(line);
				
				row++;
				 
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return datad;
	
}
	public static void processData(String[][] datad)
	{
		
		for(int i = 0;i<datad.length;i++)
		{

			if(datad[i][5].equalsIgnoreCase("yes"))
			{
				covidY++;
				if(datad[i][0].equalsIgnoreCase("hot")){
					hotY++;
				}
				if(datad[i][0].equalsIgnoreCase("normal")){
					normalY++;
				}
				if(datad[i][0].equalsIgnoreCase("cold")){
					coldY++;
				}
				if(datad[i][0].equalsIgnoreCase("cool")){
					coolY++;
				}
				if(datad[i][1].equalsIgnoreCase("no")){
					achesYn++;
				}
				if(datad[i][1].equalsIgnoreCase("yes")){
					achesYy++;
				}
				if(datad[i][2].equalsIgnoreCase("no")) {
					coughYn++;
				}
				if(datad[i][2].equalsIgnoreCase("yes")) {
					coughY++;
				}
				if(datad[i][3].equalsIgnoreCase("yes")) {
					sorethroatY++;
				}
				if(datad[i][3].equalsIgnoreCase("no")) {
					sorethroatYn++;
				}
				if(datad[i][4].equalsIgnoreCase("no")) {
					dangerzoneYn++;
				}
				if(datad[i][4].equalsIgnoreCase("yes")) {
					dangerzoneY++;
				}
			}
			else if(datad[i][5].equalsIgnoreCase("no")) {
				covidN++;
				if(datad[i][0].equalsIgnoreCase("hot")){
					hotN++;
				}
				if(datad[i][0].equalsIgnoreCase("normal")){
					normalN++;
				}
				if(datad[i][0].equalsIgnoreCase("cold")){
					coldN++;
				}
				if(datad[i][0].equalsIgnoreCase("cool")){
					coolN++;
				}
				if(datad[i][1].equalsIgnoreCase("no")){
					achesNn++;
				}
				if(datad[i][1].equalsIgnoreCase("yes")){
					achesNy++;
				}
				if(datad[i][2].equalsIgnoreCase("no")) {
					coughN++;
				}
				if(datad[i][2].equalsIgnoreCase("yes")) {
					coughNy++;
				}
				if(datad[i][3].equalsIgnoreCase("no")) {
					sorethroatN++;
				}
				if(datad[i][3].equalsIgnoreCase("yes")) {
					sorethroatNy++;
				}
				if(datad[i][4].equalsIgnoreCase("no")) {
					dangerzoneN++;
				}
				if(datad[i][4].equalsIgnoreCase("yes")) {
					dangerzoneNy++;
				}
			}
			
			
		}
			System.out.println("Hot Yes" + hotY + "Aches Yes" + achesYy + "Cough Yes" + coughY + "Sore Throat Yes" + sorethroatY + "dz yes" + dangerzoneY);
			System.out.println("Hot No" + hotN + "Aches No" + achesNy + "Cough No" + coughNy + "Sore Throat No" + sorethroatNy + "dz no" + dangerzoneNy);

			double prob = hotY/covidY * achesYy/covidY * coughY/covidY * sorethroatY/covidY * dangerzoneY/covidY * covidY/datad.length;
			double probN = hotN/covidN*achesNy/covidN*coughNy/covidN*sorethroatNy/covidN*dangerzoneNy/covidN*covidN/datad.length;
			double probability = prob/(prob+probN);
			double probabilityN = probN/(prob+probN);

			System.out.println(probabilityN);
			
	}
}

