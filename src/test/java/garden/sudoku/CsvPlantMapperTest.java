package garden.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CsvPlantMapperTest {
	
	List<String[]> csvToMap;
	List<Plant> plantList = new ArrayList<Plant>() ;
	
	@Test
	public void mapCsvToPlantsTest() {
		givenCsvToMapToPlants("simplePlantList.csv");
		thenMapToPlants();

		List<Plant> expectedPlantList = new ArrayList<Plant>();
		expectedPlantList.add(new Vegetable("A", Arrays.asList("B")));
		expectedPlantList.add(new Vegetable("B", Arrays.asList("A", "C")));
		
		Assert.assertEquals(expectedPlantList.get(0).toString(), plantList.get(0).toString());
		Assert.assertEquals(expectedPlantList.get(1).toString(), plantList.get(1).toString());
	}

	private void thenMapToPlants() {
		String plantName;
		List<String> likedNeighbours;
		Plant plant;
		
		for(int csvRow = 1; csvRow < csvToMap.size(); csvRow++) {
			plantName = getNameAt(csvRow);
			likedNeighbours = getNeighboursAt(csvRow);
			plant = new Vegetable(plantName, likedNeighbours);
			plantList.add(plant);
			
		}
	}

	private List<String> getNeighboursAt(int index) {
		String neighboursString = csvToMap.get(index)[1];
		List<String> neighboursList = Arrays.asList(neighboursString.replaceAll("\\s+","").split(","));
		return neighboursList;
	}

	private String getNameAt(int index) {
		return csvToMap.get(index)[0];
	}

	private void givenCsvToMapToPlants(String filePath) {
		CsvReader csvReader = new CsvReader();
		this.csvToMap = csvReader.readCsvFromRelativePath(filePath);
	}

}
