package p1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Basic2 {

	public static void main(String[] args) {
		
		
		consumerOperations();
		doPredicateThings();
		
	}
	
	public static void doPredicateThings()
	{
		Stream<Integer> myStream = Stream.of(45,16,789,120,336);
		
		myStream.filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				if(t>100) return true;
				return false;
			}
			
		}).forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
			
		});
	}
	
	
	public static void consumerOperations()
	{
		
		Stream<Integer> myStream = Stream.of(45,16,789,120,336);
		
		
		// ---- anny.. class Implementation -----
		myStream.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
			
		});
		
		Stream<Integer> myStream2 = Stream.of(45,16,789,120,336);
		
		// through lambda operation implementation ---
		
		myStream2.forEach(t->System.out.println(t));
		
		
		
	}
}










