package SearchInCSVFile;

import java.nio.charset.Charset;
import java.util.concurrent.Semaphore;

import Main.ActiveThread;

public class SearchInCsvThread implements Runnable {
	private final SearchInCsv _searchInCsv;
	private final String _columnName;
	private final String _expression;
	private final ActiveThread _active;
	private final Semaphore _sem;
	
	public SearchInCsvThread(
			String pathInput,
			String pathOutput,
			Charset encode,
			String columnName,
			String expression,
			Semaphore sem) throws Exception {
		_searchInCsv = new SearchInCsv(pathInput, pathOutput, encode);
		_columnName = columnName;
		_expression = expression;
		_active = new ActiveThread();
		if (sem == null)
			throw new Exception("Semaphore isn't be null.");
		_sem = sem;
	}

	@Override
	public void run() {
		try {
			_sem.acquire();
			_searchInCsv.searchInCsv(_columnName, _expression, _active);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	
		finally {
			_sem.release();
		}
	}
	
	public void interrupt() {
		_active.setIsActive(false);
	}
}
