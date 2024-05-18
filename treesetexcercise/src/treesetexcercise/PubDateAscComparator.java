package treesetexcercise;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		int result = Integer.compare(((Book) o1).getYear(), ((Book) o2).getYear());
		if (result==0) {
			result += ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
		}
		return result;
	}
	
	

}
