package labo2;

import java.util.ArrayList;
import java.util.List;

public class Livre implements Visitable{
	private String titre;
	private List<String> auteur_liste;
	private List<Visitable> enfants;

	
	Livre()
	{
		this.auteur_liste = new ArrayList<String>();
		this.titre = new String();
	}
	
	public void ajouterChapitre(Chapitre chapitre)
	{
		if(enfants==null)
		{
			enfants = new ArrayList<Visitable>();
		}
		chapitre.setParent(this); 
		this.enfants.add(chapitre);
	}
	public void definirTitre(String titre)
	{
		this.titre=titre;
	}
	public void definirAuteurs(String auteur)
	{
		this.auteur_liste.add(auteur);
	}
	public String getTitre(){
		return this.titre;
	}
	public String getAuteur_liste(){
		return auteur_liste.toString();
	}
	public List<Visitable> obtenirEnfants(){
		return this.enfants;
	}

	@Override
	public void accept(VisitorIF visiteur) {
		// TODO Auto-generated method stub
		visiteur.visit(this);
		for(Visitable chapitres : this.obtenirEnfants()){
			chapitres.accept(visiteur);
		}
	}


}
