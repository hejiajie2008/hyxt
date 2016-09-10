package com.jfxy.util;

import java.io.Serializable;
import java.util.List;

public class Pagination<T>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 一页数据默认20条
	 */
	private int pageSize = 20;
	/**
	 * 当前页码
	 */
	private int page=1;

	/**
	 * 上一页
	 */
	private int upPage;

	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 一共有多少条数据
	 */
	private long total;

	/**
	 * 一共有多少页
	 */
	private int pages;
	/**
	 * 数据集合
	 */
	private List<T> rows;

	/**
	 * 分页的url
	 */
	private String pageUrl;

	/**
	 * 获取第一条记录位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		
		
		return (this.getPage() - 1) * this.getPageSize();
	}

	/**
	 * 获取最后记录位置
	 * 
	 * @return
	 */
	public int getLastResult() {
		return this.getPage() * this.getPageSize();
	}

	/**
	 * 计算一共多少页
	 */
	public void setPages() {
		this.pages = (int) ((this.total % this.pageSize > 0) ? (this.total
				/ this.pageSize + 1) : this.total / this.pageSize);
	}

	/**
	 * 设置 上一页
	 */
	public void setUpPage() {
		this.upPage = (this.page > 1) ? this.page - 1 : this.page;
	}

	/**
	 * 设置下一页
	 */
	public void setNextPage() {
		this.nextPage = (this.page == this.pages) ? this.page
				: this.page + 1;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPages() {
		
		if(pages==0){
			this.pages = (int) ((this.total % this.pageSize > 0) ? (this.total
					/ this.pageSize + 1) : this.total / this.pageSize);
		}
		return pages;
	}

	public int getUpPage() {
		return upPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}
	
	public void setDatas(List<T> rows) {
		this.rows = rows;
	}

	public void setRows(int rows) {
		this.pageSize = rows;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Pagination(){
		
	}

	public Pagination(int page, int pageSize, long total) {
		this.setPage(page);
		this.setPageSize(pageSize);
		this.setTotal(total);
		this.init();
	}

	/**
	 * 初始化计算分页
	 */
	private void init() {
		this.setPages();// 设置一共页数
		this.setUpPage();// 设置上一页
		this.setNextPage();// 设置下一页
	}

}
