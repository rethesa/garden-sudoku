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
	
	private void givenAGardenBedOfSize(int size) {
		gardenBed = new String[size];
	}

	private void doArragePlantsThatLikeEachOther(String[] plantsListString) {
		List<Plant> plantList = getPlantListFromString(plantsListString);
		gardenBed[0] = plantList.get(0).getName();
		if(gardenBed.length > 1) {
			List<String> likes = plantList.get(0).getLikedNeighbours();
			if(likes.contains(plantList.get(1).getName())) {
				gardenBed[1] = plantList.get(1).getName();
			} else {
				gardenBed[1] = plantList.get(2).getName();
			}
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
