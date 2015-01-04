package iPhone;

import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlParse {

	public static int parsethexml(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		int newContact = 0;
        
		try{
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(request.getParameter("contacts")));
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			System.out.println("Here is the Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("contact");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					if(!eElement.getElementsByTagName("name").item(0).getTextContent().contains("undefined")||!eElement.getElementsByTagName("number").item(0).getTextContent().contains("undefined")){
					if(!eElement.getElementsByTagName("number").item(0).getTextContent().contains("?")){	
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Number : " + eElement.getElementsByTagName("number").item(0).getTextContent());
					newContact = MySqlAccess.insertintodb((String)session.getAttribute("username"),eElement.getElementsByTagName("name").item(0).getTextContent(), eElement.getElementsByTagName("number").item(0).getTextContent());
					}else{
						System.out.println("Contains ?");
					}
					}
				}
			}
		 
		}catch(Exception e){
			System.out.println("Failed To get Information");
			e.printStackTrace();
		}
		return newContact;
	}
}
