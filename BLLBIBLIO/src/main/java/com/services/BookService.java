package com.services;


import java.util.List;
import java.util.Map;

import com.bo.Book;
import com.bo.Rayon;
import com.bo.Theme;
import com.genericdao.common.EntityNotFoundException;


/**
 * 
 * Interface du Service métier permettant de gérer les livres
 * 
 * @author boudaa
 *
 */

public interface BookService {

	/** Enregistrer un livre */
	public void addNewBook(Book pBook);

	/** r�cup�re la liste des livres */
	public List<Book> getAllBooks();

	/** r�cup�re des donn�es statistiques sur les livres */
	public Map<String, Number> getBooksStat();

	/** recherche un livre par son titre */
	public List<Book> finBookByTitle(String pTitle);

	/**
	 * recherche un livre par son identifiant
	 * 
	 * @throws EntityNotFoundException
	 */
	public Book finBookById(Long idBook) throws EntityNotFoundException;

	/** r�cup�re la liste des rayons */
	public List<Rayon> getAllRayons();

	/** r�cup�re la liste des th�mes */
	public List<Theme> getAllThemes();

	/** recherche un th�me par son nom */
	public Theme getThemeByNom(String pTheme);

	/** recherche un rayon par son nom */
	public Rayon getRayonByNom(String pRayon);

	/** r�cup�re la liste des th�me associ�s � un rayon */
	public List<String> getThemeOfRayon(String rayon);

	/** mise � jour des informations d'un livre*/
	public void updateBook(Book pBook) ;

	
	
	/** supprime un livre de la base de donn�es 
	 * @throws EntityNotFoundException */
	public void deleteBook(Long pId) throws EntityNotFoundException;
}
