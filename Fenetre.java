package labo2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Fenetre extends JFrame implements ActionListener, MenuListener{
	
	JTextArea output;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu fichier,afficher;
	JMenuItem tabMatieres,livreEntier;
	JPanel toolPanel = new JPanel();
	JEditorPane htmlPage = new JEditorPane("text/html","");
	
	LecteurXML lecteur;
	
	
	
	public Fenetre(){
		//Cree la fenetre
		setLayout(new FlowLayout());
		setSize(500,500);
		setTitle("Visiteurs de fichiers XML");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ajoute du texte.
		htmlPage.setText("<p> Heyyy </p><p> Cliquer sur Fichier pour Loader un fichier! </p>");
		toolPanel.add(htmlPage);
		this.add(toolPanel);
		
		
		
		//Create de menu bar.
		menuBar = new JMenuBar();
		
		//premier bouton du menubar
		fichier = new JMenu("Fichier");
		fichier.addMenuListener(this);
		menuBar.add(fichier);
		
		
		//deuxieme bouton du menubar
		afficher = new JMenu("Afficher");
		menuBar.add(afficher);
		
		//Sub-menu item de afficher.
		tabMatieres = new JMenuItem("Table des matieres");
		tabMatieres.addActionListener(this);
		afficher.add(tabMatieres);
		
		//Sub-menu item de afficher.
		livreEntier = new JMenuItem("Livre Entier");
		livreEntier.addActionListener(this);
		afficher.add(livreEntier);	
	
		
		//Ajouter menu Bar sur le frame.
		this.setJMenuBar(menuBar);
		
		lecteur = new LecteurXML();
	}
	
	public static void main(String[] args) {
		Fenetre F = new Fenetre();
		F.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(tabMatieres))
		{
			System.out.println("La table de matieres");
			VisiteurTable v = new VisiteurTable();
			lecteur.getLivre().accept(v);
			htmlPage.setText(v.gethtmlPage());
			toolPanel.add(htmlPage);
			this.add(toolPanel);
		}
		else if(e.getSource().equals(livreEntier))
		{
			System.out.println("Le Livre entier!");
			VisitreLivreComplet v = new VisitreLivreComplet();
			lecteur.getLivre().accept(v);
			htmlPage.setText(v.gethtmlPage());
			toolPanel.add(htmlPage);
			this.add(toolPanel);
		}
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource().equals(fichier))
		{
			System.out.println("Filechooser");
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("/Users/vincentgosselin/Desktop"));
			int returnVal = chooser.showOpenDialog(getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION){
				System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
				
				//Lire fichier XML
				try {
					lecteur.lireFichier(chooser.getSelectedFile());
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				htmlPage.setText("<h1>Le fichier est charge dans JAVA!</h1>");
				toolPanel.add(htmlPage);
				this.add(toolPanel);
			}
		
		}
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}
}
