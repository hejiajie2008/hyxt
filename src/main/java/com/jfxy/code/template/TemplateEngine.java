package com.jfxy.code.template;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
@Service("templateEngine")
public class TemplateEngine {
	@Autowired
	private Configuration configuration;
	

	
	//@PostConstruct
	public void init() throws TemplateException {
		
		
		
		if (configuration == null) {
			throw new RuntimeException("configuration can't null");
		}else{
			File file=new File(this.getClass().getResource("").getPath());
			
			String path=file.getParentFile().getParentFile().getParentFile().getParentFile().getPath();
			
			System.out.println(this.getClass()+":"+path);
			try {
				configuration.setDirectoryForTemplateLoading(new File(path+"/config/template/"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public String process(String engineName, Map<?, ?> rootMap) {
		try {
			
			
			Template template = configuration.getTemplate(engineName);
			StringWriter out = new StringWriter();
			template.process(rootMap, out);
			return out.toString();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	

}
