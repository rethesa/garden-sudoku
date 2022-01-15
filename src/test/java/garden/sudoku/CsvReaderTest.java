package garden.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.CSVReader;

public class CsvReaderTest {
	
	List<Plant> plantList = new ArrayList<Plant>();
	
	@Test
	public void fillBedOfSize1WithFirstElement() {
		//givenACsvPath("src/test/resources/simplePlantList.csv");
		doCsvReader("src/test/resources/simplePlantList.csv");
		List<Plant> expectedPlantsList = null;
		Assert.assertEquals(expectedPlantsList, plantList);
	}

	private List<String> givenACsvPath(String fileName) {
		List<String> records = new ArrayList<String>();
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				records.add(mapToPlants(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;	
	}
	
	private List<List<String>> doCsvReader(String fileName) {
		List<List<String>> records = new ArrayList<List<String>>();
		try {
			FileReader fileReader = new FileReader(fileName);
			CSVReader csvReader = new CSVReader(fileReader);
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        records.add(Arrays.asList(values));
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return records;
	}

	private String mapToPlants(String nextLine) {
		
		return nextLine;
	}

}
