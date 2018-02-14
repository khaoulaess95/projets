package com.services;

import java.util.List;

import com.bo.Commentaire;

public interface CommentaireService {

	public void addCommentaire(Commentaire pCommentaire);

	public List<Commentaire> getAllCommentaires();

	public void updateCommentaire(Commentaire commentaire);

	public Commentaire getCommentaireById(Long id);

}
