package day6work;

import java.util.ArrayList;
import java.util.HashMap;

public class Day6Examples {

	public static void main(String[] args) {
		
		//Exception Example
		int[] hiya = new int[1];
		
		try{
		System.out.println(hiya[2]);
		}catch(ArrayIndexOutOfBoundsException E){
			System.out.println("You've made some kind of error");
		}
		
		//Array Lists/Collections
		int[] hiya2 = new int[10]; //normal array
		ArrayList<Integer> hiThere = new ArrayList<>(10); //Array List
		hiThere.add(0);
		hiThere.add(1);
		hiThere.add(0);
		hiThere.add(2);
		hiThere.add(3);
		System.out.println(hiThere);
		hiThere.remove(0);
		System.out.println(hiThere);
		String line = hiThere.toString();
		System.out.println(line);
		
		ArrayList<String> hiThere2 = new ArrayList<>(10); //Array List
		hiThere2.add("H");
		hiThere2.add("i");
		hiThere2.add("T");
		hiThere2.add("h");
		hiThere2.add("e");
		hiThere2.add("r");
		hiThere2.add("e");
		System.out.println(hiThere2);
		hiThere2.remove(0);
		System.out.println(hiThere2);
		String line2 = hiThere2.toString();
		System.out.println(line2);
		
		
		
		//Hash Maps - key and value and be different data types (String, int, char, etc)
		HashMap <String, String> cars = new HashMap<>();
		cars.put("Sonic", "Chevy");
		cars.put("Malibu", "Chevy");
		cars.put("F-150", "Ford");
		cars.put("F-250", "Ford");
		System.out.println(cars.get("Sonic"));
		System.out.println(cars.size());
		
		
	}

}
