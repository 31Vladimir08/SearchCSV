package Main;

import SearchInCSVFile.*;

public class Program {

	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.out.println(args.length);
		}
		else if (args.length == 5) {
			var t = new SearchInCsvThread(args[0], args[1], args[2], args[3], args[4]);
			t.run();
		}		
	}
}
