package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public boolean addVertex(String vertex){
        if(!adjList.containsKey(vertex)){
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2){
        if( adjList.containsKey(vertex1) && adjList.containsKey(vertex2)){
            if(!adjList.get(vertex1).contains(vertex2) && !adjList.get(vertex2).contains(vertex1)){
                adjList.get(vertex1).add(vertex2);
                adjList.get(vertex2).add(vertex1);
                return true;
            }
        }
        return false;
    }

    public boolean removeVertex(String vertex){
        if(adjList.containsKey(vertex)){
            for(String otherVertex : adjList.get(vertex)){
                adjList.get(otherVertex).remove(vertex);
            }
            adjList.remove(vertex);
            return true;
        }
        return false;
    }
}
