package SearchInCSVFile.Interfaces;

import java.io.IOException;

import Main.ActiveThread;

public interface ISearchInCsv {
	String getPathInput();
	String getPathOutput();
	String getIncode();
	void searchInCsv(String columnName,	String expression, ActiveThread active)
			throws IOException;
}
