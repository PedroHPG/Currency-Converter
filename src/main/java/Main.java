import java.io.IOException;
import java.util.Scanner;
import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;


public class Main {
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		
		System.out.println("---------Currency Converter---------");
		System.out.println("List of Available Currencies: 1 - Dollar, 2 - Real, 3 - Euro, 4 - Yen, 5 - Other");
		System.out.print("Enter the currency you have: ");
		
		int selector = sc.nextInt();
		Currency currency1 = selectCurrency(selector);
		System.out.println("You have selected: " + currency1.getName());
		
		System.out.print("Enter the currency you want: ");
		selector = sc.nextInt();
		Currency currency2 = selectCurrency(selector);
		System.out.println("You have selected: " + currency2.getName());
		
		System.out.print("Enter the amount you have: ");
		float value = sc.nextFloat();
		
		float result = 1;
		
		if(currency1.getName() == "Dollar") {
			result = currency2.convertFromDollar(value);
		} else if(currency2.getName() == "Dollar"){
			result = currency1.convertToDollar(value);
		} else {
			float newValue = currency1.convertToDollar(value);
			result = currency2.convertFromDollar(newValue);
		}
		
		System.out.println();
		System.out.println("Your value is worth: " + result);
		sc.close();
	}	
	
	public static Currency selectCurrency(int aux) {
		// initializing the HTML Document page variable 
		Document doc; 
		Float rate = 1.0f;
				 
		try { 
			// fetching the target website 
			doc = Jsoup.connect("https://www.exchange-rates.org/current-rates/usd").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36") 
							.header("Accept-Language", "*").get(); 
		} catch (IOException e) { 
			throw new RuntimeException(e); 
		}
				
		switch(aux) {
		case 1:
			Currency dollar = new Currency("Dollar", "USD", rate);
			return dollar;
		case 2:
			rate = Float.parseFloat(doc.select("div.current-rates a[href*=/converter/usd-brl]").first().text());
			Currency real = new Currency("Real", "BRL", rate);
			return real;
		case 3:
			rate = Float.parseFloat(doc.select("div.current-rates a[href*=/converter/usd-eur]").first().text());
			Currency euro = new Currency("Euro", "EUR", rate);
			return euro;
		case 4:
			rate = Float.parseFloat(doc.select("div.current-rates a[href*=/converter/usd-jpy]").first().text());
			Currency yen = new Currency("Yen", "JPY", rate);
			return yen;
		default:
			Currency currency = new Currency();
			return currency;
		}
	}
}
