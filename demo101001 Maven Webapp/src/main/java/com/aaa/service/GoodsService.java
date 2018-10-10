package com.aaa.service;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Goods;

public interface GoodsService {
	List<Map<String, Object>> queryAll();

	int deleteByPrimaryKey(Integer goodsid);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer goodsid);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKey(Goods record);
}
