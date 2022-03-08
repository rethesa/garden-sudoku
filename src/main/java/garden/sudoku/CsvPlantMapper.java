package garden.sudoku;

import java.util.List;

public class CsvPlantMapper {

	private List<String[]> csvToMap;

	public CsvPlantMapper(String filePath) {
		// TODO Auto-generated constructor stub
		
		CsvReader csvReader = new CsvReader();
		this.csvToMap = csvReader.readCsvFromRelativePath(filePath);
	}

}
