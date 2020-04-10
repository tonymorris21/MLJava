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
	static int coldY = 0;
	static int cooly = 0;
	static int achesy = 0;
	static int coughy = 0;
	static int sorethroaty = 0;
	static int normalN = 0;
	static int coldN = 0;
	static int coolN = 0;
	static int achesN = 0;
	static int coughN = 0;
	static int sorethroatN = 0;
	static int dangerzone = 0;
	static int dangerzoneN = 0;
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
				System.out.println(data[0] + " " + data[1]);
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
		System.out.println(datad[0][0]+datad[0][1]+datad[0][2]+datad[0][3]+datad[0][4]+datad[0][5]);
		System.out.println(datad[1][0]+datad[1][1]+datad[1][2]+datad[1][3]+datad[1][4]+datad[1][5]);
	}
}

