import java.util.ArrayList;
import java.lang.Math;

public class Roundabout {
	private int capacity;
	private double density;
	private int numberOfTrafficLights;
	private double traficConstant;
	private int totalBackwards;
    private double power;
    private int totalForward;
    private int forwardCounter=0;

	Circle location = new Circle();

	private ArrayList<node> forwardNode = new ArrayList<node>();
	private ArrayList<node> backwardNode = new ArrayList<node>();

	public Roundabout(int Capacity, double Density) // constructor
	{
		capacity = Capacity;
		density = Density;
		

	}

	public void setCapacity(int newCapacity) {
		capacity = newCapacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setDensity(double newDensity) {
		density = newDensity;
	}

	public double getDensity() {

		return density;
	}
	
	public void setForwardNode(node a)
	{
		forwardNode.add(a);
	}
	public void setBackwardNode(node b)
	{
		backwardNode.add(b);
		
	}
	public ArrayList<node> getForwardNode()
	{
		return forwardNode;
	}
	public ArrayList<node> getBackwardNode()
	{
		return backwardNode;
	}
	

	public void addtrafficlights(int x) {
		numberOfTrafficLights = x;

	}

	public void calculateTraffic() {
		for (int i = 0; i <= backwardNode.size(); i++) {
			totalBackwards = +backwardNode.get(i).getNumberOfCars();
		}
		for (int k = 0; k <= forwardNode.size();k++) {
			forwardCounter++;
		}
         density = totalBackwards / forwardCounter;
		if (numberOfTrafficLights == 0) {
			traficConstant = density / capacity;
		} else {
			power = Math.pow(1.25, numberOfTrafficLights);
			traficConstant = density / capacity * power;
		}
		totalBackwards = totalForward;
	}

	public double getTrafficConstant() {
		return traficConstant;
	}

}
