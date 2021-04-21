package SeleniumSessions;

import java.util.HashMap;
import java.util.Map;

public class HashMapConcept {

	public static void main(String[] args) {
		/**
		 * Hash Map is a special data collection
		 * which is dynamic in nature and it stores the values in key and value pair format.
		 * can have only one null key
		 * can have any number of null values
		 * it is not order based collection - doesn't maintain order
		 * Map is interface; HashMap is class
		 */
		
		//declaration of HashMap
		Map<String, String> empMap = new HashMap<String, String> ();//topcasting - child class object and parent class ref variable
		empMap.put("name", "Tom");
		empMap.put("ID", "101");
		empMap.put("City", "Bangalore");
		empMap.put("Country", "IN");
		empMap.put(null, "Selenium");//null key is allowed
		empMap.put(null, "QTP");//null key will be overwritten by QTP and we will get QTP as output
		
		empMap.put("phone", null);
		empMap.put("Address", null); //null value allowed, we will get null value here
		empMap.put("name", "Lisa");//duploicate keys allowed but latest value will be fetched
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 1);
		map1.put("B", 2);
		map1.put("C", 3);
		
		//Capturing data from HashMap
		
		System.out.println(empMap.get("name"));
		System.out.println(empMap.get(null));
		System.out.println(empMap.get("phone"));
//		System.out.println(empMap.get("phone").length());//when performing any operation on null, here we will get null pointer exception
		
		//iterating the HashMap:
		//3 ways to iterate the HashMap:
		
		//1) entryset : to fetch all key-values
		for(Map.Entry<String, String> entry : empMap.entrySet()) {
			System.out.println("key = "+ entry.getKey() + " value = "+entry.getValue());
			//it doesn't fetch the value on order basis
			//it will maintain the values on their hashcode
			//first preference given to null - as there is no hash code for null
			//virtual capacity of HashMap = 15
		}
		
		//2) keyset(): to fetch only keyset
			for(String s: empMap.keySet()) {
				System.out.println("key is: "+s);
			}
			
		//3) values(): to get the values only
			for (String v : empMap.values()) {
				System.out.println("Value = "+v);
			}
		
		//4) using lambda:
			empMap.forEach((k,v)-> System.out.println("key = "+k+" value = "+v));
			
	}

}
