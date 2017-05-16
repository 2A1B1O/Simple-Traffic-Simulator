
public class Line {
	Dot startDot = new Dot();
	Dot finishDot= new Dot();
	
    public	Line() {
		
	}
    public void SetstartDot(Dot At) {
    	startDot=At;
    }
    public Dot GetstartDot() {
    	return startDot;
    }
    public void SetfinishDot(Dot At) {
    	finishDot=At;
    }
    public Dot GetfinishDot() {
    	return finishDot;
    }
}
