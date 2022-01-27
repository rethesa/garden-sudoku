package garden.sudoku;

import java.util.List;

public interface Plant {
	
	public String getName();
	
	public List<String> getLikedNeighbours();
	
	public String toString();

}