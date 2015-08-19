package kz.epam.main;

import java.io.*;
import java.nio.charset.Charset;


public class Main{

	public static void main(String[] args) throws IOException {
		Sort sort = new Sort();
		sort.setText("asd.txt", Charset.defaultCharset());
        sort.trim();
		sort.splitText();
		sort.sort();
		sort.getSortedList();
	}

}
