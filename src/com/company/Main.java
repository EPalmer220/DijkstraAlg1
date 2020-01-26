package com.company;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        SimpleWeightedGraph<String, DefaultWeightedEdge> saMap = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        addSAVertices(saMap);
        addSAEdges(saMap);

        // DO NOT DELETE THIS METHOD
        convertToVertexes(saMap);

        dijkstraAlg("Alumni", "Rock", saMap);

        System.out.println("\n" + DijkstraShortestPath.findPathBetween(saMap, "Alumni", "Rock"));



    }

    public static void addSAVertices(SimpleWeightedGraph<String, DefaultWeightedEdge> saMap){
        String[] locations = {"Security Gate", "Admissions Building", "Senior Lot", "Teach. Lot", "US Classes",
                "Art Building", "Girls' Dorm", "Alumni", "Rock", "Entre. Center", "Mariani", "Science Building", "Boys' Dorm",
                "Chapel"};

        for(int i = 0; i < locations.length; i++)
            saMap.addVertex(locations[i]);
    }

    public static void addSAEdges(SimpleWeightedGraph<String, DefaultWeightedEdge> saMap){

        //
        // *LEFT SIDE OF CAMPUS*
        //

        //Security Gate -> Admissions
        DefaultWeightedEdge edge1 = saMap.addEdge("Security Gate", "Admissions Building");
        saMap.setEdgeWeight(edge1, 1);

        //Security Gate -> Senior Lot
        DefaultWeightedEdge edge2 = saMap.addEdge("Security Gate", "Senior Lot");
        saMap.setEdgeWeight(edge2, 1);

        //Senior Lot -> Admissions Building
        DefaultWeightedEdge edge3 = saMap.addEdge("Senior Lot", "Admissions Building");
        saMap.setEdgeWeight(edge3, 2);

        //Security Gate -> Teach. Lot
        DefaultWeightedEdge edge4 = saMap.addEdge("Security Gate", "Teach. Lot");
        saMap.setEdgeWeight(edge4, 3);

        //Teach. Lot -> US Classes
        DefaultWeightedEdge edge5 = saMap.addEdge("Teach. Lot", "US Classes");
        saMap.setEdgeWeight(edge5, 1);

        //Admissions Building -> US Classes
        DefaultWeightedEdge edge6 = saMap.addEdge("Admissions Building", "US Classes");
        saMap.setEdgeWeight(edge6, 1);

        //US Classes -> Art Building
        DefaultWeightedEdge edge7 = saMap.addEdge("US Classes", "Art Building");
        saMap.setEdgeWeight(edge7, 1);

        //Art Building -> Girls' Dorm
        DefaultWeightedEdge edge8 = saMap.addEdge("Art Building", "Girls' Dorm");
        saMap.setEdgeWeight(edge8, 1);

        //Teach. Lot -> Girls' Dorm
        DefaultWeightedEdge edge9 = saMap.addEdge("Teach. Lot", "Girls' Dorm");
        saMap.setEdgeWeight(edge9, 2);

        //Girls' Dorm -> Alumni
        DefaultWeightedEdge edge10 = saMap.addEdge("Girls' Dorm", "Alumni");
        saMap.setEdgeWeight(edge10, 3);

        //Admissions Building -> Alumni
        DefaultWeightedEdge edge11 = saMap.addEdge("Admissions Building", "Alumni");
        saMap.setEdgeWeight(edge11, 4);

        //
        // *RIGHT SIDE OF CAMPUS*
        //

        //Security Gate -> Rock
        DefaultWeightedEdge edge12 = saMap.addEdge("Security Gate", "Rock");
        saMap.setEdgeWeight(edge12, 1);

        //Rock -> Entre. Center
        DefaultWeightedEdge edge13 = saMap.addEdge("Rock", "Entre. Center");
        saMap.setEdgeWeight(edge13, 2);

        //Rock -> Mariani
        DefaultWeightedEdge edge14 = saMap.addEdge("Rock", "Mariani");
        saMap.setEdgeWeight(edge14, 3);

        //Entre. Center -> Mariani
        DefaultWeightedEdge edge15 = saMap.addEdge("Entre. Center", "Mariani");
        saMap.setEdgeWeight(edge15, 2);

        //Mariani to Science Building
        DefaultWeightedEdge edge16 = saMap.addEdge("Mariani", "Science Building");
        saMap.setEdgeWeight(edge16, 1);

        //Science Building to Boys' Dorm
        DefaultWeightedEdge edge17 = saMap.addEdge("Science Building", "Boys' Dorm");
        saMap.setEdgeWeight(edge17, 1);

        //Boys' Dorm to Chapel
        DefaultWeightedEdge edge18 = saMap.addEdge("Boys' Dorm", "Chapel");
        saMap.setEdgeWeight(edge18, 1);

        //Entre. Center to Chapel
        DefaultWeightedEdge edge19 = saMap.addEdge("Entre. Center", "Chapel");
        saMap.setEdgeWeight(edge19, 5);

        //Alumni to Chapel
        DefaultWeightedEdge edge20 = saMap.addEdge("Alumni", "Chapel");
        saMap.setEdgeWeight(edge20, 2);
    }

    public static void addRandomSAEdges(SimpleWeightedGraph<String, DefaultWeightedEdge> saMap){

        //
        // *LEFT SIDE OF CAMPUS*
        //

        //Security Gate -> Admissions
        DefaultWeightedEdge edge1 = saMap.addEdge("Security Gate", "Admissions Building");
        saMap.setEdgeWeight(edge1, randomNum());

        //Security Gate -> Senior Lot
        DefaultWeightedEdge edge2 = saMap.addEdge("Security Gate", "Senior Lot");
        saMap.setEdgeWeight(edge2, randomNum());

        //Senior Lot -> Admissions Building
        DefaultWeightedEdge edge3 = saMap.addEdge("Senior Lot", "Admissions Building");
        saMap.setEdgeWeight(edge3, randomNum());

        //Security Gate -> Teach. Lot
        DefaultWeightedEdge edge4 = saMap.addEdge("Security Gate", "Teach. Lot");
        saMap.setEdgeWeight(edge4, randomNum());

        //Teach. Lot -> US Classes
        DefaultWeightedEdge edge5 = saMap.addEdge("Teach. Lot", "US Classes");
        saMap.setEdgeWeight(edge5, randomNum());

        //Admissions Building -> US Classes
        DefaultWeightedEdge edge6 = saMap.addEdge("Admissions Building", "US Classes");
        saMap.setEdgeWeight(edge6, randomNum());

        //US Classes -> Art Building
        DefaultWeightedEdge edge7 = saMap.addEdge("US Classes", "Art Building");
        saMap.setEdgeWeight(edge7, randomNum());

        //Art Building -> Girls' Dorm
        DefaultWeightedEdge edge8 = saMap.addEdge("Art Building", "Girls' Dorm");
        saMap.setEdgeWeight(edge8, randomNum());

        //Teach. Lot -> Girls' Dorm
        DefaultWeightedEdge edge9 = saMap.addEdge("Teach. Lot", "Girls' Dorm");
        saMap.setEdgeWeight(edge9, randomNum());

        //Girls' Dorm -> Alumni
        DefaultWeightedEdge edge10 = saMap.addEdge("Girls' Dorm", "Alumni");
        saMap.setEdgeWeight(edge10, randomNum());

        //Admissions Building -> Alumni
        DefaultWeightedEdge edge11 = saMap.addEdge("Admissions Building", "Alumni");
        saMap.setEdgeWeight(edge11, randomNum());

        //
        // *RIGHT SIDE OF CAMPUS*
        //

        //Security Gate -> Rock
        DefaultWeightedEdge edge12 = saMap.addEdge("Security Gate", "Rock");
        saMap.setEdgeWeight(edge12, randomNum());

        //Rock -> Entre. Center
        DefaultWeightedEdge edge13 = saMap.addEdge("Rock", "Entre. Center");
        saMap.setEdgeWeight(edge13, randomNum());

        //Rock -> Mariani
        DefaultWeightedEdge edge14 = saMap.addEdge("Rock", "Mariani");
        saMap.setEdgeWeight(edge14, randomNum());

        //Entre. Center -> Mariani
        DefaultWeightedEdge edge15 = saMap.addEdge("Entre. Center", "Mariani");
        saMap.setEdgeWeight(edge15, randomNum());

        //Mariani to Science Building
        DefaultWeightedEdge edge16 = saMap.addEdge("Mariani", "Science Building");
        saMap.setEdgeWeight(edge16, randomNum());

        //Science Building to Boys' Dorm
        DefaultWeightedEdge edge17 = saMap.addEdge("Science Building", "Boys' Dorm");
        saMap.setEdgeWeight(edge17, randomNum());

        //Boys' Dorm to Chapel
        DefaultWeightedEdge edge18 = saMap.addEdge("Boys' Dorm", "Chapel");
        saMap.setEdgeWeight(edge18, randomNum());

        //Entre. Center to Chapel
        DefaultWeightedEdge edge19 = saMap.addEdge("Entre. Center", "Chapel");
        saMap.setEdgeWeight(edge19, randomNum());

        //Alumni to Chapel
        DefaultWeightedEdge edge20 = saMap.addEdge("Alumni", "Chapel");
        saMap.setEdgeWeight(edge20, randomNum());
    }

    public static int randomNum(){
        return (int)(Math.random() * 5) + 1; // RANGE = 5
    }

    public static void virtualTour(SimpleWeightedGraph<String, DefaultWeightedEdge> map){
        Scanner userIn = new Scanner(System.in);
        boolean isLocation = false;
        String userLoc = "";

        while(isLocation == false){
            System.out.println("Where would you like to start your journey?");

            userLoc = userIn.nextLine();
            if(isLocation(userLoc) == true)
                isLocation = true;
        }

        Iterator iter = map.edgesOf(userLoc).iterator();

        System.out.println("From the " + userLoc + ", you have these options:");

        for(int i = 0; i < map.edgesOf(userLoc).size(); i++){
            DefaultWeightedEdge edge = (DefaultWeightedEdge) iter.next();
            System.out.println("\n" + edge + " with a distance of " + map.getEdgeWeight(edge) + " units.");
        }

        System.out.println("\nWould you like to continue your journey or exit? Press \"1\" to exit:");

        Boolean isRunning = true;

        if(userIn.nextLine().equals("1")){
            isRunning = false;
        }

        while(isRunning){

            String[] locations = new String[map.edgesOf(userLoc).size()];

            iter = map.edgesOf(userLoc).iterator();

            for(int i = 0; i < locations.length; i++){
                DefaultWeightedEdge edge = (DefaultWeightedEdge) iter.next();
                String locToAdd = Graphs.getOppositeVertex(map, edge, userLoc);
                locations[i] = locToAdd;
            }

            isLocation = false;

            while(isLocation == false){
                System.out.println("Where would you like to go?");

                userLoc = userIn.nextLine();
                if(isLocation(userLoc, locations) == true)
                    isLocation = true;
            }

            System.out.println("From the " + userLoc + ", you have these options:");

            Iterator iter2 = map.edgesOf(userLoc).iterator();

            for(int i = 0; i < map.edgesOf(userLoc).size(); i++){
                DefaultWeightedEdge edge = (DefaultWeightedEdge) iter2.next();
                System.out.println("\n" + edge + " with a distance of " + map.getEdgeWeight(edge) + " units.");
            }

            System.out.println("\nWould you like to continue your journey or exit? Press \"1\" to exit:");

            if(userIn.nextLine().equals("1")){
                isRunning = false;
            }
        }
    }

    public static void dijkstraAlg(String source, String sink, SimpleWeightedGraph map){
        ArrayList<String> unvisited = Vertex.arrayListOfVertexes();
        ArrayList<String> visited = new ArrayList<String>();
        String currentVertex = source;

        // initializing the source vertex
        Vertex sourceVertex = Vertex.getVertex(source);
        sourceVertex.setWeightFromStart(0);
        sourceVertex.setPrevious(null);

        while(unvisited.size() > 0){
            ArrayList<String> unvisitedNeighbors = new ArrayList<String>();
            System.out.println("\nThe current vertex being searched is: " + currentVertex);

            // creates list of unvisited neighbors
            for(Object e : Graphs.neighborListOf(map, currentVertex)){
                String neighbor = e.toString();
                for(String f : unvisited)
                    if(f.equals(neighbor))
                        unvisitedNeighbors.add(neighbor);
            }

            for(String e : unvisitedNeighbors)
                System.out.println(e);

            for(String e : unvisitedNeighbors){

                double weightOfPrevious = Vertex.getVertex(currentVertex).getWeightFromStart();

                System.out.println("weight of previous nodes connected to " + e + " is: " + weightOfPrevious);

                DefaultWeightedEdge edge = (DefaultWeightedEdge) map.getEdge(currentVertex, e);
                double edgeWeight = map.getEdgeWeight(edge);

                double weightFromStart = edgeWeight + weightOfPrevious;

                if(weightFromStart < Vertex.getVertex(e).getWeightFromStart()){
                    Vertex.getVertex(e).setWeightFromStart(weightFromStart);
                    Vertex.getVertex(e).setPrevious(Vertex.getVertex(currentVertex));
                }
            }

            visited.add(currentVertex);
            unvisited.remove(currentVertex);
            if(unvisited.size() > 0) {
                unvisited = priorityQueue(unvisited);
                currentVertex = unvisited.get(0);
            }
        }

        currentVertex = sink;
        Stack<String> shortestPath = new Stack<String>();

        while(Vertex.getVertex(currentVertex).getPrevious() != null){
            shortestPath.add(currentVertex);
            currentVertex = Vertex.getVertex(currentVertex).getPrevious().getName();
        }

        System.out.print("\nThe shortest path from " + source + " to " + sink + " is: ");

        while(shortestPath.size() > 0)
            if(shortestPath.size() != 1)
                System.out.print(shortestPath.pop() + " to ");
            else
                System.out.print(shortestPath.pop());
    }

    public static ArrayList<String> priorityQueue(ArrayList<String> unvisited){
        String currentShortestVertex = unvisited.get(0);
        Double currentShortestWeight = Vertex.getVertex(unvisited.get(0)).getWeightFromStart();

        for(String e : unvisited){
            if(Vertex.getVertex(e).getWeightFromStart() < currentShortestWeight) {
                currentShortestVertex = e;
                currentShortestWeight = Vertex.getVertex(e).getWeightFromStart();
            }
        }
        System.out.println("current shortest vertex is: " + currentShortestVertex);
        unvisited.remove(currentShortestVertex);
        unvisited.add(0, currentShortestVertex);
        return unvisited;
    }

    public static void convertToVertexes(SimpleWeightedGraph map){
        Iterator iterator = map.vertexSet().iterator();
        System.out.println(map.vertexSet());

        while(iterator.hasNext()){
            String name = iterator.next().toString();
            Vertex vertex = new Vertex(name);
        }
    }

    public static boolean isLocation(String userLoc){
        String[] locations = {"Security Gate", "Admissions Building", "Senior Lot", "Teach. Lot", "US Classes",
                "Art Building", "Girls' Dorm", "Alumni", "Rock", "Entre. Center", "Mariani", "Science Building", "Boys' Dorm",
                "Chapel"};

        for(int i = 0; i < locations.length; i++){
            if(userLoc.equals(locations[i]))
                return true;
        }

        return false;
    }

    public static boolean isLocation(String userLoc, String[] locations){
        for(int i = 0; i < locations.length; i++){
            if(userLoc.equals(locations[i]))
                return true;
        }

        return false;
    }


}