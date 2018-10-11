package com.aaa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Goods {
	private Integer goodsid;

	private String goodsname;

	private Integer typeid;

	private String goodsdesc;

	private Double goodsunitprice;

	private String goodsimagename;

	private Integer sellcount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private String goodsdate;
	
	private GoodsType goodsType;

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname == null ? null : goodsname.trim();
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getGoodsdesc() {
		return goodsdesc;
	}

	public void setGoodsdesc(String goodsdesc) {
		this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
	}

	public Double getGoodsunitprice() {
		return goodsunitprice;
	}

	public void setGoodsunitprice(Double goodsunitprice) {
		this.goodsunitprice = goodsunitprice;
	}

	public String getGoodsimagename() {
		return goodsimagename;
	}

	public void setGoodsimagename(String goodsimagename) {
		this.goodsimagename = goodsimagename == null ? null : goodsimagename.trim();
	}

	public Integer getSellcount() {
		return sellcount;
	}

	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}

	public String getGoodsdate() {
		return goodsdate;
	}

	public void setGoodsdate(String goodsdate) {
		this.goodsdate = goodsdate;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", goodsname=" + goodsname + ", typeid=" + typeid + ", goodsdesc="
				+ goodsdesc + ", goodsunitprice=" + goodsunitprice + ", goodsimagename=" + goodsimagename
				+ ", sellcount=" + sellcount + ", goodsdate=" + goodsdate + ", goodsType=" + goodsType + "]";
	}

	public Goods(Integer goodsid, String goodsname, Integer typeid, String goodsdesc, Double goodsunitprice,
			String goodsimagename, Integer sellcount, String goodsdate, GoodsType goodsType) {
		super();
		this.goodsid = goodsid;
		this.goodsname = goodsname;
		this.typeid = typeid;
		this.goodsdesc = goodsdesc;
		this.goodsunitprice = goodsunitprice;
		this.goodsimagename = goodsimagename;
		this.sellcount = sellcount;
		this.goodsdate = goodsdate;
		this.goodsType = goodsType;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

}