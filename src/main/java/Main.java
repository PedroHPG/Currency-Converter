import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------Currency Converter---------");
		System.out.print("Enter the currency you have: ");
		String currency1 = sc.nextLine();
		
		System.out.print("Enter the currency you want: ");
		String currency2 = sc.nextLine();
		
		System.out.print("Enter the amount you have: ");
		float value = sc.nextFloat();
		
		System.out.println();
		System.out.println("That sure is some data you just entered");
	}
}
