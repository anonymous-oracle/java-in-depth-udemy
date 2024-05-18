package codingexercise3;

public class IRUtil {

	public static int getFrequencyCount(String term, String doc) {
		term = term.toLowerCase();
		doc = doc.toLowerCase();
		int term_count = 0;
		while (true){
			int term_index = doc.indexOf(term);
			if (term_index!=-1){
				term_count++;
				doc = doc.substring(term_index);
			} else {
				break;
			}
		}
		return term_count;
	}
	
	public static double termFrequency(String term, String doc) {
		int frequencyCount = getFrequencyCount(term, doc);
		int docTermCount = doc.split(" ").length;
		
		return frequencyCount / docTermCount;
	}
}
