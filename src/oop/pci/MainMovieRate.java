package oop.pci;
import java.util.*;
public class MainMovieRate {
 public static void main (String[] args){
	 
	 List <MovieRate> LRArr = new ArrayList <MovieRate> ();
		
	 LRArr.add(new MovieRate("Lady in the water",2.5));
	 LRArr.add(new MovieRate("Snakes on a plane", 3.5));
     LRArr.add(new MovieRate("Just my luck",3.0));
     LRArr.add(new MovieRate("Superman returns", 3.5));
		
	List <MovieRate> GSArr = new ArrayList<MovieRate>();

	GSArr.add(new MovieRate("Lady in the water",3.0));
	GSArr.add(new MovieRate("Snakes on a plane", 3.5));
	GSArr.add(new MovieRate("Just my luck",1.5));
	GSArr.add(new MovieRate("Superman returns", 5.0));	
		
	List <MovieRate> MPArr = new ArrayList<MovieRate>();

	MPArr.add(new MovieRate("Lady in the water",2.5));
	MPArr.add(new MovieRate("Snakes on a plane", 3.0));
	MPArr.add(new MovieRate("The night listener",4.5));
	MPArr.add(new MovieRate("Superman returns", 4.0));	

	Map <String, List <MovieRate>> critics = new HashMap <String, List <MovieRate>>();
	critics.put("Lisa Rose", LRArr);
    critics.put("Gene Seymour", GSArr);
    critics.put("Michael Philips", MPArr);
	 
	// trova valutazioni per Lisa Rose
    List<MovieRate> LRx = critics.get("Lisa Rose");
	for(MovieRate x: LRx) 
		if(x.movie.equals("Superman returns"))
			System.out.println(x.rate);
	
	List <MovieRate> LRy = critics.get("Lisa Rose");
	for(MovieRate y : LRy )
		if(y.movie.equals("Snakes on a plane"))
			System.out.println(y.rate);
	
	// trova valutazioni per Michael Philips
	List<MovieRate> MPx = critics.get("Michael Philips");
	for(MovieRate x1: MPx) 
		if(x1.movie.equals("Superman returns"))
			System.out.println(x1.rate);
	
	List <MovieRate> MPy = critics.get("Michael Philips");
	for(MovieRate y1 : MPy )
		if(y1.movie.equals("Snakes on a plane"))
			System.out.println(y1.rate);
	
     System.out.println("ecco prova"+critics.get("Lisa Rose").size());
     System.out.println("ecco prova1"+critics.get("Lisa Rose").equals(LRArr));
/*public static <MovieRate> eucliDiScore(MovieRate<String,Double>){
	Double X = (x.rate-x1.rate);
	Double Y = (y.rate-y1.rate);
	Double distance =  Math.sqrt(X+Y);
	return distance;
}*/
 }
}
