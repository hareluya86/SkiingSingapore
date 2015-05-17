/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author KH
 */
public class TerrainEdge  {
    
    private TerrainPoint source;
    private TerrainPoint dest;
    
    //To improvise as an edge
    public TerrainEdge(TerrainPoint source, TerrainPoint dest){
        this.source = source;
        this.dest = dest;
    }
    
    public TerrainPoint getSource(){
        return source;
    }
    
    public TerrainPoint getDest(){
        return dest;
    }
}
