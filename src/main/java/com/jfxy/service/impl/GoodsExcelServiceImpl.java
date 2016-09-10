package com.jfxy.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;












//import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.stereotype.Service;

import scala.annotation.meta.field;

import com.jfxy.dao.GoodsDao;
import com.jfxy.dao.GoodsclassDao;
import com.jfxy.dao.MemDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.ExcelField;
import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsExcel;
import com.jfxy.pojo.Goodsclass;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.GoodsnumberExcel;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.util.ReflectionUtils;
import com.jfxy.util.StringUtil;

/**
 * 会员excel
 * 
 * @author hejiajie
 * 
 */
@Service
public class GoodsExcelServiceImpl {

	public static int STARTROW = 0;

	public static int STARTCELL = 5;

	

	
	
	
	@Resource
	private GoodsclassDao goodsclassDao;
	@Resource
	private MemDao memDao;
	@Resource
	private GoodsDao goodsDao;

	

	

	public List<GoodsExcel> exceltoPojo(Sheet oFirstSheet,Integer createshopid) {
		List<GoodsExcel> list = new ArrayList<GoodsExcel>();
		int rows = oFirstSheet.getRows();
		
		for (int row = GoodsExcelServiceImpl.STARTCELL; row < rows; row++) {
			GoodsExcel goods = new GoodsExcel();
			goods.setCreateshopid(createshopid);
			StringBuffer validate = new StringBuffer();
			for (ExcelField excel : MemoryListener.listgoodsfiled) {
				String value=oFirstSheet.getCell(excel.getFieldid()-1, row).getContents();
				
				switch (excel.getFieldtype()) {
				case 1:
					if(StringUtil.isBlank(value)){
						value="0";
					}
					Integer valInt=Integer.parseInt(value);
					ReflectionUtils.setGoodsExcelMethodField(goods,excel.getField(),valInt);
					
					break;
				case 2:
					
					ReflectionUtils.setGoodsExcelMethodField(goods,excel.getField(),value);
					break;
				case 3:
					if(StringUtil.isBlank(value)){
						value="0";
					}
					
					BigDecimal valDecimal=new BigDecimal(value);
					ReflectionUtils.setGoodsExcelMethodField(goods,excel.getField(),valDecimal);
					
				default:
					break;
				}
				
				
			}
		
			
			
			int index=MemoryListener.listgoodsfiled.size();
			List<ExcelField> excelFields=new ArrayList<ExcelField>();
			for (Memcustomfield memcustomfield : MemoryListener.goodscustomfields) {
				ExcelField excelField=new ExcelField();
				excelField.setFieldid(index);
				excelField.setFieldname(memcustomfield.getCustomfieldname());
				
				String value = oFirstSheet.getCell(excelField.getFieldid(), row)
						.getContents();
				excelField.setFieldvalue(value);
				excelField.setField(memcustomfield.getCustomfield());
				excelFields.add(excelField);
				index++;
			}
			goods.setExcelFields(excelFields);
			
			
			String goodscode=goods.getGoodscode();
			Map<String, Object> validateMap=new HashMap<String, Object>();
			validateMap.put("goodscode", goodscode);
			validateMap.put("shopid", createshopid);
			if(goodsDao.validateGoodsCode(validateMap)>0){
				if(validate.length()==0){
					validate.append("对不起，该商品编码己存在！");
				}
			}
			
			
			if(validate.length()==0){
				validate.append("success");
			}
			
			goods.setValidate(validate.toString());
			list.add(goods);

		}
		return list;
	}
	
	public List<GoodsnumberExcel> exceltoGoodsnumberPojo(Sheet oFirstSheet) {
		List<GoodsnumberExcel> list = new ArrayList<GoodsnumberExcel>();
		int rows = oFirstSheet.getRows();
		
		for (int row = GoodsExcelServiceImpl.STARTCELL; row < rows; row++) {
			GoodsnumberExcel goodsnumber = new GoodsnumberExcel();
			StringBuffer validate = new StringBuffer();
			for (ExcelField excel : MemoryListener.listgoodsnumberfiled) {
				String value=oFirstSheet.getCell(excel.getFieldid()-1, row).getContents();
				
				switch (excel.getFieldtype()) {
				case 1:
					Integer valInt=Integer.parseInt(value);
					ReflectionUtils.setGoodsnumberExcelMethodField(goodsnumber,excel.getField(),valInt);
					break;
				case 2:
					
					ReflectionUtils.setGoodsnumberExcelMethodField(goodsnumber,excel.getField(),value);
					break;
				case 3:
					BigDecimal valDecimal=new BigDecimal(value);
					ReflectionUtils.setGoodsnumberExcelMethodField(goodsnumber,excel.getField(),valDecimal);
				default:
					break;
				}
				
				
			}
		
			
			
			if(validate.length()==0){
				validate.append("success");
			}
			
			goodsnumber.setValidate(validate.toString());
			list.add(goodsnumber);

		}
		return list;
	}

	
	
	public File getExcelFile(String fileName){
		String path=this.getClass().getResource("/").getPath();
		File resultFile=new File(path+"Upload/Template/"+fileName);
		return resultFile;
	}

