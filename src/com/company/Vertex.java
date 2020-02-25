package com.company;

import java.util.*;

public class Vertex {

    private String name;
    private double shortestWeightFromStart;
    private double shortestTotalWeight;
    private Vertex previous;
    public static HashMap<String, Vertex> listOfVertexes = new HashMap<>();

    public Vertex(String name){
        this.name = name;
        this.shortestWeightFromStart = Double.POSITIVE_INFINITY;
        this.shortestTotalWeight = Double.POSITIVE_INFINITY;
        listOfVertexes.put(name, this);
    }


    public Vertex(String name, double weight, Vertex previous){
        this.name = name;
        this.shortestWeightFromStart = Double.POSITIVE_INFINITY;
        this.shortestTotalWeight = Double.POSITIVE_INFINITY;
        this.previous = previous;
        listOfVertexes.put(name, this);
    }

    public static void showListOfVertexes(){
        Set entrySet = listOfVertexes.entrySet();
        Iterator iter = entrySet.iterator();

        while(iter.hasNext()){
            Map.Entry currentVertex = (Map.Entry)iter.next();
            System.out.println("Key is: "+currentVertex.getKey() +
                    " & " +
                    " value is: "+currentVertex.getValue());
        }
    }

    public static ArrayList<String> arrayListOfVertexes(){
        ArrayList<String> result = new ArrayList<String>();

        Set entrySet = listOfVertexes.entrySet();
        Iterator iter = entrySet.iterator();

        while(iter.hasNext()){
            Map.Entry currentVertex = (Map.Entry)iter.next();
            result.add((String) currentVertex.getKey());
        }

        return result;
    }

    public static Vertex getVertex(String name){
        return listOfVertexes.get(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightFromStart() {
        return shortestWeightFromStart;
    }

    public void setWeightFromStart(double shortestWeightFromStart) {
        this.shortestWeightFromStart = shortestWeightFromStart;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public double getShortestTotalWeight() {
        return shortestTotalWeight;
    }

    public void setShortestTotalWeight(double shortestTotalWeight) {
        this.shortestTotalWeight = shortestTotalWeight;
    }
}
