package WindowBuilderTest;

import java.util.ArrayList;

public class Station {

	private char id;
	private boolean checked;
	private ArrayList<Bus> bus;
	
	public Station(char id) {
		this.id = id;
		this.checked = true;
		this.bus = new ArrayList<>();
	}

	public char getID() {
		return this.id;
	}
	
	public void setID(char id) {
		this.id = id;
	}
	
	public void addBus(Bus b) {
		this.bus.add(b);
	}
	
	public ArrayList<Bus> getBus(){
		return this.bus;
	}
	
	public boolean estDejaVisite() {
		return this.checked; 
	}
	
	
}
