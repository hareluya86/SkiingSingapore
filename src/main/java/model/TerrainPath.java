/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author vincent.a.lee
 */
public class TerrainPath implements Comparable<TerrainPath>, Cloneable, Iterable<TerrainPoint>{
    
    protected Stack<TerrainPoint> path = new Stack<TerrainPoint>();
    
    protected int length = 0;
    
    protected int drop = 0;
    
    public TerrainPath(){
        
    }
    
    
    public void addPoint(TerrainPoint newPoint){
        path.push(newPoint);
        length++;
        drop = Math.abs(path.firstElement().getHeight() - path.lastElement().getHeight());
    }
    
    public TerrainPoint popLastPoint(){
        TerrainPoint lastPoint = path.pop();
        length--;
        drop = Math.abs(path.firstElement().getHeight() - path.lastElement().getHeight());
        return lastPoint;
        
    }
    
    public TerrainPoint checkLastPoint(){
        return path.peek();
    }

    @Override
    public int compareTo(TerrainPath tp) {

        return (tp.getLength() != this.length) ? this.length - tp.getLength() : this.drop - tp.getDrop();
    }

    public int getLength() {
        return length;
    }

    public int getDrop() {
        return drop;
    }

    public boolean contains(TerrainPoint nextPoint) {
        return this.path.contains(nextPoint);
    }
    
    //Does not perform a deep but shallow copy instead
    //reference: http://stackoverflow.com/questions/54909/how-do-i-clone-a-generic-list-in-java#comment20060674_56383
    @Override
    public TerrainPath clone(){
        TerrainPath newPath = new TerrainPath();
        //We're just copying references here, but since our Terrain doesn't change, it doesn't matter
        for(TerrainPoint point : this.path){
            newPath.addPoint(point);
        }
        return newPath;
    }

    @Override
    public Iterator<TerrainPoint> iterator() {
        return this.path.iterator();
    }

    @Override
    public String toString() {
        String pathString = "";
        for(TerrainPoint point : path){
            pathString += "("+point.getX()+","+point.getY()+","+point.getHeight()+")-";
        }
                
        return "TerrainPath{" + "path=" + pathString + ", length=" + length + ", drop=" + drop + '}';
    }
    
    
}
