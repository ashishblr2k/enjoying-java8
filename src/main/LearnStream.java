package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LearnStream {
	
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        learnGroupby();
    }
	
	private static void learnGroupby(){
		
		List<Foo> list = new ArrayList<Foo>();
		
		list.add(new Foo(1, "P1",  400));
		list.add(new Foo(2, "P2",  400));
		list.add(new Foo(3, "P3",  20));
		list.add(new Foo(3, "P3",  20));
		list.add(new Foo(1, "P1",  40));
		list.add(new Foo(4, "P4", 200));
		list.add(new Foo(4, "P4", 900));
		
		Map<String, Integer> salesBySeller =
			    list.stream()
			         .collect(Collectors.groupingBy(Foo::getName,
			        		 Collectors.summingInt(Foo::getQuantity)));
		
		salesBySeller.forEach((name, totalQty) -> System.out.print(name+"=="+totalQty+"\t"));
		
		/*list.stream()
		  .collect(Collectors.groupingBy(foo -> foo.id,
		                                    Collectors.summingInt(foo->foo.targetCost)))
		  .forEach((id,sumTargetCost)->System.out.println(id+"\t"+sumTargetCost));*/
		
	}

}
