package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{
	public static int a= (int)Math.floor(Math.random()*10)+1; 
    public static void index() {

    	//en fazla 10 kategori
    	for(int i=0; i<a; i++)    //random veri olusturulması (3 il icin)
    	{
    		
    	
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
        	{
    			new Vote("Category"+i,"Trabzon").save();
        	}
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
        	{
    			new Vote("Category"+i,"Ankara").save();
        	}
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
        	{
    			new Vote("Category"+i,"Izmir").save();
        	}		
    	}
      List votes=Vote.findAll();
      votes.toArray();
      
int [][] oylar= new int [3][4];
      oylar[0][0]=(int)Vote.count("category=? and location=?", "AKP","Trabzon") ;
      oylar[0][1]=(int)Vote.count("category=? and location=?", "CHP","Trabzon") ;
      oylar[0][2]=(int)Vote.count("category=? and location=?", "MHP","Trabzon") ;
      oylar[0][3]=(int)Vote.count("category=? and location=?", "Diger","Trabzon") ;
      oylar[1][0]=(int)Vote.count("category=? and location=?", "AKP","Izmir") ;
      oylar[1][1]=(int)Vote.count("category=? and location=?", "CHP","Izmir") ;
      oylar[1][2]=(int)Vote.count("category=? and location=?", "MHP","Izmir") ;
      oylar[1][3]=(int)Vote.count("category=? and location=?", "Diger","Izmir") ;
      oylar[2][0]=(int)Vote.count("category=? and location=?", "AKP","Ankara") ;
      oylar[2][1]=(int)Vote.count("category=? and location=?", "CHP","Ankara") ;
      oylar[2][2]=(int)Vote.count("category=? and location=?", "MHP","Ankara") ;
      oylar[2][3]=(int)Vote.count("category=? and location=?", "Diger","Ankara") ;
        render(oylar);
    }
    

    
    
    
}
