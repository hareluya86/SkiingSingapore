/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mycompany.skiingsingapore.Constants;
import java.util.Stack;

/**
 *
 * @author vincent.a.lee
 */
public class TerrainPath implements Comparable, Cloneable{
    
    private Stack<TerrainPoint> path = new Stack();
    
    private int length = 0;
    
    private int drop = 0;
    
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

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
