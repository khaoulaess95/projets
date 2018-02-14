package com.xml;

import org.w3c.dom.*;

import java.io.File;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.bo.Ligne;
import com.bo.Triangle;

//On va Utiliser le parseur DOM

//serialisation des dessins en xml

public class XmlWriter {
	
	private Document doc;
	
	public void convert(String pFile,List<Ligne> lines) throws XmlException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			
			//root element : creer l'element racine
			Element rootElement = doc.createElement("Formes");
			doc.appendChild(rootElement);

			for(Ligne it : lines) {
				
				//la ligne
				Element ligne = doc.createElement("ligne");
			    
			    //son point A
			    Element pintA = doc.createElement("pointA");
			    pintA.setAttribute("X", String.valueOf(it.getPa().getX()));
			    pintA.setAttribute("Y", String.valueOf(it.getPa().getX()));

			    //son point B
			    Element pintB = doc.createElement("pointB");
			    pintB.setAttribute("X", String.valueOf(it.getPb().getX()));
			    pintB.setAttribute("Y", String.valueOf(it.getPb().getY()));
			    
			    
			    ligne.appendChild(pintA);
			    ligne.appendChild(pintB);

			    rootElement.appendChild(ligne);
			}
			
			
			//remplir le fichier XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source =new DOMSource(doc);
			StreamResult result = new StreamResult(new File(pFile));
			transformer.transform(source, result);
			
			
			//output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
			
		}catch(Exception ex) {
			throw new XmlException(ex);
		}
	}
}

