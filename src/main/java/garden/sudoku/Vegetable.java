package garden.sudoku;

import java.util.List;

public class Vegetable implements Plant {
	
	private String name;
	private List<String> likedNeighbours;
	
	public Vegetable(String name, List<String> likedNeighbours) {
		this.name = name;
		this.likedNeighbours = likedNeighbours;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getLikedNeighbours() {
		return likedNeighbours;
	}

	public String toString() {
		String plantString = "name: " + this.name + " likes: " + this.likedNeighbours.toString();
		return plantString;
	}

}
