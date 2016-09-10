package com.jfxy.util;

import java.util.ArrayList;
import java.util.List;


import com.jfxy.pojo.Sysgroup;
import com.jfxy.pojo.Sysmodule;

public class ListToTreeUtils {
	

	
	public static List<Sysgroup> getSysGroupTree(List<Sysgroup> list){
		
		List<Sysgroup> tree=new ArrayList<Sysgroup>();
		List<Sysgroup> result=new ArrayList<Sysgroup>();
		int size=list.size();
		int i=0;
		while(i<size){
			Sysgroup sysgroup=list.get(i);
			if(sysgroup.getParentgroupid()==0){
				
				
			    getListToTree(list,sysgroup,size);
			    tree.add(sysgroup);
			}
			i++;
		}
		result=getTreetoList(tree, result);
		
		
		
		
		return result;
	}
	public static void getListToTree(List<Sysgroup> list,Sysgroup sysgroup,int size){
		int i=0;
		List<Sysgroup> clist=new ArrayList<Sysgroup>();
		while(i<size){
			
			Sysgroup sysgroupi=list.get(i);
			
			if(sysgroupi.getParentgroupid().intValue()==sysgroup.getGroupid().intValue()){
				
				getListToTree(list,sysgroupi,size);
				
				clist.add(sysgroupi);
			}
			
			i++;
		}
		sysgroup.setSysgroupChilds(clist);
		
	}
	
	public static List<Sysgroup> getTreetoList(List<Sysgroup> ls,List<Sysgroup> result){
		int size=ls.size();
		int i=0;
		String str="|--";
		while(i<size){
			Sysgroup g=ls.get(i);
			
				String idstr=g.getParentidstr();
				StringBuffer sb=new StringBuffer("");
				StringBuffer kg=new StringBuffer(); 
				if(idstr.contains("/")){
					int size2=idstr.split("/").length-1;
					
					for(int j=0;j<size2;j++){
						sb.append(str);
						if(j>=2){
							kg.append("　　");
						}
					}
					
					
				}
				g.setGroupname(kg.toString()+sb.toString()+g.getGroupname());
			result.add(g);
			getTreetoList(g.getSysgroupChilds(), result);
			i++;
		}
		return result;
		
	}
	
	
 public static List<Sysmodule> getSysModuleTree(List<Sysmodule> list){
		
		List<Sysmodule> tree=new ArrayList<Sysmodule>();
		List<Sysmodule> result=new ArrayList<Sysmodule>();
		for(int i=0;i<list.size();i++){
			Sysmodule sysmodule=list.get(i);
			Integer pid=sysmodule.getModuleparentid();
			Integer mid=sysmodule.getModuleid();
			
			if(pid.intValue()==0){
				List<Sysmodule> clist=new ArrayList<Sysmodule>();
				for(int j=0;j<list.size();j++){
					Sysmodule sysgroupj=list.get(j);
					if(mid.intValue()==sysgroupj.getModuleparentid().intValue()){
						clist.add(sysgroupj);
						
					}
				}
				sysmodule.setSysmoduleChilds(clist);
				
				
				tree.add(sysmodule);
			}
			
		}
		
		for(int i=0;i<tree.size();i++){
			Sysmodule sg=tree.get(i);
			result.add(sg);
			List<Sysmodule> ls=sg.getSysmoduleChilds();
			for(int j=0;j<ls.size();j++){
				Sysmodule sgj=ls.get(j);
				sgj.setModulecaption("|---"+sgj.getModulecaption());
				result.add(sgj);
			}
		}
		
		
		return result;
	}

}
