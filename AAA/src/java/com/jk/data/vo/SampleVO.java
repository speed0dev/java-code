package com.jk.data.vo;

import java.io.Serializable;

public class SampleVO implements Serializable{

	//
	private String name;
	private String Mode;
	private String itemNum;
	private String itemData;
	
	private String Price;
	private String checkName;
	private String codeNameP;
	//
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	public String getItemNum() {
		return itemNum;
	}
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	public String getItemData() {
		return itemData;
	}
	public void setItemData(String itemData) {
		this.itemData = itemData;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getCodeNameP() {
		return codeNameP;
	}
	public void setCodeNameP(String codeNameP) {
		this.codeNameP = codeNameP;
	}
	
	
}
