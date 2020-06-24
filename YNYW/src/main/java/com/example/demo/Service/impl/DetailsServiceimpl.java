package com.example.demo.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.rental;
import com.example.demo.Service.DetailsService;
import com.example.demo.dao.DetailsDao;

@Service
public class DetailsServiceimpl implements DetailsService{
	
	@Autowired
	DetailsDao detailsDao;

	@Override
	public List<Book> findBook(Book book) {
		return detailsDao.findBook(book);
	}

	@Override
	public boolean insetrental(rental rental) {
		Book book=detailsDao.find(rental.getBookId());
		if(book.getQuantity()<=0) {
			return false;
		}
		int row=detailsDao.insetrental(rental);
		if(row>0) {
			book.setQuantity(book.getQuantity()-1);
			int row1=detailsDao.updatebook(book);
			if(row1>0) {
			    return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
