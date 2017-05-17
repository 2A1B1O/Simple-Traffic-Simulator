public class Road {
	private int numofLanes;
	private int lenght;
	private int Capacity;
	private int trafficlights;
	private double traficconstant;
	private double at;
	private int backcap;
	private int forwardcap;
	public node backnode = new node();
	public node forwardnode = new node();
	Line line1 = new Line();

	public Road() {
		backcap = backnode.getNumberOfCars();
		forwardcap = forwardnode.getNumberOfCars();
		backcap = forwardcap;
	}

	public void setnumofLanes(int x) {
		x = numofLanes;
	}

	public void setlenght(int y) {
		y = lenght;
	}

	public int getnumofLanes() {
		return numofLanes;
	}

	public int getlenght() {
		return lenght;
	}

	public void addtrafficlights(int k) {
		k = trafficlights;
	}

	public void setcapacity() {
		Capacity = numofLanes * lenght;
	}

	public int getcapacity() {

		return Capacity;
	}

	public void calculatetraffic() {
		if (trafficlights == 0) {
			traficconstant = backcap / Capacity;

		} else {
			at = Math.pow(1.25, trafficlights);
			traficconstant = backcap / Capacity * at;

		}
	}

	public double gettrafficconstant() {
		return traficconstant;
	}
}
