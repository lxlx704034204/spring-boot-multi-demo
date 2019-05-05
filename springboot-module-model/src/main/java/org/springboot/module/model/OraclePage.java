package org.springboot.module.model;

import java.util.List;

import lombok.Data;

@Data
public class OraclePage<T> {

	private int curPage;
	private int pageSize;
	private int allCount;
	private List<T> lists;

	public OraclePage() {
		super();
	}

	public OraclePage(int curPage, int pageSize) {
		super();
		this.curPage = curPage;
		this.pageSize = pageSize;
	}
	
}
