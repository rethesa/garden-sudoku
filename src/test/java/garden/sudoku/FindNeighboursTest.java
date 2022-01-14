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
	
	private void givenAGardenBedOfSize(int size) {
		gardenBed = new String[size];
	}

	private void doArragePlantsThatLikeEachOther(String[] plantsListString) {
		List<Plant> plantList = getPlantListFromString(plantsListString);
		Plant firstPlant = plantList.get(0);
		gardenBed[0] = firstPlant.getName();
		List<String> likedNeighboursOfFirst = firstPlant.getLikedNeighbours();
		if(gardenBed.length == 2) {
			int count = 1;
			while(gardenBed[1] == null) {
				if(likedNeighboursOfFirst.contains(plantList.get(count).getName())) {
					gardenBed[1] = plantList.get(count).getName();
				}
				count++;
			}
		} if(gardenBed.length == 3) {
			Plant secondPlant = null;
			int count1 = 1;
			while(gardenBed[1] == null) {
				if(likedNeighboursOfFirst.contains(plantList.get(count1).getName())) {
					gardenBed[1] = plantList.get(count1).getName();
					secondPlant = plantList.get(count1);
				}
				count1++;
			}
			List<String> likedNeighboursOfSecond = secondPlant.getLikedNeighbours();
			int count2 = 1;
			while(gardenBed[2] == null) {
				if(likedNeighboursOfSecond.contains(plantList.get(count2).getName())) {
					gardenBed[2] = plantList.get(count2).getName();
				}
				count2++;
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
