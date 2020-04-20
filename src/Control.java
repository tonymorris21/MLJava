
public class Control {


	// this is the method that is automatically run when you click "run"
	
	public static void main(String[] args) 
	{
	    //gets rows to use with training model
		int datarows = FileProcessing.getRows();
		//gets frequencies from rows
		String[][] datad = FileProcessing.getData(datarows);
		//processes the results
		FileProcessing.processData(datad);
		
		
		BaseScreen2 myScreen = new BaseScreen2("Hello");
		myScreen.setVisible(true);
	    
	}

}
