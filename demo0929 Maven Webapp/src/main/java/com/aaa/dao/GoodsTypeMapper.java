package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.GoodsType;

public interface GoodsTypeMapper {
	List<Map<String, Object>> queryType();

	int deleteByPrimaryKey(Integer typeid);

	int insert(GoodsType record);

	int insertSelective(GoodsType record);

	GoodsType selectByPrimaryKey(Integer typeid);

	int updateByPrimaryKeySelective(GoodsType record);

	int updateByPrimaryKey(GoodsType record);
}