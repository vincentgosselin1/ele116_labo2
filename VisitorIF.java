package labo2;

public interface VisitorIF {
	public void visit(Livre livre);
	public void visit(Chapitre chapitre);
	public void visit(Paragraphe paragraphe);
}
