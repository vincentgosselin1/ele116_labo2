package labo2;

import java.util.Iterator;
import java.util.List;

public class VisitreLivreComplet implements VisitorIF{
	
	private VisitorIF visiteur;
	private Iterator<Visitable> iterator;
	
	private String htmlPage = "";
	
	
	public String gethtmlPage()
	{
		return htmlPage;
	}


	@Override
	public void visit(Livre livre) {
		// TODO Auto-generated method stub
		htmlPage += "<h1>" + livre.getTitre() + "</h1> <br>";
		htmlPage += "<b>" + livre.getAuteur_liste().toString() + "</b> <br>";
	}





	@Override
	public void visit(Chapitre chapitre) {
		// TODO Auto-generated method stub
		htmlPage += "<h3>" + chapitre.getTitre() + "</h3> <br>";
	}





	@Override
	public void visit(Paragraphe paragraphe) {
		// TODO Auto-generated method stub
		htmlPage += "<u>" + paragraphe.getContenu() + "</u> <br>";
	}
}
