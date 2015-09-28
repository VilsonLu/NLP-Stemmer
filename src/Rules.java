import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Rules {
	
	public List<String> prefixes;
	
	public Rules(){
		loadPrefix();
	}
	
	public void loadPrefix(){
		prefixes = new ArrayList<String>();
		try {
			File file = new File("./resources/prefixes");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()){
				prefixes.add(scanner.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
			if(word.subSequence(1, 3).equals("in") || word.subSequence(1, 3).equals("um")){
				temp = word.substring(0, 1) + word.substring(3, word.length());
			}
		}
		return temp;
	}
	
	public String removePrefixation(String word){
		String temp = word;
		// 3 length prefixes
		for(String s: prefixes){
			if(word.startsWith(s)){
				temp = temp.substring(s.length()+1,word.length());
				
				if(temp.startsWith("-")){
					temp = temp.substring(1);
				}
				
				return temp;
			}
		}
	
		return temp;
	}
}
