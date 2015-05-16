/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LeeKiatHaw
 */
public class TerrainPoint implements Comparable<TerrainPoint>, Iterable<TerrainPoint> {
    
    private int X;
    private int Y;
    
    private int height;
    
    private List<TerrainPoint> neighbours = new ArrayList<TerrainPoint>();
    
    //private TerrainPoint north;
    //private TerrainPoint south;
    //private TerrainPoint east;
    //private TerrainPoint west;
    
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TerrainPoint getNorth() {
        for(TerrainPoint neighbour : neighbours){
            if(neighbour.getX() == this.getX() && 
                    neighbour.getY() == this.getY() - 1)
                return neighbour;
        }
        return null;
    }

    public void setNorth(TerrainPoint north) {
        this.neighbours.add(north);
    }

    public TerrainPoint getSouth() {
        for(TerrainPoint neighbour : neighbours){
            if(neighbour.getX() == this.getX() && 
                    neighbour.getY() == this.getY() + 1)
                return neighbour;
        }
        return null;
    }

    public void setSouth(TerrainPoint south) {
        this.neighbours.add(south);
    }

    public TerrainPoint getEast() {
        for(TerrainPoint neighbour : neighbours){
            if(neighbour.getX() == this.getX() + 1 && 
                    neighbour.getY() == this.getY())
                return neighbour;
        }
        return null;
    }

    public void setEast(TerrainPoint east) {
        this.neighbours.add(east);
    }

    public TerrainPoint getWest() {
        for(TerrainPoint neighbour : neighbours){
            if(neighbour.getX() == this.getX() - 1 && 
                    neighbour.getY() == this.getY())
                return neighbour;
        }
        return null;
    }

    public void setWest(TerrainPoint west) {
        this.neighbours.add(west);
    }
    
    public int size(){
        
        return this.neighbours.size();
    }

    @Override
    public int compareTo(TerrainPoint tp) {
        return this.height - tp.getHeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TerrainPoint other = (TerrainPoint) obj;
        if (this.X != other.X) {
            return false;
        }
        if (this.Y != other.Y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.X;
        hash = 23 * hash + this.Y;
        hash = 23 * hash + this.height;
        return hash;
    }

    @Override
    public Iterator<TerrainPoint> iterator() {
        //TerrainPointIterator i = new TerrainPointIterator();
        //i.setThisPoint(this);
        //return i;
        return this.neighbours.iterator();
    }

    @Override
    public String toString() {
        return "TerrainPoint{" + "X=" + X + ", Y=" + Y + ", height=" + height + '}';
    }
    
    
    
}
