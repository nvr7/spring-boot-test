package com.vr.LearnSpringBootWeb.Service;

import java.util.List;

import com.vr.LearnSpringBootWeb.model.Book;

public interface PageService {
	
	List<Book> listBook();
	Book saveOrUpdate(Book book);
	Book getIdBook (Integer id);
	void  delete (Integer id);

}
