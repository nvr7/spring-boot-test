package com.vr.LearnSpringBootWeb.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vr.LearnSpringBootWeb.Service.PageService;
import com.vr.LearnSpringBootWeb.model.Book;


@Service
public class BookDao implements PageService {
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Book> listBook(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Book", Book.class) .getResultList();
	}

	@Override
	public Book saveOrUpdate(Book book) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Book saved = em.merge(book);
		em.getTransaction().commit();
		return saved;
	}



	@Override
	public Book getIdBook(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.find(Book.class, id);
	}



	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Book.class, id));
		em.getTransaction().commit();
	}

}
