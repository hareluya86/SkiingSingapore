/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Iterator;

/**
 * Traverses the TerrainPoint's neighbours in the order:
 *      North -> South -> East -> West
 * @author LeeKiatHaw
 */
public class TerrainPointIterator implements Iterator<TerrainPoint>{
    
    private int index = 0;
    
    private TerrainPoint thisPoint;

    public TerrainPoint getThisPoint() {
        return thisPoint;
    }

    public void setThisPoint(TerrainPoint thisPoint) {
        this.thisPoint = thisPoint;
    }

    @Override
    public boolean hasNext() {
        return index < thisPoint.size();
    }

    @Override
    public TerrainPoint next() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
