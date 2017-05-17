import java.io.Serializable;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class Map implements Serializable{
private ArrayList <node> MyNodes= new ArrayList();
private ArrayList <Road> MyRoads= new ArrayList();
private static final long serialVersionUID = 1L;
public ArrayList<Road> getMyRoads() {
	return MyRoads;
}
public void setMyRoads(ArrayList<Road> myRoads) {
	MyRoads = myRoads;
}
private ArrayList <Roundabout> MyRoundabouts= new ArrayList();

public Map(){
	
}
public void  AddRoad(Road r){
	MyRoads.add(r);
}
public void AddRoundabout(Roundabout r){
	MyRoundabouts.add(r);
}
public void  AddNode(node n){
	MyNodes.add(n);
}
public void RemoveRoad(){
	//arrayin sadece so elemaný deðil, istenilen elemaný silinmeli . arada boþluklar kalabilir mi ?
	//öyleyse içine aldýðý elemaný arraylistte bulmak için önce search yapýp sonra silicek? diðerleriyle Tartýþ.
}
public void RemoveRoundabout(){
	
}
public void RemoveNode(){
	
}

}
