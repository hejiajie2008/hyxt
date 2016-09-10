package com.jfxy.test;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jfxy.code.config.GenerateConfig;
import com.jfxy.code.db.MySQLOperator;
import com.jfxy.code.pojo.Table;
import com.jfxy.code.template.TemplateEngine;
import com.jfxy.util.DateUtil;


/**
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/spring/spring*.xml"})
		**/
public class Test1 {
	@Autowired
	private MySQLOperator mySQLOperator;
	@Autowired
	private TemplateEngine templateEngine;
	//@Test
	public void testMY() throws Exception{
		
		
		List<Table> list=mySQLOperator.getTables();
		String dirurl = "d:\\hyxt2\\";
		//String module = GenerateConfig.MODULE;
		String author = GenerateConfig.AUTHOR;
		String now = DateUtil.format(new Date(), DateUtil.yyyy_MM_dd_HH_mm_ss);
		for (Table t : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			PrintWriter pw = null;
			String str = null;
			File file=null;
			map.put("author", author);
			map.put("now", now);
			map.put("table", t);
			str = templateEngine.process("mybatis.ftl", map);
			file = new File(dirurl + "\\mapping");
			file.mkdirs();
			
			
			file = new File(dirurl + "\\mapping\\" + t.getJavaName() + ".xml");
			pw = new PrintWriter(file);
			pw.print(str);
			pw.close();
			
			str = templateEngine.process("mapper.ftl", map);
			file = new File(dirurl + "\\com\\jfxy\\dao");
			file.mkdirs();
			file = new File(dirurl + "\\com\\jfxy\\dao\\" + t.getJavaName() + "Dao.java");
			pw = new PrintWriter(file);
			pw.print(str);
			pw.close();
			
			
			
			str = templateEngine.process("pojo.ftl", map);
			file = new File(dirurl + "\\com\\jfxy\\pojo");
			file.mkdirs();
			file = new File(dirurl + "\\com\\jfxy\\pojo\\" + t.getJavaName() + ".java");
			pw = new PrintWriter(file);
			pw.print(str);
			pw.close();
			
			
			str = templateEngine.process("formBean.ftl", map);
			file = new File(dirurl + "\\com\\jfxy\\pojo\\form");
			file.mkdirs();
			file = new File(dirurl + "\\com\\jfxy\\pojo\\form\\" + t.getJavaName() + "FormBean.java");
			pw = new PrintWriter(file);
			pw.print(str);
			pw.close();
			
			
		}
	}

}
