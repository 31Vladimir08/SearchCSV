package SearchInCSVFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Main.ActiveThread;
import SearchInCSVFile.Interfaces.ISearchInCsv;

public class SearchInCsv implements ISearchInCsv{
	private final String _pathInput;
	private final String _pathOutput;
	private final String _incode;
	public SearchInCsv(String pathInput, String pathOutput, String incode) {
		_pathInput = pathInput;
		_pathOutput = pathOutput;
		_incode = incode;
	}
	
	public String getPathInput() {
		return _pathInput;
	}
	public String getPathOutput() {
		return _pathOutput;
	}
	public String getIncode() {
		return _incode;
	}
	
	@Override
	public void searchInCsv(String columnName, String expression, ActiveThread active) throws IOException {
		try(var scanner = new Scanner(new File(_pathInput)))
		{
			var isHeader = true;
			var columnNumbers = new ArrayList<Integer>();
			while (scanner.hasNextLine()) {
				if (!active.getIsActive())
					return;
				var line = scanner.nextLine();
				if (isHeader) {
					writeResult(line, false);
					columnNumbers = getColumnNumbers(line, columnName);
					isHeader = false;
					continue;
				}
				
				if (isContent(line, columnNumbers, expression)) {
					writeResult(line, true);
				}
			}
		}
		catch(IOException ex){
			throw ex;
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
	
	private boolean isContent(String line, ArrayList<Integer> columnNumbers, String expression) {
		var values = line.split(";");
		for (var item : columnNumbers) {
			if (values[item].equals(expression)) {
				return true;
			}
		}
		return false;
	}
	
	private void writeResult(String line, boolean append) throws IOException {
		try(FileWriter writer = new FileWriter(_pathOutput, append))
        {
            writer.write(line);
            writer.flush();
        }
        catch(IOException ex){
        	throw ex;
        }		
	}
}
