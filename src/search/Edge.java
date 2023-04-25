package search;
import java.util.ArrayList;

public class Edge  implements Comparable<Edge> {
	String edgeName;
	Node start;
	Node end;
	Integer weight;

	static String setName;
	static ArrayList<Edge> bestEdges = graphSearchWeights.bestEdges;
	static ArrayList<Edge> theseEdges = graphSearchWeights.theseEdges;
	static ArrayList<Edge> edgesToSort = graphSearchWeights.edgesToSort;


public Edge(String edgeName, Node start, Node end, Integer weight) {
	this.edgeName = edgeName;
	this.start = start;
	this.end = end;
	this.weight = weight;
}


public  int getWeight(Edge edge) {
	return edge.weight;
}


@Override
	public int compareTo(Edge e){
		if (this.weight > e.weight) {  // you're comparing the Edges by the 'weight'
		  return 1;
		}
		else if (this.weight == e.weight){
		  return 0;
		}
		else {
		  return -1;
		}
	}

	public static void displayEdgeList(ArrayList<Edge> set) {
		setName = "";
		setName = getEdgeListName(set);
		System.out.print(setName + ":");
		if (set.size() > 0) {
			for (int i = 0; i < set.size(); i++) {
				System.out.print(" " + set.get(i).edgeName + ", weight: " + set.get(i).weight + ",");
			}
		} else {
			System.out.print(" empty");
		}
		System.out.println("");
	}

	public static String getEdgeListName(ArrayList<Edge> edgeList) {
		String listName = "";
		if (edgeList == bestEdges) {
			listName = "BestEdges";
		} else if (edgeList == theseEdges) {
			listName = "TheseEdges";
		} else if (edgeList == edgesToSort) {
			listName = "EdgesToSort";
		} else {
			listName = "Untitled List";
		}
		return listName;
	}
}
	
