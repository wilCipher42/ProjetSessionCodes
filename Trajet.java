package WindowBuilderTest;

public class Trajet {
    Station startStation;
    Station endStation;
    int distance;

    public Trajet(Station startStation, Station endStation, int distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }
    /*
    public String getDistance() {
    	return "Station de depart: "+this.startStation.getID()+"; "+"Station d'arrivé: "+this.endStation.getID()+"; distance: "+this.distance+" km";
    }
    */
    public int getDistance() {
    	return this.distance;
    }
    
    public Station getStartStation() {
    	return this.startStation;
    }
    public Station getEndStation() {
    	return this.endStation;
    }
}

