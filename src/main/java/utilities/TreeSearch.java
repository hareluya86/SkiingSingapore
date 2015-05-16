/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.List;
import model.Terrain;
import model.TerrainPath;
import utilities.impl.DFSSearch;

/**
 *
 * @author vincent.a.lee
 */
public abstract class TreeSearch {
    
    public static enum TYPE{
        DFS,
        
    }
    
    protected Terrain terrain;
    
    public abstract void searchAll();
    
    public static TreeSearch getTreeSearch(TYPE type){
        switch(type){
            case DFS    : return new DFSSearch();
            default     : break;
        }
        
        return null;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    
    public abstract List<TerrainPath> getAllPath();
    
}
