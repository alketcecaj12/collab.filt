package oop.pci.cap3;
import java.util.*;
import it.sauronsoftware.feed4j.FeedException;
import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class GenVettFeed {

	public static void main(String[] args) throws Exception {
	    Map< String , Map<String, Integer>>	feedmap = new HashMap<String, Map<String, Integer>>();
	    GenVettFeed gf= new GenVettFeed();
		
	    	 BufferedReader br = new BufferedReader(new FileReader(new File("feedlist.txt")) );
	    	 
	    	 
	    	 String line = "";
	    	 while((line = br.readLine())!=null){
	 			feedmap.put(line, gf.mapi(line));
			
	    	 }
	    	 br.close();
	    	 System.out.println(feedmap);
	    	
	    	 BufferedWriter bw = new BufferedWriter(new FileWriter(new File("feedres.txt")) );
	    	 
	    }
   
public Map<String,Map<String, Integer>>map (String line)throws Exception{
	String t="";
	 Map<String,Map<String,Integer>>feedmap= new HashMap<String, Map<String,Integer>>();
	 BufferedReader br = new BufferedReader(new FileReader(new File("feedlist.txt")) );
	 line = br.readLine();
	 StringBuffer sb= new StringBuffer();
	 
	 while((line = br.readLine())!=null){
		 sb.append(line);
  try
      {
     	 URL url = new URL(line);
	     Feed feed = FeedParser.parse(url);
	      
	     int items = feed.getItemCount();
			for (int i = 0; i < items; i++) {
				FeedItem item = feed.getItem(i);
				t= item.getTitle();
				
				String sum = item.getTitle()+item.getDescriptionAsText();
			
				System.out.println(""+item.getLink());
				Map<String, Integer>feedi=new HashMap<String, Integer>();
	 
			for(int k = 0; k<sum.length(); k++){
    	     sum = sum.trim();
    	      if(sum.length()>0){
	            Integer g= feedi.get(sum);
	          if(g==null){
		        feedi.put(sum,1);
	       }
	      if(g!=null){
		   feedi.put(sum,g+1);
	          }
    	 }
    for(String str: feedi.keySet()){
    		 int c = feedi.get(str);
    		 System.out.println(str+" : "+c);
             }
      }
	 feedmap.put(t, feedi);// inserisco il titolo e il dizionario del feed i-esimo
}
    }catch (Exception e){
    
    System.out.println(e.getStackTrace());	
          }
	  }br.close();
	  
	return feedmap;
	}

public Map<String, Integer> mapi (String line) throws Exception {
	
	Map<String,Integer>feedi= new HashMap<String, Integer>();
	int k =0;
	  URL url = new URL(line);
	     
         Feed feed = FeedParser.parse(url);
	      
	     int items = feed.getItemCount();
	     String[] sum= new String [items];
	     for (int i = 0; i < items; i++) {
				FeedItem item = feed.getItem(i);
				System.out.println(item.getTitle());
					sum[i]= item.getTitle()+item.getDescriptionAsText();
			if(item.getTitle()==null) sum[i] =null;
					i++;
	     }
	     
	     for(String s : sum){
    	    if(s==null) continue;
	    	s = s.trim();
    	      if(s.length()>0){
	            Integer g = feedi.get(s);
	          if(g==null){
		        feedi.put(s,1);
	       }
	      if(g!=null){
		   feedi.put(s,g+1);
	          }
    	 }
	   }
    for(String str: feedi.keySet()){
    		 int c = feedi.get(str);
    		 System.out.println(str+" : "+c);
             }
   
      
return feedi;
	}
}



