package com.java.s1.util;

public class Pager {
	
	private Long perPage;
	private Long page;
	private Long startRow;
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	boolean pre;
	boolean next;
	
	
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		//총페이지수 계산
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		//한 블럭당 표시할 페이지 번호 수
		Long perBlock = 5L;
		//총 페이지가 몇 블럭인지 계산
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		//현재 페이지 번호로부터 몇 블럭인지 계산
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		//현재 블럭으로부터 startNum, lastNum 계산
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		//이전, 다음 블럭 여부 확인
		this.pre = false;
		if(curBlock > 1) {
			pre = true;
		}
		
		this.next = false;
		if(curBlock < totalBlock) {
			next = true;
		}
		//마지막 페이지 번호 조정
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	
	public Long getPerPage() {
		if(perPage == null || perPage < 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(page == null || page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
}
