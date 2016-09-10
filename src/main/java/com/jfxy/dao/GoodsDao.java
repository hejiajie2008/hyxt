package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Batch;
import com.jfxy.pojo.Goods;
import com.jfxy.pojo.form.GoodsFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface GoodsDao  {
	/**
     * 添加数据<br />
     * @param goods 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Goods goods);
	
	
	
	/**
     * 修改数据<br />
     * @param goods 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Goods goods);
	
	
	
	
	
	/**
	 * 删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author hejiajie
	 */
	public int deleteById(int value);
	
	/**
	 * 批量删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author hejiajie
	 */
	public int deleteByIds(Map<String,Object> map);
	
	
	
	
	
	
	/**
     * 按条件统计记录数 <br />
     * @param goods 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(GoodsFormBean goodsFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param goods 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Goods> pageList(GoodsFormBean goodsFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param goods 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Goods> list(Goods goods);
	
	/**
	 * 批量添加商品
	 * <功能详细描述>
	 * @param batchGoods [参数说明]
	 * 
	 * @return void [返回类型说明]
	 * @exception throws [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public void batchCreateGoods(Batch batchGoods);
	
	
	/**
	 * 验证goods的唯一性
	 * @param goodscode
	 * @return
	 */
	public int validateGoodsCode(Map<String, Object> map);
	
    

}
