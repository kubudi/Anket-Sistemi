package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{

    public static void index() {
    	int a= (int)Math.floor(Math.random()*10)+1; 
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
        int []votes=new int [a];
        int count=a;
    	for(int i=0; i<a; i++)    
    	{
    		votes[i]= (int) Vote.count("category=?", "Category"+i);
    	}
        render(count,votes);
    }
    
    public static long oysayisi() {   	
    	return Vote.count();
    }
    
    public static long oysayisi(String choice) {  
    	return  Vote.count("category=?", choice);
    }
    public static long oysayisi(String choice,String location) {  
    	return  Vote.count("category=? and location=?",choice, location);
    }
    
    
}