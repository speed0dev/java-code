package xml;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jk.data.control.ReadXmlDomManager;

class XMLToGridTest {

	@Test
	void xmlLoadTest() {
		System.out.println("=== xml Loader ===");
		
		String xmlFile = "C:/WebProjects/JavaProjects/gitStorage/java-code/AAA/xml/Load.xml";
		
		ReadXmlDomManager xmlDom = new ReadXmlDomManager();
		xmlDom.makeDataSet(xmlFile);
		
		//
		
		
	}

}
