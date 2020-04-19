/*******************************************************
*
*   control class to run the screen for Lab 5
*
*
********************************************************/


public class Control {


	// this is the method that is automatically run when you click "run"
	
	public static void main(String[] args) 
	{
	    
		int datarows = FileProcessing.getRows();		
		String[][] datad = FileProcessing.getData(datarows);
		FileProcessing.processData(datad);
		
		FileProcessing.testData();
		BaseScreen2 myScreen = new BaseScreen2("Hello");
		myScreen.setVisible(true);
	    
	}

}
