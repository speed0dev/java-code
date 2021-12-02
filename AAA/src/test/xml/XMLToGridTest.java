package xml;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jk.data.control.ReadXmlDomManager;
import com.jk.data.util.ReflectUtil;
import com.jk.data.vo.SampleVO;
import com.jk.data.vo.meta.DataGridVO;
import com.jk.data.vo.meta.OrdMetaVO;

class XMLToGridTest {

	
	//------------------------
	// final 
	//------------------------
	@Test
	void xmlLoadTest() {
		System.out.println("=== xml Loader ===");
		
		String xmlFile = "C:/WebProjects/JavaProjects/gitStorage/java-code/AAA/xml/Load.xml";
		
		ReadXmlDomManager xmlDom = new ReadXmlDomManager();
		xmlDom.createDataSet(xmlFile);
		
		
		
	}
	
	
	@Test
	void makeDataSet() {
		System.out.println("=== xml Loader ===");
		
		String xmlFile = "C:/WebProjects/JavaProjects/gitStorage/java-code/AAA/xml/Load.xml";
		
		ReadXmlDomManager xmlDom = new ReadXmlDomManager();
		xmlDom.makeDataSet(xmlFile);
		
		
		
	}
	
	
	//-------------------------------
	//
	@Test
	void nameTest() {
		//
		String name = ReflectUtil.getName("setName");
		System.out.println(name);
		
		//==================================
		System.out.println(">>>>>>>>>>>>");
		
		List<String> names = ReflectUtil.getNameList(SampleVO.class);
		SampleVO vo = new SampleVO();
		List<Method> methods = ReflectUtil.getMethodList(vo.getClass());
		
		for(String nm: names) {
			System.out.println(nm);
		}
		
		try {
			for(Method m : methods) {
				//
				m.invoke(vo, "AAAAAAAAAA, BBB, CCCV");
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( vo.getMode() );
		
	}
	
	// List ClassType 
	@Test
	public void getListTClass() {
		
		List<DataGridVO<String>> list = new ArrayList<DataGridVO<String>>();
		
		//Iterator<DataGridVO<String>> it = list.iterator();
		Class c = list.iterator().getClass();
		c.getTypeName();
		System.out.println();
		
		
		
	}
	

}
