/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.skiingsingapore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import model.Terrain;
import model.TerrainPath;
import utilities.TerrainBuilder;
import utilities.TreeSearch;

/**
 *
 * @author LeeKiatHaw
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        
        int source = 0;
        int numTestCases = 10;
        
        Terrain newTerrain;
        TerrainBuilder builder = new TerrainBuilder();
        File file;
        switch(source){
            case 0  :   URL url = new URL("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");
                        newTerrain = builder.buildTerrain(new BufferedReader(new InputStreamReader(url.openStream())));
                        break;
            case 1  :   file = new File("/Users/LeeKiatHaw/Google Drive/SkiingSingapore/test1.txt");
                        newTerrain = builder.buildTerrain(new BufferedReader(new FileReader(file)));
                        break;
            case 2  :   file = new File("/Users/LeeKiatHaw/Google Drive/SkiingSingapore/test2.txt");
                        newTerrain = builder.buildTerrain(new BufferedReader(new FileReader(file)));
                        break;
            default :   throw new RuntimeException("Option "+source+" for datasource is not recognized.");
        }
        
        //do some random checks
        for(int i=0;i<numTestCases;i++){
            int x = (int) (Math.random()*newTerrain.getHeight());
            int y = (int) (Math.random()*newTerrain.getWidth());
            
            System.out.println(newTerrain.getPoint(x, y));
            
        }
        //System.out.println(newTerrain.getPoint(563, 225).getHeight() + " " + newTerrain.getPoint(563+1, 225).getHeight() + " " + newTerrain.getPoint(563+2, 225).getHeight());
        //System.out.println(newTerrain.getPoint(4, 623).getHeight() + " " + newTerrain.getPoint(4+1, 623).getHeight() + " " + newTerrain.getPoint(4+2, 623).getHeight());
        //System.out.println(newTerrain.getPoint(689, 998).getHeight() + " " + newTerrain.getPoint(689+1, 998).getHeight() + " " + newTerrain.getPoint(689+2, 998).getHeight());
        //System.out.println(newTerrain.getPoint(24, 57).getHeight() + " " + newTerrain.getPoint(24+1, 57).getHeight() + " " + newTerrain.getPoint(24+2, 57).getHeight());
        
        TreeSearch dfs = TreeSearch.getTreeSearch(TreeSearch.TYPE.DFS);
        
        dfs.setTerrain(newTerrain);
        dfs.searchAll();
        
        List<TerrainPath> allPaths = dfs.getAllPath();
        Collections.sort(allPaths);
        if(allPaths != null)
            System.out.println(allPaths.get(0));
    }
}
