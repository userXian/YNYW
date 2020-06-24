package com.example.demo.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BooksService;
import com.example.demo.dao.BooksDao;

@Service
public class BooksServiceimpl implements BooksService{
	
	@Autowired
	BooksDao BooksDao;

	public List<Book> findBook(Book book) {
		return BooksDao.findBook(book);
	}
	@Override
	public boolean Booksadd(Book book) {
		
		int row=BooksDao.Booksadd(book);
		if(row>0) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public boolean Booksupdate(Book book) {
		int row=BooksDao.Booksupdate(book);
		if(row>0) {
			return true;
		}else {
			return false;
		}
	}
}
