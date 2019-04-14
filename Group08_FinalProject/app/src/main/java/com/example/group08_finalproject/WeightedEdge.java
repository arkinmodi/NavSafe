package com.example.group08_finalproject;

/**
 * Weighted edge ADT. An edge is defined as a path between two adjacent intersections.
 * The weight is determined by the accumulation of severity indices from collisions that occurred
 * on the path.
 */
public class WeightedEdge{
    private final Intersection firstIntersection;
    private final Intersection secondIntersection;
    private final int weight;

    /**
     * Constructor for a weighted edge
     * 
     * @param first - first intersection
     * @param second - second intersection connected to the first intersection
     * @param weight - weight of the edge
     */
    public WeightedEdge(Intersection first, Intersection second, int weight)
    {
        this.firstIntersection = first;
        this.secondIntersection = second;
        this.weight = weight;
    }

    public Intersection getFirstIntersection(){
        return firstIntersection;
    }

    public Intersection getSecondIntersection(){
        return secondIntersection;
    }

    public int getWeight(){
        return weight;
    }
}