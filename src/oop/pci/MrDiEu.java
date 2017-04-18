package oop.pci;

import java.util.*;

public class MrDiEu {
 
	public Double distEuclid(String u1, String u2, Map <String,Map<String, Double>> critics){
		
        Map <String, Double> u1c = critics.get(u1);
		Map<String, Double> u2c = critics.get(u2);
		double d = 0;
	
	for (String film : u1c.keySet()){
			double v1 = u1c.get(film); // per ogni stringa film trova il suo valore
		      Double v2 = u2c.get(film);
		     // System.out.println(v1);
		      
			// System.out.println("_");
		               if(v2 == null)
				        continue;
		               d+=(v2-v1)*(v2-v1);
		       //        System.out.println(v2);
		      //         System.out.println("*");
		}
		return Math.sqrt(d);
	}

public double[] dEUvT( Map <String,Map<String, Double>> critics, String w1){
	double []d = new double[critics.size()-1]; 
		int i=0;
		 for (String critics_i: critics.keySet()){
			 if( critics_i.equals(w1))
				 continue;
			 d[i]+=distEuclid(w1, critics_i, critics);
			i++;
		}
	return d;
	}
	
public double [] racc(String c, String m, Map<String, Map<String, Double>> critics){
	
	double [] result = new double[critics.size()-1];
    
	//int j= 0;
	//for(String s : critics.keySet()){
	//result[j]= distEuclid(c,s,critics);
    //}
	result= dEUvT(critics,c);
    int i = 0;
    for(String ci: critics.keySet()){
		 if(critics.get(ci).get(m)==null)
			 continue;
    	result[i] *= critics.get(ci).get(m); 
		 
		i++;
	//System.out.println("result [i] "+result[i]);
    }
      return result;
}


	public double [][] dETvT(Map <String,Map<String, Double>>critics){
		int i=0;
		double [][] d2=null;
		d2=new double[critics.size()][critics.size()-1];
	for(String s : critics.keySet()){
		d2[i] = dEUvT(critics, s);
		i++;
	}
	return d2;
	}
	
	public static void main (String[]args){

	
		Map <String , Double> ratesLR = new HashMap<String , Double >();

	  ratesLR.put("Lady in the water", 1.5);
	  ratesLR.put("Snakes on a plane", 3.5);
	  ratesLR.put("Just my luck", 3.0);
	  ratesLR.put("Superman returns", 1.5);
	  ratesLR.put("The night Listener", 3.0);
	  ratesLR.put("You me and Dupree", 2.5);
	  
    
	  
	  Map <String , Double> ratesGS = new HashMap <String , Double >();
	  
	  ratesGS.put("Lady in the water", 2.5);
	  ratesGS.put("Snakes on a plane", 3.5);
	  ratesGS.put("Just my luck", 3.0);
	  ratesGS.put("Superman returns",  3.5);
	  ratesGS.put("The night Listener", 3.0);
	  ratesGS.put("You me and Dupree", 4.5);
	  
	  Map <String , Double> ratesMP = new HashMap <String , Double >();
	  
	  ratesMP.put("Lady in the water",   2.5);
	  ratesMP.put("Snakes on a plane",   3.5);
	  ratesMP.put("Just my luck",      1.5);
	  ratesMP.put("Superman returns",    3.5);
	  ratesMP.put("The night Listener", 4.0);
	  ratesGS.put("You me and Dupree", 3.5);
	  
	  Map <String , Double> ratesCP = new HashMap <String , Double >();
	  
	  ratesCP.put("Lady in the water",   2.5);
	 ratesCP.put("Snakes on a plane",3.5 );
	  ratesCP.put("Just my luck ",3.0 );
	  ratesCP.put("Superman returns",  4.0);
	  ratesCP.put("The night Listener", 4.5);
	   ratesCP.put("You me and Dupree", 2.5);
	  
    Map <String , Double> ratesML = new HashMap <String , Double >();
	  
    ratesML.put("Lady in the water", 3.0 );
    ratesML.put("Snakes on a plane", 4.0 );
	  ratesML.put("Just my luck ",      3.0 );
	  ratesML.put("Superman returns",  3.0);
	  ratesML.put("The night Listener", 3.0);
	  ratesML.put("You me and Dupree", 2.0);
	  
    Map <String , Double> ratesJM = new HashMap <String , Double >();
	  
    ratesJM.put("Lady in the water", 3.0 );
    ratesJM.put("Snakes on a plane", 4.0 );
    ratesJM.put("Just my luck ",      3.0 );
    ratesJM.put("Superman returns",  5.0);
    ratesJM.put("The night Listener", 3.0);
    ratesJM.put("You me and Dupree", 3.5);
	  
  Map <String , Double> ratesT = new HashMap <String , Double >();
    ratesT.put("Lady in the water", 3.0 );
    ratesT.put("Snakes on a plane", 4.5 );
    ratesJM.put("Just my luck ",      3.0 );
   // ratesT.put("Superman returns",  4.0);
    //ratesJM.put("The night Listener", 3.0);
    //ratesT.put("You me and Dupree", 1.0);
  
	  
	  
	  Map<String, Map<String, Double>> critics = new HashMap<String, Map<String, Double>> ();
	  
	  critics.put("Lisa Rose", ratesLR);
	  critics.put("Gene Seymour", ratesGS);
	  critics.put("Michael Phillips", ratesMP);
	  critics.put("Claudia Puig", ratesCP);
	  critics.put("Mick Lasale", ratesML);
	  critics.put("John Matthews", ratesJM);
	 critics.put("Toby", ratesT);
	 
		//System.out.println(critics.get("Lisa Rose"));
	  //System.out.println(critics.keySet());
	  
	  
	  MrDiEu mrd = new MrDiEu();
      System.out.println("dist euclidea fra Lisa Rose e Gene Seymour è "
    		  + mrd.distEuclid("Lisa Rose", "Gene Seymour", critics));
	//dist euclid uno verso tutti -----------------------------------------------------
      
      MrDiEu mrd1 = new MrDiEu();
       double[] d = new double [critics.size()-1];
      
       d=mrd1.dEUvT( critics,"Toby");
         for(int i = 0; i<d.length; i++){
            System.out.println("dist euclid di Toby verso "+i+"  è "+d[i]);
            }
         //dist euclid tutti verso tutti--------------------------------------------------
       MrDiEu mrd2 = new MrDiEu();
     double [][]d2= new double [critics.size()-1][critics.size()-1];
      d2= mrd2.dETvT(critics);
     for(int i = 0; i<d2.length; i++){
    	 for(int h = 0; h<d2[0].length; h++){
    	    System.out.println("dist euclid del critico  "+i+" verso il critico "+h+"  è "+d2[i][h]);
    	   }
     }
  // chiamata funz. racc  //--------------------------------------------------------
    
     MrDiEu mrd5 = new MrDiEu();
    double []d5= mrd5.racc("Toby","Superman returns", critics); 
    	
    for(int i = 0; i<d5.length; i++){
     System.out.println("dist euclid pesata di Toby verso il critico "+i+" con rif a SR è "+d5[i]);
    	  }
     
     
     
     
	
	}
}