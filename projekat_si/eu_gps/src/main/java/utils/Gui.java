package utils;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Button;

public class Gui {

	private JFrame frame;
	private JFrame frameCoo;
	private JFrame frameName;
	private JFrame frameSearch;

	private JTextField cooFirstLat;
	private JTextField cooFirstLon;
	private JTextField cooSecondLat;
	private JTextField cooSecondLon;

	private JTextField FirstName;
	private JTextField SecondName;
	private JTextField SearchName;

	private Button btnName;
	private Button btnCoo;
	private Button btnSubmitCoo;
	private Button btnSubmitName;
	private Button btnSearch;
	private Button btnConfirm;
	private Button btnTutorial;

	static String excelPath = "./data/cities.xlsx";
	static String sheetName = "Sheet1";
	static excelUtils excel = new excelUtils(excelPath, sheetName);

	static int numOfCities = excel.getRowCount();
	static Cities cities = new Cities();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cities.add(numOfCities, excel);
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to City Distance Calculator");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 11, 407, 33);
		frame.getContentPane().add(lblNewLabel);


		/* Buttons! */


		btnTutorial = new Button("Tutorial");
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Welcome to City Distance Calculator!\n"
						+ "\n"
						+ "If you want to know the distance between two Cities in Europe\n"
						+ "You can choose the Cities by entering their coordinates\n"
						+ "(Button Search by Coordinates)\n"
						+ "Or you can choose the Cities by entering their names\n"
						+ "(Button Search by City Name)\n"
						+ "If you are maybe interested in certain details about a certain City \n"
						+ "Use the Search Info button!\n"
						+ "Enjoj!:)");
			}
		});
		btnTutorial.setForeground(new Color(70, 130, 180));
		btnTutorial.setBackground(new Color(224, 255, 255));
		btnTutorial.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnTutorial.setBounds(195, 50, 100, 30);
		frame.getContentPane().add(btnTutorial);

		btnSearch = new Button("Search Info");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frameSearch.setVisible(true);
			}
		});
		btnSearch.setForeground(new Color(70, 130, 180));
		btnSearch.setBackground(new Color(224, 255, 255));
		btnSearch.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnSearch.setBounds(187, 178, 120, 30);
		frame.getContentPane().add(btnSearch);

		btnName = new Button("Search by City Name");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frameName.setVisible(true);
			}
		});
		btnName.setBackground(new Color(224, 255, 255));
		btnName.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnName.setBounds(173, 138, 143, 22);
		frame.getContentPane().add(btnName);

		btnCoo = new Button("Search by Coordinates");
		btnCoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frameCoo.setVisible(true);
			}
		});
		btnCoo.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnCoo.setBackground(new Color(224, 255, 255));
		btnCoo.setBounds(173, 99, 143, 22);
		frame.getContentPane().add(btnCoo);


		/* Frame for Picking Coordinates */


		JPanel panelCoo = new JPanel();

		frameCoo = new JFrame();
		frameCoo.getContentPane().setBackground(new Color(135, 206, 235));
		frameCoo.setBounds(100, 100, 550, 250);
		frameCoo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCoo.add(panelCoo);

		panelCoo.setLayout(null);

		// Label and Text Field for First City Latitude and Longitude

		JLabel labelLL1 = new JLabel("Latitude of the first City: ");
		labelLL1.setBounds(10,20,190,25); // x y width height
		panelCoo.add(labelLL1);

		cooFirstLat = new JTextField();
		cooFirstLat.setBounds(200, 20, 200, 25);
		panelCoo.add(cooFirstLat);

		JLabel labelLL2 = new JLabel("Longitude of the first City: ");
		labelLL2.setBounds(10,50,190,25);
		panelCoo.add(labelLL2);

		cooFirstLon = new JTextField();
		cooFirstLon.setBounds(200, 50, 200, 25);
		panelCoo.add(cooFirstLon);

		// Label and Text Field for Second City Latitude and Longitude

		JLabel labelLL3 = new JLabel("Latitude of the second City: ");
		labelLL3.setBounds(10,100,190,25); // x y width height
		panelCoo.add(labelLL3);

		cooSecondLat = new JTextField();
		cooSecondLat.setBounds(200, 100, 200, 25);
		panelCoo.add(cooSecondLat);

		JLabel labelLL4 = new JLabel("Longitude of the second City: ");
		labelLL4.setBounds(10,130,190,25);
		panelCoo.add(labelLL4);

		cooSecondLon = new JTextField();
		cooSecondLon.setBounds(200, 130, 200, 25);
		panelCoo.add(cooSecondLon);

		frameCoo.setVisible(false);

		btnSubmitCoo = new Button("Submit");
		btnSubmitCoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				City city1 = findByLatLon(cooFirstLat, cooFirstLon);
				City city2 = findByLatLon(cooSecondLat, cooSecondLon);
				//System.out.println(city1.getLatitude() + " " 
				//+ city1.getLongitude() + "\n" + city2.getLatitude() + " " + city2.getLongitude());
				showDistanceLatLon(city1, city2);
				clearCoo();
				frameCoo.setVisible(false);
			}
		});
		btnSubmitCoo.setBounds(90,170,80,25);
		panelCoo.add(btnSubmitCoo);


		/* Frame for Search City info */


		JPanel panelSearch = new JPanel();

		frameSearch = new JFrame();
		frameSearch.getContentPane().setBackground(new Color(135, 206, 235));
		frameSearch.setBounds(100, 100, 250, 200);
		frameSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSearch.add(panelSearch);

		panelSearch.setLayout(null);

		// Label and Text Field for Search

		JLabel labelSearch = new JLabel("Search database for City details: ");
		labelSearch.setBounds(10,20,200,25); // x y width height
		panelSearch.add(labelSearch);

		SearchName = new JTextField();
		SearchName.setBounds(10, 50, 200, 25);
		panelSearch.add(SearchName);

		frameSearch.setVisible(false);

		btnConfirm = new Button("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				City city = searchByName(SearchName);
				show(city);
				clearSearch();
				frameSearch.setVisible(false);
			}
		});
		btnConfirm.setBounds(75,90,80,25);
		panelSearch.add(btnConfirm);


		/* Frame for Picking by City Name */


		JPanel panelName = new JPanel();

		frameName = new JFrame();
		frameName.getContentPane().setBackground(new Color(135, 206, 235));
		frameName.setBounds(100, 100, 500, 250);
		frameName.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameName.add(panelName);

		panelName.setLayout(null);

		// Label and Text Field for First City Name

		JLabel labelN1 = new JLabel("Name of the first City: ");
		labelN1.setBounds(10,20,150,25); // x y width height
		panelName.add(labelN1);

		FirstName = new JTextField();
		FirstName.setBounds(170, 20, 200, 25);
		panelName.add(FirstName);


		// Label and Text Field for Second City Name

		JLabel labelN3 = new JLabel("Name of the second City: ");
		labelN3.setBounds(10,100,150,25); // x y width height
		panelName.add(labelN3);

		SecondName = new JTextField();
		SecondName.setBounds(170, 100, 200, 25);
		panelName.add(SecondName);

		frameName.setVisible(false);

		btnSubmitName = new Button("Submit");
		btnSubmitName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				City city1 = searchByName(FirstName);
				City city2 = searchByName(SecondName);
				//System.out.println(city1.getLatitude() + " " + city1.getLongitude() 
				//+ "\n" + city2.getLatitude() + " " + city2.getLongitude());
				showDistance(city1, city2);
				clearName();
				frameName.setVisible(false);
			}
		});
		btnSubmitName.setBounds(90,170,80,25);
		panelName.add(btnSubmitName);


	}

	public City searchByName(JTextField name) {
		String nameCity = "";
		double d = 0;
		boolean found1 = false;
		if (!name.getText().contentEquals("")) {
			nameCity = name.getText();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Please fill in the requested!");
		}

		Iterator<City> iterator = cities.listOfCities.iterator();
		while (iterator.hasNext()) {
			City city1 = iterator.next();
			if (city1.getName().equals(nameCity))
			{
				//System.out.println("Pronasao!");
				found1 = true;
				return city1;
			}

		}
		if (found1 == false)
		{
			JOptionPane.showMessageDialog(null, "The entered city does not exist in the database!\n\n"
					+ "Please check your spelling!\n");
		}
		return null;
	}

	public City findByLatLon (JTextField latField, JTextField lonField)
	{
		double lat1 = 0;
		double lon1 = 0;
		if(!latField.getText().contentEquals("") || !lonField.getText().contentEquals(""))
		{
			try {
				lat1 = Double.parseDouble(latField.getText());
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "This is the Search by Coordinates window!\n" +
													"Please use numbers for coordinates!\n\n"
													+ "If you wanted to enter the Name of the city \n"
													+ "Click on the Search By City Name button in main menu!");
				e.printStackTrace();
				
			}
			try {
				lon1 = Double.parseDouble(lonField.getText());
			} catch(NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "This is the Search by Coordinates window!\n" +
						"Please use numbers for coordinates!\n\n"
						+ "If you wanted to enter the Name of the city \n"
						+ "Click on the Search By City Name button in main menu!");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "You forgot to enter all values!\nTry again!");
		}
		Iterator<City> iterator = cities.listOfCities.iterator();
		while (iterator.hasNext()) {
			City city1 = iterator.next();
			if (city1.getLatitude().equals(lat1) && city1.getLongitude().equals(lon1))
			{
				//System.out.println("Pronasao!");
				return city1;
			}
		}

		return null;
	}


	public double distance(double lat1, double lon1, double lat2, double lon2)
	{

		//convert to radians
		lat1 = Math.toRadians(lat1);
		lon1 = Math.toRadians(lon1);
		lat2 = Math.toRadians(lat2);
		lon2 = Math.toRadians(lon2);

		//Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat/2),2)
				+ Math.cos(lat1) * Math.cos(lat2)
				* Math.pow(Math.sin(dlon/2),2);

		double c = 2 * Math.asin(Math.sqrt(a));

		//Radius of Earth in kilometers!
		double r = 6371;

		//calculate result 
		return (c*r);
	}

	public void show(City city) 
	{
		JOptionPane.showMessageDialog(null, "Name of the City you've entered " + city.getName() + "\n\n"
				+ "Country: " + city.getCountry() + "\n"
				+ "City Population: " + city.getPopulation() + "\n"
				+ "Timezone in which the city is in: " + city.getTimezone() + "\n"
				+ "Latitude and Longitude: " + "(" + city.getLatitude() + ", " + city.getLongitude() + ")\n");
	}

	public void showDistanceLatLon(City city1, City city2) 
	{
		if (city1 == null) {
			JOptionPane.showMessageDialog(null, "The first entered latitude and longitude combination\n"
					+ "does not exist in the database!\n\n");
		}
		else if (city2 == null) {
			JOptionPane.showMessageDialog(null, "The second entered latitude and longitude combination\n"
					+ "does not exist in the database!\n\n");
		}
		else {
			showDistance(city1, city2);
		}
	}

	public void showDistance(City city1, City city2) 
	{
		double result = distance(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
		DecimalFormat df = new DecimalFormat("#.00000");
		String resultRounded = df.format(result);
		JOptionPane.showMessageDialog(null, "The distance between " + city1.getName() + " and " + city2.getName() + " is: "+ resultRounded + "km!");
	}

	public void clearCoo() 
	{
		cooFirstLat.setText(null);
		cooFirstLon.setText(null);
		cooSecondLat.setText(null);
		cooSecondLon.setText(null);

	}

	public void clearName()
	{
		FirstName.setText(null);
		SecondName.setText(null);		
	}

	public void clearSearch() 
	{
		SearchName.setText(null);
	}

}
