package Main;

import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.concurrent.Semaphore;

import SearchInCSVFile.*;

public class Program {

	public static void main(String[] args) {
		try {
			//mainDevelop();		
			mainReleas(args);
			System.out.println("Finished");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void mainDevelop() throws Exception {
		var input = "D:\\TestBigData.csv";
        var output = "D:\\TestOutput.csv";
        var encode = "UTF-8";
        var columname = "xdyqw";
        var expression = "1441963104";
        
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Semaphore sem = new Semaphore(1);
        var mThing = new SearchInCsvThread(input, output, charsets.get(encode), columname, expression, sem);
        var mThing2 = new SearchInCsvThread(input, output, charsets.get(encode), columname, expression, sem);

		Thread myThready = new Thread(mThing);
		Thread myThready2 = new Thread(mThing2);
		myThready.start();
		myThready2.start();
		mThing.interrupt();
		myThready.join();
		myThready2.join();
	}
	
	private static void mainReleas(String[] args) throws Exception {
		if (args.length != 5)
			throw new Exception("Incorrect input parameters.");
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		Semaphore sem = new Semaphore(1);
		var myThready = new Thread(
				new SearchInCsvThread(args[0], args[1], charsets.get(args[2]), args[3], args[4], sem));
		myThready.run();
		myThready.join();
	}
}
