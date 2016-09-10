package com.jfxy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import scala.collection.mutable.ArrayBuilder.ofRef;

import com.jfxy.pojo.ExcelPojo;
import com.jfxy.pojo.MaxNumPojo;
import com.jfxy.pojo.Sysshop;
import com.jfxy.service.impl.MemExcelServiceImpl;
import com.jfxy.util.ChineseToEnglish;
import com.jfxy.util.ConnSqlUtils;
import com.jfxy.util.ExcelUtil;
import com.jfxy.util.MailUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class XmlTest {

	private MemExcelServiceImpl memExcelConstant;

	//@Test
	public void testMY() throws Exception {
		String sFilePath = "d:/tt.xls";
		InputStream is = new FileInputStream(sFilePath);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

		for (int numSheet = MemExcelServiceImpl.STARTROW; numSheet < hssfWorkbook
				.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

			if (hssfSheet == null) {
				continue;
			}
			for (int rowNum = MemExcelServiceImpl.STARTCELL; rowNum <= hssfSheet
					.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}

				System.out.println(memExcelConstant.toExcel(hssfRow));

			}
		}
	}

	//@Test
	public void testMY2() throws Exception {
		String sFilePath = "d:/tt.xls";
		InputStream is = new FileInputStream(sFilePath);
		Workbook rwb = Workbook.getWorkbook(is);
		int sheetSum = rwb.getNumberOfSheets();

		for (int sheetNum = 0; sheetNum < sheetSum; sheetNum++) {
			Sheet oFirstSheet = rwb.getSheet(sheetNum);
			int rows = oFirstSheet.getRows();
			for (int row = MemExcelServiceImpl.STARTCELL; row < rows; row++) {
				if (!memExcelConstant.getMemcard(oFirstSheet, row).equals("")) {
					System.out.println(memExcelConstant.toExcel2(oFirstSheet,
							row));
				}

			}

		}
	}

	//@Test
	public void testMY3() throws Exception {
		WritableWorkbook book = null;
		try {
			// 打开文件
			book = Workbook.createWorkbook(new File("D:/tt/test.xls"));
			// 生成名为"学生"的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("学生", 0);
			// 指定单元格位置是第一列第一行(0, 0)以及单元格内容为张三
			Label label = new Label(0, 0, "张三");
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			// 保存数字的单元格必须使用Number的完整包路径
			jxl.write.Number number = new jxl.write.Number(1, 0, 30);
			sheet.addCell(number);
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

	public static PreparedStatement preparedStatement = null;

	public static ResultSet getResultSet(Connection conn, String sql) {

		ResultSet rs = null;
		try {
			preparedStatement = conn.prepareStatement(sql);

			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	//@Test
	public void testConn() {
		String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// String sDBUrl ="jdbc:sqlserver://192.168.0.74;databaseName=wakeup";
		String url = "jdbc:sqlserver://jfxy03;databaseName=bfyy_vip5968";
		String username = "sa";
		String password = "admin2015";
		// 查询店铺表
		String findShopSql = "select ShopID,ShopName,rtrim(ltrim(shopremark)) from sysshop order by ShopID asc";

		String findGoodsSql = "select goodsId,name from goods";
		// 每月新增会员数
		String findNewMem = "select MemShopID,count(*) from mem   where   MemCreateTime between ? and ? group by MemShopID";

		// 每月站点消费总单数
		String zdxfNum = "select ordershopid,count(orderID) from orderlog where ordercreatetime between ? and ? group by ordershopid";

		/* 站点对应会员总数 */
		String totalMemNum = "select MemShopID,count(*) from mem group by MemShopID";

		String cfxyMemNum = "select ss.ordershopid ,count(ss.orderMemID) from ( select orderMemID,ordershopid from orderlog m where m.ordercreatetime between ? and ? group by orderMemID,ordershopid having count(orderID)>1 ) as ss group by ss.ordershopid";

		String xsgjGoods = "select ordershopID,goodsid,count(*) num from orderdetail left join orderlog on orderlog.orderID=orderdetail.orderID  where orderlog.ordercreatetime between ? and ? group by goodsid,orderlog.ordershopID order by num";

		url = "jdbc:sqlserver://10.10.0.22;databaseName=zhimakaihua_vip5968";
		String startTime = "2015-12-01";
		String endTime = "2015-12-31";
		password = "jfcredit22*";

		List<String> areaList = new ArrayList<String>();
		try {
			Class.forName(sDriverName);

			Connection conn = DriverManager.getConnection(url, username,
					password);

			/* 查询所有店铺 */
			ResultSet rs = getResultSet(conn, findShopSql);

			List<Sysshop> list = new ArrayList<Sysshop>();

			while (rs.next()) {
				Sysshop sysshop = new Sysshop();
				sysshop.setShopid(rs.getInt(1));
				sysshop.setShopname(rs.getString(2));
				sysshop.setShopremark(rs.getString(3));
				list.add(sysshop);
			}
			preparedStatement.close();

			for (Sysshop shop : list) {
				if (!areaList.contains(shop.getShopremark())) {
					areaList.add(shop.getShopremark());
				}

			}
			System.out.println(areaList);
			/* 每月新增会员数 */
			Map<Integer, String> goodsMap = new HashMap<Integer, String>();
			PreparedStatement goodsPre = conn.prepareStatement(findGoodsSql);

			ResultSet goodsRes = goodsPre.executeQuery();

			while (goodsRes.next()) {
				goodsMap.put(goodsRes.getInt(1), goodsRes.getString(2));
			}

			goodsRes.close();

			/* 每月新增会员数 */
			Map<Integer, Integer> addMembyMonth = new HashMap<Integer, Integer>();
			PreparedStatement p2 = conn.prepareStatement(findNewMem);

			p2.setString(1, startTime);
			p2.setString(2, endTime);
			ResultSet rs2 = p2.executeQuery();

			while (rs2.next()) {
				addMembyMonth.put(rs2.getInt(1), rs2.getInt(2));
			}

			p2.close();

			/* 每月站点消费总单数 */
			Map<Integer, Integer> zdxfNumMap = new HashMap<Integer, Integer>();

			PreparedStatement zdxfNumpr = conn.prepareStatement(zdxfNum);
			zdxfNumpr.setString(1, startTime);
			zdxfNumpr.setString(2, endTime);

			ResultSet zdxfrs = zdxfNumpr.executeQuery();
			while (zdxfrs.next()) {
				zdxfNumMap.put(zdxfrs.getInt(1), zdxfrs.getInt(2));
			}

			zdxfNumpr.close();

			Map<Integer, Integer> rechargeMemNum = new HashMap<Integer, Integer>();
			PreparedStatement p3 = conn.prepareStatement(cfxyMemNum);
			p3.setString(1, startTime);
			p3.setString(2, endTime);

			ResultSet rs3 = p3.executeQuery();

			while (rs3.next()) {
				rechargeMemNum.put(rs3.getInt(1), rs3.getInt(2));
			}

			p3.close();

			Map<Integer, Integer> totalMemMap = new HashMap<Integer, Integer>();
			PreparedStatement p4 = conn.prepareStatement(totalMemNum);

			ResultSet rs4 = p4.executeQuery();

			while (rs4.next()) {
				totalMemMap.put(rs4.getInt(1), rs4.getInt(2));
			}

			p4.close();

			PreparedStatement p6 = conn.prepareStatement(xsgjGoods);

			p6.setString(1, startTime);
			p6.setString(2, endTime);
			ResultSet rs6 = p6.executeQuery();

			List<MaxNumPojo> maxNumPojostlist = new ArrayList<MaxNumPojo>();
			while (rs6.next()) {
				MaxNumPojo max = new MaxNumPojo();
				max.setShopid(rs6.getInt(1));
				max.setGoodsid(rs6.getInt(2));
				max.setNum(rs6.getInt(3));
				maxNumPojostlist.add(max);
			}

			p6.close();

			Map<Integer, String> xsgjGoodsMap = MaxNumPojo.getGoods(
					maxNumPojostlist, goodsMap);
			Map<Integer, Integer> xsgjGoodsNumMap = MaxNumPojo
					.getGoodsMaxNum(maxNumPojostlist);

			List<ExcelPojo> listExcel = new ArrayList<ExcelPojo>();
			for (String area : areaList) {
				for (Sysshop shop : list) {
					if (area.equals(shop.getShopremark())) {
						ExcelPojo excelPojo = new ExcelPojo();
						int shopId = shop.getShopid();
						excelPojo.setShopId(shopId);
						excelPojo.setArea(shop.getShopremark());
						excelPojo.setShopName(shop.getShopname());
						excelPojo.setAddMembyMonth(0);
						if (addMembyMonth.containsKey(shopId)) {
							excelPojo.setAddMembyMonth(addMembyMonth
									.get(shopId));
						}
						excelPojo.setRechargeMemNum(0);
						if (rechargeMemNum.containsKey(shopId)) {
							excelPojo.setRechargeMemNum(rechargeMemNum
									.get(shopId));
						}
						excelPojo.setTotalMemNum(0);
						if (totalMemMap.containsKey(shopId)) {
							excelPojo.setTotalMemNum(totalMemMap.get(shopId));
						}
						excelPojo.setZdxfNum(0);
						if (zdxfNumMap.containsKey(shopId)) {
							excelPojo.setZdxfNum(zdxfNumMap.get(shopId));
						}
						excelPojo.setMaxGoods("");
						if (xsgjGoodsMap.containsKey(shopId)) {
							excelPojo.setMaxGoods(xsgjGoodsMap.get(shopId));
						}
						excelPojo.setMaxGoodsNum(0);
						if (xsgjGoodsNumMap.containsKey(shopId)) {
							excelPojo.setMaxGoodsNum(xsgjGoodsNumMap
									.get(shopId));
						}

						listExcel.add(excelPojo);
					}

				}
			}

			ExcelUtil.toExcel(listExcel);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//@Test
	public void test2Conn() {
		String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// String sDBUrl ="jdbc:sqlserver://192.168.0.74;databaseName=wakeup";
		String url = "jdbc:sqlserver://10.10.0.22;databaseName=zhimakaihua_vip5968";
		String username = "sa";
		String password = "jfcredit22*";
		// 查询店铺表
		String finduser = "select t1.shopremark,t1.shopid,t1.shopname,t2.username,t2.useraccount from sysshop t1 left join sysuser t2 on t1.shopid=t2.usershopid";

		WritableWorkbook book = null;

		try {
			Class.forName(sDriverName);
			Connection conn = DriverManager.getConnection(url, username,
					password);

			/* 查询所有店铺 */
			ResultSet rs = getResultSet(conn, finduser);

			// 打开文件
			book = Workbook.createWorkbook(new File("D:/tt/shopuser.xls"));
			// 生成名为"学生"的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("test", 0);

			List<String> list = new ArrayList<String>();
			list.add("大区");
			list.add("店铺ID");
			list.add("店铺名");
			list.add("用户名");
			list.add("账号");

			for (int p = 0; p < list.size(); p++) {
				Label labeltitle = new Label(p, 0, list.get(p));

				sheet.addCell(labeltitle);
			}

			int i = 0;

			while (rs.next()) {
				int p = 0;
				String area = (rs.getString(++p).replaceAll("\n|\r", ""));
				String shopid = rs.getString(++p);
				String shopname = rs.getString(++p).replace("\n|\r", "");
				String usname = rs.getString(++p);
				String useraccount = rs.getString(++p);

				int j = 0;
				i++;
				/* 大区 */
				ExcelUtil.addCell(sheet, j++, i, area);
				ExcelUtil.addCell(sheet, j++, i, shopid);
				ExcelUtil.addCell(sheet, j++, i, shopname);
				ExcelUtil.addCell(sheet, j++, i, usname);
				ExcelUtil.addCell(sheet, j++, i, useraccount);
			}
			// 写入数据并关闭文件
			book.write();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	//@Test
	public void test3conn() {

		String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// String sDBUrl ="jdbc:sqlserver://192.168.0.74;databaseName=wakeup";
		String url = "jdbc:sqlserver://10.10.0.22;databaseName=zhimakaihua_vip5968";
		String username = "sa";
		String password = "jfcredit22*";
		// 查询店铺表
		String sysshop = "select shopid,shopName,shopcontactMan,shoptelephone,shopaddress,shopremark from sysshop";

		WritableWorkbook book = null;

		try {
			Class.forName(sDriverName);
			Connection conn = DriverManager.getConnection(url, username,
					password);

			/* 查询所有店铺 */
			ResultSet rs = getResultSet(conn, sysshop);

			// 打开文件
			book = Workbook.createWorkbook(new File("D:/tt/shop.xls"));
			// 生成名为"学生"的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("test", 0);

			List<String> list = new ArrayList<String>();

			list.add("店铺ID");
			list.add("店铺名");
			list.add("负责人");
			list.add("负责人电话");
			list.add("店铺地址");
			list.add("备注");

			for (int p = 0; p < list.size(); p++) {
				Label labeltitle = new Label(p, 0, list.get(p));

				sheet.addCell(labeltitle);
			}

			int i = 0;

			while (rs.next()) {
				int p = 0;

				String shopid = rs.getString(++p);
				String shopname = rs.getString(++p).replace("\n|\r", "");
				String shopcontactMan = rs.getString(++p);
				String shoptelephone = rs.getString(++p);
				String shopaddress = rs.getString(++p);
				String shopremark = rs.getString(++p);

				int j = 0;
				i++;
				/* 大区 */
				ExcelUtil.addCell(sheet, j++, i, shopid);
				ExcelUtil.addCell(sheet, j++, i, shopname);
				ExcelUtil.addCell(sheet, j++, i, shopcontactMan);
				ExcelUtil.addCell(sheet, j++, i, shoptelephone);
				ExcelUtil.addCell(sheet, j++, i, shopaddress);

				ExcelUtil.addCell(sheet, j++, i, shopremark);
			}
			// 写入数据并关闭文件
			book.write();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	//@Test
	public void testY4() {
		String sFilePath = "d:/tt/users.xls";
		StringBuffer sqlsb = new StringBuffer();
		File file = new File(this.getClass().getResource("").getPath());

		String path = file.getParentFile().getParentFile().getParentFile()
				.getParentFile().getParentFile().getPath();
		File ff = new File(path
				+ "/src/main/resources/config/template/email.ftl");
		
		Connection conn=ConnSqlUtils.getConn(path+"/src/main/resources/config/properties/db.properties");

		System.out.println(conn);
		File sqlFile = new File(path
				+ "/src/main/resources/config/template/sql.ftl");
		String mb = "";
		try {
			mb = FileUtils.readFileToString(ff, Charset.defaultCharset());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "";
		try {
			sql = FileUtils.readFileToString(sqlFile, Charset.defaultCharset());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream is;
		try {
			is = new FileInputStream(sFilePath);
			Workbook rwb = Workbook.getWorkbook(is);
			int sheetSum = rwb.getNumberOfSheets();

			for (int sheetNum = 0; sheetNum < sheetSum; sheetNum++) {
				Sheet oFirstSheet = rwb.getSheet(sheetNum);
				int rows = oFirstSheet.getRows();
				for (int row = 0; row < rows; row++) {
					String areaName = oFirstSheet.getCell(0, row).getContents();

					String shopName = oFirstSheet.getCell(2, row).getContents();

					String addressName = oFirstSheet.getCell(4, row)
							.getContents();
					String lxman = oFirstSheet.getCell(5, row).getContents();
					String phone = oFirstSheet.getCell(6, row).getContents();
					String email = oFirstSheet.getCell(7, row).getContents();
					System.out.println(email);
					/**
					 * System.out.println("区域名称："+areaName+",店铺名："+shopName+
					 * ",地址："+addressName+ ",联系人："+lxman+",电话："+phone+
					 * ",email:"+email);
					 **/

					// System.out.println(this.getClass()+":"+path);
					String user = "";

					String[] keys = new String[] { "芝麻开花店", "芝麻开花", "广场店",
							"豪庭店", "店" };
					for (String key : keys) {
						if (shopName.contains(key)) {
							user = shopName.replace(key, "");
							break;
						}
					}
					String sqlcontent = sql;
					Map<String, String> rootsql = new HashMap<String, String>();
					rootsql.put("useraccount",
							ChineseToEnglish.getPingYin(lxman));
					rootsql.put("username", lxman);
					rootsql.put("userpassword", phone);
					rootsql.put("usertelephone", phone);
					rootsql.put("userremark", areaName);

					rootsql.put("usergroupid", "61");
					rootsql.put("ptuseraccount",
							ChineseToEnglish.getPingYin(user));
					rootsql.put("ptusername", user);
					rootsql.put("ptuserpassword", "123456");
					rootsql.put("ptusergroupid", "63");
					rootsql.put("shopname", shopName);
					rootsql.put("shoptelephone", phone);
					rootsql.put("shopcontactman", lxman);
					rootsql.put("shopaddress", addressName);

					for (Map.Entry<String, String> r : rootsql.entrySet()) {
						sqlcontent = sqlcontent.replaceAll("\\{" + r.getKey()
								+ "\\}", r.getValue());
					}
					System.out.println(sqlcontent);
					// sqlsb.append(sqlcontent);

					String content = mb;

					Map<String, String> root = new HashMap<String, String>();
					root.put("shopname", shopName);
					root.put("shopurl", "http://zhimakaihua.qhjfxy.com");
					root.put("adminuser", ChineseToEnglish.getPingYin(lxman));
					root.put("adminpwd", phone);
					root.put("pwd", "123456");
					root.put("user", ChineseToEnglish.getPingYin(user));
					// 获取输出流（指定到控制台（标准输出））

					for (Map.Entry<String, String> r : root.entrySet()) {
						content = content.replace("${" + r.getKey() + "}",
								r.getValue());
					}

					 MailUtils.sendMessage(email, "会员一卡通系统账号", content);
					 System.out.println("己成功！");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sqlsb.toString());

	}
	
	public static void main(String[] args) {
		
		String usp="邵志文";
		
		String wlyz=ChineseToEnglish.getPingYin(usp);
		System.out.println(wlyz);
		
		
		/**
		String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://zhimakaihua.qhjfxy.com:51433;databaseName=zhimakaihua_vip5968";
		
		String password = "jfcredit22*";
		String username="sa";

		List<String> areaList = new ArrayList<String>();
		
			try {
				Class.forName(sDriverName);
				Connection conn = DriverManager.getConnection(url, username,
						password);

				
				ResultSet rs = getResultSet(conn, "select *from goods");
				
				System.out.println(rs.next());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		**/
	}

}
