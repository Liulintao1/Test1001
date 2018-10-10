package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Goods;

public interface GoodsMapper {
	List<Map<String, Object>> queryAll();
    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}