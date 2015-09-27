
public class StemmerHelper {
	
	
	public static boolean isConsonant(char letter){
		switch(letter){
		case 'b':
		case 'c':
		case 'd':
		case 'f':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'v':
		case 'w':
		case 'x': 
		case 'y':
		case 'z': return true;
		default: return false;
		}
	}
	public static boolean isVowel(char letter){
		
		switch(letter){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': return true; 
			default: return false;
	
		}
	}
	
	public static boolean endsInVowel(String word){
		if(isVowel(word.charAt(word.length()-1))){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean endInConsonant(String word){
		if(isConsonant(word.charAt(word.length()-1))){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean startsInVowel(String word){
		if(isVowel(word.charAt(0))){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean startsInConsonant(String word){
		if(isConsonant(word.charAt(0))){
			return true;
		} else {
			return false;
		}
	}
}
