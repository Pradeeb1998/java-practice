package com.practice.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApi {

	public static void main(String[] args) {

		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		List<Float> price = new ArrayList<Float>();

		System.out.println("*** boat mode start ***");
		System.out.println("");

		for (Product iteration : productsList) {
			if (iteration.getPrice() < 30000) {
				price.add(iteration.getPrice());
				System.out.print(iteration.getPrice() + ", ");
			}
		}
		System.out.println("");
		System.out.println(price);
		System.out.println("");

		System.out.println("*** beast mode start ***");
		price = productsList.stream().filter(p -> p.getPrice() < 30000)// filtering data
				.map(x -> x.getPrice()) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println("*** beast mode start ***");
		System.out.println("");
		System.out.print(price);

	}

}

class Product {

	int id;
	String name;
	float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
