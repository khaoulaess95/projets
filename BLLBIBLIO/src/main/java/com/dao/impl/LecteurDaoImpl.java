package com.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.bo.Lecteur;
import com.dao.LecteurDAO;
import com.genericdao.common.EntityNotFoundException;
import comM.genericdao.impl.HibernateSpringGenericDaoImpl;

@Repository
public class LecteurDaoImpl extends HibernateSpringGenericDaoImpl<Lecteur, Long> implements
		LecteurDAO {

	public LecteurDaoImpl() {

		super(Lecteur.class);

	}
	

	public List<Lecteur> getLecteurByName(String pName)
			throws EntityNotFoundException {

		// soit avec : une requete HQL et la méthode find
		// List<Lecteur> list = (List<Lecteur>) getHibernateTemplate().find(
		// "from Lecteur where nom = ? ", pName);

		// ou

		List<Lecteur> list = getEntityByColumn("Lecteur", "nom", pName);

		if (list == null || list.isEmpty()) {

			throw new EntityNotFoundException("Objet recherché introuvable");
		}

		return list;

	}

}
