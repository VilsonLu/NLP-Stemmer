import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import DAO.NewsDAO;
import XMLDocumentParser.DocumentParser;


public class Driver {
	public static void main(String[] args){

		Stemmer stemmer = new Stemmer();
		String word = "pinagbasahan";
		
		DocumentParser docParser = new DocumentParser();
		//Scanner s = new Scanner(System.in);
		String filename = "./resources/Samples";
		
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		System.out.println(":: NAMED ENTITY RECOGNIZER USING REGULAR EXPRESSIONS ::");
		System.out.print("   > Enter filename of News XML (exclude the extension): ");
		
		//filename = s.next();
	
		filename += ".xml";
		
		System.out.println("===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===-===");
		
		List<NewsDAO> articles = docParser.parseXMLNewsFile(filename);
		List<StemmedWord> results = new ArrayList<StemmedWord>();
		for(NewsDAO n : articles) {
			StringTokenizer tokenizer = new StringTokenizer(n.getBody());
			while(tokenizer.hasMoreTokens()){
				String currentWord = tokenizer.nextToken();
				String stemmedWord = stemmer.stemmer(currentWord);
				System.out.print("Word: " + currentWord + " ");
				System.out.print("Stemmed: " + stemmedWord);
				results.add(new StemmedWord(currentWord,stemmedWord));
			}
		}
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("./resources/results.txt"));
			out.write("Full Word\tStemmed Word\n");
			for(StemmedWord r: results){
				out.write(r.getFullWord()+"\t"+r.getStemmedWord()+"\n");
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(word+ ": " + stemmer.stemmer(word));
	}
}
