package garden.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CsvToPlantMapperTest {
	
	List<String[]> csvToMap;
	List<Plant> plantList = new ArrayList<Plant>() ;
	
	@Test
	public void mapCsvToPlantsTest() {
		givenCsvToMapToPlants("simplePlantList.csv");
		whenCsvIsMappedToPlants();

		List<Plant> expectedPlantList = new ArrayList<Plant>();
		expectedPlantList.add(new Vegetable("A", Arrays.asList("B")));
		expectedPlantList.add(new Vegetable("B", Arrays.asList("A", "C")));
		thenPlantListIs(expectedPlantList);
	}

	private void thenPlantListIs(List<Plant> expectedPlantList) {
		Assert.assertEquals(expectedPlantList.get(0).toString(), plantList.get(0).toString());
		Assert.assertEquals(expectedPlantList.get(1).toString(), plantList.get(1).toString());
	}

	private void whenCsvIsMappedToPlants() {
		String plantName;
		List<String> likedNeighbours;
		Plant plant;
		//start at 1, because row 0 are the column headers
		for(int csvRow = 1; csvRow < csvToMap.size(); csvRow++) {
			plantName = getPlantNameAt(csvRow);
			likedNeighbours = getPlantNeighboursAt(csvRow);
			plant = new Vegetable(plantName, likedNeighbours);
			plantList.add(plant);
		}
	}

	private List<String> getPlantNeighboursAt(int index) {
		String neighboursString = csvToMap.get(index)[1];
		List<String> neighboursList = Arrays.asList(neighboursString.replaceAll("\\s+","").split(","));
		return neighboursList;
	}

	private String getPlantNameAt(int index) {
		return csvToMap.get(index)[0];
	}

	private void givenCsvToMapToPlants(String filePath) {
		CsvReader csvReader = new CsvReader();
		this.csvToMap = csvReader.readCsvFromRelativePath(filePath);
	}

}
