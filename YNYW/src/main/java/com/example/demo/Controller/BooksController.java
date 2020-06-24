package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.user;
import com.example.demo.Service.BooksService;
import com.example.demo.Service.DetailsService;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class BooksController {
	
	@Autowired
	BooksService BooksServiceimpl;

	@PostMapping("/books")
	@ResponseBody
	public List Books(@RequestBody Book book){
		List<Book> books= BooksServiceimpl.findBook(book);
		return books;
	}
	
	@PostMapping("/booksadd")
	@ResponseBody
	public boolean Booksadd(@RequestBody Book book) {
		return BooksServiceimpl.Booksadd(book);
	}
	
	@PostMapping("/booksupdate")
	@ResponseBody
	public boolean Booksupdate(@RequestBody Book book) {
		return BooksServiceimpl.Booksupdate(book);
	}
	
}
