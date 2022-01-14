package garden.sudoku;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindNeighboursTest {
	
	String[] gardenBed;
	
	@Test
	public void fillBedOfSize1WithFirstElement() {
		givenAGardenBedOfSize(1);
		String[] plantsListString = {"A likes X"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize2WithPlantThatFirstOneLikes() {
		givenAGardenBedOfSize(2);
		String[] plantsListString = {"A likes B", "B likes X"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "B"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize2WithPlantThatFirstOneLikesButIsNotNext() {
		givenAGardenBedOfSize(2);
		String[] plantsListString = {"A likes C", "B likes X", "C likes X"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "C"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize2WithPlantThatFirstOneLikesButIsNotNextNext() {
		givenAGardenBedOfSize(2);
		String[] plantsListString = {"A likes D", "B likes X", "C likes X", "D likes X"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "D"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize3WithPlantThatLikesTheNext() {
		givenAGardenBedOfSize(3);
		String[] plantsListString = {"A likes B", "B likes C", "C likes X"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "B", "C"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize3WithPlantsUnordered() {
		givenAGardenBedOfSize(3);
		String[] plantsListString = {"A likes B", "C likes X", "B likes C"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "B", "C"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	@Test
	public void fillBedOfSize4WithPlantsUnordered() {
		givenAGardenBedOfSize(4);
		String[] plantsListString = {"A likes B", "D likes X", "C likes D", "B likes C"};
		doArragePlantsThatLikeEachOther(plantsListString);
		String[] expectedGardenBed = {"A", "B", "C", "D"};
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}
	
	private void givenAGardenBedOfSize(int size) {
		gardenBed = new String[size];
	}

	/*
	 * Set the first element in the list as the first plant in the garden.
	 * Then find the first liked neighbour and set it as the next plant in the garden.
	 * For this neighbour continue with it's liked neighbours.
	 */
	private void doArragePlantsThatLikeEachOther(String[] plantsListString) {
		List<Plant> plantList = getPlantListFromString(plantsListString);	
		
		Plant actualPlant = plantList.get(0);
		gardenBed[0] = actualPlant.getName();
		for(int gardenBedIdenx = 1; gardenBedIdenx < gardenBed.length; gardenBedIdenx++) {
			List<String> likedNeighboursOfPlant = actualPlant.getLikedNeighbours();
			Plant nextPlant = null;
			int count = 1;
			while(gardenBed[gardenBedIdenx] == null) {
				if(likedNeighboursOfPlant.contains(plantList.get(count).getName())) {
					gardenBed[gardenBedIdenx] = plantList.get(count).getName();
					nextPlant = plantList.get(count);
				}
				count++;
			}
			actualPlant = nextPlant;
		}
	}

	private List<Plant> getPlantListFromString(String[] plantsListString) {
		List<Plant> vegetableList = new LinkedList<Plant>();
		for(int i = 0; i < plantsListString.length; i++) {
			String[] triple = plantsListString[i].split(" ");
			List<String> likes = new LinkedList<String>();
			likes.add(triple[2]);
			Plant plant = new Vegetable(triple[0], likes);
			vegetableList.add(plant);
		}
		return vegetableList;
	}
	
}
