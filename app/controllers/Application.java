package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller{
	public static int a= (int)Math.floor(Math.random()*10)+1; 
    public static void index() {

    	//en fazla 10 kategori
    	for(int i=0; i<81; i++)    //random veri olusturulması (3 il icin)
    	{
    		
    	
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
    			new Vote("AKP",String.valueOf(i)).save();
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
    			new Vote("CHP",String.valueOf(i)).save();
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
    			new Vote("MHP",String.valueOf(i)).save();
    		for(int j=0; j<Math.floor(Math.random()*10)+1;j++)
    			new Vote("Diger",String.valueOf(i)).save();
    	}

    	ArrayList arrayList = new ArrayList();

    	for (int i = 0; i < 81 ; i++)
    	{
    		
    	ArrayList l2 = new ArrayList(); 

    	l2.add(Vote.count("category=? and location=?", "AKP",String.valueOf(i)));
    	l2.add(Vote.count("category=? and location=?", "CHP",String.valueOf(i))) ;
    	l2.add(Vote.count("category=? and location=?", "MHP",String.valueOf(i))) ;
    	l2.add(Vote.count("category=? and location=?", "Diger",String.valueOf(i)));
    	arrayList.add(l2);
    	}
           
        List<Object[]> votes = Vote.find("select location, category, count(*) from Vote group by location, category order by location, category")
                .fetch();
        String location = null;
        for (Object[] vote : votes) {
            if (!vote[0].equals(location)) {
                location = (String) vote[0];
                System.out.println("*********************************************");
            }
            System.out.println(vote[0] + "=> " + vote[1] + ": " + vote[2]);
        }

        render();
    }
    
    public static void getVote(String il) {
    	int [] data=new int [4];
    	ArrayList<Long> liste = new ArrayList<Long>();

    	liste.add(Vote.count("category=? and location=?", "AKP",il));
    	liste.add(Vote.count("category=? and location=?", "CHP",il)) ;
    	liste.add(Vote.count("category=? and location=?", "MHP",il)) ;
    	liste.add(Vote.count("category=? and location=?", "Diger",il));
	
    	renderJSON(liste);
    }

    
    
    
}