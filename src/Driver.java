
public class Driver {
	public static void main(String[] args){

		Stemmer stemmer = new Stemmer();
		String word = "pinagbasahan";
		
		System.out.println(word+ ": " + stemmer.stemmer(word));
	}
}
