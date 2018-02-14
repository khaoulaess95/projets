package com.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lecteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLecteur;

	private String nom;

	private String prenom;

	private String email;

	public Lecteur() {
	}

	public Lecteur(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Long getIdLecteur() {
		return idLecteur;
	}

	public void setIdLecteur(Long idLecteur) {
		this.idLecteur = idLecteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
