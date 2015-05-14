/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LeeKiatHaw
 */
public class TerrainPoint {
    
    private int X;
    private int Y;
    
    private int height;
    
    private TerrainPoint north;
    private TerrainPoint south;
    private TerrainPoint east;
    private TerrainPoint west;

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
        return north;
    }

    public void setNorth(TerrainPoint north) {
        this.north = north;
    }

    public TerrainPoint getSouth() {
        return south;
    }

    public void setSouth(TerrainPoint south) {
        this.south = south;
    }

    public TerrainPoint getEast() {
        return east;
    }

    public void setEast(TerrainPoint east) {
        this.east = east;
    }

    public TerrainPoint getWest() {
        return west;
    }

    public void setWest(TerrainPoint west) {
        this.west = west;
    }
    
    
}
