package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;

import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		
		for(int i = 1; i<=N; i++) {
			System.out.printf("Product #%d data: %n",i);
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee:");
				double customsFee = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);
			} else  if(ch == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY):");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));			
				Product product = new UsedProduct(name, price, date);
				list.add(product);
			} else {
				Product product = new Product(name, price);
				list.add(product);
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}
		
		
		
		
		
		sc.close();
		
		
	}

}
