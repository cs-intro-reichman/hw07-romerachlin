

public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i < dictionary.length; i++) {	
		if (word.equals(dictionary[i])){
			return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 		
		// int N = hashtag.length();
		// String lowerCaseString = hashtag.toLowerCase();
		// System.err.println(lowerCaseString.substring(0,0));

        int N = hashtag.length();
		String lowerCaseHashtag = hashtag.toLowerCase();
        for (int i = 1; i <= N; i++) {
		boolean isWord = existInDictionary(lowerCaseHashtag.substring(0,i), dictionary);
			if (isWord) {
			System.out.println(lowerCaseHashtag.substring(0,i));
			breakHashTag(lowerCaseHashtag.substring(i), dictionary);
			return;
			}
	      }
		  breakHashTag(lowerCaseHashtag.substring(1), dictionary);
	}

}
