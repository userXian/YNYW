package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.rental;

@Mapper
public interface DetailsDao {
	
	public List<Book> findBook(Book book);
	public Book find(String bookId);
	public int insetrental(rental rental);
    public int updatebook(Book book);
    public rental revertselect(rental rental);
	
}
