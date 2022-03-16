package garden.sudoku;

import java.util.List;

public class CsvToPlantMapper {

	private List<String[]> csvToMap;

	public CsvToPlantMapper(String filePath) {
		// TODO Auto-generated constructor stub
		
		CsvReader csvReader = new CsvReader();
		this.csvToMap = csvReader.readCsvFromRelativePath(filePath);
	}

}
