package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.rental;
import com.example.demo.Entity.user;
import com.example.demo.Service.DetailsService;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class DetailsController {
	
	@Autowired
	DetailsService DetailsServiceimpl;

	@PostMapping("/details")
	@ResponseBody
	public List Details(@RequestBody Book book){
		List<Book> books= DetailsServiceimpl.findBook(book);
		return books;
	}
	
	@PostMapping("/ent")
	@ResponseBody
	public boolean Ent(@RequestBody rental rental ) {
		return DetailsServiceimpl.insetrental(rental);
		
	}
	
}
