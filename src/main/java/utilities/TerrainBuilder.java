/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import model.Terrain;
import model.TerrainPoint;

/**
 *
 * @author LeeKiatHaw
 */
public class TerrainBuilder {
    
    public Terrain buildTerrain(BufferedReader file) throws IOException{
        //Read the size of the terrain first
        String firstLine = file.readLine();
        String[] size = firstLine.split(" ");
        
        Terrain newTerrain = new Terrain();
        if(size.length != 2) 
            throw new RuntimeException("Size of terrain is not specified: "+size);
        
        newTerrain.initializeTerrainSize(Integer.parseInt(size[0]), Integer.parseInt(size[1]));
        
        //Read line by line, set the points
        
        int Y = 0;
        String line;
        while((line = file.readLine()) != null){
            String[] lineItems = line.split(" ");
            for(int X = 0; X<lineItems.length; X++){
                newTerrain.setPoint(X, Y, Integer.parseInt(lineItems[X]));
            }
            Y++;
        }
        
        //connect them together
        for(int x=0; x<newTerrain.getWidth(); x++){
            for(int y=0; y<newTerrain.getHeight(); y++){
                TerrainPoint point = newTerrain.getPoint(x, y);
                //set links to all 4 directions
                //north
                if(y-1 >= 0) point.setNorth(newTerrain.getPoint(x, y-1));
                //south
                if(y+1 < newTerrain.getHeight()) point.setNorth(newTerrain.getPoint(x, y+1));
                //east
                if(x-1 >= 0) point.setEast(newTerrain.getPoint(x-1, y));
                //south
                if(x+1 < newTerrain.getWidth()) point.setWest(newTerrain.getPoint(x+1, y));
                
            }
        }
        return newTerrain;
    }
}
