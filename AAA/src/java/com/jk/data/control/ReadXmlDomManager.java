package com.jk.data.control;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.jk.data.util.XmlNodeUtil;



public class ReadXmlDomManager {

	
	//
	public void makeDataSet(String fname) {
		
		//
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	      try {

	          // optional, but recommended
	          // process XML securely, avoid attacks like XML External Entities (XXE)
	          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

	          
	          XPathFactory xpathFactory = XPathFactory.newInstance();
	          XPath xpath = xpathFactory.newXPath();
	          
	          // parse XML file
	          DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File(fname));
	          
	          doc.getDocumentElement().normalize();

	          //System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	          System.out.println("========== start ==========");

	          
	          XPathExpression expr = xpath.compile("//result/items");	          
	          NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	          
	          System.out.println("items Node len:" + nodeList.getLength() );
	          
	          
	          //=========================================
	          ////
	          XPathExpression expr2 = xpath.compile("//result/items/itemList/item");
	          NodeList nodeList2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
	          System.out.println("item Node len:" + nodeList2.getLength() );
	          
	          int len = nodeList2.getLength();
	          Node parent = null;
	          
	          System.out.println( "[Start] =======================================================" );
	          
	          for(int i=0;i<len;i++) {
	        	  
	        	  //
	        	  System.out.println("["+i+"]Mode :" +  XmlNodeUtil.getCharaData(nodeList2.item(i), "Mode"));
	        	  System.out.println("["+i+"]Price :" +  XmlNodeUtil.getCharaData(nodeList2.item(i), "Price"));
	        	  
	        	  //
	        	  parent = nodeList2.item(i).getParentNode().getParentNode();
	        	  System.out.println( "["+i+"]itemNum :" + XmlNodeUtil.getCharaData(parent, "itemNum") );
	        	  System.out.println( "["+i+"]itemUser :" + XmlNodeUtil.getCharaData(parent, "itemUser") );
	        	  
	        	  System.out.println( "=======================================================" );
	          }
	          
	          	          
	          
	      }catch (Exception e) {
	          e.printStackTrace();
	      }
	      
	}
	
	
	
	
}
