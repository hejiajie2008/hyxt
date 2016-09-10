package com.jfxy.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
















import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.GoodsExcel;
import com.jfxy.pojo.Goodsnumber;
import com.jfxy.pojo.GoodsnumberExcel;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcustomfield;
import com.jfxy.service.MemService;
import com.jfxy.service.StockManagerService;
import com.jfxy.service.impl.GoodsExcelServiceImpl;
import com.jfxy.service.impl.MemExcelServiceImpl;
import com.jfxy.util.DateUtil;
import com.jfxy.util.FileUtil;


/**
 * 
 * 工具模块
 * 用于一些文件上传、验证码之类的。
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
@Controller
@RequestMapping(value = "/util")
public class UtilAction extends BaseAction{

	@Autowired
	private MemService memService;
	
	@Autowired
	private StockManagerService stockManagerService;
	@Autowired
	private MemExcelServiceImpl memExcelServiceImpl;
	@Autowired
	private GoodsExcelServiceImpl goodsExcelServiceImpl;
	/**
	 * 获取报表走势图数据
	 * @param request
	 * @return
	 * @throws Exception [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "getline", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getline(HttpServletRequest request)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("title", "会员走势图");
		map.put("subtitle", "");
		List<String> list = new ArrayList<String>();
		List<Integer> listdate = new ArrayList<Integer>();
		for (int i = 1; i <= 30; i++) {
			list.add(i + "");
			listdate.add(i);
		}

		map.put("xAxis", list);
		// map.put("yAxis", "流量 (点击次数)");
		map.put("valueSuffix", "点击次数");

		map.put("data", listdate);

		return map;
	}

	private int width = 90;// 定义图片的width
	private int height = 20;// 定义图片的height
	private int codeCount = 4;// 定义图片上显示验证码的个
	private int xx = 15;
	private int fontHeight = 18;
	private int codeY = 16;
	char[] codeSequence = {
			// 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			// 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			// 'X', 'Y', 'Z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 生成验证码
	 * @param req
	 * @param resp
	 * @throws IOException [参数说明]
	 * 
	 * @return void [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping("/code")
	public void getCode(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// Graphics2D gd = buffImg.createGraphics();
		// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// 创建随机数
		Random random = new Random();
		// 将图像填充为白色
		gd.setColor(Color.GRAY);

		gd.setColor(new Color(15, 71, 36));
		gd.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
		// 设置字体
		gd.setFont(font);

		// 画边框
		gd.setColor(new Color(15, 71, 36));
		gd.drawRect(0, 0, width - 1, height - 1);

		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到
		gd.setColor(Color.BLACK);
		for (int i = 0; i < 40; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// 随机产生codeCount数字的验证码
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字
			String code = String.valueOf(codeSequence[random
					.nextInt(codeSequence.length)]);
			// 产生随机的颜色分量来构颜色值，这样输出的每位数字的颜色值都将不同
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中
			gd.setColor(new Color(red, green, blue));
			gd.drawString(code, (i + 1) * xx, codeY);

			// 将产生的四个随机数组合在��
			randomCode.append(code);
		}
		// 将四位数字的验证码保存到Session中
		HttpSession session = req.getSession();
		// System.out.print(randomCode);
		session.setAttribute("code", randomCode.toString());

		// 禁止图像缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

	/**
	 * 下载Excel方法
	 * @param request
	 * @param response
	 * @throws Exception [参数说明]
	 * 
	 * @return void [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(value = "/doloadExcl", method = RequestMethod.GET)
	@ResponseBody
	public void download(HttpServletRequest request,
			HttpServletResponse response,String type) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		
		String fileName = type+".xls";
		/**
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "Upload\\Template\\";
		String downLoadPath = ctxPath + fileName;
		**/
		File downloadFile=memExcelServiceImpl.getExcelFile(fileName);
		try {
			long fileLength = downloadFile.length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downloadFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}

	}
	/**
	 * 上传商品信息Excel方法
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadExcel")
	@ResponseBody
	public synchronized Map<String, Object>  uploadExcel(HttpServletRequest request,Integer type,
			@RequestParam(value = "fileData", required = false) MultipartFile fileData) {
		
		
		Map<String, Object> map=null;
		
		
		switch (type) {
		case 0:
			map=uploadMemExcel(request,fileData);
			break;
		case 1:
			map=uploadgoodsExcel(request,fileData);
			break;
		case 2:
			map=uploadgoodsnumberExcel(request,fileData);
			break;

		default:
			break;
		}
		
		
		

		return map;
	}
	
	/**会员模块 start**/
	/**
	 * 验证会员信息
	 * @param request
	 * @param fileData
	 * @return
	 */
	public  Map<String, Object>  uploadMemExcel(HttpServletRequest request,MultipartFile fileData){
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream is=null;
		try {
			String ctxPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "\\" ;
			
			String fileName=DateUtil.getHHmmssws()+fileData.getOriginalFilename();
			
			String returnPath="Upload\\Members\\"+DateUtil.getyyyyMMdd()+"/"+fileName;
			map.put("filepath", fileName);
			
			File rootPath=new File(ctxPath+returnPath);
			FileUtils.copyInputStreamToFile(fileData.getInputStream(),rootPath);
			is = fileData.getInputStream();
			Workbook rwb = Workbook.getWorkbook(is);
			int sheetSum = rwb.getNumberOfSheets();
			int sheetNum = 0;
			List<Memcustomfield> customfields=null;
			customfields= MemoryListener.memcustomfields;
		

			map.put("customfields", customfields);
			while(sheetNum < sheetSum){
				Sheet oFirstSheet = rwb.getSheet(sheetNum++);
				
				List<MemExcel> list=memExcelServiceImpl.exceltoPojo(oFirstSheet,this.getUserId());
					map.put("rows", list);
				
				
				break;

			}
			
			
			map.put("success", 1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 导入会员信息
	 * 导入Excel方法
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/importExcel")
	@ResponseBody
	public  Map<String, Object>  importExcel(HttpServletRequest request,String strPath) {
		
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String returnPath="Upload\\Members\\"+DateUtil.getyyyyMMdd()+"/"+strPath;
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream is = null;
		try {
			is = new FileInputStream(new File(ctxPath+returnPath));
			Workbook rwb = Workbook.getWorkbook(is);
			importUpload(rwb,0);
			
			map.put("success", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	/**会员模块 end**/
	
	
	/**商品模块 start**/
	/**
	 * 上传商品模块
	 * @param fileData
	 * @return
	 */
	public  Map<String, Object>  uploadgoodsExcel(HttpServletRequest request,MultipartFile fileData){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String fileName=DateUtil.getHHmmssws()+fileData.getOriginalFilename();
		
		String returnPath="Upload\\Goods\\"+DateUtil.getyyyyMMdd()+"/"+fileName;
		map.put("filepath", fileName);
		
		InputStream is=null;
		try {
			is = fileData.getInputStream();
			File rootPath=new File(ctxPath+returnPath);
			FileUtils.copyInputStreamToFile(fileData.getInputStream(),rootPath);
			
			Workbook rwb = Workbook.getWorkbook(is);
			int sheetSum = rwb.getNumberOfSheets();
			int sheetNum = 0;
			List<Memcustomfield> customfields=null;
			
				customfields= MemoryListener.goodscustomfields;
			

			map.put("customfields", customfields);
			while(sheetNum < sheetSum){
				Sheet oFirstSheet = rwb.getSheet(sheetNum++);
				
					List<GoodsExcel> list=goodsExcelServiceImpl.exceltoPojo(oFirstSheet,this.getUserShopId());
					map.put("rows", list);
				
				
				break;

			}
			
			map.put("success", 1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 导入Excel方法
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/importgoodsExcel")
	@ResponseBody
	public synchronized Map<String, Object>  importgoodsExcel(HttpServletRequest request,String strPath
			) {
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String returnPath="Upload\\Goods\\"+DateUtil.getyyyyMMdd()+"/"+strPath;
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream is = null;
		try {
			is = new FileInputStream(new File(ctxPath+returnPath));
			Workbook rwb = Workbook.getWorkbook(is);
			importUpload(rwb,1);
			
			map.put("success", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	/**商品模块 end**/
	
	
	
	
	
	/**
	 * 商品库存导入验证Excel
	 * @param request
	 * @param strPath
	 * @return
	 */
	public  Map<String, Object>  uploadgoodsnumberExcel(HttpServletRequest request,MultipartFile fileData){
		Map<String, Object> map = new HashMap<String, Object>();
		
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String fileName=DateUtil.getHHmmssws()+fileData.getOriginalFilename();
		
		String returnPath="Upload\\GoodsNumber\\"+DateUtil.getyyyyMMdd()+"/"+fileName;
		map.put("filepath", fileName);
		
		InputStream is=null;
		try {
			
			File rootPath=new File(ctxPath+returnPath);
			FileUtils.copyInputStreamToFile(fileData.getInputStream(),rootPath);
			is=fileData.getInputStream();
			Workbook rwb = Workbook.getWorkbook(is);
			int sheetSum = rwb.getNumberOfSheets();
			int sheetNum = 0;
			while(sheetNum < sheetSum){
				Sheet oFirstSheet = rwb.getSheet(sheetNum++);
				
					List<GoodsnumberExcel> list=goodsExcelServiceImpl.exceltoGoodsnumberPojo(oFirstSheet);
					map.put("rows", list);
				
				
				break;

			}
			
			map.put("success", 1);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	

	
	
	
	/**
	 * 导入Excel方法
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/importgoodsnumberExcel")
	@ResponseBody
	public synchronized Map<String, Object>  importgoodsnumberExcel(HttpServletRequest request,String strPath
						) {
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String returnPath="Upload\\GoodsNumber\\"+DateUtil.getyyyyMMdd()+"/"+strPath;
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream is = null;
		try {
			is = new FileInputStream(new File(ctxPath+returnPath));
			Workbook rwb = Workbook.getWorkbook(is);
			importUpload(rwb,2);
			
			map.put("success", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	/**
	 * 上传入库方法
	 * @param rwb [参数说明]
	 * 
	 * @return void [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public void importUpload(Workbook rwb,Integer type){
		int sheetSum = rwb.getNumberOfSheets();

		for (int sheetNum = 0; sheetNum < sheetSum; sheetNum++) {
			Sheet oFirstSheet = rwb.getSheet(sheetNum);
			if(type==0){
				List<MemExcel> mems=memExcelServiceImpl.exceltoPojo(oFirstSheet,this.getUserId());
				memService.createMemExcel(mems);
				
			}else if(type==1){
				List<GoodsExcel> goods=goodsExcelServiceImpl.exceltoPojo(oFirstSheet,this.getUserShopId());
				stockManagerService.createGoodsExcel(goods,this.getUserShopId());
			}else if(type==2){
				List<GoodsnumberExcel> goodsnumber=goodsExcelServiceImpl.exceltoGoodsnumberPojo(oFirstSheet);
				
			}
			

		}
	}
	
	
	/**
	 * 上传图片
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadify")
	@ResponseBody
	public Map<String, Object> uploadify(HttpServletRequest request,
			@RequestParam(value = "fileData", required = false) MultipartFile fileData) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" + "Upload\\Template\\";
		File uploadFile = new File(ctxPath + fileData.getOriginalFilename());  
		
		try {
			FileCopyUtils.copy(fileData.getBytes(),uploadFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", 1);
		map.put("newfile", "Upload/Template/"+fileData.getOriginalFilename());


		
		
		
		return map;
		
	}
	
	/**
	 * 上传图片
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadImg")
	@ResponseBody
	public Map<String, Object> upload_img(HttpServletRequest request,
			@RequestParam(value = "fileData", required = false) MultipartFile fileData,String WebImage) {
		Map<String, Object> map = new HashMap<String, Object>();
		String filename=WebImage+".png";
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String returnPath="Upload\\WebImage\\";
		File uploadFile = new File(ctxPath+returnPath + filename); 
		
		
		try {
			FileCopyUtils.copy(fileData.getBytes(),uploadFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", 1);
		map.put("newfile", returnPath+filename);


		
		
		
		return map;
		
	}
	/**
	 * 上传图片
	 * @param fileData
	 * @return [参数说明]
	 * 
	 * @return Map<String,Object> [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/uploadPhoto")
	@ResponseBody
	public Map<String, Object> upload_photo(HttpServletRequest request,
			@RequestParam(value = "fileData", required = false) MultipartFile fileData) {
		Map<String, Object> map = new HashMap<String, Object>();
		String imageType=FileUtil.getExtend(fileData.getOriginalFilename());
		String filename=DateUtil.dateRandom()+imageType;
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "\\" ;
		
		String returnPath="Upload\\MemPhoto\\"+DateUtil.getyyyyMM()+"/";
		
		File rootPath=new File(ctxPath+returnPath);
		if(!rootPath.exists()){
			rootPath.mkdirs();
		}
		File uploadFile = new File(ctxPath+returnPath + filename);  
		
		try {
			FileCopyUtils.copy(fileData.getBytes(),uploadFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", 1);
		map.put("newfile", returnPath+filename);


		
		
		
		return map;
		
	} 
	
	
	

}
