package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bo.Commentaire;
import com.dao.CommentaireDao;
import com.services.CommentaireService;

@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	private CommentaireDao commentaireDao;

	@Override
	public void addCommentaire(Commentaire pCommentaire) {

		commentaireDao.create(pCommentaire);

	}

	public List<Commentaire> getAllCommentaires() {
		return commentaireDao.getAll();
	}

	public Commentaire getCommentaireById(Long id) {
		return commentaireDao.findById(id);
	}


	public void updateCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

}
