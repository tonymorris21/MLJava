import java.math.BigDecimal;

public class DataProcessing 
{
	static int temp;
	static int aches;
	static int cough;
	static int throat;
	static int dangerzone;
	
	static int tempN;
	static int achesN;
	static int coughN;
	static int throatN;
	static int dangerzoneN;
	static double probabilityYes=0;
	static double probabilityNo=0;
	static double probability=0;
	static double covidNo = 0;
	static double covidYes = 0;
	public static void processResults(String Temp, String Aches, String Cough, String Throat, String Dangerzone)
	{
		System.out.println(Temp);
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
			achesN = FileProcessing.achesNy;
		}
		if(Cough=="no")
		{
			cough=FileProcessing.coughYn;
			coughN = FileProcessing.coughNy;
		}
		if(Throat=="no")
		{
			throat=FileProcessing.sorethroatYn;
			throatN=FileProcessing.sorethroatNy;
		}
		if(Dangerzone=="no")
		{
			dangerzone=FileProcessing.dangerzoneYn;
			dangerzoneN=FileProcessing.dangerzoneNy;
		}
		
		
	}
	public static void processData() {
		

		probabilityYes = temp/FileProcessing.covidY * aches/FileProcessing.covidY * cough/FileProcessing.covidY * throat/FileProcessing.covidY * dangerzone/FileProcessing.covidY*FileProcessing.covidY/FileProcessing.datacount;
		probabilityNo = tempN/FileProcessing.covidN * achesN/FileProcessing.covidN * coughN/FileProcessing.covidN * throatN/FileProcessing.covidN * dangerzoneN/FileProcessing.covidN*FileProcessing.covidN/FileProcessing.datacount;
		
		covidNo = probabilityNo/(probabilityYes+probabilityNo);
		covidYes = probabilityYes/(probabilityYes+probabilityNo);
		
		

	
	}

}
