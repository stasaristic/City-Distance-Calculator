package utils;

import java.io.IOException;
import java.io.Serializable;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils implements Serializable {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public excelUtils(String excelPath, String sheetName) 
	{
		try {

			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	public static String getCellDataString(int rowNum, int colNum) throws IOException
	{
		//za hvatanje string vrednosti
		String valueString = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(value);
		return valueString;		
	}
	
	public static Double getCellDataDouble(int rowNum, int colNum) throws IOException
	{

		//za hvatanje double vrednosti
		double valueDouble = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return valueDouble;
		//System.out.println(value);
	}
	
	
	public static int getCellDataInt(int rowNum, int colNum) throws IOException
	{
		//za hvatanje int vrednosti
		int valueInt= (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println(value);
		return valueInt;
	}


	public int getRowCount()
	{
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

}
