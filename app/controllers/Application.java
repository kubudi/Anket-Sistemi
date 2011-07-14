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
      int [] trabzon=new int [4];
      int [] izmir=new int [4];
      int [] ankara=new int [4];
      trabzon[0]=(int)Vote.count("category=? and location=?", "AKP","Trabzon") ;
      trabzon[1]=(int)Vote.count("category=? and location=?", "CHP","Trabzon") ;
      trabzon[2]=(int)Vote.count("category=? and location=?", "MHP","Trabzon") ;
      trabzon[3]=(int)Vote.count("category=? and location=?", "Diger","Trabzon") ;
      izmir[0]=(int)Vote.count("category=? and location=?", "AKP","Izmir") ;
      izmir[1]=(int)Vote.count("category=? and location=?", "CHP","Izmir") ;
      izmir[2]=(int)Vote.count("category=? and location=?", "MHP","Izmir") ;
      izmir[3]=(int)Vote.count("category=? and location=?", "Diger","Izmir") ;
      ankara[0]=(int)Vote.count("category=? and location=?", "AKP","Ankara") ;
      ankara[1]=(int)Vote.count("category=? and location=?", "CHP","Ankara") ;
      ankara[2]=(int)Vote.count("category=? and location=?", "MHP","Ankara") ;
      ankara[3]=(int)Vote.count("category=? and location=?", "Diger","Ankara") ;
        render(trabzon,izmir,ankara);
    }
    

    
    
    
}