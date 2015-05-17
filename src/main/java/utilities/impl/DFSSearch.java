/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TerrainEdge;
import model.TerrainPath;
import model.TerrainPoint;
import utilities.TreeSearch;

/**
 *
 * @author LeeKiatHaw
 */
public class DFSSearch extends TreeSearch {
    
    //A list to represent all paths visited
    private List<TerrainPath> allPaths = new ArrayList<TerrainPath>();
    private File allPathsOutput = new File("output.txt");
    private TerrainPath bestSkiPath;
    
    @Override
    public void searchAll(){
        //First, check if the terrain has been set
        if(this.terrain == null) throw new RuntimeException("Terrain has not been set in search tree!");
        
        //Get a long list of all terrains and sort them
        List<TerrainPoint> allPoints = this.terrain.getAllPoints();
        Collections.sort(allPoints);
        
        System.out.println(allPoints.size()); //debug
        BufferedWriter bWriter;
        try {
            //Output to file instead of tracking them in a large arrayList
            bWriter = new BufferedWriter(new FileWriter(allPathsOutput));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        
        //This is the current index of the allPointsSorted list that we are checking
        int startPoint = 0;
        //This is the starting TerrainPoint for each path
        TerrainPoint startingPoint;
        
        
        //Let's start!
        //First, the condition to loop through all Terrain points in allPointsSorted
        while(startPoint < allPoints.size()){
            //Get the startingPoint
            startingPoint = allPoints.get(startPoint);
            
            //Initialize variables
            //This is a stack that we use to track all points we're going to visit in the current search
            Stack<TerrainEdge> visitingPathPoints = new Stack();
            TerrainEdge startingEdge = new TerrainEdge(null,startingPoint);
            visitingPathPoints.push(startingEdge);
            //This is a stack that we use to track all points we have visited in the current path
            TerrainPath visitedPathPoints = new TerrainPath();
            
            //visitedPathPoints.push(startingPoint);
            //Keep visiting nodes that remain in visitedPathPoints
            //Because it is a stack, we tend to visit the last visited point, so it 
            //becomes a DFS instead of a BFS (source: http://stackoverflow.com/questions/21508765/how-to-implement-depth-first-search-for-graph-with-non-recursive-aprroach)
            while(!visitingPathPoints.isEmpty()){
                
                TerrainEdge currentEdge = visitingPathPoints.pop();
                //Only when you have visited a point,
                TerrainPoint currentPoint = currentEdge.getDest();
                visitedPathPoints.addPoint(currentPoint);
                
                //I don't really like flags, but in this case I think I have no choice...
                //Search for all possible next point to visit
                boolean newPointsAdded = false;
                Iterator<TerrainPoint> i = currentPoint.iterator();
                while(i.hasNext()){
                    TerrainPoint nextPoint = i.next();
                    if(
                            //Conditions to add the nextPoint into the visitingPathPoints stack
                            //1) if the next height is higher than the current one
                            nextPoint.getHeight() > currentPoint.getHeight()
                            //2) if it has not been visited in the current path in visitedPathPoints
                            && !visitedPathPoints.contains(nextPoint)){
                        visitingPathPoints.push(new TerrainEdge(currentPoint,nextPoint));
                        newPointsAdded = true;
                    }
                }
                //When there are no more further points to visit for the currentPoint,
                //"close" up the current path and add them to either an all path list
                //or a file
                if(newPointsAdded)
                    continue;
                
                TerrainPath closedPath = visitedPathPoints.clone();
                if(bestSkiPath == null || bestSkiPath.compareTo(closedPath) < 0){ //New path is better or best path hasn't been set
                    bestSkiPath = closedPath;
                }
                //this.allPaths.add(closedPath);
                //Output to file instead
                try{
                    bWriter.write(closedPath.toString());
                    bWriter.newLine();
                    bWriter.flush();
                } catch(IOException ex){
                    throw new RuntimeException(ex);
                }
                
                //This is the part where we determine how we should reconstruct the TerrainPath
                //as we are potentially moving a few levels up the tree
                //or switching parents

                //First, get the next visiting node and check which parent it has in 
                //visitedPathPoints. We assume it can only have 1 parent because no points can 
                //be visited more than once.
                //However, each point can have many "parents" and these parents can exist in 
                //the visited stack.
                //So, we will get the edge instead of just the point to know exactly which parent 
                //the next point will come from
                if(visitingPathPoints.isEmpty())
                    continue;
                
                //TerrainPoint nextPoint = visitingPathPoints.peek();
                TerrainPoint nextParent = visitingPathPoints.peek().getSource();
                /*TerrainPoint leafPoint = null;
                for(TerrainPoint parent : visitedPathPoints){
                    for(TerrainPoint neighbour : nextPoint){
                        if(parent.equals(neighbour)){
                            leafPoint = parent;
                        } 
                    } 
                }*/
                //Next, prune the visitedPathPoint to the point of leafPoint
                //if(leafPoint == null){ //nextPoint is the root, it shouldn't be
                //    throw new RuntimeException("Cannot find root for next point: "+nextPoint);
                //}
                while(!visitedPathPoints.checkLastPoint().equals(nextParent)){
                    visitedPathPoints.popLastPoint();
                }
            }
            
            //end of the loop
            startPoint++;
        }
        try {
            bWriter.write("The best path goes to: "+bestSkiPath.toString());
            bWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<TerrainPath> getAllPath() {
        return this.allPaths;
    }
    
}
