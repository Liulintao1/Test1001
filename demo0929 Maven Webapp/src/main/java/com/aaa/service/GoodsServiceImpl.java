package com.aaa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.GoodsMapper;
import com.aaa.entity.Goods;
@Service
public class GoodsServiceImpl implements GoodsService {
@Autowired
private GoodsMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer goodsid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(goodsid);
	}

	@Override
	public int insert(Goods record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Goods record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public Goods selectByPrimaryKey(Integer goodsid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(goodsid);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Goods record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<Map<String, Object>> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

}
