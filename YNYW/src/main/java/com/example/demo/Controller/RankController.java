package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.RankBook;
import com.example.demo.Entity.RankReader;
import com.example.demo.Service.RankService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@Controller
@RequestMapping("/rank")
public class RankController {
	@Autowired
	RankService rankService;

	private static class PageParamBody {
		private String pageIndex;
		private String pageSize;

		public String getPageIndex() {
			return pageIndex;
		}

		public void setPageIndex(String pageIndex) {
			this.pageIndex = pageIndex;
		}

		public String getPageSize() {
			return pageSize;
		}

		public void setPageSize(String pageSize) {
			this.pageSize = pageSize;
		}
	}

	@PostMapping("/getnum")
	@ResponseBody
	public Map<String, Integer> getNum() {
		return rankService.getNum();
	}
	@PostMapping("/getbooks")
	@ResponseBody
	public List<RankBook> getBooks(@RequestBody PageParamBody paramBody) {
		return rankService.getBooks(Integer.valueOf(paramBody.getPageIndex()), Integer.valueOf(paramBody.getPageSize()));
	}
	@PostMapping("/getreaders")
	@ResponseBody
	public List<RankReader> getReaders(@RequestBody PageParamBody paramBody) {
		return rankService.getReaders(Integer.valueOf(paramBody.getPageIndex()), Integer.valueOf(paramBody.getPageSize()));
	}
	
}
