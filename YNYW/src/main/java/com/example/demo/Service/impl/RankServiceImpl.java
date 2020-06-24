package com.example.demo.Service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.RankBook;
import com.example.demo.Entity.RankReader;
import com.example.demo.Service.RankService;
import com.example.demo.dao.RankDao;

@Service
public class RankServiceImpl implements RankService{
	@Autowired
	RankDao rankDao;
	@Override
	public Map<String, Integer> getNum() {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> res = rankDao.getNum();
		map.put("bookNum", res.get(0));
		map.put("readerNum", res.get(1));
		return map;
	}

	@Override
	public List<RankBook> getBooks(int pageIndex, int pageSize) {
		return rankDao.getBooks(pageIndex * pageSize, pageSize);
	}

	@Override
	public List<RankReader> getReaders(int pageIndex, int pageSize) {
		return rankDao.getReaders(pageIndex * pageSize, pageSize);
	}
	
}
