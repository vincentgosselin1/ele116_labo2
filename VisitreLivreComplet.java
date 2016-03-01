package labo2;

import java.util.Iterator;
import java.util.List;

public class VisitreLivreComplet {
	
	private Visiteur visiteur;
	private Iterator<Noeud> iterator;
	
	private Livre livre;
	private List<Chapitre> chapitres;
	private List<Paragraphe> paragraphes;
	
	private String htmlPage = "";
	
	VisitreLivreComplet(LecteurXML lecteur){
		visiteur = new Visiteur();
		Noeud noeud = lecteur.getLivre().accept(visiteur);
		noeud.obtenirEnfants();
		chapitres = livre.obtenirChapitres();
	}
	
	
	
	private String titre_to_html(String t)
	{
		return "<h1>"+t+"</h1>";
	}
	private String auteur_to_html(String t)
	{
		return "<i>"+t+"</i>";
	}
	private String chapitre_titre_to_html(String t)
	{
		return "<b>"+t+"</b>";
	}
	private String paragraphes_to_html(String t)
	{
		return "<u>"+t+"</u>";
	}
	
	
	
	
	public void htmlBuilder(){
		htmlPage += titre_to_html(visiteur.visit(livre).getTitre()) + "<br>";
		htmlPage += auteur_to_html(visiteur.visit(livre).getAuteur_liste()) + "<br>";
		for(int i=0;i<this.chapitres.size();i++)
		{
			htmlPage += chapitre_titre_to_html(this.chapitres.get(i).getTitre()) + "<br>";
			for(int j=0;j<chapitres.get(i).obtenirParagraphes().size();j++)
			{
				htmlPage += this.paragraphes_to_html(chapitres.get(i).obtenirParagraphes().get(j).getContenu()) + "<br>"; 
			}
		}
		
	}
	
	public String gethtmlPage()
	{
		return htmlPage;
	}
}
