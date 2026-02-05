package p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductMain {

	HashMap<String, Product> allProducts = new HashMap<>();
	
	public ProductMain() {
		
		Product p1 = new Product("Dell", 65000,"Laptop");
		Product p2 = new Product("Sony", 65000,"Camera");
		Product p3 = new Product("Duster", 200,"Duster");
		Product p4 = new Product("Pen-123", 50,"Pen");
		
		
		
		allProducts.put("Laptop", p1);
		allProducts.put("Camera", p2);
		allProducts.put("Duster", p3);
		allProducts.put("Pen", p4);
		
		
	}
	
	public static void main(String[] args) {
		
		ProductMain main = new ProductMain();
		
		/* create new map of products where price is more than 10000*/
		
		/* create new -> collect*/
		
		Map<String, Product> map = main.allProducts.entrySet().stream()
		.filter((pEntry)->{
			if(pEntry.getValue().getCost()>10000)return true;
			else return false;
		}).collect(Collectors.toMap(
				(pentry)->{
					return pentry.getKey();
				}
				, (pentry)->{
					return pentry.getValue();
				}));
				
		
		System.out.println(map);
		
		Set<Product> set = main.allProducts.entrySet().stream()
				.filter((p)->{
					if(p.getValue().getCost()>10000)return true;
					else return false;
				}).map(p->{
					return p.getValue();
				}).collect(Collectors.toSet());
		
		System.out.println(set);
						
		
	}
	
	
}
