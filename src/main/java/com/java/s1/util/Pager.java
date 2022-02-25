package com.java.s1.util;

public class Pager {
	
	//page당 표시할 row의 개수
	private Long perPage;
	//page 번호
	private Long page;
	//시작 번호
	private Long startRow;
	//끝 번호
	private Long lastRow;
	
	//----------검색창--------------------------
	private String search;
	private String kind;
	
	//----------JSP에서 사용할 변수들-------------
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;
	
	
	

	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		//전체 Row의 개수를 매개변수로
		//전체 Page의 개수 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//Block 당 개수
		Long perBlock=10L;
		//전체 Block의 개수 구하기
		Long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//page번호로 현재 block 번호를 찾기
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;			
		}
		
		//현재 Block 번호로 startNum, lastNum 구하기
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		//이전, 다음 블럭 유무
		this.pre=false;
		if(curBlock > 1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock > curBlock) {
			this.next=true;
		}
		
		//현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}

	}
	
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage < 0) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page==null || this.page < 1) {
			this.page=1L;
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

	public String getSearch() {
		//검색어가 넘어오지 않을 때 (search=null일 때)
		if(search==null) {
			this.search="";
		}
		
//		this.search="%"+this.search+"%";
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
