package com.jk.data.vo.meta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jk.data.util.ReflectUtil;
import com.jk.data.util.XmlNodeUtil;

//
public class DataGridVO<T> {

	private String nodePath = "";
	
	private List<Object> pTypeList = new ArrayList<Object>();
	
	private List<T> resultList = new ArrayList<T>(); 
	
	private int curIdx = 0;
	
	private T t;
	
	public String getNodePath() {
		return nodePath;
	}

	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}
	
	public void setParent(Object obj) {
		pTypeList.add(obj);
	}

	//
	public Object next() {
		if(curIdx>= pTypeList.size()) {
			return null;
		}
		
		Object obj = pTypeList.get(curIdx);
		++curIdx;
		return obj;
	}
	
	//
	public Object getNext(int idx) {
		if(idx >= pTypeList.size()) {
			return null;
		}
		
		Object obj = pTypeList.get(curIdx);
		return obj;
	}
	
	//
	public Object getParentType() {
		if(curIdx>= pTypeList.size()) {
			return null;
		}
		
		Object obj = pTypeList.get(curIdx);
		++curIdx;
		return obj;
	}
	
	public List<T> getResult(){
		return resultList;
	}
	
	public T getType() {
		return t;
	}

	
	//-----------------------------------
	//
	public void createRow(Node node, T newItem) {	//
		int nCount = pTypeList.size();
		
		int count = 0;
		Object type = null;
		List<String> nameList = null;
		//List<Method> methodList = null;
		Map<String, Method> methodMap = null;
		Method m = null;
		
		String charVal = "";
		
		String methodName = "";
		
		while(true) {
			if(count >= nCount) {
				break;
			}
			
			type = getNext(count); //
			
			if(type!=null) {
				//
				nameList = ReflectUtil.getNameList(type.getClass());
				methodMap = ReflectUtil.getMethodMap(type.getClass()); 	//Map
				
				for(String name : nameList) {
					charVal = XmlNodeUtil.getCharaData(node, name);
					if(!"".equals(charVal)) {
						methodName = ReflectUtil.setName(name);
						m = methodMap.get(methodName);
						if(m != null) {
							// method 이름 일치 해야 함.
							try {
								m.invoke(newItem, charVal);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					
				}
			}
			++count;
			
			
		}
		
		resultList.add(newItem);
		
	}
	
	
	//
	public void createGrid(NodeList itemlist) {
		int len = itemlist.getLength();
		Node n = null;
		
		for(int i=0;i<len;i++) {
			n = itemlist.item(i);
			//
			//makeRow(n);
			
		}
		
	}
	
	
	

	//
	private void makeRow(Node n) throws Exception {
		int len = pTypeList.size();
		
		//다시생각해볼것.
		T item = (T) t.getClass().newInstance();
		
		for(Object obj : pTypeList) {
			
			
			
		}
		
		
	}
	
}
