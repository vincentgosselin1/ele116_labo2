package labo2;

public class Chapitre extends Noeud{
	private String titre_chapitre;
	
	Chapitre(Livre livre)
	{
		super(livre);
		this.titre_chapitre = new String();
	}
	
	public void definirTitre(String titre)
	{
		this.titre_chapitre=titre;
	}
	public void ajouterParagraphe(Paragraphe paragraphe)
	{
		this.ajouterEnfant(paragraphe);
	}
	public String getTitre()
	{
		return this.titre_chapitre;
	}

}
