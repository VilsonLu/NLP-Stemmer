
public class Stemmer {
	public String stemmer(String word){
		Rules rule = new Rules();
		String temp = word;
		if(temp.length() > 2){
		// remove the suffixes first - they are easy
			if(isValidStemmed(rule.removeSuffixation(word))){
				temp = rule.removeSuffixation(word);
			}
			// remove the infixes
			if(isValidStemmed(rule.removeInfixation(temp))){
				temp = rule.removeInfixation(temp);
			}
			
			// remove the prefixes
			if(isValidStemmed(rule.removePrefixation(temp))){
				temp = rule.removePrefixation(temp);
			}
		}
		
		return temp;
	}
	
	public boolean isValidStemmed(String word){
		boolean hasVowel = false;
		
		if(word.length() > 0 ) {
		
			if(StemmerHelper.startsInConsonant(word)){
				
				for(int i=0; i<word.length(); i++){
					if(StemmerHelper.isVowel(word.charAt(i))){
						hasVowel = true;
					}
				}
				
				if(hasVowel && word.length() >= 4){
					return true;
				} else {
					return false;
				}
			} else {
				boolean hasConsonant = false;
				for(int i=0; i<word.length(); i++){
					if(StemmerHelper.isConsonant(word.charAt(i))){
						hasConsonant = true;
					}
				}
				
				if(hasConsonant && word.length() >= 3){
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}

	}
}
