import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class FileProcessing 
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
	static int datacount;
	static int achesYy = 0;
	static int achesYn = 0;
	static int achesNn = 0;
	static int achesNy = 0;
	static double testprob = 0;
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

	static int testrows;

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
					
					datarows = (int) (iteration*0.70);
					testrows = iteration-datarows;
					
					
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			

} catch (FileNotFoundException e1) {
	
	e1.printStackTrace();
} catch (IOException e1) {
	
	e1.printStackTrace();
}
		return datarows;
	
}
	
	// puts data into datad string 2d array 
	public static String[][] getData(int datarows)
	{
		
		String[][] datad = new String[datarows][6];
		
		
		int row = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/MLdata.csv")))
		{
			String line;
			count=0;
			//skips the first 3 lines of the csv
			while (row != datarows) {
				if(!(count>=3)) {
					count++;
					line=br.readLine();
					
					continue;
				}
				
				//stores data in datad[][]
				line=br.readLine();
				String [] data = line.split(",");
				datad[row][0] = data[0];
				datad[row][1] = data[1];
				datad[row][2] = data[2];
				datad[row][3] = data[3];
				datad[row][4] = data[4];
				datad[row][5] = data[5];
								
				
				
				row++;
				 
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return datad;
	
}
	//finds the frequencies of the various column labels
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
			coldY = 1;
			DecimalFormat format = new DecimalFormat("0.#####");
			double prob = coldY/covidY* achesYn/covidY * coughYn/covidY * sorethroatYn/covidY * dangerzoneYn/covidY *covidY/datad.length;
			double probN = coldN/covidN*achesNn/covidN*coughN/covidN*sorethroatN/covidN*dangerzoneN/covidN*covidN/datad.length;
			System.out.println(format.format(prob));
			double probandn = prob+probN;
			System.out.println("ColdY" + coldY + "achesYn" + achesYn + "coughYn" + coughYn + "sorethroatYn" + sorethroatYn + "dangerzoneYn" + dangerzoneYn);
			double probabilit1y = probN/probandn;
			System.out.println(format.format(probN));
			System.out.println(format.format(probabilit1y));

			datacount = datad.length;
			
	}
	
	//gets the testdata and forwards the data onto DataProcessing.processResults and then DataProcessing.processData
	public static void testData() {
		int row = 2;
		int correct = 0;
		int incorrect = 0;
		int count = 0;
		
		String dataTest[][] = new String[testrows+1][6];
		try (BufferedReader br = new BufferedReader(new FileReader("src/MLdata.csv")))
		{
			String line;
			count=0;
			while (row !=  testrows+1) {
				if(count<getRows()) {
					count++;
						line=br.readLine();
						

					
					
					continue;
				}
				
				
				line=br.readLine();
				//stores data in dataTest[]
				
				String [] data = line.split(",");
				
				dataTest[row][0] = data[0];
				dataTest[row][1] = data[1];
				dataTest[row][2] = data[2];
				dataTest[row][3] = data[3];
				dataTest[row][4] = data[4];
				dataTest[row][5] = data[5];
								
				
				
				row++;
				 
			}
			String temp = null;
			String aches = null;
			String dangerzone = null;
			String cough = null;
			String throat = null;
			for(int i = 0;i<dataTest.length;i++)
			{
			;
				if("hot".equals(dataTest[i][0])){
						temp = "Hot";
				}
				if("normal".equals(dataTest[i][0])){
						temp = "Normal";
				}
				if("cold".equals(dataTest[i][0])){
						temp = "Cold";
				}
				if("cool".equals(dataTest[i][0])){
						temp = "Cool";
				}
				if("no".equals(dataTest[i][1])){
						aches = "no";
				}
				if("yes".equals(dataTest[i][1])){
						aches = "yes";
				}
				if("no".equals(dataTest[i][2])) {
						cough = "no";
				}
				if("yes".equals(dataTest[i][2])) {
						cough = "yes";
				}
				if("yes".equals(dataTest[i][3])) {
						throat = "yes";
				}
				if("no".equals(dataTest[i][3])) {
						throat = "no";
				}
				if("no".equals(dataTest[i][4])) {
						dangerzone= "no";
				}
				if("yes".equals(dataTest[i][4])) {
						dangerzone = "yes";
				}
			
				DataProcessing.processResults(temp, aches, cough, throat, dangerzone);
				DataProcessing.processData();
				if(DataProcessing.covidNo>DataProcessing.covidYes)
				{
					System.out.println(dataTest[i][5]);
					if("no".equals(dataTest[i][5]))
					{
						correct++;
					}
					else {
						incorrect++;
					}
				}
				if(DataProcessing.covidYes>DataProcessing.covidNo)
				{
					if("yes".equals(dataTest[i][5]))
					{
						correct++;
					}
					else {
						incorrect++;
					}
					
				}
				}

			int total = incorrect+correct;
			testprob = ((double)correct / total*100);
			
				
				
				
				
			

	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
	
}
