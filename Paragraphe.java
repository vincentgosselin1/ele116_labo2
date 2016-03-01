package labo2;

public class Paragraphe extends Noeud{
	private String contenu;
	
	Paragraphe(Chapitre chapitre)
	{
		super(chapitre);
		contenu = new String();
	}
	public void definirContenu(String contenu)
	{
		this.contenu=contenu;
	}
	public String getContenu(){
		return contenu;
	}
}
