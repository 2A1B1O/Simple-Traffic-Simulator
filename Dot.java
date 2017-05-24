import java.io.Serializable;

public class Dot implements Serializable {
 private	int x;
 private	int y;
	
	
	public Dot() {
		
	}
	public void setX(int at) {
		x=at;
	}
    public int getX() {
    	return x;
    }
    public void setY(int at){
    	y=at;
    }
    public int getY() {
    	return y;
    }
}
