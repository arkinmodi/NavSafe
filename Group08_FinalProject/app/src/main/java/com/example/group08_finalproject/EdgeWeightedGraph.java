package com.example.group08_finalproject;

import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Edge weighted graph for the intersections and edges (roads) in Seattle.
 */
public class EdgeWeightedGraph{
    private int numIntersections;
    private int numEdges;
    private HashMap<Intersection, ArrayList<WeightedEdge>> adj;

    /**
     * Constructor for an edge weighted graph - intersections not connected
     * 
     * @param numIntersections - number of intersections
     */
    public EdgeWeightedGraph(int numIntersections)
    {
        if(numIntersections < 0){
            throw new IllegalArgumentException("Number of intersections must be positive");
        }
        this.numIntersections = numIntersections;
        this.numEdges = 0;
        this.adj = new HashMap<Intersection, ArrayList<WeightedEdge>>();
    }

    /**
     * Get number of intersections in the graph
     * 
     * @return numIntersections - number of intersections in graph
     */
    public int getNumIntersections(){
        return numIntersections;
    }

    /**
     * Get number of edges in the graph
     * 
     * @return numEdges - number of edges in graph
     */
    public int getNumEdges(){
        return numEdges;
    }

    /**
     * Create a weighted edge from two intersections to add to the graph
     * 
     * @param x - first intersection
     * @param y - second intersection
     * @throws IOException
     */
    public void addEdge(Intersection x, Intersection y) throws IOException{
        //determine the weight of the edge
        int weight = SearchCollision.search(x, y);
        //create edge
        WeightedEdge e = new WeightedEdge(x, y, weight);
        //get the linked list of edges of intersection x
        ArrayList<WeightedEdge> edges = adj.get(x);
        //if there is no associated array list with the intersection, make one
        if(edges == null){
            edges = new ArrayList<WeightedEdge>();
        }
        //add edge to list
        edges.add(e);
        //overwrite the linked list associated with intersection x
        adj.put(x, edges);
        
        //perform same actions to intersection y
        edges = adj.get(y);
        // if there is no associated array list with the intersection, make one
        if (edges == null) {
            edges = new ArrayList<WeightedEdge>();
        }
        edges.add(e);
        adj.put(y, edges);
        
        //increment number of edges by 1
        numEdges++;
    }

    /**
     * Add edges given the two intersections and their weight
     *
     * @param x - first intersection
     * @param y - second intersection
     * @param weight - weight of edge
     */
    public void addEdge(Intersection x, Intersection y, int weight){
        // create edge
        WeightedEdge e = new WeightedEdge(x, y, weight);
        // get the linked list of edges of intersection x
        ArrayList<WeightedEdge> edges = adj.get(x);
        // if there is no associated array list with the intersection, make one
        if (edges == null) {
            edges = new ArrayList<WeightedEdge>();
        }
        // add edge to list
        edges.add(e);
        // overwrite the linked list associated with intersection x
        adj.put(x, edges);

        // perform same actions to intersection y
        edges = adj.get(y);
        // if there is no associated array list with the intersection, make one
        if (edges == null) {
            edges = new ArrayList<WeightedEdge>();
        }
        edges.add(e);
        adj.put(y, edges);

        // increment number of edges by 1
        numEdges++;
    }
    /**
     * Get linked list of weighted edges that are connected to intersection x
     * @param x - intersection in question
     * @return array list of weighted edges connected to x
     */
    public ArrayList<WeightedEdge> adj(Intersection x){
        return adj.get(x);
    }

    /**
     * Write the graph to a given file name
     * 
     * @param fileName - file name to write to
     * @throws IOException
     */
    public void writeGraph(String fileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        /**
         * format of each line: 
         * intersection 1 x/y coordinates,
         * intersection 1 unit desc, 
         * intersection 2 x/y
         * intersection 2 unit desc,
         * edge weight
         */
        for(ArrayList<WeightedEdge> arr: adj.values()){
            for(WeightedEdge w: arr){
                // x coordinate of first intersection
                writer.write(Float.toString(w.getFirstIntersection().getXCoord()));
                writer.write(", ");
                // y coordinate of first intersection
                writer.write(Float.toString(w.getFirstIntersection().getYCoord()));
                writer.write(", ");
                // description of first intersection
                writer.write(w.getFirstIntersection().getUnitDesc());
                writer.write(", ");
                // x coordinate of second intersection
                writer.write(Float.toString(w.getSecondIntersection().getXCoord()));
                writer.write(", ");
                // y coordinate of second intersection
                writer.write(Float.toString(w.getSecondIntersection().getYCoord()));
                writer.write(", ");
                // description of second intersection
                writer.write(w.getSecondIntersection().getUnitDesc());
                writer.write(", ");
                // weight of edge
                writer.write(w.getWeight());
                writer.newLine();
            }
        }
        writer.close();
    }
}