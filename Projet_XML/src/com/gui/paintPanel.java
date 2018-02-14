package com.gui;

import java.util.List;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import com.bo.Ligne;
import com.bo.Point;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.utils.Utils;

//le panneau qui contient le dessin
public class paintPanel extends JPanel{
	
	//liste des dessins a convertir en XML
	private List<Ligne> lines= new ArrayList<Ligne>();
	
	private Ligne selectedLine;
	
	private boolean drawMode = true;
	
	//evenement : clic sur la sourie puis on gluisse pour dessiner
	public paintPanel(MainFrame parent) {
		//on va ecouter les evenements de la sourie
		addMouseListener(new MouseAdapter(){
			
			Point pointd;

			//l'orsque on clic sur la sourie
	public void mousePressed(MouseEvent e) {
				pointd =new Point(e.getX(),e.getY());
				
		    }
			
			//l'orsque on glisse la sourie
	public void mouseReleased(MouseEvent e) {
				Point pointf =new Point(e.getX(),e.getY());
				Ligne lineDistanceMin=null;
				
				if(drawMode) {

					lines.add(new Ligne(pointd,pointf));
					
					//on a detecter le probleme de rafraichissement donc la solution est la methode :
					repaint();
				}
				
				else {
					if(lines.size()!=0) {
						
					lineDistanceMin = lines.get(0);
					
					
					for(Ligne it : lines) {
						if(Utils.distancePointLine(pointf, it) < Utils
								.distancePointLine(pointf,lineDistanceMin)) {
							lineDistanceMin = it;
						}
					}
					}
			//ajout des commentaires
			//une fois qu'on a selectionner la ligne on peut ajouter des commentaires
					
				selectedLine = lineDistanceMin;
					
				String comment = JOptionPane.showInputDialog("Enter votre commentaire");
				
				selectedLine.addComments(comment);
				
				parent.writeInCommentsLab(getSelectedLine().getComments());//si on a une ligne on stock le commentaire dans le label
				
				}	
			}
			
		});
	}
	
	//la methode qui s'occupe de la sérialization : convertion en XML
    public void convertToXML() {
    	
    }
	
	//tracer toutes les lignes qu'on a dans la liste
	public void drawLines(Graphics g) {
		for(Ligne it : lines) {
			g.drawLine(it.getPa().getX(),it.getPa().getY(),it.getPb().getX(),it.getPb().getY());
		}
	}
	
	//Dessiner
	public void paint(Graphics g) {
		super.paint(g);
		drawLines(g);
	}
	
	public void add(Ligne l) {
		lines.add(l);
	}

	public List<Ligne> getLines() {
		return lines;
	}

	public void setLines(List<Ligne> lines) {
		this.lines = lines;
	}

	public boolean isDrawMode() {
		return drawMode;
	}

	public void setDrawMode(boolean drawMode) {
		this.drawMode = drawMode;
	}

	public Ligne getSelectedLine() {
		return selectedLine;
	}

	public void setSelectedLine(Ligne selectedLine) {
		this.selectedLine = selectedLine;
	}
	
	
	
	
	
}
