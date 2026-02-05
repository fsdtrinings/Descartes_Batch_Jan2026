package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*use when we want to make a map from List*/
public class GroupingByDemo {
	
	List<Product> list = new ArrayList<>();
	
	public GroupingByDemo() {
		Product p1= new Product("dsd",8000,"Laptop");
		Product p2= new Product("dgtsd",45800,"Laptop");
		Product p3= new Product("ddsd",68000,"Laptop");
		
		Product p4= new Product("dsddgd",8000,"Camera");
		Product p5= new Product("d gfbsd",8000,"Camera");
		Product p6= new Product("szddsd",8000,"Camera");
		
		Product p7= new Product("dsuyrd",8000,"Bag");
		Product p8= new Product("qretdsd",8000,"Bag");
		Product p9= new Product("kjgdsd",8000,"Bag");
		
		list = Arrays.asList(p1,p2,p3,p4,p5,p6,p8,p9);
	
	}
	
	public static void main(String[] args) {
		
		GroupingByDemo obj = new GroupingByDemo();
		
		Map<String, List<Product>> map = obj.list.stream().collect(Collectors
				.groupingBy((product)->product.getCategory()));
		System.out.println(map);
	}

}
