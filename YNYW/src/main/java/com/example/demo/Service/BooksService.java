package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Book;

public interface BooksService {

	public List<Book> findBook(Book book);
	public boolean Booksadd(Book book);
	public boolean Booksupdate(Book book);
	
}
