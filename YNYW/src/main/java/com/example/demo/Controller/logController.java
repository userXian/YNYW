package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LogService;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class logController {
	
	@Autowired
	LogService LogServiceimpl;

	@PostMapping("/logs")
	@ResponseBody
	public List Logs() {
		return LogServiceimpl.logs();
	}
	
}
