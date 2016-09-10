package com.jfxy.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.CellType;
import jxl.CellView;
import jxl.DateCell;
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

import com.jfxy.dao.MemDao;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.ExcelField;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Sysshop;
import com.jfxy.util.DateUtil;
import com.jfxy.util.StringUtil;

/**
 * 会员excel
 * 
 * @author hejiajie
 * 
 */
@Service
public class MemExcelServiceImpl {

	public static int STARTROW = 0;

	public static int STARTCELL = 5;

	/* 会员卡号 */
	public static int MEMCARD = 0;

	public static String MEMCARD_LABEL = "会员卡号";

	/* 姓名 */
	public static int MEMNAME = 1;
	public static String MEMNAME_LABEL = "姓名";

	/* 性别 */
	public static int MEMSEX = 2;
	public static String MEMSEX_LABEL = "性别";

	/* 身份证号码 */
	public static int MEMIDENTITYCARD = 3;
	public static String MEMIDENTITYCARD_LABEL = "身份证号码";

	/* 手机号码 */
	public static int MEMMOBILE = 4;
	public static String MEMMOBILE_LABEL = "手机号码";

	/* 固定电话 */
	public static int MEMTELEPHONE = 5;
	public static String MEMTELEPHONE_LABEL = "固定电话";

	/* 生日 */
	public static int MEMBIRTHDAY = 6;
	public static String MEMBIRTHDAY_LABEL = "生日";

	/* 积分 */
	public static int MEMPOINT = 7;
	public static String MEMPOINT_LABEL = "积分";

	/* 余额 */
	public static int MEMMONEY = 8;
	public static String MEMMONEY_LABEL = "余额";

	/* 历史消费金额 */
	public static int MEMCONSUMEMONEY = 9;
	public static String MEMCONSUMEMONEY_LABEL = "历史消费金额";

	/* 电子邮箱 */
	public static int MEMEMAIL = 10;
	public static String MEMEMAIL_LABEL = "电子邮箱";

	/* 地址 */
	public static int MEMADDRESS = 11;
	public static String MEMADDRESS_LABEL = "地址";

	/* 会员等级ID */
	public static int MEMLEVELID = 12;
	public static String MEMLEVELID_LABEL = "会员等级ID";

	/* 店铺ID */
	public static int MEMSHOPID = 13;
	public static String MEMSHOPID_LABEL = "开卡店铺ID";

	/* 办卡日期 */
	public static int MEMCREATETIME = 14;
	public static String MEMCREATETIME_LABEL = "办卡日期";
	
	
	/* 办卡日期 */
	public static int MEMREMARK = 15;
	public static String MEMREMARK_LABEL = "备注";
	
	public static int MEMCARDNUMBER = 16;
	
	public static int CUSTOMERFIELD=17;

	@Resource
	private MemDao memDao;

	public String toExcel(HSSFRow hssfRow) {
		StringBuffer sb = new StringBuffer();
		// 卡号
		sb.append(MEMCARD_LABEL + ":" + hssfRow.getCell(MEMCARD) + ",");
		// 姓名
		sb.append(MEMNAME_LABEL + ":" + hssfRow.getCell(MEMNAME) + ",");
		// 性别
		sb.append(MEMSEX_LABEL + ":" + hssfRow.getCell(MEMSEX) + ",");
		/* 身份证号码 */
		sb.append(MEMIDENTITYCARD_LABEL + ":"
				+ String.valueOf(hssfRow.getCell(MEMIDENTITYCARD)) + ",");

		// HSSFCell cell=hssfRow.getCell(MEMMOBILE);

		/* 手机号码 */
		sb.append(MEMMOBILE_LABEL + ":" + ",");

		return sb.toString();
	}

	// 会员卡号
	public String getMemcard(Sheet oFirstSheet, int row) {
		return oFirstSheet.getCell(MEMCARD, row).getContents();
	}

