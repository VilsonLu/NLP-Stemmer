
public class Stemmer {
	public String stemmer(String word){
		Rules rule = new Rules();
		String temp = word;
		// remove the suffixes first - they are easy.
		temp = rule.removeSuffixation(word);
		// remove the infixes 
		temp = rule.removeInfixation(temp);
		// remove the suffixes
		temp = rule.removePrefixation(temp);
		return temp;
	}
}