	public void writeExcel() {
		
		
		FileOutputStream bos=null;
		try {
			bos = new FileOutputStream(getExcelFile("Goods.xls"));
			WritableWorkbook wwb = Workbook.createWorkbook(bos);
			WritableSheet ws = wwb.createSheet("商品列表", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 25,
					WritableFont.BOLD);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setAlignment(Alignment.CENTRE);
			int listgoodsfiledlen = MemoryListener.listgoodsfiled.size()
					+ MemoryListener.goodscustomfields.size() - 1;
			Label label1 = new Label(0, 0, "商品信息批量录入模板", wcf);
			ws.mergeCells(0, 0, listgoodsfiledlen, 2);
			ws.addCell(label1);
			StringBuffer sbsj = new StringBuffer(
					"相关数据字典：（★★请严格按照相关格式填写，以免导入错误★★）\n");
			sbsj.append("         列名带有\"*\"是必填列;\n")
					.append("         商品编码：只能是长度为5～25位字符(数字、字母、字母数字组合);\n")
					.append("         商品分类ID：");
			Goodsclass goodsclasstj=new Goodsclass();
			List<Goodsclass> goodsclasses=goodsclassDao.list(goodsclasstj);
			for(Goodsclass goodsclass:goodsclasses){
				sbsj.append(goodsclass.getClassid()).append("-")
				.append(goodsclass.getClassname()).append(" ");
			}
			sbsj.append(";\n");
			sbsj.append("         商品积分：填写0或正整数\n")
					.append("         商品类型：0-普通商品 1-服务项目;\n")
					.append("         最低折扣：填写0～1之间的小数;\n")
					.append("         提成类型：1-按固定比例提成  2-按固定金额提成;\n")
					.append("         提成金额(比例)： 当'提成类型ID'为1时，'提成金额(比例)'填0～1的小数; 当'提成类型ID'为2时，'提成金额(比例)'填整数;\n");
			
			
			WritableCellFormat wcf2 = new WritableCellFormat();
			wcf2.setVerticalAlignment(VerticalAlignment.TOP);
			wcf2.setWrap(true);
			ws.setRowView(3, 2600, false); // 设置行高

			Label label2 = new Label(0, 3, sbsj.toString(), wcf2);

			ws.mergeCells(0, 3, listgoodsfiledlen, 3);

			ws.addCell(label2);

			for (ExcelField memExcel : MemoryListener.listgoodsfiled) {
				wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
				wf.setColour(jxl.format.Colour.RED);

				WritableCellFormat wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.CENTRE);
				StringBuffer title = new StringBuffer();
				if (memExcel.getFieldisnull() == 0) {
					title.append("*");
				}
				title.append(memExcel.getFieldname());
				Label lab = new Label(memExcel.getFieldid() - 1, 4,
						title.toString(), wcfF);
				ws.setColumnView(memExcel.getFieldid() - 1,
						memExcel.getFieldlength());// 根据内容自动设置列宽
				ws.addCell(lab);

				Label lab2 = new Label(memExcel.getFieldid() - 1, 5,
						memExcel.getFieldvalue());
				ws.addCell(lab2);
			}

			int index = MemoryListener.listgoodsfiled.size();
			for (Memcustomfield memcustomfield : MemoryListener.goodscustomfields) {

				wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
				wf.setColour(jxl.format.Colour.RED);
				WritableCellFormat wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.CENTRE);
				Label lab = new Label(index, 4,
						memcustomfield.getCustomfieldname(), wcfF);
				ws.setColumnView(index, 18);// 根据内容自动设置列宽
				ws.addCell(lab);
				index++;
			}
			wwb.write();
			wwb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public void writeNumberExcel() {
		
		
		FileOutputStream bos=null;
		try {
			bos = new FileOutputStream(getExcelFile("GoodsNumber.xls"));
			WritableWorkbook wwb = Workbook.createWorkbook(bos);
			WritableSheet ws = wwb.createSheet("库存列表", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 25,
					WritableFont.BOLD);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setAlignment(Alignment.CENTRE);
			int listMemfiledlen = MemoryListener.listgoodsnumberfiled.size();
			Label label1 = new Label(0, 0, "商品库存批量录入模板", wcf);
			ws.mergeCells(0, 0, listMemfiledlen, 2);
			ws.addCell(label1);
			StringBuffer sbsj = new StringBuffer(
					"相关数据字典：（★★请严格按照相关格式填写，以免导入错误★★）\n");
			sbsj.append("         列名带有\"*\"是必填列;\n")
					.append("         商品编码：只能是长度为5～25位字符(数字、字母、字母数字组合);\n")
					.append("         商品库存：填写0或正整数或大于0的小数位不超2位的小数\n");
					
			
			
			WritableCellFormat wcf2 = new WritableCellFormat();
			wcf2.setVerticalAlignment(VerticalAlignment.TOP);
			wcf2.setWrap(true);
			ws.setRowView(3, 2600, false); // 设置行高

			Label label2 = new Label(0, 3, sbsj.toString(), wcf2);

			ws.mergeCells(0, 3, listMemfiledlen, 3);

			ws.addCell(label2);

			for (ExcelField memExcel : MemoryListener.listgoodsnumberfiled) {
				wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
				wf.setColour(jxl.format.Colour.RED);

				WritableCellFormat wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.CENTRE);
				StringBuffer title = new StringBuffer();
				if (memExcel.getFieldisnull() == 0) {
					title.append("*");
				}
				title.append(memExcel.getFieldname());
				Label lab = new Label(memExcel.getFieldid() - 1, 4,
						title.toString(), wcfF);
				ws.setColumnView(memExcel.getFieldid() - 1,
						memExcel.getFieldlength());// 根据内容自动设置列宽
				ws.addCell(lab);

				
			}
			Goods goodsyz=new Goods();
			List<Goods> listGoods=goodsDao.list(goodsyz);
			for(int i=0;i<listGoods.size();i++){
				Goods goods=listGoods.get(i);
				
				Label lab2 = new Label(0, 5+i,
						goods.getGoodscode());
				
				
				ws.addCell(lab2);
				
				lab2 = new Label(1, 5+i,
						goods.getName());
				ws.addCell(lab2);
			}
			

			
			wwb.write();
			wwb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
