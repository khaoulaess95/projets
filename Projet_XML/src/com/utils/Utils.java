package com.utils;

import com.bo.*;

//Cette classe est utulisé pour calculer la distance entre le dessin et le clic de la sourie

public class Utils {
	
	
	public static double distancePointLine(Point p,Ligne line) {
		
		int y1 = line.getPa().getY();
		int x1 = line.getPa().getX();

		int x2 = line.getPb().getX();
		int y2 = line.getPb().getY();

		return Math.abs((y2-y1)*p.getX()-(x2-x1)*p.getY()+x2*y1-y2*x1)/Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		
	}
	
	public static double distancePointCarre(Point p,Carre C) {return 0;}

	public static double distancePointCercle(Point p,Cercle CL) {return 0;}
	
	public static double distancePointDecagone(Point p,Decagone D) {return 0;}

	public static double distancePointEnneagone(Point p,Enneagone E) {return 0;}

	public static double distancePointHeptagone(Point p,Heptagone H) {return 0;}

	public static double distancePointHexagone(Point p,Hexagone HX) {return 0;}

	public static double distancePointOctagone(Point p,Octagone O) {return 0;}

	public static double distancePointPentagone(Point p,Pentagone P) {return 0;}

	public static double distancePointRectangle(Point p,Rectangle R) {return 0;}

	public static double distancePointTriangle(Point p,Triangle T) {return 0;}



	
	
}
