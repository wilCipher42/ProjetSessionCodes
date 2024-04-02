package WindowBuilderTest;

/* class Horaire qui servira de modele d'heures et 
 * de minutes
 */

public class Horaire {
	
	protected int heures;
	protected int minutes;

	public Horaire(int h, int m) {
		this.heures = h;
		this.minutes = m;
	}
	
	public int getHeures() {
		return this.heures;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public String getHoraire() {
		return this.heures+":"+this.minutes;
	}

}
