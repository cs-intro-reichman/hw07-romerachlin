
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		if (str.length()==1) {
			return "";

		}else{
		String tail = str.substring(1);

		return tail;
	}
}

	public static int levenshtein(String word1, String word2) {
		String lower1 = word1.toLowerCase();
		String lower2 = word2.toLowerCase();
		if (lower1.length()==0) {
			return lower2.length();
		}if (lower2.length()==0) {
			return lower1.length();
		}if (lower1.charAt(0)==lower2.charAt(0)) {
			return levenshtein(tail(lower1), tail(lower2));
		}else{
			return 1+Math.min(levenshtein(tail(lower1),tail(lower2)),(Math.min(levenshtein(tail(lower1), lower2), levenshtein(lower1, tail(lower2)))));
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
		// Your code goes here
	}

}
