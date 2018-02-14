package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Pentagone {
	private Point pa,pb,pc,pd,pe;
	
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
	public Pentagone(Point pa, Point pb, Point pc, Point pd, Point pe) {
		this.pa = pa;
		this.pb = pb;
		this.pc = pc;
		this.pd = pd;
		this.pe = pe;
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

	public Point getPc() {
		return pc;
	}

	public void setPc(Point pc) {
		this.pc = pc;
	}

	public Point getPd() {
		return pd;
	}

	public void setPd(Point pd) {
		this.pd = pd;
	}

	public Point getPe() {
		return pe;
	}

	public void setPe(Point pe) {
		this.pe = pe;
	}
	
	

}
