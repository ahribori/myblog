package com.aribori.common.lib;

import java.util.List;

public class ListContainer {
	
	private List<?> list;
	private Page page;
	
	public ListContainer(List<?> list, Page page) {
		super();
		this.list = list;
		this.page = page;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "ObjectList [list=" + list + ", page=" + page + "]";
	}
}
