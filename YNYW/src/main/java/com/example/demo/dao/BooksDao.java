package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.Book;

@Mapper
public interface BooksDao {
	
	public List<Book> findBook(Book book);
	public int Booksadd(Book book);
	public int Booksupdate(Book book);
	
}