	public List<MemExcel> exceltoPojo(Sheet oFirstSheet,Integer userid) {
		List<MemExcel> list = new ArrayList<MemExcel>();
		int rows = oFirstSheet.getRows();
		
		for (int row = MemExcelServiceImpl.STARTCELL; row < rows; row++) {
			MemExcel mem = new MemExcel();
			StringBuffer validate = new StringBuffer();
			String memcard = getMemcard(oFirstSheet, row);
			if (memcard.length() == 0) {
				break;
			} else {
				if (memDao.validateMemCard(memcard) > 0) {
					validate.append("会员卡号己存在;");
				} 

			}
			// 卡号
			mem.setMemcard(memcard);
			// 姓名
			mem.setMemname(oFirstSheet.getCell(MEMNAME, row).getContents());
			// 性别
			String sex = oFirstSheet.getCell(MEMSEX, row).getContents();
			if (sex.equals("男")) {
				mem.setMemsex(1);
			} else if (sex.equals("女")) {
				mem.setMemsex(0);
			} else {
				if (validate.length() == 0) {
					validate.append("性别有误;");
				}

			}
			String memidentitycard = oFirstSheet.getCell(MEMIDENTITYCARD, row)
					.getContents();
			if (StringUtil.isNotBlank(memidentitycard)
					&& memidentitycard.length() != 18) {
				if (validate.length() == 0) {
					validate.append("身份证号码位数不对;");
				}
			}
			/* 身份证号码 */
			mem.setMemidentitycard(memidentitycard);
			
			
			/* 手机号码 */
			String memmobile=oFirstSheet.getCell(MEMMOBILE, row).getContents();
			if(StringUtil.isBlank(memmobile)){
				
			}else if( memmobile.length() != 11){
					
				if (validate.length() == 0) {
				validate.append("手机号码位数不对;");
				}
				
			}else{
				
				if (memDao.validateMobile(memmobile)> 0) {
					if (validate.length() == 0) {
						validate.append("手机号己存在;");
					}
					
				}
				
			}
			mem.setMemmobile(memmobile);
			
			/* 固定电话 */
			mem.setMemtelephone(oFirstSheet.getCell(MEMTELEPHONE, row)
					.getContents());
			/* 生日 */
			String membirthday = oFirstSheet.getCell(MEMBIRTHDAY, row)
					.getContents();

			mem.setMembirthday(membirthday);
			/* 积分 */
			String point = oFirstSheet.getCell(MEMPOINT, row).getContents();
			mem.setMempoint(Integer.parseInt(point));
			/* 余额 */
			String money = oFirstSheet.getCell(MEMMONEY, row).getContents();
			mem.setMemmoney(new BigDecimal(money));
			/* 历史消费金额 */
			String lsMoney = oFirstSheet.getCell(MEMCONSUMEMONEY, row)
					.getContents();
			mem.setMemconsumemoney(new BigDecimal(lsMoney));
			/* 电子邮箱 */
			mem.setMememail(oFirstSheet.getCell(MEMEMAIL, row).getContents());
			/* 地址 */
			mem.setMemaddress(oFirstSheet.getCell(MEMADDRESS, row)
					.getContents());
			/* 会员等级ID */
			String levelID = oFirstSheet.getCell(MEMLEVELID, row).getContents();
			mem.setMemlevelid(Integer.parseInt(levelID));
			/* 店铺ID */
			String shopID = oFirstSheet.getCell(MEMSHOPID, row).getContents();
			if(StringUtil.isBlank(shopID)){
				if (validate.length() == 0) {
					validate.append("店铺ID不能为空;");
				}
			}else{
				
				if(MemoryListener.isczshopid(Integer.parseInt(shopID))){
					mem.setMemshopid(Integer.parseInt(shopID));
				}else{
					if(validate.length()==0){
						validate.append("店铺ID不存在");
					}
				}
				
			}
			
			
			
			
			/* 办卡日期 */
			
			   Cell c = oFirstSheet.getCell(MEMCREATETIME, row);
			   if(c.getType()== CellType.DATE){
				   DateCell dc = (DateCell) c;
                   Date memCreateTime = dc.getDate();
                   mem.setMemcreatetime(memCreateTime);
			   }else{
				   String memCreateTimeS = oFirstSheet.getCell(MEMCREATETIME, row)
							.getContents();
					Date memCreateTime;
					try {
						memCreateTime = DateUtil.parse(memCreateTimeS);
						mem.setMemcreatetime(memCreateTime);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						if (validate.length() == 0) {
							validate.append("办卡日期格式有误");
						}
					}
					
				   
			   }
			
			/** 备注 */
			String memremark = oFirstSheet.getCell(MEMREMARK, row)
					.getContents();
			mem.setMemremark(memremark);
			/**卡面号码**/
			String memcardnumber=oFirstSheet.getCell(MEMCARDNUMBER, row).getContents();
			mem.setMemcardnumber(memcardnumber);
			
			int index=CUSTOMERFIELD;
			List<ExcelField> excelFields=new ArrayList<ExcelField>();
			for (Memcustomfield memcustomfield : MemoryListener.memcustomfields) {
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
			mem.setExcelFields(excelFields);
			
			
			if(validate.length()==0){
				validate.append("success");
			}
			
			mem.setValidate(validate.toString());
			mem.setMemuserid(userid);
			list.add(mem);
			
		}
		return list;
	}

	public String toExcel2(Sheet oFirstSheet, int row) {
		StringBuffer sb = new StringBuffer();
		// 卡号
		sb.append(MEMCARD_LABEL + ":" + getMemcard(oFirstSheet, row) + ",");
		// 姓名
		sb.append(MEMNAME_LABEL + ":"
				+ oFirstSheet.getCell(MEMNAME, row).getContents() + ",");
		// 性别
		sb.append(MEMSEX_LABEL + ":"
				+ oFirstSheet.getCell(MEMSEX, row).getContents() + ",");
		/* 身份证号码 */
		sb.append(MEMIDENTITYCARD_LABEL + ":"
				+ oFirstSheet.getCell(MEMIDENTITYCARD, row).getContents() + ",");
		/* 手机号码 */
		sb.append(MEMMOBILE_LABEL + ":"
				+ oFirstSheet.getCell(MEMMOBILE, row).getContents() + ",");
		/* 固定电话 */
		sb.append(MEMTELEPHONE_LABEL + ":"
				+ oFirstSheet.getCell(MEMTELEPHONE, row).getContents() + ",");
		/* 生日 */
		sb.append(MEMBIRTHDAY_LABEL + ":"
				+ oFirstSheet.getCell(MEMBIRTHDAY, row).getContents() + ",");
		/* 积分 */
		sb.append(MEMPOINT_LABEL + ":"
				+ oFirstSheet.getCell(MEMPOINT, row).getContents() + ",");
		/* 余额 */
		sb.append(MEMMONEY_LABEL + ":"
				+ oFirstSheet.getCell(MEMMONEY, row).getContents() + ",");
		/* 历史消费金额 */
		sb.append(MEMCONSUMEMONEY_LABEL + ":"
				+ oFirstSheet.getCell(MEMCONSUMEMONEY, row).getContents() + ",");
		/* 电子邮箱 */
		sb.append(MEMEMAIL_LABEL + ":"
				+ oFirstSheet.getCell(MEMEMAIL, row).getContents() + ",");
		/* 地址 */
		sb.append(MEMADDRESS_LABEL + ":"
				+ oFirstSheet.getCell(MEMADDRESS, row).getContents() + ",");
		/* 会员等级ID */
		sb.append(MEMLEVELID_LABEL + ":"
				+ oFirstSheet.getCell(MEMLEVELID, row).getContents() + ",");

		/* 店铺ID */
		sb.append(MEMSHOPID_LABEL + ":"
				+ oFirstSheet.getCell(MEMSHOPID, row).getContents() + ",");
		/* 办卡日期 */
		sb.append(MEMCREATETIME_LABEL + ":"
				+ oFirstSheet.getCell(MEMCREATETIME, row).getContents() + ",");

		return sb.toString();
	}
	
	public File getExcelFile(String fileName){
		String path=this.getClass().getResource("/").getPath();
		File resultFile=new File(path+"Upload/Template/"+fileName);
		return resultFile;
	}

	public void writeExcel() {
		
		
		FileOutputStream bos=null;
		try {
			bos = new FileOutputStream(getExcelFile("Members.xls"));
			WritableWorkbook wwb = Workbook.createWorkbook(bos);
			WritableSheet ws = wwb.createSheet("会员列表", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 25,
					WritableFont.BOLD);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setAlignment(Alignment.CENTRE);
			int listMemfiledlen = MemoryListener.listMemfiled.size()
					+ MemoryListener.memcustomfields.size() - 1;
			Label label1 = new Label(0, 0, "会员信息批量录入模板", wcf);
			ws.mergeCells(0, 0, listMemfiledlen, 2);
			ws.addCell(label1);
			StringBuffer sbsj = new StringBuffer(
					"相关数据字典：（★★请严格按照相关格式填写，以免导入错误★★）\n");
			sbsj.append("         列名带有\"*\"是必填列;\n")
					.append("         会员卡号：会员卡号长度为3~20位,且只能数字或者英文字母;\n")
					.append("         性别：填写“男”或者“女”;\n")
					.append("         手机号码：只能是11位数字的标准手机号码;\n")
					.append("         固定电话：最好填写为“区号+电话号码”，例：075529755361;\n")
					.append("         生日：必须填写为“年-月-日”，例：1990-12-27，如果未留请填写：1900-1-1;\n")
					.append("         “积分”和“余额”不能为空, 如果为空请填写“0”;\n")
					.append("         会员等级ID：");
			List<Memlevel> levels = MemoryListener.listMemlevels;
			for (Memlevel memlevel : levels) {
				sbsj.append(memlevel.getLevelid()).append("-")
						.append(memlevel.getLevelname()).append(" ");
			}
			sbsj.append(";\n");
			sbsj.append("         开卡店铺ID：");

			List<Sysshop> listshops = MemoryListener.listShops;
			for (Sysshop shop : listshops) {
				sbsj.append(shop.getShopid()).append("-")
						.append(shop.getShopname()).append(" ");
			}
			sbsj.append(";\n");
			sbsj.append("         办卡日期：必须填写为“年-月-日”，例：2013-1-27;");
			WritableCellFormat wcf2 = new WritableCellFormat();
			wcf2.setVerticalAlignment(VerticalAlignment.TOP);
			wcf2.setWrap(true);
			ws.setRowView(3, 3000, false); // 设置行高

			Label label2 = new Label(0, 3, sbsj.toString(), wcf2);

			ws.mergeCells(0, 3, listMemfiledlen, 3);

			ws.addCell(label2);

			for (ExcelField memExcel : MemoryListener.listMemfiled) {
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

			int index = MemoryListener.listMemfiled.size();
			for (Memcustomfield memcustomfield : MemoryListener.memcustomfields) {

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

}
