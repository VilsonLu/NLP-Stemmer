import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class HtmlReader {
	public static void readHtml(){
		String filename = "./resources/diction.htm";
	
		try {
			File file = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("p");
			for(int i=0; i<nList.getLength(); i++){
				Node node = nList.item(i);
				System.out.println(node.getNodeValue());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
