package com.jk.data.util;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlNodeUtil {

	
	//
	public static String getCharaData(Node node, String name) {
		
		Element element = (Element)node;
		NodeList list = element.getElementsByTagName(name);
	    Element line = (Element)list.item(0);
		if(line == null) {
			return "";
		}
	    
		//
	    Node child = line.getFirstChild();
	    if(child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData().trim();
	    }
	    return "";
	}
	
	//
	public static NodeList getPathList(String path, Document doc, XPath xpath) throws Exception {
		// xpath.compile("//result/items/itemList/item");
		XPathExpression expr2 = xpath.compile(path);
		Object obj = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
		if(obj == null) {
			return null;
		}
		return (NodeList)obj;
	}
	
}
