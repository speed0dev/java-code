package com.jk.data.vo.meta;

import java.util.List;

import javax.xml.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jk.data.util.XmlNodeUtil;
import com.jk.data.vo.DataVO;
import com.jk.data.vo.ItemVO;
import com.jk.data.vo.RowVO;

public class OrdMetaVO {

	private DataGridVO<ItemVO> gridItem = new DataGridVO<ItemVO>();
	
	private DataGridVO<DataVO> gridData = new DataGridVO<DataVO>();
	
	private DataGridVO<RowVO> gridRow = new DataGridVO<RowVO>();
	
	private List<ItemVO> ItemListResult = null;
	
	
	// Setting
	public OrdMetaVO() {
		
		gridItem.setNodePath("//items/itemList/item");
		gridData.setNodePath("//items/dataList/data");
		gridRow.setNodePath("//items/rowList/row");
		
		gridItem.setParent(new ItemVO());
		
	}
	
	
	public List<ItemVO> listItemResult(){
		return ItemListResult;
	} 
	
	
	// 공통메소드로 추출 할것.
	public void create(Document doc, XPath xpath) {
		
		String itemPath = gridItem.getNodePath();
		String gridPath = gridData.getNodePath();
		String rowPath = gridRow.getNodePath();
		
		try {
			
			//
			NodeList itemlist = XmlNodeUtil.getPathList(itemPath, doc, xpath);
			System.out.println("Item :" + itemlist.getLength());
			gridItem.createGrid(itemlist);
			
			int len = itemlist.getLength();
			Node n = null;
			
			for(int i=0;i<len;i++) {
				n = itemlist.item(i);
				gridItem.createRow(n, new ItemVO());
			}
			
			ItemListResult = gridItem.getResult();
			
			
			
			
			
			NodeList gridList = XmlNodeUtil.getPathList(gridPath, doc, xpath);
			System.out.println("grid :" + gridList.getLength());
			
			
			
			NodeList rowList = XmlNodeUtil.getPathList(rowPath, doc, xpath);
			System.out.println("row :" + rowList.getLength());
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
