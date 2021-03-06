package com.jfxy.pojo.form;

import java.util.List;
import com.jfxy.pojo.RptMem;
import com.jfxy.util.Pagination;



public class RptMemFormBean extends Pagination<RptMem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 登陆用户名
	 */
	private String memcard;
	
	/**
	 * 登陆用户名
	 */
	private String memcardl;
	
	private Integer memlevelid;
	
	private Integer isShow=0;
	
	private Integer memshopid;
	
	private List<Integer> memshopids;
	
	
	 /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mem.MemProvince
     *
     * @mbggenerated Mon Nov 30 16:11:47 CST 2015
     */
    private String memprovince;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mem.MemCity
     *
     * @mbggenerated Mon Nov 30 16:11:47 CST 2015
     */
    private String memcity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mem.MemCounty
     *
     * @mbggenerated Mon Nov 30 16:11:47 CST 2015
     */
    private String memcounty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mem.MemVillage
     *
     * @mbggenerated Mon Nov 30 16:11:47 CST 2015
     */
    private String memvillage;
	
	
	public String getMemcard() {
		
		
		return memcard;
	}
	public void setMemcard(String memcard) {
		this.memcard = memcard;
	}
	public Integer getMemlevelid() {
		return memlevelid;
	}
	public void setMemlevelid(Integer memlevelid) {
		this.memlevelid = memlevelid;
	}
	public Integer getMemshopid() {
		return memshopid;
	}
	public void setMemshopid(Integer memshopid) {
		this.memshopid = memshopid;
	}
	public List<Integer> getMemshopids() {
		return memshopids;
	}
	public void setMemshopids(List<Integer> memshopids) {
		this.memshopids = memshopids;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getMemcardl() {
		return memcardl;
	}
	public void setMemcardl(String memcardl) {
		this.memcardl = memcardl;
	}
	public String getMemprovince() {
		return memprovince;
	}
	public void setMemprovince(String memprovince) {
		this.memprovince = memprovince;
	}
	public String getMemcity() {
		return memcity;
	}
	public void setMemcity(String memcity) {
		this.memcity = memcity;
	}
	public String getMemcounty() {
		return memcounty;
	}
	public void setMemcounty(String memcounty) {
		this.memcounty = memcounty;
	}
	public String getMemvillage() {
		return memvillage;
	}
	public void setMemvillage(String memvillage) {
		this.memvillage = memvillage;
	}
	
	
	
}
