package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic {

	public static void main(String[] args) {

		//step1(); // use for each
		//step2(); // use filter
		step3(); // use all of the above+ map

	}

	public static void step3()
	{
		Stream<Integer> myStream2 = Stream.of(45, 16, 789, 120, 336, 189, 978, 436);

		List<Integer> list = new ArrayList<>();
		
		List<Integer> list_for_Collectors =  myStream2.filter((d) -> {
			if (d > 100)
				return true;
			else
				return false;
		}).map((d)->{
			d+=d;
			return d;
		}) // .forEach((d)->System.out.println(d));
		/*.forEach((d)->{
			list.add(d);
		});*/
		 .collect(Collectors.toList());
		
		 // --------------------
		 
		 list.stream().forEach(d->System.out.println(d));
				
		
	}
	
	
 	public static void step2() {
		Stream<Integer> myStream2 = Stream.of(45, 16, 789, 120, 336);

		List<Integer> list2 = myStream2.filter((d) -> {
			if (d > 100)
				return true;
			else
				return false;
		}).collect(Collectors.toList());

		System.out.println(list2);
	}

	public static void step1() {

		Stream<Integer> myStream = Stream.of(45, 16, 789, 120, 336);

		myStream.forEach(d -> System.out.println(d));

		System.out.println("-----------------------------------");

	}
}
