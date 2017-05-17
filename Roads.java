public class Road {
	private int numofLanes;
	private int lenght;
	private int capacity;
	private int trafficLights;
	private double traficConstant;
	private double at;
	private int backCap;
	private int forwardCap;
	public node backNode = new node();
	public node forwardNode = new node();
	Line line1 = new Line();

	public Road() {
		backCap = backNode.getNumberOfCars();
		forwardCap = forwardNode.getNumberOfCars();
		backCap = forwardCap;
	}

	public void setNumofLanes(int x) {
		x = numofLanes;
	}

	public void setLenght(int y) {
		y = lenght;
	}

	public int getNumofLanes() {
		return numofLanes;
	}

	public int getLenght() {
		return lenght;
	}

	public void addTrafficLights(int k) {
		k = trafficLights;
	}

	public void setCapacity() {
		capacity = numofLanes * lenght;
	}

	public int getCapacity() {

		return capacity;
	}

	public void calculateTraffic() {
		if (trafficLights == 0) {
			traficConstant = backCap / capacity;

		} else {
			at = Math.pow(1.25, trafficLights);
			traficConstant = backCap / capacity * at;

		}
	}

	public double getTrafficConstant() {
		return traficConstant;
	}
}
