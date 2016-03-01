package labo2;

public class Paragraphe implements Visitable{
	private String contenu;
	private Visitable parent;
	
	
	Paragraphe()
	{
		contenu = new String();
	}
	public void definirContenu(String contenu)
	{
		this.contenu=contenu;
	}
	public String getContenu(){
		return contenu;
	}
	public Visitable obtenirParent(){
		return parent;
	}
	public void setParent(Chapitre chapitre)
	{
		this.parent=chapitre;
	}
	@Override
	public void accept(VisitorIF visiteur) {
		// TODO Auto-generated method stub
		visiteur.visit(this);
	}
	
}
