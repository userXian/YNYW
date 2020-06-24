package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.rental;

public interface DetailsService {

	public List<Book> findBook(Book book);
	public boolean insetrental(rental rental);
	
}
