package com.jfxy.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jfxy.pojo.ExcelPojo;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelUtil {
	
	public static void addCell(WritableSheet sheet,int j,int i,int value) throws RowsExceededException, WriteException{
		jxl.write.Number number = new jxl.write.Number(j, i, value);
		sheet.addCell(number);
	}
	
	public static void addCell(WritableSheet sheet,int j,int i,double value) throws RowsExceededException, WriteException{
		
		
		jxl.write.Number number = new jxl.write.Number(j, i, value);
		sheet.addCell(number);
	}
	
	public static void addCell(WritableSheet sheet,int j,int i,String value) throws RowsExceededException, WriteException{
		Label label = new Label(j, i, value);
		sheet.addCell(label);
	}
	
	public static void toExcel(List<ExcelPojo> listExcel){
		WritableWorkbook book = null;
		try {
			// 打开文件
			book = Workbook.createWorkbook(new File("D:/tt/test.xls"));
			// 生成名为"学生"的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("test", 0);
			// 指定单元格位置是第一列第一行(0, 0)以及单元格内容为张三
			
			List<String> list=new ArrayList<String>();
			list.add("大区");
			list.add("网点ID");
			list.add("网点");
			list.add("每月新增会员数");
			list.add("每月站点消费总单数");
			list.add("月度新会员招募占比");
			list.add("每月重复消费会员数");
			list.add("站点会员总数");
			list.add("月度会员销售活跃度");
			list.add("站点销售冠军商品");
			list.add("销售冠军商品数据");
			
			for(int j=0;j<list.size();j++){
				Label labeltitle = new Label(j, 0, list.get(j));
				
				sheet.addCell(labeltitle);
			}
			
			
			int i=1;
			
			for(ExcelPojo p:listExcel){
				
				
				int j=0;
				
				/*大区*/
				addCell(sheet,j++,i,p.getArea());
				/*网点ID*/
				addCell(sheet,j++,i,p.getShopId());
				
				/*网点名称*/
				addCell(sheet,j++,i,p.getShopName());
				
				
				// 保存数字的单元格必须使用Number的完整包路径
				/*每月新增会员数*/
				addCell(sheet,j++,i,p.getAddMembyMonth());
				/*每月站点消费总单数*/
				addCell(sheet, j++, i, p.getZdxfNum());
				/*月度新会员招募占比*/
				addCell(sheet, j++, i, p.getNewMemRebate());
				/*重复消费会员数*/
				addCell(sheet, j++, i, p.getRechargeMemNum());
				/*站点会员总数*/
				addCell(sheet, j++, i, p.getTotalMemNum());
				/*站点会员总数*/
				addCell(sheet, j++, i, p.getYdhyxshyd());
				
				/*站点销售冠军商品*/
				addCell(sheet, j++, i, p.getMaxGoods());
				/*销售冠军商品数据*/
				addCell(sheet, j++, i, p.getMaxGoodsNum());
				
				
	
				
				i++;
			}
			
			// 写入数据并关闭文件
			book.write();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (book != null) {
				try {
					book.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
