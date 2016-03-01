package labo2;

import java.util.ArrayList;
import java.util.List;

public class Livre extends Noeud{
	private String titre;
	private List<String> auteur_liste;

	Livre()
	{
		super();
		this.auteur_liste = new ArrayList<String>();
		this.titre = new String();
	}
	
	public void definirTitre(String titre)
	{
		this.titre=titre;
	}
	public void definirAuteurs(String auteur)
	{
		this.auteur_liste.add(auteur);
	}
	public void AjouterChapitres(Chapitre chapitre)
	{
		this.ajouterEnfant(chapitre);
	}
	public String getTitre(){
		return this.titre;
	}
	public String getAuteur_liste(){
		return auteur_liste.toString();
	}
}
