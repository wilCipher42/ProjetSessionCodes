package WindowBuilderTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.ImageIcon;

/* classe Bus
 * qui va afficher le numero du bus et son horaire prevu
 */

public class Bus {

	Random rand = new Random();

	protected int id;
	protected int countedRedBus;
	protected Horaire horairePrevu;
	protected Horaire horaireReel;
	protected boolean estDispo;
	protected boolean respDriver;

	public Bus(int id) {
		this.id = id;
		this.countedRedBus = 0;
		this.horairePrevu = new Horaire(rand.nextInt(0,23),rand.nextInt(0,59));
		this.horaireReel = new Horaire(0,0);
		this.estDispo = true;
		this.respDriver = true;

	}

	public int getID() {
		return this.id;
	}

	public String getHorairePrevu() {	//pour afficher l'horaire de depart prevu du bus
		return String.format("%02d",this.horairePrevu.getHeures())+":"+
		String.format("%02d",this.horairePrevu.getMinutes())+" - "+"Bus "+this.id;
	}

	public String getHoraireReel() {
		return this.horaireReel.getHeures()+":"+this.horaireReel.getMinutes();

	}

	public void setHorairePrevu(int h, int m) {
		this.horairePrevu.heures = h;
		this.horairePrevu.minutes = m;
	}

	public void setHoraireReel(int h, int m) {
		this.horaireReel.heures = h;
		this.horaireReel.minutes = m;
	}

	public boolean estDisponible() {

		/* 
		 * Cette methode va générer aleatoirement la reponse du chauffeur
		 * à savoir si le bus est plein ou pas. True=il y a de la place
		 * false = pas de place
		 * Ensuite on met à jour la variable respDriver du resultat
		 */



		//boolean response = rand.nextBoolean();
		this.respDriver = rand.nextBoolean();

		if(!this.respDriver)
			this.estDispo = false;

		return respDriver;
	}
	
	/*Methode qui retourne une icone de bus. Si le bus est plein, ce sera une
	 * icone rouge. Si non, ce sera une icone verte 
	 */
	public static ImageIcon iconBus(Bus b) {
		ImageIcon iconVert = new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_vert.png");
		ImageIcon iconRouge = new ImageIcon("/Users/macbookpro/Library/CloudStorage/OneDrive-UniversitéduQuébecenOutaouais/UQO/Session 2/INF1573-01 Programmation II/ProjetSession_Codes/Icons/autobus_rouge.png");

		if(b.estDisponible())
			return iconVert;
		else {
			return iconRouge;
		}
	}
	
}
