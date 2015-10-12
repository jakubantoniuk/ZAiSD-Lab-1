import java.io.*;

public class ImportText {
	static public String readFile (String path) {
	try(BufferedReader br = new BufferedReader(new FileReader(path))) {
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    String everything = sb.toString();
		return everything;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
	static int countLines(String str){
		String[] lines = str.split("\r\n|\r|\n");
		return lines.length;
	}
}
