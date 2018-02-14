package com.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * théme d'un livre
 * 
 * @author Boudaa
 *
 */

@Entity
public class Theme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idThme;
	
	
	private String nom;
	
//	@OneToMany( fetch = FetchType.LAZY)
//	@JoinColumn(name = "IDTHME")
	@OneToMany(mappedBy="theme" ,fetch=FetchType.LAZY)
	private List<Book> livres;
	
	

	public Theme(Long idThme, String nom, List<Book> livres) {
	
		this.idThme = idThme;
		this.nom = nom;
		this.livres = livres;
	}

	public Theme() {
		
	}

	@Override
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public List<Book> getLivres() {
		return livres;
	}

	public void setLivres(List<Book> livres) {
		this.livres = livres;
	}

	public Long getIdThme() {
		return idThme;
	}

	public void setIdThme(Long idThme) {
		this.idThme = idThme;
	}

}
