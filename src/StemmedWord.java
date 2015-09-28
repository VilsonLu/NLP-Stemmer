
public class StemmedWord {
	private String fullWord;
	private String stemmedWord;
	
	
	public StemmedWord(String fullWord, String stemmedWord){
		this.fullWord = fullWord;
		this.stemmedWord = stemmedWord;
	}
	
	public String getFullWord() {
		return fullWord;
	}

	public void setFullWord(String fullWord) {
		this.fullWord = fullWord;
	}

	public String getStemmedWord() {
		return stemmedWord;
	}

	public void setStemmedWord(String stemmedWord) {
		this.stemmedWord = stemmedWord;
	}

	
}
