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
		String[] thirdLine = {"B", "A"};
		
		List<String[]> expectedCsvList = new ArrayList<String[]>();
		expectedCsvList.add(firstLine);
		expectedCsvList.add(secondLine);
		expectedCsvList.add(thirdLine);
		
		Assert.assertEquals(expectedCsvList.size(), csvList.size());
		Assert.assertEquals(expectedCsvList.get(0), csvList.get(0));
		Assert.assertEquals(expectedCsvList.get(1), csvList.get(1));
		Assert.assertEquals(expectedCsvList.get(2), csvList.get(2));
	}


	private List<String[]> doReadCsvFromRelativPath(String filePath) {
		CsvReader csvReader = new CsvReader();
		return csvReader.readCsvFromRelativePath(filePath);
			
	}


}
