package garden.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PlantMapperTest {
	
	List<String[]> csvToMap;
	List<Plant> plantList = new ArrayList<Plant>() ;
	
	@Test
	public void mapCsvToPlantsTest() {
		givenCsvToMapToPlants("simplePlantList.csv");
		thenMapToPlants();

		List<Plant> expectedPlantList = new ArrayList<Plant>();
		expectedPlantList.add(new Vegetable("A", Arrays.asList("B")));
		System.out.println(new Vegetable("A", Arrays.asList("B")).toString());
		expectedPlantList.add(new Vegetable("B", Arrays.asList("A", "C")));
		System.out.println(new Vegetable("B", Arrays.asList("A", "C")));
	
		Assert.assertArrayEquals(expectedPlantList.toArray(), plantList.toArray());
	}

	private void thenMapToPlants() {
		String plantName;
		String likedNeighbours;
		Plant plant;
		
		plantName = csvToMap.get(1)[0];
		likedNeighbours = csvToMap.get(1)[1];
		plant = new Vegetable(plantName, Arrays.asList(likedNeighbours.trim().split(",")));
		System.out.println(plant.toString());
		plantList.add(plant);
		
		plantName = csvToMap.get(2)[0];
		likedNeighbours = csvToMap.get(2)[1];
		plant = new Vegetable(plantName, Arrays.asList(likedNeighbours.trim().split(",")));
		System.out.println(plant.toString());
		plantList.add(plant);
		
	}

	private void givenCsvToMapToPlants(String filePath) {
		CsvReader csvReader = new CsvReader();
		csvToMap = csvReader.readCsvFromRelativePath(filePath);	
	}

}
