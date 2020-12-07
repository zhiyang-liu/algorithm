package 装饰者;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedNum extends BufferedReader {

    BufferedReader bufferedReader;

	public BufferedNum(BufferedReader bufferedReader) {
		super(bufferedReader);
		this.bufferedReader = bufferedReader;
	}

	int count = 1;

	public String readLine() throws IOException {
		String line = bufferedReader.readLine();
		if (line == null) {
			return null;
		}
		String str = count + " " +line;
		count++;
		return str;		
	}

}
