package kz.epam.main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * <h1>Class for reading the file</h1>
 * 
 * @version 1.0
 * @author MRSPEC
 *
 */
public class FileReader {
	static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
