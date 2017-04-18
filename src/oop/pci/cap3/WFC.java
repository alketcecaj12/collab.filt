package oop.pci.cap3;

import it.sauronsoftware.feed4j.FeedException;
import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class WFC {
	
	     public static void main(String[] args) throws Exception {
	    	 
	    	 BufferedReader br = new BufferedReader(new FileReader(new File("feedlist.txt")) );
	    	 String line = br.readLine();
	    	 
	    	 StringBuffer sb= new StringBuffer();
	    	 while((line = br.readLine())!=null){
	 	    	 sb.append(line);	
	    try
		     {
	    	 URL url = new URL(line);
	    	
			     Feed feed = FeedParser.parse(url);
		
			//System.out.println("** HEADER **");
			FeedHeader header = feed.getHeader();
			//System.out.println("Title: " + header.getTitle());
			//System.out.println("Link: " + header.getLink());
			System.out.println("Description: " + header.getDescription());
			//System.out.println("Language: " + header.getLanguage());
			//System.out.println("PubDate: " + header.getPubDate());
			
			System.out.println("** ITEMS **");
			int items = feed.getItemCount();
			for (int i = 0; i < items; i++) {
				FeedItem item = feed.getItem(i);
				System.out.println("Title: " + item.getTitle());
				System.out.println("Link: " + item.getLink());
				System.out.println("Plain text description: " + item.getDescriptionAsText());
				
				//System.out.println("HTML description: " + item.getDescriptionAsHTML());
				System.out.println("PubDate: " + item.getPubDate());
	 				}
	    	 }
	    	  catch (FeedException e) {
				System.out.println(e.getMessage());
			  }
          }br.close();
	  }
   }



