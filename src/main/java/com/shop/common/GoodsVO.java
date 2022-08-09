package com.shop.common;

public class GoodsVO {
	private int gno;	//상품코드
	private String gcategory;    //카테고리
	private String gname;    	//상품명
	private int gprice; 		//가격
	private String gcolor; 		//색상
	private int amount;  		//수량
	private String gsize;		//크기
	private String gcontent;    //설명
	private String gimage;  	//이미지
	private int best;    		//인기도
	private String regdate;		//등록일
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGcategory() {
		return gcategory;
	}
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getGcolor() {
		return gcolor;
	}
	public void setGcolor(String gcolor) {
		this.gcolor = gcolor;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getGsize() {
		return gsize;
	}
	public void setGsize(String gsize) {
		this.gsize = gsize;
	}
	public String getGcontent() {
		return gcontent;
	}
	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}
	public String getGimage() {
		return gimage;
	}
	public void setGimage(String gimage) {
		this.gimage = gimage;
	}
	public int getBest() {
		return best;
	}
	public void setBest(int best) {
		this.best = best;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "GoodsVO [gno=" + gno + ", gcategory=" + gcategory + ", gname=" + gname + ", gprice=" + gprice
				+ ", gcolor=" + gcolor + ", amount=" + amount + ", gsize=" + gsize + ", gcontent=" + gcontent
				+ ", gimage=" + gimage + ", best=" + best + ", regdate=" + regdate + "]";
	}
}
