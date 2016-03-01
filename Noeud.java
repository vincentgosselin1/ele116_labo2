package labo2;

import java.util.ArrayList;
import java.util.List;

public class Noeud implements Visitable{

	private Noeud parent;
	private List<Noeud> enfants;
	

	Noeud()//livre
	{
		this.parent = null;
		this.enfants = null;
	}
	
	Noeud(Chapitre chapitre)//chapitre
	{
		this.parent = chapitre;
		this.enfants = null;
	}

	public void ajouterEnfant(Noeud noeud)
	{
		if(enfants==null)
		{
			enfants = new ArrayList<Noeud>();
		}
		noeud.parent = this;
		enfants.add(noeud);   
	}
	
	public Noeud obtenirParent(){
		return parent;
	}
	
	public List<Noeud> obtenirEnfants(){
		return enfants;
	}
	

	@Override
	public Noeud accept(Visiteur visiteur) {
		// TODO Auto-generated method stub
		return visiteur.visit(this);
	}



}
