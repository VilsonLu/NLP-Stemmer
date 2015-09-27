
public class Rules {
	// Suffixation
	public String removeSuffixation(String word){
		// if the end word ends in -han/-hin
		String temp = word;
		if(word.endsWith("han") || word.endsWith("hin")){
			temp = temp.substring(0, word.length()-3);
		} else if (word.endsWith("in")|| word.endsWith("an")){ // if the end word ends in -in/an
			temp = temp.substring(0, word.length()-2);
		}
		return temp;
	}
	
	// Infixation
	public String removeInfixation(String word){
		String temp = word;
		if(StemmerHelper.startsInConsonant(word)){
			System.out.println(word.subSequence(1, 3));
			if(word.subSequence(1, 3).equals("in") || word.subSequence(1, 3).equals("um")){
				temp = word.substring(0, 1) + word.substring(3, word.length());
			}
		}
		return temp;
	}
	
	public String removePrefixation(String word){
		String temp = word;
		// 3 length prefixes
		if(word.startsWith("mag") || word.startsWith("pag")){
			temp = temp.substring(3,word.length());
			if(temp.startsWith("-")){
				temp = temp.substring(1);
			}
		}
		return temp;
	}
}
