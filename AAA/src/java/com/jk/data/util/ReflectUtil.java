package com.jk.data.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtil {
	
	//
	public static List<String> getNameList(Class clzz) {
		List<String> list = new ArrayList<String>();
		
		//Class clzz = obj.getClass();
		if(clzz == null) {
			return list;
		}
		
		Method[] methods = clzz.getDeclaredMethods();
		String mName = "";
		
		
		for(Method m : methods) {
			mName = m.getName();
			if(mName.startsWith("set")) {	//
				list.add(getName(mName));
			}
		}
		return list;
	}
	
	public static List<Method> getMethodList(Class clzz) {
		List<Method> list = new ArrayList<Method>();
		
		//Class clzz = obj.getClass();
		if(clzz == null) {
			return list;
		}
		
		Method[] methods = clzz.getDeclaredMethods();
		String mName = "";
		
		for(Method m : methods) {
			mName = m.getName();
			if(mName.startsWith("set")) {	//
				list.add(m);
			}
		}
		return list;
	}
	
	
	public static String getName(String name) {
		if(name.length() < 3) {
			return name;
		}
		char[] arr = name.substring(3).toCharArray();
		arr[0] = Character.toLowerCase(arr[0]);
		return new String(arr);
	}

	
	public static String setName(String name) {
		
		char[] arr = name.toCharArray();
		arr[0] = Character.toUpperCase(arr[0]);
		return "set" + new String(arr);
	}

	
	
	//
	public static Map<String, Method> getMethodMap(Class clzz) {
		Map<String, Method> map = new HashMap<String, Method>();
		
		//Class clzz = obj.getClass();
		if(clzz == null) {
			return map;
		}
		
		Method[] methods = clzz.getDeclaredMethods();
		String mName = "";
		
		for(Method m : methods) {
			mName = m.getName();
			if(mName.startsWith("set")) {	//
				map.put(mName, m);
			}
		}
		return map;
	}
	
	
	

}
