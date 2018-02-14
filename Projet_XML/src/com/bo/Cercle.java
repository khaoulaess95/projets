package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Cercle {
	private Point po;
	
	private double rayon;
	
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
	public Cercle(Point po, double rayon) {
		this.po = po;
		this.rayon = rayon;
	}
	public Point getPo() {
		return po;
	}
	public void setPo(Point po) {
		this.po = po;
	}
	public double getRayon() {
		return rayon;
	}
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	
	
}
