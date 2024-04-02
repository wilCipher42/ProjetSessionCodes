package WindowBuilderTest;

import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReseauRoutier {

	static Random rand = new Random();

	protected ArrayList<Station> stations;
	protected ArrayList<Trajet> trajets;
	protected String incident;
	protected IncidentParcours incidents;
	protected int normalDist; 	//va nous servir a calculer la distance normale entre 2 stations
	
	protected int maxDistance = Integer.MIN_VALUE;
    protected LinkedList<Station> longestPath = new LinkedList<>();

	public ReseauRoutier() {
		this.stations = new ArrayList<>();
		this.trajets = new ArrayList<>();
		this.incidents = new IncidentParcours();
		this.normalDist = 0;
	}

	public void addStation(Station station) {
		this.stations.add(station);
	}

	public void addRoute(Trajet trajet) {
		this.trajets.add(trajet);
	}

	public ArrayList<Trajet> getRoute() {
		return this.trajets;
	}

	//algo de Dijkstra qui retourne la distance minimale
	public int shortestPath(Station start, Station end) {
		Map<Station, Integer> distanceMap = new HashMap<>();
		Map<Station, Station> predecessorMap = new HashMap<>();
		PriorityQueue<Station> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));

		// Initialisation des distances
		for (Station station : stations) {
			distanceMap.put(station, station == start ? 0 : Integer.MAX_VALUE);
			if (station == start) priorityQueue.add(station);
		}

		while (!priorityQueue.isEmpty()) {
			Station currentStation = priorityQueue.poll();
			if (currentStation == end) break; // Arrêter lorsque la destination est atteinte

			for (Trajet trajet : trajets) {
				if (trajet.startStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.endStation)) {
						distanceMap.put(trajet.endStation, newDistance);
						predecessorMap.put(trajet.endStation, currentStation);
						priorityQueue.add(trajet.endStation);
					}
				} else if (trajet.endStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.startStation)) {
						distanceMap.put(trajet.startStation, newDistance);
						predecessorMap.put(trajet.startStation, currentStation);
						priorityQueue.add(trajet.startStation);
					}
				}
			}
		}

		// Reconstitution du chemin
		ArrayList<Station> path = new ArrayList<>();
		Station current = end;
		while (current != null) {
			path.add(current);
			current = predecessorMap.get(current);
		}
		Collections.reverse(path);

		// System.out.println("Chemin le plus court : " );

		// for (var e: path){
		//   System.out.print(e.getID() + "----->");
		//}

		// Retourne la distance minimale
		return distanceMap.get(end);
	}

	public String findPathAsString(Station start, Station end) {
	    Map<Station, Station> predecessorMap = new HashMap<>();
	    Map<Station, Integer> distanceFromStart = new HashMap<>();
	    Queue<Station> queue = new LinkedList<>();
	    Set<Station> visited = new HashSet<>();

	    queue.add(start);
	    visited.add(start);
	    distanceFromStart.put(start, 0);

	    boolean pathFound = false;
	    while (!queue.isEmpty() && !pathFound) {
	        Station current = queue.poll();
	        if (current.equals(end)) {
	            pathFound = true;
	            break;
	        }

	        for (Trajet trajet : trajets) {
	            Station neighbor = null;
	            int distanceToAdd = 0;
	            if (trajet.startStation.equals(current)) {
	                neighbor = trajet.endStation;
	                distanceToAdd = trajet.distance;
	            } else if (trajet.endStation.equals(current)) {
	                neighbor = trajet.startStation;
	                distanceToAdd = trajet.distance;
	            }

	            if (neighbor != null && !visited.contains(neighbor)) {
	                visited.add(neighbor);
	                queue.add(neighbor);
	                predecessorMap.put(neighbor, current);
	                int currentDistance = distanceFromStart.get(current) + distanceToAdd;
	                distanceFromStart.put(neighbor, currentDistance);
	            }
	        }
	    }

	    if (!pathFound) {
	        this.normalDist = 0; // ou une autre valeur indiquant qu'aucun chemin n'a été trouvé
	        return "Aucun chemin trouvé.";
	    }

	    // Reconstitution du chemin et calcul de la distance totale
	    LinkedList<Station> path = new LinkedList<>();
	    for (Station at = end; at != null; at = predecessorMap.get(at)) {
	        path.addFirst(at);
	    }
	    this.normalDist = distanceFromStart.get(end); // Affectation de la distance calculée

	    // Construction de la chaîne de caractères pour l'itinéraire
	    StringBuilder pathBuilder = new StringBuilder();
	    boolean isFirst = true;
	    for (Station station : path) {
	        if (!isFirst) {
	            pathBuilder.append(" -----> ");
	        } else {
	            isFirst = false;
	        }
	        pathBuilder.append(station.getID());
	    }

	    // Inclure la distance totale dans le résultat final
	    //pathBuilder.append("\nDistance totale: ").append(this.normalDist).append(" unités");

	    return pathBuilder.toString();
	}


	
	/*On réutilise l'algo de Djistra mais cette fois-ci, pour retourner
	 * l'itinéraire comme des chaines de caracteres 
	 */
	public String shortPath(Station start, Station end) {
		Map<Station, Integer> distanceMap = new HashMap<>();
		Map<Station, Station> predecessorMap = new HashMap<>();
		PriorityQueue<Station> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));

		// Initialisation des distances
		for (Station station : stations) {
			distanceMap.put(station, station == start ? 0 : Integer.MAX_VALUE);
			if (station == start) priorityQueue.add(station);
		}

		while (!priorityQueue.isEmpty()) {
			Station currentStation = priorityQueue.poll();
			if (currentStation == end) break; // Arrêter lorsque la destination est atteinte

			for (Trajet trajet : trajets) {
				if (trajet.startStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.endStation)) {
						distanceMap.put(trajet.endStation, newDistance);
						predecessorMap.put(trajet.endStation, currentStation);
						priorityQueue.add(trajet.endStation);
					}
				} else if (trajet.endStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.startStation)) {
						distanceMap.put(trajet.startStation, newDistance);
						predecessorMap.put(trajet.startStation, currentStation);
						priorityQueue.add(trajet.startStation);
					}
				}
			}
		}

		// Reconstitution du chemin
		ArrayList<Station> path = new ArrayList<>();
		Station current = end;
		while (current != null) {
			path.add(current);
			current = predecessorMap.get(current);
		}
		Collections.reverse(path);

		// System.out.println("Chemin le plus court : " );
		String schema="";


		StringBuilder simplePathBuilder = new StringBuilder();
		StringBuilder detailedPathBuilder = new StringBuilder();
		boolean isFirst = true;

		// Construire d'abord la chaîne simple des noms des stations.
		for (Station e : path) {
			if (!isFirst) {
				simplePathBuilder.append(" -----> ");
			}
			simplePathBuilder.append(e.getID());
			isFirst = false;
		}

		// Réinitialiser isFirst pour le détail des stations et des bus.
		isFirst = true;

		// Ajouter ensuite les détails pour chaque station, sauf la dernière.
		for (int index = 0; index < path.size() - 1; index++) {
			Station e = path.get(index);
			if (!isFirst) {
				detailedPathBuilder.append(" -----> ");
			}
			detailedPathBuilder.append("Station ").append(e.getID()).append(": Prendre bus ");
			if (!e.getBus().isEmpty()) {
				for (int i = 0; i < e.getBus().size(); i++) {
					if (i > 0) {
						detailedPathBuilder.append(", ");
					}
					detailedPathBuilder.append("b").append(e.getBus().get(i).getID());
				}
			} else {
				// Si aucune info de bus, juste terminer la phrase.
				detailedPathBuilder.append("aucun bus disponible");
			}
			isFirst = false;
		}

		// Ajouter la dernière station sans détail de bus.
		if (path.size() > 0 && !isFirst) {
			detailedPathBuilder.append(" -----> ");
		}
		if (path.size() > 0) {
			Station lastStation = path.get(path.size() - 1);
			detailedPathBuilder.append("Station ").append(lastStation.getID());
		}

		// Afficher d'abord la chaîne simple des noms des stations. Et ensuite les differents bus
		schema = simplePathBuilder.toString()+"\n"+detailedPathBuilder.toString();


		/* Retourne l'itinéraire de la station de depart
		 * a la station d'arrivé en chaines de caractères
		 * Et aussi les bus qu'on doit prendre
		 */
		return schema;
	}

	//Cette version de Djistra va retourner la liste des stations qu'on va prendre
	public ArrayList<Station> stationPath(Station start, Station end) {
		Map<Station, Integer> distanceMap = new HashMap<>();
		Map<Station, Station> predecessorMap = new HashMap<>();
		PriorityQueue<Station> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distanceMap::get));

		// Initialisation des distances
		for (Station station : stations) {
			distanceMap.put(station, station == start ? 0 : Integer.MAX_VALUE);
			if (station == start) priorityQueue.add(station);
		}

		while (!priorityQueue.isEmpty()) {
			Station currentStation = priorityQueue.poll();
			if (currentStation == end) break; // Arrêter lorsque la destination est atteinte

			for (Trajet trajet : trajets) {
				if (trajet.startStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.endStation)) {
						distanceMap.put(trajet.endStation, newDistance);
						predecessorMap.put(trajet.endStation, currentStation);
						priorityQueue.add(trajet.endStation);
					}
				} else if (trajet.endStation == currentStation) {
					int newDistance = distanceMap.get(currentStation) + trajet.distance;
					if (newDistance < distanceMap.get(trajet.startStation)) {
						distanceMap.put(trajet.startStation, newDistance);
						predecessorMap.put(trajet.startStation, currentStation);
						priorityQueue.add(trajet.startStation);
					}
				}
			}
		}

		// Reconstitution du chemin
		ArrayList<Station> path = new ArrayList<>();
		Station current = end;
		while (current != null) {
			path.add(current);
			current = predecessorMap.get(current);
		}
		Collections.reverse(path);

		return path;
	}


	//cette methode va creer notre reseau routier entier
	public void listeTrajets() {
		//Creer des stations et les ajouter a notre reseau routier
		this.addStation(new Station('A'));
		this.addStation(new Station('B'));
		this.addStation(new Station('C'));
		this.addStation(new Station('D'));
		this.addStation(new Station('E'));
		this.addStation(new Station('F'));
		this.addStation(new Station('G'));

		//Creer des bus qu'on va assigner a differentes stations
		Bus b1 = new Bus(1);
		Bus b2 = new Bus(2);
		Bus b3 = new Bus(3);
		Bus b4 = new Bus(4);
		Bus b5 = new Bus(5);
		Bus b6 = new Bus(6);
		Bus b7 = new Bus(7);
		


		/* Assigner les bus aux stations
		 * Les stations vont de A-G : 0-6
		 */
		this.stations.get(0).addBus(b1);//A

		this.stations.get(1).addBus(b1);	//station B
		this.stations.get(1).addBus(b2);

		this.stations.get(2).addBus(b3);

		this.stations.get(3).addBus(b4);
		this.stations.get(3).addBus(b1);

		this.stations.get(4).addBus(b5);

		this.stations.get(5).addBus(b2);
		//this.stations.get(5).addBus(b6);

		this.stations.get(6).addBus(b6);
		


		//On créé des routes(ou trajets) et on les ajoute à notre reseau routier
		this.addRoute(new Trajet(this.stations.get(0),this.stations.get(1),rand.nextInt(5,50)));  //position 0: uqo-galerieHull
		/*this.addRoute(new Trajet(this.stations.get(0),this.stations.get(2),rand.nextInt(5,50)));  //position 1: uqo-Rideau
    	this.addRoute(new Trajet(this.stations.get(0),this.stations.get(3),rand.nextInt(5,50)));
    	this.addRoute(new Trajet(this.stations.get(0),this.stations.get(4),rand.nextInt(5,50)));
    	this.addRoute(new Trajet(this.stations.get(0),this.stations.get(5),rand.nextInt(5,50)));
		 */
		this.addRoute(new Trajet(this.stations.get(1),this.stations.get(2),rand.nextInt(5,50)));
		this.addRoute(new Trajet(this.stations.get(1),this.stations.get(3),rand.nextInt(5,50)));
		this.addRoute(new Trajet(this.stations.get(1),this.stations.get(4),rand.nextInt(5,50)));
		//this.addRoute(new Trajet(this.stations.get(1),this.stations.get(5),rand.nextInt(5,50)));  //position 2: 

		this.addRoute(new Trajet(this.stations.get(2),this.stations.get(5),rand.nextInt(5,50))); //C - F
		this.addRoute(new Trajet(this.stations.get(3),this.stations.get(5),rand.nextInt(5,50))); //C - F

		this.addRoute(new Trajet(this.stations.get(6),this.stations.get(3),rand.nextInt(5,50))); //C - F
		/*this.addRoute(new Trajet(this.stations.get(2),this.stations.get(3),rand.nextInt(5,50)));
    	this.addRoute(new Trajet(this.stations.get(3),this.stations.get(4),rand.nextInt(5,50)));
    	this.addRoute(new Trajet(this.stations.get(5),this.stations.get(4),rand.nextInt(5,50)));
		 */

	}


	//cette methode va retourner les horaires des bus du trajet
	public String busItinarySchedule(Station st, Station s) {
		// Présumons que shortPath retourne une ArrayList<Station> de l'itinéraire
		ArrayList<Station> itinerary = stationPath(st,s);
		HashSet<Bus> processedBuses = new HashSet<>(); // Pour garder une trace des bus déjà traités
		StringBuilder horaires = new StringBuilder();
		String test = "";

		// Utilisation d'une boucle for classique pour avoir l'index de la station
		for (int index = 0; index < itinerary.size(); index++) {
			Station station = itinerary.get(index);
			// Vérifie si la station actuelle n'est pas la dernière
			if (index < itinerary.size() - 1) {
				for (Bus bus : station.getBus()) {
					// Vérifie si le bus a déjà été traité
					if (!processedBuses.contains(bus)) {
						processedBuses.add(bus);
						// Ajoute l'horaire du bus à la chaîne si ce n'est pas déjà fait
						if (horaires.length() > 0) 
							horaires.append("\n"); // Pour séparer les horaires s'il y en a plusieurs
						horaires.append(bus.getHorairePrevu());
						
						incident = this.incidents.situationTraffic(bus);
					}
				}
			}
		}

		// Affiche les horaires des bus pour l'itinéraire
		return horaires.toString();

	}

	
	//ma fonction main pour mes tests
	public static void main(String[] args) {
		ReseauRoutier reseau = new ReseauRoutier();
    	reseau.listeTrajets();

		//int shortestDistance = reseau.shortestPath(reseau.stations.get(0), reseau.stations.get(5));
		//pour tester la sortie des bus par station
		ArrayList<Bus> listes = new ArrayList<>();
		listes = reseau.stations.get(0).getBus();
		for(int i =0; i<listes.size(); i++) {
			System.out.println(reseau.stations.get(0).getID()+":"+listes.get(i).getID());
		}
		 

	}
}