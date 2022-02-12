package utils;

import java.io.Serializable;

public class City implements Serializable {

	int id, population;
	double latitude, longitude;
	String name, country, timezone;
	
	public City() {
		id = 0;
		population = 0;
		latitude = 0;
		longitude = 0;
		name = null;
		country = null;
		timezone = null;
	}

	public City(int id, double latitude, double longitude, int population, 
			String name, String country, String timezone) {

		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population = population;
		this.name = name;
		this.country = country;
		this.timezone = timezone;
	}
	
	public int getId() {
		return id;
	}

	public int getPopulation() {
		return population;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getTimezone() {
		return timezone;
	}


	@Override
	public String toString() {
		return "City [population=" + population + ", latitude=" + latitude + ", longitude=" + longitude + ", name="
				+ name + ", country=" + country + ", timezone=" + timezone + "]";
	}
}
