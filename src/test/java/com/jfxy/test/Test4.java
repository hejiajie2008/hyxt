package com.jfxy.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsExcel;

public class Test4 {
	public static void main(String[] args) {
		 
		try {
			Class clazz = Class.forName("com.jfxy.pojo.Goods"); 
			GoodsExcel goods = new GoodsExcel();
			Method method = clazz.getDeclaredMethod("setGoodscode", String.class);
			
			 Field idF = clazz.getDeclaredField("name");  
			 
			 idF.setAccessible(true);
			 
			 idF.set(goods, "110"); //set  
			method.invoke(goods, "123");
			
			System.out.println(goods.getGoodscode());
			
			System.out.println(goods.getName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
