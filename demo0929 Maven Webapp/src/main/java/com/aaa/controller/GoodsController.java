package com.aaa.controller;

import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.entity.Goods;
import com.aaa.entity.GoodsType;
import com.aaa.service.GoodsService;
import com.aaa.service.GoodsTypeService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService service;
	@Autowired
	private GoodsTypeService tservice;

	@RequestMapping("/queryAll")
	@ResponseBody
	public List<Map<String, Object>> queryAll() {
		List<Map<String, Object>> goods = service.queryAll();
		System.out.println(goods + "查询方法...");
		return goods;

	}

	@RequestMapping("/queryType")
	@ResponseBody
	public List<Map<String,Object>> queryType() {
		List<Map<String, Object>> types = tservice.queryType();
		System.out.println(types + "查询类型...");
		return types;

	}
/*
	@RequestMapping("/insert")
	public void insert(@RequestBody Goods record, HttpServletResponse response) throws IOException {
		int a = service.insert(record);
		PrintWriter out = response.getWriter();
		System.out.println(a + "行受影响");
		out.print("添加成功");
	}
*/
	@RequestMapping("/insert")
	public void insert(@RequestParam("goodsimage") MultipartFile file, Goods record,HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String goodsImageName=Transfer(file, request);
		record.setGoodsimagename(goodsImageName);
		int a=service.insert(record);
		System.out.println("\t添加执行...");
		if (a>0) {
			out.print("添加成功");
		}else{
			out.print("添加失败");
		}
		
	}

private String Transfer(MultipartFile file,HttpServletRequest request) {
	String path=request.getServletContext().getRealPath("/resources/upload");
	String fileName=file.getOriginalFilename();
	File targetFile=new File(path,fileName);
	if (!targetFile.exists()) {
		targetFile.mkdirs();
	}
	try {
		file.transferTo(targetFile);
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return request.getContextPath()+"/resources/upload/"+fileName;
}
}
