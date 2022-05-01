package SearchInCSVFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import SearchInCSVFile.Interfaces.ISearchInCsv;

public class SearchInCsv implements ISearchInCsv {

	@Override
	public void searchInCsv(String pathInputFile, String pathOutputFile, String incode, String columnName,
			String expression) {
		try(var scanner = new Scanner(new File(pathInputFile)))
		{
			var lineNumber = 0;
			while (scanner.hasNextLine()) {
				var line = scanner.nextLine();
				if (lineNumber == 0) {
					var columnNumbers = getColumnNumbers(line, columnName);
				}
				else {
					
				}
				lineNumber++;
			}
		}
		catch(IOException ex){
            
            System.out.println(ex.getMessage());
        } 
	}
	
	private ArrayList<Integer> getColumnNumbers(String header, String columnName){
		var columnNumbers = new ArrayList<Integer>();
		var columns = header.split(";");
		for (var item : columns) {
			var colName = item.split(" ")[1];
			if (colName.equals(columnName)) {
				columnNumbers.add(Arrays.asList(colName).indexOf(item));
			}
		}
		return columnNumbers;
	}
}
