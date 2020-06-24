package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.RankBook;
import com.example.demo.Entity.RankReader;
import com.example.demo.Service.RankService;

@RestController("/rank")
public class RankController {
	@Autowired
	RankService rankService;
	
	
	@PostMapping("/getnum")
	public Map<String, Integer> getNum() {
		return rankService.getNum();
	}
	@PostMapping("/getbooks")
	public List<RankBook> getBooks(int pageIndex, int pageSize) {
		return rankService.getBooks(pageIndex, pageSize);
	}
	@PostMapping("/getreads")
	public List<RankReader> getReaders(int pageIndex, int pageSize) {
		return rankService.getReaders(pageIndex, pageSize);
	}
	
}
