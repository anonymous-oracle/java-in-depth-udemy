package check_distance_between_same_letters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public static boolean checkDistances(String s, int[] distance) {
    	
    		HashMap<String, ArrayList<Integer>> spaceMap = new HashMap<>();
    		for (int i=0; i < s.length(); i++) {
    			String chString = String.valueOf(s.charAt(i));
    			if (spaceMap.containsKey(chString)) {
    				spaceMap.get(chString).add(i);
    				
    			} else {
    				spaceMap.put(chString, new ArrayList<Integer>(Arrays.asList(i)));
    			}
    		}
    		boolean evenlySpaced = true;
    		for (Entry<String, ArrayList<Integer>> mapEntry: spaceMap.entrySet()) {
    			char ch = mapEntry.getKey().charAt(0);
    			ArrayList<Integer> idxArray = mapEntry.getValue();
    			int idxDifference =  idxArray.get(1) - idxArray.get(0) - 1;
    			if (idxDifference != distance[(int) (ch - 'a')]) {
    				evenlySpaced = false;
    				break;
    			}
    		}
		return evenlySpaced;
    		}
        
    
    		
    
public static void main(String[] args) {
	boolean result = checkDistances("abaccb", new int[] {1,2,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
	System.out.println(result);
}    

}