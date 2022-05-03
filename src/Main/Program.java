package Main;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.SortedMap;

import SearchInCSVFile.*;

public class Program {

	public static void main(String[] args) {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		if (args.length == 0)
		{
			System.out.println(args.length);
		}
		else if (args.length == 5) {
			var t = new SearchInCsvThread(args[0], args[1], charsets.get(args[2]), args[3], args[4]);
			t.run();
		}
	}
}
