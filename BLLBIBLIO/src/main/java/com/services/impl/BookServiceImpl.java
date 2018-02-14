package com.services.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Book;
import com.bo.Rayon;
import com.bo.Theme;
import com.dao.BookDao;
import com.dao.RayonDao;
import com.dao.ThemeDao;
import com.genericdao.common.EntityNotFoundException;
import com.services.BookService;

/**
 * Interface du Service métier permettant de gérer les livres
 * 
 * @author T. BOUDAA
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	/**
	 * d�pendance avec le DAO g�rant les livres. Spring injetera une instance de
	 * BookDaoImpl dans cette variable
	 */
	@Autowired
	private BookDao bookDao;

	/**
	 * d�pendance avec le DAO g�rant les rayons. Spring injetera une instance de
	 * RayonDaoImpl dans cette variable
	 */
	@Autowired
	private RayonDao rayonDao;

	/**
	 * d�pendance avec le DAO g�rant les themes. Spring injetera une instance de
	 * ThemeDaoImpl dans cette variable
	 */
@Autowired 
	private ThemeDao themeDao;

	public void addNewBook(Book pBook) {

		// TODO : dans le cas g�n�ral cette m�thode pourra faire des
		// v�rifications des r�gles m�tier avant de passer la main au DAO

		bookDao.create(pBook);

	}

	public List<Book> getAllBooks() {

		// TODO : dans le cas g�n�ral cette m�thode pourra faire des
		// v�rifications des r�gles m�tier avant de passer la main au DAO

		return bookDao.getAll();
	}

	public List<Book> finBookByTitle(String pTitle) {

		// TODO : dans le cas g�n�ral cette m�thode pourra faire des
		// v�rifications des r�gles m�tier avant de passer la main au DAO

		return bookDao.getBookByTitle(pTitle);
	}

	@Override
	public Book finBookById(Long idBook) throws EntityNotFoundException {
		return bookDao.findById(idBook);

	}

	public Map<String, Number> getBooksStat() {
		int compteur = 0;
	
		
		
		List<Book> books = bookDao.getAll();
		
		
		
		
		Map<String, Number> data = new HashMap<String, Number>();
		for (Book iti : books) {
			compteur = 0;
			for (Book itj : books) {
				if (iti.getTheme().getNom().equals(itj.getTheme().getNom()))
					compteur++;
			}
			data.put(iti.getTheme().getNom(), compteur);
		}

		return data;
	}

	public List<String> getThemeOfRayon(String rayon) {

		Rayon r = bookDao.getRayonByNom(rayon);
		List<Theme> listThemes = r.getThemes();
		List<String> themeLabels = new ArrayList<String>();
		for (Theme it : listThemes) {
			themeLabels.add(it.getNom());
		}
		return themeLabels;
	}

	public Theme getThemeByNom(String pTheme) {
		// on a suppos� que le nom d'un theme est unique

		return themeDao.getEntityByColumn("Theme", "nom", pTheme).get(0);
		
	}

	public Rayon getRayonByNom(String pRayon) {
		// on a suppos� que le nom d'un rayon est unique

		return rayonDao.getEntityByColumn("Rayon", "nom", pRayon).get(0);
	}
	
	
	
	public void deleteBook(Long pId) throws EntityNotFoundException {
		
		//il y aura d autres chose a faire
		bookDao.delete(pId);
	}
	
	
	public void updateBook(Book pBook) {
		bookDao.update(pBook);
		
	}


	public BookDao getBookDao() {
		return bookDao;
	}

	// Les getters/setters (necessaires pour que Spring puisse ingecter les
	// d�pendances
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Rayon> getAllRayons() {
		return rayonDao.getAll();
	}

	public List<Theme> getAllThemes() {
		return themeDao.getAll();
	}

	public RayonDao getRayonDao() {
		return rayonDao;
	}

	public void setRayonDao(RayonDao rayonDao) {
		this.rayonDao = rayonDao;
	}

	public ThemeDao getThemeDao() {
		return themeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}




}

	


