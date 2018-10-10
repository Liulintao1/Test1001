package com.aaa.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.GoodsTypeMapper;
import com.aaa.entity.GoodsType;
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
@Autowired
private GoodsTypeMapper dao;
	@Override
	public int deleteByPrimaryKey(Integer typeid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(typeid);
	}

	@Override
	public int insert(GoodsType record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(GoodsType record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public GoodsType selectByPrimaryKey(Integer typeid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(typeid);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsType record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodsType record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<Map<String, Object>> queryType() {
		// TODO Auto-generated method stub
		return dao.queryType();
	}

}
