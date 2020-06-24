package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import com.example.demo.Entity.RankBook;
import com.example.demo.Entity.RankReader;

public interface RankService {
	Map<String, Integer> getNum();
	List<RankBook> getBooks(int pageIndex, int pageSize);
	List<RankReader> getReaders(int pageIndex, int pageSize);
}
