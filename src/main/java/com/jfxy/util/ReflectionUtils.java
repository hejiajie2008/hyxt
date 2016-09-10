package com.jfxy.util;

import java.lang.reflect.Field;

import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsExcel;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.GoodsnumberExcel;

public class ReflectionUtils {
	
	public static void setMethodField(Class clazz,Object obj,String fieldName,Object value){
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(obj, value); 
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void setGoodsExcelMethodField(GoodsExcel goodsExcel,String fieldName,Object value){
		try {
			Class clazz = Class.forName(Goods.class.getName());
			setMethodField(clazz,goodsExcel,fieldName,value);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void setGoodsnumberExcelMethodField(GoodsnumberExcel goodsnumberExcel,String fieldName,Object value){
		try {
			Class clazz = Class.forName(GoodsnumberExcel.class.getName());
			setMethodField(clazz,goodsnumberExcel,fieldName,value);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
