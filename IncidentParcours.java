package WindowBuilderTest;

import java.util.Random;

public class IncidentParcours {

	
	enum etatTraffic {
		INITIAL,
		BAD_METEO,
		WORK_ON_ROAD,
		ISSUE_ON_ROAD,
	}
	
	protected etatTraffic etatTraffic;
	
	Random rand = new Random();
	
	public IncidentParcours() {
		this.etatTraffic = etatTraffic.INITIAL;
	}
	
	/*
	 * Méthodes pour gérer les horaires des bus, les incidents 
	 * sur le parcours et les conditions météorologiques. Et informer 
	 * les usagers en temps réel des conditions de circulation et des horaires de passage mis à jour.
	 */
	public String situationTraffic(Bus b) {	// pour indiquer la situation du traffic
		int i = rand.nextInt(4);
		
		switch(i) {
		case 1:
			this.etatTraffic = etatTraffic.BAD_METEO;
			b.horaireReel.minutes = b.horairePrevu.minutes+2;
			b.setHoraireReel(b.horairePrevu.heures, b.horaireReel.minutes);
			
			return "En raison des mauvaises conditions météo, le Bus "
					+b.id+" aura un retard de 10 min"; 
		
		case 2: 
			this.etatTraffic = etatTraffic.WORK_ON_ROAD;
			b.horaireReel.minutes = b.horairePrevu.minutes+2;
			b.setHoraireReel(b.horairePrevu.heures, b.horaireReel.minutes);
			
			return "Il y a des travaux sur la route, le bus "
					+b.id+" aura un retard de 20 min"; 

		case 3: 
			this.etatTraffic = etatTraffic.ISSUE_ON_ROAD;
			b.horaireReel.minutes = b.horairePrevu.minutes+2;
			b.setHoraireReel(b.horairePrevu.heures, b.horaireReel.minutes);
			
			return "Il y a eu un accident sur la route, le bus "
					+b.id+" aura un retard de 30 min"; 

		default:
			this.etatTraffic = etatTraffic.INITIAL;
			return "Il n'y a présentement aucun incident sur la route ::)";
						
		}
	
	}

}
