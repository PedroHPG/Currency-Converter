import java.io.IOException;
import java.util.Scanner;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;


public class Main {
	//Conversion rates in relation to dollar
	static float dollar = 1f;
	static float real = 5.5f;
	static float euro = 1.2f;
	static float yen = 100.00f;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// initializing the HTML Document page variable 
		Document doc; 
		 
		try { 
			// fetching the target website 
			doc = Jsoup.connect("https://www.exchange-rates.org/current-rates/usd").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36") 
					.header("Accept-Language", "*").get(); 
		} catch (IOException e) { 
			throw new RuntimeException(e); 
		}

		
		
		System.out.println("---------Currency Converter---------");
		System.out.println("List of Available Currencies: 1 - Dollar, 2 - Real, 3 - Euro, 4 - Yen, 5 - Other");
		System.out.print("Enter the currency you have: ");
		int currency1 = sc.nextInt();
		System.out.println("You have selected: " + showCurrency(currency1));
		
		System.out.print("Enter the currency you want: ");
		int currency2 = sc.nextInt();
		System.out.println("You have selected: " + showCurrency(currency2));
		
		System.out.print("Enter the amount you have: ");
		float value = sc.nextFloat();
		
		float result = 1;
		
		if(currency1 == 1) {
			result = convertFromDollar(currency2, value);
		} else if(currency2 == 1){
			result = convertToDollar(currency1, value);
		} else {
			float newValue = convertToDollar(currency1, value);
			result = convertFromDollar(currency2, newValue);
		}
		
		System.out.println();
		System.out.println("Your value is worth: " + result);
	}
	
	public static String showCurrency(int currency) {
		String result = "";
		switch (currency) {
		case 1: result = "Dollar";
				break;
		case 2: result = "Real";
				break;
		case 3: result = "Euro";
				break;
		case 4: result = "Yen";
				break;
		default: System.out.println("We don't do monopoly money, sorry");
				result = "Some fake money thing";
				break;
		}
		return result;
	}
	
	public static float convertToDollar(int currency, float value) {
		float result = 1;
		float conversion = 1;
		switch (currency) {
		case 1: conversion = dollar;
				break;
		case 2: conversion = real;
				break;
		case 3: conversion = euro;
				break;
		case 4: conversion = yen;
				break;
		default: System.out.println("We don't do monopoly money, sorry");
				break;
		}
		result = value/conversion;
		return result;
	}
	
	public static float convertFromDollar(int currency, float value) {
		float result = 1;
		float conversion = 1;
		switch (currency) {
		case 1: conversion = dollar;
				break;
		case 2: conversion = real;
				break;
		case 3: conversion = euro;
				break;
		case 4: conversion = yen;
				break;
		default: System.out.println("We don't do monopoly money, sorry");
				break;
		}
		result = conversion*value;
		return result;
	}
}
