package p1;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
class Product
{
	String productName;
	int cost;
	String category;
	
	
}

public class Demo {

	List<Product> list;
	Demo()
	{
		list = Arrays.asList(
			    new Product("Laptop", 60000, "Electronics"),
			    new Product("Mobile", 20000, "Electronics"),
			    new Product("Shirt", 2000, "Clothing"),
			    new Product("TV", 50000, "Electronics"),
			    new Product("Jeans", 3000, "Clothing")
			);
	}
	
	public static void main(String[] args) {
		long count =
			    new Demo().list.stream()
			        .map(p -> p.getCategory())
			        .distinct()
			        .count();

			System.out.println(count);
	}
	
}
