package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.RankBook;
import com.example.demo.Entity.RankReader;
@Mapper
public interface RankDao {
	List<Integer> getNum();
	List<RankBook> getBooks(int startIndex, int pageSize);
	List<RankReader> getReaders(int startIndex, int pageSize);
}
