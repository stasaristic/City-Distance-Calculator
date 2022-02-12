package utils;

import java.util.*;
import java.io.IOException;



public class Cities{

	List<City> listOfCities = new ArrayList<City>();


	public void add(int num, excelUtils excel) throws IOException {
		int i = 1;
		while (i != num)
		{
			listOfCities.add(new City(excel.getCellDataInt(i, 0), excel.getCellDataDouble(i,9), 
					excel.getCellDataDouble(i, 10),excel.getCellDataInt(i, 6), 
					excelUtils.getCellDataString(i, 2), 
					excel.getCellDataString(i, 5), excel.getCellDataString(i, 7)));
			//System.out.println(excel.getCellDataInt(i, 0) + " added to the arraylist!");
			i++;
		}
	}
}
