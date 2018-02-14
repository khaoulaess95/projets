package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Ligne {
	private Point pa,pb;
	
	String id;
	//liste de commentaire de la ligne selectionner
	private List<String> comments = new ArrayList<String>();
	
	
	public void addComments(String comment) {
		comments.add(comment);
	}
	
	//recuperer la liste des commentaires
	public String getComments() {
		StringBuffer sb = new StringBuffer();
		for(String it : comments) {
			sb.append(it);
			sb.append("|");
		}
		
		return sb.toString();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Ligne(Point pa, Point pb) {
		this.pa = pa;
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "Ligne [pa=" + pa + ", pb=" + pb + ", id=" + id + "]";
	}

	public Point getPa() {
		return pa;
	}

	public void setPa(Point pa) {
		this.pa = pa;
	}

	public Point getPb() {
		return pb;
	}

	public void setPb(Point pb) {
		this.pb = pb;
	}

	
	
	
}
