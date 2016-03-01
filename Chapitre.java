package labo2;

import java.util.ArrayList;
import java.util.List;

public class Chapitre implements Visitable{
	private String titre_chapitre;
	private Visitable parent;
	private List<Visitable> enfants;
	
	Chapitre()
	{
		this.titre_chapitre = new String();
	}
	
	public void definirTitre(String titre)
	{
		this.titre_chapitre=titre;
	}
	public void ajouterParagraphe(Paragraphe paragraphe)
	{
		if(enfants==null)
		{
			enfants = new ArrayList<Visitable>();
		}
		paragraphe.setParent(this);
		this.enfants.add(paragraphe);
	}
	public String getTitre()
	{
		return this.titre_chapitre;
	}
	public Visitable obtenirParent(){
		return parent;
	}
	public void setParent(Livre livre)
	{
		this.parent=livre;
	}
	public List<Visitable> obtenirEnfants(){
		return this.enfants;
	}

	@Override
	public void accept(VisitorIF visiteur) {
		// TODO Auto-generated method stub
		visiteur.visit(this);
		for(Visitable paragraphes : this.obtenirEnfants()){
			paragraphes.accept(visiteur);
		}
		
	}
}
