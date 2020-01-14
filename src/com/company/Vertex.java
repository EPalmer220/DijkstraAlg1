package com.company;

public class Vertex {
    private String name;
    private double weightFromStart;
    private double weight;
    private Vertex previous;

    public Vertex(String name, double weight, Vertex previous){
        this.name = name;
        this. weight = weight;
        this.previous = previous;
    }


}
