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
    			new Vote("AKP","Trabzon").save();
    			new Vote("CHP","Trabzon").save();
    			new Vote("MHP","Trabzon").save();
    			new Vote("Diger","Trabzon").save();
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
      int [][] trabzon=new int[1] [4];
     
      trabzon[0][0]=(int)Vote.count("category=? and location=?", "AKP","Trabzon") ;
      trabzon[0][1]=(int)Vote.count("category=? and location=?", "CHP","Trabzon") ;
      trabzon[0][2]=(int)Vote.count("category=? and location=?", "MHP","Trabzon") ;
      trabzon[0][3]=(int)Vote.count("category=? and location=?", "Diger","Trabzon") ;
  
        render(trabzon);
    }
    

    
    
    
}