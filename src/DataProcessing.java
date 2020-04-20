

public class DataProcessing 
{
	static int temp;
	static int aches;
	static int cough;
	static int throat;
	static int dangerzone;
	
	private static int tempN;
	private static int achesN;
	private static int coughN;
	private static int throatN;
	private static int dangerzoneN;
	

	static double covidNo = 0;
	static double covidYes = 0;
	
	//retrieves results from jframe option form and this method is also used for processing the test rows
	public static void processResults(String Temp, String Aches, String Cough, String Throat, String Dangerzone)
	{
		
		//gets frequencies for each of the selected options

		if(Aches=="yes")
		{
			aches=FileProcessing.achesYy;
			achesN = FileProcessing.achesNy;
		}
		if(Cough=="yes")
		{
			cough=FileProcessing.coughY;
			coughN = FileProcessing.coughNy;
		}
		if(Throat=="yes")
		{
			throat=FileProcessing.sorethroatY;
			throatN = FileProcessing.sorethroatNy;
		}
		if(Dangerzone=="yes")
		{
			dangerzone=FileProcessing.dangerzoneY;
			dangerzoneN = FileProcessing.dangerzoneNy;
		}
		if(Temp=="Hot")
		{
			temp=FileProcessing.hotY;
			System.out.println(temp);
			tempN = FileProcessing.hotN;
		}
		if(Temp=="Cold")
		{
			temp=FileProcessing.coldY;
			tempN = FileProcessing.coldN;
		}
		if(Temp=="Cool")
		{
			temp=FileProcessing.coolY;
			tempN = FileProcessing.coolN;
		}
		if(Temp=="Normal")
		{
			temp=FileProcessing.normalY;
			tempN = FileProcessing.normalN;
		}
		if(Aches=="no")
		{
			aches=FileProcessing.achesYn;
			achesN = FileProcessing.achesNn;
		}
		if(Cough=="no")
		{
			cough=FileProcessing.coughYn;
			coughN = FileProcessing.coughN;
		}
		if(Throat=="no")
		{
			throat=FileProcessing.sorethroatYn;
			throatN=FileProcessing.sorethroatN;
		}
		if(Dangerzone=="no")
		{
			dangerzone=FileProcessing.dangerzoneYn;
			dangerzoneN=FileProcessing.dangerzoneN;
		}
		
		
	}
	//calculates the probabilities
	public static void processData() {
		double probabilityYes=0;
		double probabilityNo=0;

		probabilityYes = temp/FileProcessing.covidY * aches/FileProcessing.covidY * cough/FileProcessing.covidY * throat/FileProcessing.covidY * dangerzone/FileProcessing.covidY*FileProcessing.covidY/FileProcessing.datacount;
		probabilityNo = tempN/FileProcessing.covidN * achesN/FileProcessing.covidN * coughN/FileProcessing.covidN * throatN/FileProcessing.covidN * dangerzoneN/FileProcessing.covidN*FileProcessing.covidN/FileProcessing.datacount;
		
		covidNo = probabilityNo/(probabilityYes+probabilityNo);
		covidYes = probabilityYes/(probabilityYes+probabilityNo);
		
		

	
	}

}
