package p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMainComplexMap {

	HashMap<String, List<Product>> allProducts = new HashMap<>();
	
	public ProductMainComplexMap() {
		
		Product p1 = new Product("Dell", 65000,"Laptop");
		Product p2 = new Product("HP", 75000,"Laptop");
		Product p3 = new Product("X", 5000,"Laptop");
		
		List<Product> allLaptops = Arrays.asList(p1,p2,p3);
		
		Product p4 = new Product("Nikon", 165000,"Camera");
		Product p5 = new Product("Sony", 5000,"Camera");
		Product p6 = new Product("Nikon", 6000,"Camera");
		Product p7 = new Product("Nikon", 15000,"Camera");
		
		List<Product> allCamera = Arrays.asList(p4,p5,p6,p7);
		
		allProducts.put("Laptop",allLaptops);
		allProducts.put("camera",allCamera);
		
	}
	
	public static void main(String[] args) {
		
		ProductMainComplexMap main = new ProductMainComplexMap();
		
		/* create new map of products where price is more than 10000*/
		
		/* create new -> collect*/
		
	Map<String, Set<Product>>	map = main.allProducts.entrySet().stream()
		.collect(Collectors.toMap(
				entry->{
					return entry.getKey();
				}
				, 
				entry->{
					return entry.getValue().stream().
							filter(p->p.getCost()>10000)
							.collect(Collectors.toSet());
				}));
		
		System.out.println(map);
			
	}
	
	
}
