package garden.sudoku;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReader {

	public List<String[]> readCsvFromRelativePath(String filePath) {
		List<String[]> csvList = new ArrayList<String[]>();
		try {
			Path absolutePath = Paths.get(ClassLoader.getSystemResource(filePath).toURI());
			csvList = readCsvFromAbsolutePath(absolutePath);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return csvList;
	}
	
	private List<String[]> readCsvFromAbsolutePath(Path absolutePath) {
	    List<String[]> list = new ArrayList<String[]>();
	    try {
	    	Reader reader = Files.newBufferedReader(absolutePath);
			CSVReader csvReader = new CSVReader(reader);
			list = csvReader.readAll();
			reader.close();
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	}

}
