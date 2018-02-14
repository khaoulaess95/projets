package com.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.xml.XmlException;
import com.xml.XmlWriter;

public class MainFrame extends JFrame{
	
	
	private JPanel panMenu = new JPanel();
	
	//pour afficher les commentaires
	private JPanel commentPan = new JPanel();
	
	//panneau pour dessiner
	private paintPanel paintPanel;
	
	//on a creer un label pour y mettre les commentaires recus
    private JLabel commentLab = new JLabel();

	
	//creation de la fenetre
	//LES METHODES utiilisés sont définies dans la classe JFrame
	public MainFrame() {
		 paintPanel = new paintPanel(this);
		setTitle("Application XML");	
		
	//Construire le menu
		
		//BOUTON pour convertir les formes en XML
		JButton convertToXmlBtn = new JButton("Convertir en XML");
		
		//Bouton pour choisir le mode dessiner ou pas dessiner
		JButton changerMode = new JButton("Activer/Desactiver dessin");

		//ajouter le bouton de convertir au paneau
		panMenu.add(convertToXmlBtn,JPanel.LEFT_ALIGNMENT);
		
		//ajouter le bouton de dessin au paneau
		panMenu.add(changerMode,JPanel.LEFT_ALIGNMENT);

		//si on clique sur le bouton : activer/desactiver dessin
		changerMode.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if(paintPanel.isDrawMode()) {
				paintPanel.setDrawMode(false);
				}
				else {
					paintPanel.setDrawMode(true);
				}
			}
		});
		
		//si on clique sur le bouton : Convertir en XML 
		convertToXmlBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//convertir les formes en XML
				
				XmlWriter xmlWriter = new XmlWriter();
				
				try {
				    xmlWriter.convert("D:\\XEnsaForms.xml", paintPanel.getLines());
				    
				    JOptionPane.showMessageDialog(null,"Fichier XML creé correctement","OK",JOptionPane.INFORMATION_MESSAGE);
				}catch(XmlException e1) {
					JOptionPane.showMessageDialog(null,"Erreur de conversion du fichier en XML","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//Ajouter au menu 

		
		commentLab.setText("TEST");//sinon le label reste vide

		commentPan.add(commentLab);
		
		add(panMenu,BorderLayout.NORTH);
		
		add(commentPan,BorderLayout.SOUTH);//afficher les commentaires
		
		add(paintPanel);

		
		//caracteristique de la surface
		setSize(500,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//mettre a jour le label
	public void writeInCommentsLab(String pString) {
			commentLab.setText(commentLab.getText()+"|" +pString);//si on a une ligne on stock le commentaire dans le label
	}
	
	public static void main(String []args) {
		//creer la fenetre
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
			
		});
	}

}
