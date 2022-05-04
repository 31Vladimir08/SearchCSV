package Main;

import java.nio.charset.Charset;
import java.util.SortedMap;

import SearchInCSVFile.*;

public class Program {

	public static void main(String[] args) {
		/*SortedMap<String, Charset> charsets = Charset.availableCharsets();
		if (args.length == 0)
		{
			System.out.println(args.length);
		}
		else if (args.length == 5) {
			var t = new SearchInCsvThread(args[0], args[1], charsets.get(args[2]), args[3], args[4]);
			t.run();
		}*/
		try {
			mainDevelop();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void mainDevelop() {
		var input = "D:\\TestBigData.csv";
        var output = "D:\\TestOutput.txt";
        var encode = "UTF-8fdfdf";
        var columname = "xdyqw";
        var expression = "1441963104";
        
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        var t = new SearchInCsvThread(input, output, charsets.get(encode), columname, expression);
		t.run();
		
	}
}
