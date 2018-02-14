package com.dao.impl;

import java.awt.print.Book;
import java.util.List;

import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.bo.Rayon;
import com.dao.BookDao;
import com.genericdao.common.EntityNotFoundException;

@Repository
public class BookDaoImpl extends HibernateSpringGenericDaoImpl <Book , Long> implements BookDao {

	public BookDaoImpl() {

			super(Book.class);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBookByTitle(String pTitle) {

		// Une requete HQL simple pour chercher les livres par titre
		return (List<Book> ) getHibernateTemplate().find("from Book where title=?", pTitle);
		

	}

	public Rayon getRayonByNom(String rayon) {

		// Une requete HQL simple pour chercher les rayons par nom

		List l = getHibernateTemplate().find("from Rayon where nom=?", rayon);

		if (l == null || l.size() == 0)
			throw new ObjectRetrievalFailureException(Rayon.class, rayon);

		return (Rayon) l.get(0);

	}

	@Override
	public com.bo.Book create(com.bo.Book arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long arg0) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public com.bo.Book findById(Long arg0) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.bo.Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.bo.Book> getAll(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.bo.Book> getAllDistinct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.bo.Book> getAllDistinct(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.bo.Book> getEntityByColumn(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(com.bo.Book arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rayon getRayonByNom(String rayon) {
		// TODO Auto-generated method stub
		return null;
	}
}
