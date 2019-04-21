package org.springboot.module.model;

import java.util.List;

public class OraclePage<T> {

	private int start;
	private int size;
	private int allCount;
	private List<T> lists;

	public OraclePage() {
		super();
	}

	public OraclePage(int start, int size) {
		super();
		this.start = start;
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "OraclePage [start=" + start + ", size=" + size + ", allCount=" + allCount + ", lists=" + lists + "]";
	}

}
