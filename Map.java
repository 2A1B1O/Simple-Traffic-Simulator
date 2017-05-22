import java.io.Serializable;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class Map implements Serializable {
	private ArrayList<node> MyNodes = new ArrayList();
	public ArrayList<node> getMyNodes() {
		return MyNodes;
	}

	public void setMyNodes(ArrayList<node> myNodes) {
		MyNodes = myNodes;
	}

	public ArrayList<Roundabout> getMyRoundabouts() {
		return MyRoundabouts;
	}

	public void setMyRoundabouts(ArrayList<Roundabout> myRoundabouts) {
		MyRoundabouts = myRoundabouts;
	}

	private ArrayList<Road> MyRoads = new ArrayList();
	private ArrayList<Roundabout> MyRoundabouts = new ArrayList();
	private static final long serialVersionUID = 1L;

	public ArrayList<Road> getMyRoads() {
		return MyRoads;
	}

	public void setMyRoads(ArrayList<Road> myRoads) {
		MyRoads = myRoads;
	}

	

	public Map() {

	}

	public void AddRoad(Road r) {
		MyRoads.add(r);
	}

	public void AddRoundabout(Roundabout r) {
		MyRoundabouts.add(r);
	}

	public void AddNode(node n) {
		MyNodes.add(n);
	}

	public void RemoveRoad() {
		
	}

	public void RemoveRoundabout() {

	}

	public void RemoveNode() {

	}

}

}
