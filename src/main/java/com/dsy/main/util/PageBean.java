package com.dsy.main.util;

import java.util.List;

public class PageBean<T> {
	private List<T> list;
	private int totalCount;
	private int totalPage;
	private int pageSize;
	private int currentPage;

	public PageBean(int totalCount, int currentPage, int pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", pageSize="
				+ pageSize + ", currentPage=" + currentPage + "]";
	}

}
