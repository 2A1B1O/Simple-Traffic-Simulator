import java.io.Serializable;

public class Line implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x,y,x1,y1;
	private double distance;

public Line(int x, int y, int x1, int y1) {
	super();
	this.x = x;
	this.y = y;
	this.x1 = x1;
	this.y1 = y1;
}
public Line(){}
public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public int getX1() {
	return x1;
}

public void setX1(int x1) {
	this.x1 = x1;
}

public int getY1() {
	return y1;
}

public void setY1(int y1) {
	this.y1 = y1;
}
	public void setDistance(int x1, int y1, int x2, int y2, double distance) {
		distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public double getDistance() {
		return distance;
	}
}


