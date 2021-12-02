package com.jk.data.vo.meta;

import java.util.ArrayList;
import java.util.List;

import com.jk.data.vo.DataVO;
import com.jk.data.vo.ItemVO;
import com.jk.data.vo.NodeItemVO;

//
public class SampleMetaVO {

	//List<Type> 

	private List<ItemVO> itemList = new ArrayList<ItemVO>();
	
	private List<NodeItemVO> nodeItemList = new ArrayList<NodeItemVO>();
	
	private List<DataVO> dataList = new ArrayList<DataVO>();

	
	//
	private String pathName = "";
	private List<String[]> nodePart = null;
	
	
}
