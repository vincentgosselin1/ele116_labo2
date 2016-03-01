package labo2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LecteurXML{

	private MyHandler handler = new MyHandler();
	private SAXParser saxParser;
	
	private Livre livre;
	

	public void lireFichier(File file) throws ParserConfigurationException, SAXException
	{
		System.out.println(file.getName());
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParser = saxParserFactory.newSAXParser();
		try {
			saxParser.parse(file, handler);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.livre=handler.livre;
	}
	public Livre getLivre(){
		return livre;
	}
	
	
	

	private class MyHandler extends DefaultHandler{

		boolean blivre = false;
		boolean btitre_livre = false;
		boolean bauteur = false;
		boolean bchapitre = false;
		boolean btitre_chapitre = false;
		boolean bparagraphe = false;
		
		private Livre livre;
		private Chapitre chapitre;
		private Paragraphe paragraphe;
		

		@Override
		public void startElement(String uri, String localName, String qName, 
				Attributes attributes) throws SAXException{

			if(qName.equalsIgnoreCase("livre")){
				blivre = true;
			}
			else if(qName.equalsIgnoreCase("titre_livre")){
				btitre_livre = true;
			}
			else if(qName.equalsIgnoreCase("auteur")){
				bauteur = true;
			}
			else if(qName.equalsIgnoreCase("chapitre")){
				bchapitre = true;
			}
			else if(qName.equalsIgnoreCase("titre_chapitre")){
				btitre_chapitre = true;
			}
			else if(qName.equalsIgnoreCase("paragraphe")){
				bparagraphe = true;
			}
			System.out.println("In the startElement fonction!");

		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException{
		System.out.println("In the endElement fonction!");


		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			System.out.println("In the characters fonction!");
			if(blivre)
			{
				livre = new Livre();
				blivre = false;
			}
			else if(btitre_livre)
			{
				livre.definirTitre(new String(ch, start, length));
				btitre_livre = false;
			}
			else if(bauteur)
			{
				livre.definirAuteurs(new String(ch, start, length));
				bauteur = false;
			}
			else if(bchapitre)
			{
				chapitre = new Chapitre();
				bchapitre = false;
			}
			else if(btitre_chapitre)
			{
				chapitre.definirTitre(new String(ch, start, length));
				livre.ajouterChapitre(chapitre);
				btitre_chapitre = false;
			}
			else if(bparagraphe)
			{
				paragraphe = new Paragraphe();
				paragraphe.definirContenu(new String(ch, start, length));
				chapitre.ajouterParagraphe(paragraphe);
				bparagraphe = false;
			}
		}
	}
}












