import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------Currency Converter---------");
		System.out.println("List of Available Currencies: 1 - Real, 2 - Dollar, 3 - Euro, 4 - Yen, 5 - Other");
		System.out.print("Enter the currency you have: ");
		int currency1 = sc.nextInt();
		System.out.println("You have selected: " + showCurrency(currency1));
		
		System.out.print("Enter the currency you want: ");
		int currency2 = sc.nextInt();
		System.out.println("You have selected: " + showCurrency(currency2));
		
		System.out.print("Enter the amount you have: ");
		float value = sc.nextFloat();
		
		System.out.println();
		System.out.println("That sure is some data you just entered");
	}
	
	public static String showCurrency(int currency) {
		String result = "";
		switch (currency) {
		case 1: result = "Real";
				break;
		case 2: result = "Dollar";
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
}
