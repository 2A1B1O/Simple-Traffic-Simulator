
public class Roads {
   private	int numofLanes;
   private   int lenght;
   private	int Capacity;
   private  int trafficlights;
   private double traficconstant;
   private double at;
 public	node backnode = new node();
 public node forwardnode = new node();
	
	public Roads(){
		
	}
	public void setnumofLanes(int x) {
		x=numofLanes;
	}
	public void setlenght(int y){
		y=lenght;
	}
   public int getnumofLanes(){
	   return numofLanes;
   }
   public int getlenght(){
	   return lenght;
   }
   public void addtrafficlights(int k) {
	   k=trafficlights;
   }
   public int  getcapacity(){
	   Capacity=numofLanes*lenght;
	   return Capacity;
   }
   public  double calculatetraffic() {
	   if(trafficlights==0) {
		   traficconstant = backnode.numberOfCars/Capacity;
		   return traficconstant;
	   }
	   else { 
		   at=Math.pow(1.25,trafficlights);
		   traficconstant = backnode.numberOfCars/Capacity*at;
		   
	   }
   }
}
