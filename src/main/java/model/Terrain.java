/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeeKiatHaw
 */
public class Terrain {
    
    private int width;
    private int height;
    
    private List<List<TerrainPoint>> pointLists;
    
    public void initializeTerrainSize(int width, int height){
        //Instantiate ArrayList for the X axis
        pointLists = new ArrayList(width);
        
        //Instantiate ArrayLists for the Y axis
        for(int i=0; i<width; i++){
            pointLists.add(new ArrayList(height));
        }
        
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public TerrainPoint getPoint(int x, int y){
        return pointLists.get(x).get(y);
    }
    
    public void setPoint(int x, int y, int height){
        TerrainPoint newPoint = new TerrainPoint();
        newPoint.setX(x);
        newPoint.setY(y);
        newPoint.setHeight(height);
        
        pointLists.get(x).add(y, newPoint);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
