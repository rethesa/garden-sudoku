package garden.sudoku;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CsvReaderTest {
	
	List<Plant> plantList = new ArrayList<Plant>();
	
	@Test
	public void readCommaSeperatedValuesFromCsvTest() {
		List<String[]> csvList = doReadCsvFromRelativPath("simplePlantList.csv");
		
		List<String[]> expectedCsvList = new ArrayList<String[]>();
		expectedCsvList.add(new String[] {"Pflanzenname", "Gute Nachbarn"});
		expectedCsvList.add(new String[] {"A", "B"});
		expectedCsvList.add(new String[] {"B", "A, C"});
		
		Assert.assertArrayEquals(expectedCsvList.toArray(), csvList.toArray());
	}

	private List<String[]> doReadCsvFromRelativPath(String filePath) {
		CsvReader csvReader = new CsvReader();
		return csvReader.readCsvFromRelativePath(filePath);	
	}

}
