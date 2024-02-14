package HangMan_Temperature;

/*Design a temperature generator program that allows users to convert temperatures between Celsius (C), Kelvin (K), and Fahrenheit (F) scales.*/

import java.util.Scanner;

public class Temperature {
	private int number;
	private String scale;
	private String newScale;
	
	public void inputScale() {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Enter the scale: (C for Celsius, F for Fahrenheit, K for Kelvin)");
		
			scale = in.next();

			if (!scale.equals("C") && !scale.equals("K") && !scale.equals("F")) {
			    System.out.println("Wrong scale. Try again!");
			}
			else {
				break;
			}
		}
	}//take the original scale of the temperature
	
	public void inputNum() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the temperature of the scale: ");
		
		number = in.nextInt();
	}//take the number of temperature
	
	public void inputNewScale() {
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Enter the scale: (C for Celsius, F for Fahrenheit, K for Kelvin)");
		
			newScale = in.next();

			if (!newScale.equals("C") && !newScale.equals("K") && !newScale.equals("F")) {
			    System.out.println("Wrong scale. Try again!");
			}
			else {
				break;
			}
		}
	}//take the new scale to convert
	
	public void check() {
		double newC = 0;
		double newK = 0;
		double newF = 0;
		
		if (newScale.equals("C") && (scale.equals("K") || scale.equals("F"))) {
		    if (scale.equals("K")) {
		        newC = number - 273.15;
		        System.out.println("Equal " + newC + " Celsius");
		    } else {
		        newC = (number - 32) / (9.0 / 5.0);
		        System.out.println("Equal " + newC + " Celsius");
		    }
		} else if (newScale.equals("K") && (scale.equals("C") || scale.equals("F"))) {
		    if (scale.equals("C")) {
		        newK = number + 273.15;
		        System.out.println("Equal " + newK + " Kelvin");
		    } else {
		        newK = (number + 459.67) / (9.0 / 5.0); 
		        System.out.println("Equal " + newK + " Kelvin");
		    }
		} else if (newScale.equals("F") && (scale.equals("C") || scale.equals("K"))) {
		    if (scale.equals("C")) {
		        newF = number * (9.0 / 5.0) + 32; 
		        System.out.println("Equal " + newF  + " Fahbrenheit");
		    } else {
		        newF = (number * (9.0 / 5.0)) - 459.67; 
		        System.out.println("Equal " + newF  + " Fahbrenheit");
		    }
		}
	}//calculate the new temperature based on the new scale
	
	public void convert() {
		inputScale();
		inputNum();
		inputNewScale();
		check();
	}//start the convert
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Temperature one = new Temperature();
		
		one.convert();
	}
}
