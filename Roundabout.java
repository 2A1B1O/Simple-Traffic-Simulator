import java.util.ArrayList;

public class Roundabout {
private int capacity;
private double x;
private double y;
private double radius;

private double density;
private int numberOfTrafficLights;

public ArrayList <node> forwardNode=new ArrayList<node>();
public ArrayList <node> backwardNode=new ArrayList<node>();
public void setCapacity(int newCapacity)
{
	capacity=newCapacity;
}
public int getCapacity()
{
	return capacity;
}

public double getDensity()
{
	
	return density;
}
public void setDensity(double newDensity)
{
	density=newDensity;
}
public void setX(double newX)
{
	x=newX;
}
public double getX()
{return x;
}
public void setY(double newY)
{
	y=newY;
	}
public double getY()
{
	return y;}
public void setRadius(double r)
{radius=r;
	}
public double getRadius()
{
	return radius;
	}
public Roundabout(int Capacity,double Density) //constructor
{
	capacity=Capacity;
	density=Density;
}
public void addtrafficlights(int x)
{
numberOfTrafficLights=x;

}
}
