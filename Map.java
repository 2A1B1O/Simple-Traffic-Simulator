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
	//arrayin sadece so eleman� de�il, istenilen eleman� silinmeli . arada bo�luklar kalabilir mi ?
	//�yleyse i�ine ald��� eleman� arraylistte bulmak i�in �nce search yap�p sonra silicek? di�erleriyle Tart��.
}
public void RemoveRoundabout(){
	
}
public void RemoveNode(){
	
}

}
