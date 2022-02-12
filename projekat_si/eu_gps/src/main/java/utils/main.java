package utils;

import java.io.IOException;
import java.io.Serializable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class main implements Serializable{
	
	public static void main(String[] args) throws IOException {
		
		// Test creating database
		
		/*String excelPath = "./data/cities.xlsx";
		String sheetName = "Sheet1";
		excelUtils excel = new excelUtils(excelPath, sheetName);
		
		int numOfCities = excel.getRowCount();
		System.out.println("Number of Cities in the database:" + numOfCities);

		Cities cities = new Cities();
		cities.add(numOfCities, excel);
		
		System.out.println(cities.listOfCities.get(5).name);
		
		for (int i = 0; i < 10; i++)
		{

			System.out.println(cities.listOfCities.get(i).id);
		}*/
    }
		
}


// TESTS FOR TYPES OF VALUES IN CELLS

/*
int rowno = 3;

Row row = excel.sheet.getRow(rowno);
Cell cell = row.getCell(6);
Double value = 0d;
switch (cell.getCellType()) {
case _NONE:
    break;
case NUMERIC:
	value = cell.getNumericCellValue();
    System.out.println("This cell is numeric" + value);

    break;
case STRING:
    System.out.println("This cell is string");
    break;
case FORMULA:
    System.out.println("This cell is formula");
    break;
case BLANK:
    break;
case BOOLEAN:
    System.out.println("This cell is numeric");
    break;
case ERROR:
    break;*/