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
import model.Terrain;
import utilities.TerrainBuilder;

/**
 *
 * @author LeeKiatHaw
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        URL url = new URL("http://s3-ap-southeast-1.amazonaws.com/geeks.redmart.com/coding-problems/map.txt");
        TerrainBuilder builder = new TerrainBuilder();
        
        Terrain newTerrain = builder.buildTerrain(new BufferedReader(new InputStreamReader(url.openStream())));
        
        //do some random access
        System.out.println(newTerrain.getPoint(563, 225).getHeight() + " " + newTerrain.getPoint(563+1, 225).getHeight() + " " + newTerrain.getPoint(563+2, 225).getHeight());
        System.out.println(newTerrain.getPoint(4, 623).getHeight() + " " + newTerrain.getPoint(4+1, 623).getHeight() + " " + newTerrain.getPoint(4+2, 623).getHeight());
        System.out.println(newTerrain.getPoint(689, 998).getHeight() + " " + newTerrain.getPoint(689+1, 998).getHeight() + " " + newTerrain.getPoint(689+2, 998).getHeight());
        System.out.println(newTerrain.getPoint(24, 57).getHeight() + " " + newTerrain.getPoint(24+1, 57).getHeight() + " " + newTerrain.getPoint(24+2, 57).getHeight());
        
    }
}
