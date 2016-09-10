package com.jfxy.util.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.jfxy.pojo.Sysshop;
import com.jfxy.service.impl.MemoryServiceImpl;


public class ShopTag extends BaseTag {

	StringBuffer sb = new StringBuffer();// 构建StringBuffer对象，用户拼接分页标签

	private Integer shopid;// 订单类型
	@Override
	public void doTag() throws JspException, IOException {
		

		JspWriter out = this.getJspContext().getOut();// 指定输入流，用于页面输出分页信息、
		
		List<Sysshop> shopList=MemoryServiceImpl.getAuthShop(getUserId());
		for(Sysshop shop:shopList){
			if(shop.getShopid()==shopid){
				sb.append("<option value=\""+shop.getShopid()+"\" selected=\"selected\">"+shop.getShopname()+"</option>");
			}else{
				sb.append("<option value=\""+shop.getShopid()+"\">"+shop.getShopname()+"</option>");
			}
			
		}
		

		out.print(sb);
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	
	

	
	

	

}