
import java.io.Serializable;

public class Circle implements Serializable{
	// g.fillOval(x - radius, y - radius, diameter, diameter); bu fonksiyona
	// göre ayarlandı
	int x;
	int y;
	Dot center = new Dot();
	public Dot getCenter() {
		return center;
	}

	public void setCenter(Dot center) {
		this.center = center;
	}

	Line radius = new Line();
	double r;
	double diameter;

	Circle() {
		x = center.getX();
		y = center.getY();

	}

	public void SetR() {
		r = radius.getDistance();
	}

	public void SetDiameter() {
		diameter = r * 2;

	}

	public double getR() {
		return r;
	}

	public double getDiameter() {
		return diameter;
	}

}
