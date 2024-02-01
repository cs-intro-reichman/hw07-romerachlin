
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// if (str.length()==1) {
		// 	return "";

		// }else{
		String tail = str.substring(1);

		return tail;
	}
// }

	public static int levenshtein(String word1, String word2) {
		if (word1.length()==0 && word1.length()==0) {
			return 0;
		}

		String lower1 = word1.toLowerCase();
		String lower2 = word2.toLowerCase();
		char head1 = 0;
		char head2 = 1;
		if (word1.length()!=0) {
		head1 = lower1.charAt(0);
		}
		if (word2.length()!=0) {
		head2 = lower2.charAt(0);
		}

		if (lower1.length()==0) {
			return lower2.length();
		}else if (lower2.length()==0) {
			return lower1.length();
		}else if (head1==head2) {
			return levenshtein(tail(lower1), tail(lower2));
		}else{
			return 1+
			Math.min		(levenshtein(tail(lower1),tail(lower2))
			,(Math.min		(levenshtein(tail(lower1), lower2)
					, 		levenshtein(lower1, tail(lower2)))));
		}
		
		}


		
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine();
		}
		
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int min = threshold;
		for (int i = 0; i < dictionary.length; i++) {
			if (levenshtein(word, dictionary[i])<=threshold){
				int relevent = levenshtein(word, dictionary[i]);
				if (relevent<min) {
					min=relevent;
				}
			}

		}
		return word;
	}

}
