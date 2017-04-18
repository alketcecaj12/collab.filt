package oop.pci;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MrDeItemBased {

	public double distEuclid(String m1, String m2, Map <String,Map<String, Double>> cpm){
		
		
		Map <String, Double> m1c = cpm.get(m1);
		Map<String, Double> m2c = cpm.get(m2);
		
		double d =0, dx=0, dy=0, dis=0;
		
		for (String critic_i: m1c.keySet()){
			double v1x = m1c.get(critic_i); // per ogni stringa critico trova il suo valore
		      double v2x = m2c.get(critic_i);
		      if(v2x == 0)
			        continue;
		               dx=(v2x-v1x);
		System.out.println(dx);
		}
		    for (String critic_j: m2c.keySet()){
		    		double v1y = m1c.get(critic_j); // per ogni stringa critico trova il suo valore
		       		double v2y = m2c.get(critic_j);
		       		      if(v2y == 0)
		       			        continue;
		       		               dy=(v2y-v1y);
		       		            System.out.println(dy);       		            
		    }
	 dis += Math.pow(dx,2)+ Math.pow(dy,2);
		
		 return d= Math.sqrt(dis);
	}
	
public double[] deUvT( Map <String,Map<String, Double>> critics, String w1){
	double []d1= new double [critics.size()];
	int i=0;
	for (String criticsi: critics.keySet()){
		d1[i]=distEuclid(w1, criticsi, critics);
		i++;
	}
return d1;
}

public double[][] deTvT(  Map <String,Map<String, Double>> critics){
	double [][]d1= new double [critics.size()][critics.size()];
	int i=0;
	for (String criticsi: critics.keySet()){
		d1[i]=deUvT(critics, criticsi);
		i++;
	}
return d1;
}
	
	  public static void main (String [] args){
		  Map <String , Double> LIW = new HashMap< String , Double >();

		  LIW.put("Lisa Rose", 2.5);
		  LIW.put("Gene Seymour", 3.0);
		  LIW.put("Michael Philips", 2.5);
		 LIW.put("Claudia Puig", 4.5);
		  LIW.put("Mick Lasalle", 3.0);
		  LIW.put("Jack Mathews", 3.0);
		  LIW.put("Toby", 3.5);
		
		  Map <String , Double> SOP = new HashMap <String , Double >();
		  
		  SOP.put("Lisa Rose", 3.5);
		  SOP.put("Gene Seymour", 3.5);
		  SOP.put("Michael Philips", 3.0);
		  SOP.put("Claudia Puig", 3.5);
		  SOP.put("Mick Lasalle", 4.0);
		  SOP.put("Jack Mathews", 4.0);
		  SOP.put("Toby", 4.5);
		
		  Map <String , Double> JML = new HashMap <String , Double >();
		  
		  JML.put("Lisa Rose", 3.0);
		  JML.put("Gene Seymour", 1.5);
		  JML.put("Michael Philips", 2.5);
		  JML.put("Claudia Puig", 3.0);
		  JML.put("Mick Lasalle", 2.0);
		  JML.put("Jack Mathews", 4.5);
		  JML.put("Toby", 2.5);
		
		  Map <String , Double> SR = new HashMap <String , Double >();
		  
		  SR.put("Lisa Rose", 3.5);
		  SR.put("Gene Seymour", 5.0);
		  SR.put("Michael Philips", 3.5);
		  SR.put("Claudia Puig", 4.0);
		  SR.put("Mick Lasalle", 3.0);
		  SR.put("Jack Mathews", 5.0);
		 SR.put("Toby", 4.0);
		
	      Map <String , Double> YMD = new HashMap <String , Double >();
		  
	      YMD.put("Lisa Rose", 2.5);
	      YMD.put("Gene Seymour", 3.5);
	      YMD.put("Michael Philips", 2.5);
	      YMD.put("Claudia Puig", 2.5);
	      YMD.put("Mick Lasalle", 2.0);
	      YMD.put("Jack Mathews", 3.5);
	      YMD.put("Toby", 1.0);
		  
	      Map <String , Double> TNL = new HashMap <String , Double >();
		  
	      TNL.put("Lisa Rose", 3.0);
	      TNL.put("Gene Seymour", 3.0);
	      TNL.put("Michael Philips", 4.0);
	      TNL.put("Claudia Puig", 4.5);
	      TNL.put("Mick Lasalle", 3.0);
	      TNL.put("Jack Mathews", 3.5);
	      TNL.put("Toby", 3.5);
		  
	      Map<String, Map<String, Double>> cpm = new HashMap<String, Map<String, Double>> ();
		  
		  cpm.put("Lady in the water", LIW);
		  cpm.put("Snakes on a plane", SOP);
		    cpm.put("Just my luck", JML);
		  cpm.put("Superman returns", SR);
		  cpm.put("You me and Dupree", YMD);
		  cpm.put("The night listener", TNL);
		  
	       System.out.println(cpm);
	       System.out.println("");
	       System.out.println("*** la distanza uno a uno");
	       
	       MrDeItemBased mrib= new MrDeItemBased();
	       System.out.println("La distanza fra LadyInTheWater e Superman è " + mrib.distEuclid
	    		   ("Lady in the water", "Superman returns", cpm));
	        
	       System.out.println("");
	       System.out.println("***la distanza  uno e tutti gli altri******");
	       MrDeItemBased mrib1= new MrDeItemBased();
	      
	       double [] lista = new double[cpm.size()];
	      
	     lista = mrib1.deUvT(cpm, "Lady in the water");  
	     
	     for(int i = 0; i<lista.length; i++){
	    	 System.out.println("La distanza euclidea dell film Lady in the water e il film "+i+" è "+lista[i]);
	     }
	  
	     System.out.println("");
	       System.out.println("***la distanza tutti verso tutti è ******");
	       MrDeItemBased mrib2= new MrDeItemBased();
	      
	       double [][] lista2 = new double[cpm.size()][cpm.size()];
	      
	     lista2 = mrib2.deTvT(cpm);  
	     
	     for(int i = 0; i<lista2.length;i++){
	    		for(int j = 0; j<lista2[0].length;j++)
	    	System.out.println("La distanza del film "+i+" verso il film " +j+" è "+lista2[i][j]);
	    	}
	     System.out.println(""+cpm.get("Superman returns").values());
	  }
	  }

