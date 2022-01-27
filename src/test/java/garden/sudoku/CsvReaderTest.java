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
		String[] firstLine = {"Pflanzenname", "Gute Nachbarn"};
		String[] secondLine = {"A", "B"};
		String[] thirdLine = {"B", "A, C"};
		
		List<String[]> expectedCsvList = new ArrayList<String[]>();
		expectedCsvList.add(firstLine);
		expectedCsvList.add(secondLine);
		expectedCsvList.add(thirdLine);
		
		Assert.assertArrayEquals(expectedCsvList.toArray(), csvList.toArray());
	}

	private List<String[]> doReadCsvFromRelativPath(String filePath) {
		CsvReader csvReader = new CsvReader();
		return csvReader.readCsvFromRelativePath(filePath);	
	}

}
