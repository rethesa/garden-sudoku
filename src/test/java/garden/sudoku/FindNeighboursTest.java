package garden.sudoku;

import org.junit.Assert;
import org.junit.Test;

public class FindNeighboursTest {
	
	String[] gardenBed;
	
	@Test
	public void fillBedOfSize1() {
		givenAGardenBedOfSize(1);
		doArragePlantsThatLikeEachOther("Tomate");
		String[] expectedGardenBed = {"Tomate"};
		thenGardenIsEquivalentTo(expectedGardenBed);
	}
	
	@Test
	public void fillBedOfSize2WithPlantsThatLikeEachOther() {
		givenAGardenBedOfSize(2);
		doArragePlantsThatLikeEachOther("Tomate");
		String[] expectedGardenBed = {"Tomate", "Basilikum"};
		thenGardenIsEquivalentTo(expectedGardenBed);
	}

	private void thenGardenIsEquivalentTo(String[] expectedGardenBed) {
		Assert.assertArrayEquals(expectedGardenBed, gardenBed);
	}

	private void doArragePlantsThatLikeEachOther(String plant) {
		gardenBed[0] = plant;
	}

	private void givenAGardenBedOfSize(int size) {
		gardenBed = new String[size];
	}

}
