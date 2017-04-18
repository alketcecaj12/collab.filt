package oop.pci.cap3;
import java.io.*;
import java.util.*;
import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;

public class WFC2Map {
	
	     public static void main(String[] args) throws Exception {
	    	 
	    	 BufferedReader br = new BufferedReader(new FileReader(new File("feedlist.txt")) );
	    	 String line = br.readLine();
	    	String[] desc= null;
	    	 int j=0;
	    	 StringBuffer sb= new StringBuffer();
	    	 
	    	 while((line = br.readLine())!=null){
	    	 sb.append(line);
	    	 URL url = new URL(line);
	    	
	    	 try{
	    		 
	    	Feed feed = FeedParser.parse(url);
		
			System.out.println("** HEADER **");
			FeedHeader header = feed.getHeader();
			System.out.println("Title: " + header.getTitle());
			System.out.println("Description: " + header.getDescription());
			System.out.println("Language: " + header.getLanguage());
			
			System.out.println("** ITEMS **");
			int items = feed.getItemCount();
			for (int i = 0; i < items; i++) {
				FeedItem item = feed.getItem(i);
				System.out.println("Title: " + item.getTitle());
				System.out.println("Description: " + item.getDescriptionAsText());
				
				desc[j]= item.getDescriptionAsText();
			    if(desc[j]==null)
			    	continue;
			    j++;
			}
			 
	    }catch (Exception e){
				  System.out.println("problema con feedparsing "+e.getMessage());
			 }
	    
	    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("reslist.txt")) );
		 try
		 {
		 while((line= br.readLine())!=null){
			 bw.write(desc[j]);
		 }
		 bw.close();
		 
		 }catch(Exception e ){
			 e.printStackTrace();
		 }
	   
	  } br.close();
			 
	   
			   
			   
	     }
 
}







	     




