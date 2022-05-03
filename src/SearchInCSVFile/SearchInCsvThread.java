package SearchInCSVFile;

import java.io.IOException;
import java.nio.charset.Charset;

import Main.ActiveThread;

public class SearchInCsvThread implements Runnable {
	private final SearchInCsv _searchInCsv;
	private final String _columnName;
	private final String _expression;
	private final ActiveThread _active;
	
	public SearchInCsvThread(
			String pathInput,
			String pathOutput,
			Charset encode,
			String columnName,
			String expression) {
		_searchInCsv = new SearchInCsv(pathInput, pathOutput, encode);
		_columnName = columnName;
		_expression = expression;
		_active = new ActiveThread();
	}

	@Override
	public void run() {
		try {
			_searchInCsv.searchInCsv(_columnName, _expression, _active);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void interrupt() {
		_active.setIsActive(false);
	}
}
