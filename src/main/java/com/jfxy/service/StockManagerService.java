package com.jfxy.service;

import java.util.List;

import com.jfxy.pojo.Goods;
import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.GoodsExcel;
import com.jfxy.pojo.Goodsclass;
import com.jfxy.pojo.Goodslog;
import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.Timingproject;
import com.jfxy.pojo.Timingrules;
import com.jfxy.pojo.form.GoodsFormBean;
import com.jfxy.pojo.form.GoodsclassFormBean;
import com.jfxy.pojo.form.GoodslogFormBean;
import com.jfxy.pojo.form.MemstoragetimingFormBean;
import com.jfxy.pojo.form.OrderlogFormBean;
import com.jfxy.pojo.form.TimingprojectFormBean;
import com.jfxy.pojo.form.TimingrulesFormBean;
/**
 * 
 * 商品管理业务层接口
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public interface StockManagerService {
	
	public GoodsclassFormBean getPage(GoodsclassFormBean goodsclassFormBean);
	
	public TimingrulesFormBean getPage(TimingrulesFormBean timingrulesFormBean);
	
	public TimingprojectFormBean getPage(TimingprojectFormBean timingprojectFormBean);
	
	
	public void delGoodsClass(Integer goodsclassid,Integer shopid);
	
	public List<GoodsClassRebat>  getGoodsclassrebatlist();
	
	
	public void saveGoodsclass(Goodsclass goodsclass,Integer shopid);
	
	public Goodsclass findGoodsclass(Integer classid);
	
	public List<GoodsClassRebat> getGoodsclassrebatlist(Integer classid,Integer shopid);
	
	public GoodsFormBean getPage(GoodsFormBean goodsFormBean);
	
	public void saveGoods(Goods goods);
	
	public Goods findGoods(Goods goods);
	
	public void delGoods(Integer goodsid);
	
	public void updateGoods(Goods goods);
	
	public int saveGoodsIn(Goodslog goodslog);
	
	
	public GoodslogFormBean getPage(GoodslogFormBean goodslogFormBean);
	
	public List<Goods> findGoodsList(Goods goods);
	
	public void saveGoodsExpense(Orderlog orderlog);
	
	public OrderlogFormBean getPage(OrderlogFormBean orderlogFormBean);
	
	public void updateGoodsExpense(Orderlog orderlog);
	
	public void deleteGoodsExpense(Orderlog orderlog);
	
	public boolean createGoodsExcel(List<GoodsExcel>  goods,Integer createshopid);
	
	public int timingrules_add(Timingrules timingrules);
	public int timingrules_edit(Timingrules timingrules);
	
	public List<Timingrules> timingrules_get(Timingrules timingrules);
	
	
	public int timingrules_del(Integer rulesid);
	
	public List<Timingrules> list(Timingrules timingrules);
	
	public Integer timingProject_add(Timingproject timingproject);
	public Integer timingProject_edit(Timingproject timingproject);
	
	public Integer timingProject_del(Integer projectid);
	
	public List<Timingproject> timingrules_get(Timingproject timingproject);
	
	
}
