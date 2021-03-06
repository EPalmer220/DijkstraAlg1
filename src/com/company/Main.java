package com.company;

import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.ALTAdmissibleHeuristic;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        SimpleWeightedGraph<String, DefaultWeightedEdge> saMap = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        addSAVertices(saMap);
        addRandomSAEdges(saMap);

        // DO NOT DELETE THIS METHOD
        convertToVertexes(saMap);

        // This is my own Dijkstra's Algorithm
        aStarAlg("Rock", "Chapel", saMap);

        // This is the built-in Dijkstra's Algorithm, used for testing purposes
        System.out.println("\n" + DijkstraShortestPath.findPathBetween(saMap, "Rock", "Chapel"));
        numHops("Rock", "Chapel", saMap);



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

    /**
     * Calculates the shortest path between two vertexes using Dijkstra's algorithm
     * @param source the starting vertex
     * @param sink the destination vertex
     * @param map the map that is being searched
     */
    public static int dijkstraAlg(String source, String sink, SimpleWeightedGraph map){
        ArrayList<String> unvisited = Vertex.arrayListOfVertexes();
        ArrayList<String> visited = new ArrayList<String>();
        String currentVertex = source;
        int nodeCounter = 0;

        // initializing the source vertex
        Vertex sourceVertex = Vertex.getVertex(source);
        sourceVertex.setWeightFromStart(0);
        sourceVertex.setPrevious(null);
        nodeCounter++;

        while(unvisited.size() > 0){
            nodeCounter++;
            ArrayList<String> unvisitedNeighbors = new ArrayList<String>();
            //System.out.println("\nThe current location whose paths are being evaluated is: " + currentVertex);

            // creates list of unvisited neighbors
            for(Object e : Graphs.neighborListOf(map, currentVertex)){
                String neighbor = e.toString();
                for(String f : unvisited)
                    if(f.equals(neighbor))
                        unvisitedNeighbors.add(neighbor);
            }

            // Calculates weightFromStart for each neighbor
            for(String e : unvisitedNeighbors){

                double weightOfPrevious = Vertex.getVertex(currentVertex).getWeightFromStart();

                DefaultWeightedEdge edge = (DefaultWeightedEdge) map.getEdge(currentVertex, e);
                double edgeWeight = map.getEdgeWeight(edge);

                double weightFromStart = edgeWeight + weightOfPrevious;

                // if neighbor's weightFromStart < shortestWeightFromStart, then weightFromStart = shortestWeighFromStart
                if(weightFromStart < Vertex.getVertex(e).getWeightFromStart()){
                    Vertex.getVertex(e).setWeightFromStart(weightFromStart);
                    Vertex.getVertex(e).setPrevious(Vertex.getVertex(currentVertex));
                }
            }

            // moves the vertex being evaluated to "visited" ArrayList
            visited.add(currentVertex);
            unvisited.remove(currentVertex);
            if(unvisited.size() > 0) {
                unvisited = priorityQueue(unvisited);
                currentVertex = unvisited.get(0);
            }
        }

        currentVertex = sink;
        Stack<String> shortestPath = new Stack<String>();

        // Creates Stack of previous vertexes, starting with the one connected to the sink (destination) vertex
        while(Vertex.getVertex(currentVertex).getPrevious() != null){
            shortestPath.add(currentVertex);
            currentVertex = Vertex.getVertex(currentVertex).getPrevious().getName();
        }

        System.out.print("\nUsing Dijkstra, the shortest path from " + source + " to " + sink + " is: " + source + " to ");

        // Pops stack to print the shortest path
        while(shortestPath.size() > 0)
            if(shortestPath.size() != 1)
                System.out.print(shortestPath.pop() + " to ");
            else
                System.out.print(shortestPath.pop());

        return nodeCounter;
    }

    /**
     * Finds the vertex with the lowest shortestWeightFromStart and puts it at the front of the ArrayList
     * @param unvisited the ArrayList of unvisited neighbors that's being reordered
     * @return the reordered ArrayList
     */
    public static ArrayList<String> priorityQueue(ArrayList<String> unvisited){
        String currentShortestVertex = unvisited.get(0);
        Double currentShortestWeight = Vertex.getVertex(unvisited.get(0)).getWeightFromStart();

        // iterates through unvisited to find the Vertex with the lowest shortestWeightFromStart
        for(String e : unvisited){
            if(Vertex.getVertex(e).getWeightFromStart() < currentShortestWeight) {
                currentShortestVertex = e;
                currentShortestWeight = Vertex.getVertex(e).getWeightFromStart();
            }
        }

        // puts the lowest-weight vertex at the front of the list
        unvisited.remove(currentShortestVertex);
        unvisited.add(0, currentShortestVertex);
        return unvisited;
    }

    public static int aStarAlg(String source, String sink, SimpleWeightedGraph map){
        int nodeCounter = 0;
        ArrayList<String> unvisited = Vertex.arrayListOfVertexes();
        ArrayList<String> visited = new ArrayList<String>();
        String currentVertex = source;
        ALTAdmissibleHeuristic heuristicMap = new ALTAdmissibleHeuristic(map, map.vertexSet());

        // initializing the source vertex
        Vertex sourceVertex = Vertex.getVertex(source);
        sourceVertex.setWeightFromStart(0);
        sourceVertex.setShortestTotalWeight(heuristicMap.getCostEstimate(source, sink));
        //System.out.println(sourceVertex.getShortestTotalWeight());
        sourceVertex.setPrevious(null);
        nodeCounter++;

        while(!currentVertex.equals(sink)){
            nodeCounter++;
            ArrayList<String> unvisitedNeighbors = new ArrayList<String>();
            //System.out.println("\nThe current location whose paths are being evaluated is: " + currentVertex);

            // creates list of unvisited neighbors
            for(Object e : Graphs.neighborListOf(map, currentVertex)){
                String neighbor = e.toString();
                for(String f : unvisited)
                    if(f.equals(neighbor))
                        unvisitedNeighbors.add(neighbor);
            }

            // Calculates totalWeight for each neighbor
            for(String e : unvisitedNeighbors){

                double weightOfPrevious = Vertex.getVertex(currentVertex).getWeightFromStart();

                DefaultWeightedEdge edge = (DefaultWeightedEdge) map.getEdge(currentVertex, e);
                double edgeWeight = map.getEdgeWeight(edge);

                double weightFromStart = edgeWeight + weightOfPrevious;

                //System.out.println("Heuristic being calculated is: " + heuristicMap.getCostEstimate(currentVertex, sink));

                double totalWeight = weightFromStart + heuristicMap.getCostEstimate(currentVertex, sink);

                // also have to update shortest weight from start
                // if neighbor's totalWeight < shortestTotalWeight, then weightFromStart = shortestWeighFromStart
                if(weightFromStart < Vertex.getVertex(e).getWeightFromStart())
                    Vertex.getVertex(e).setWeightFromStart(weightFromStart);

                if(totalWeight < Vertex.getVertex(e).getShortestTotalWeight()){
                    Vertex.getVertex(e).setShortestTotalWeight(totalWeight);
                    Vertex.getVertex(e).setPrevious(Vertex.getVertex(currentVertex));
                }
            }

            // moves the vertex being evaluated to "visited" ArrayList
            visited.add(currentVertex);
            unvisited.remove(currentVertex);
            if(unvisited.size() > 0) {
                unvisited = priorityQueueAStar(unvisited);
                currentVertex = unvisited.get(0);
            }
        }

        currentVertex = sink;
        Stack<String> shortestPath = new Stack<String>();

        // Creates Stack of previous vertexes, starting with the one connected to the sink (destination) vertex
        while(Vertex.getVertex(currentVertex).getPrevious() != null){
            shortestPath.add(currentVertex);
            currentVertex = Vertex.getVertex(currentVertex).getPrevious().getName();
        }

        System.out.print("\nUsing A*, the shortest path from " + source + " to " + sink + " is: " + source + " to ");

        // Pops stack to print the shortest path
        while(shortestPath.size() > 0)
            if(shortestPath.size() != 1)
                System.out.print(shortestPath.pop() + " to ");
            else
                System.out.print(shortestPath.pop());

        return nodeCounter;
    }

    public static ArrayList<String> priorityQueueAStar(ArrayList<String> unvisited){
        String currentShortestVertex = unvisited.get(0);
        Double currentShortestWeight = Vertex.getVertex(unvisited.get(0)).getShortestTotalWeight();

        // iterates through unvisited to find the Vertex with the lowest shortestWeightFromStart
        for(String e : unvisited){
            if(Vertex.getVertex(e).getShortestTotalWeight() < currentShortestWeight) {
                currentShortestVertex = e;
                currentShortestWeight = Vertex.getVertex(e).getShortestTotalWeight();
            }
        }

        // puts the lowest-weight vertex at the front of the list
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

    public static void numHops(String source, String sink, SimpleWeightedGraph map){
        int numHopsDijkstra = dijkstraAlg(source, sink, map);

        clear(map);

        int numHopsAStar = aStarAlg(source, sink, map);
        System.out.println("\n\nUsing Dijkstra, it took " + numHopsDijkstra + " hops. " +
                "Using A*, it took " + numHopsAStar + " hops.");
    }

    public static void clear(SimpleWeightedGraph map){
        for(Object v : map.vertexSet()){
            Vertex.getVertex((String) v).setShortestTotalWeight(Double.POSITIVE_INFINITY);
            Vertex.getVertex((String) v).setWeightFromStart(Double.POSITIVE_INFINITY);
            Vertex.getVertex((String) v).setPrevious(null);
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