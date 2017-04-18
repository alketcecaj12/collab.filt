package oop.pci;

import java.util.HashMap;
import java.util.Map;

public class MrCpItemBased {
	
	public double coeffp(String u1, String u2, Map <String,Map<String, Double>> critics){
		Map <String, Double> u1c = critics.get(u1);
		Map<String, Double> u2c = critics.get(u2);
		double sum1=0, sum2=0, sum1sq=0, sum2sq=0, Psum=0;
		double cp = 0;
		
		for (String film: u1c.keySet()){
			sum1 += u1c.get(film);
		double temp=sum1*sum1;
		sum1sq+=temp;
		}           //   System.out.println("la somma è"+sum1+"e la somma dei quadratti è"+sum1sq);
		
		for (String film2: u2c.keySet()){
			sum2+=u2c.get(film2);
			double temp=sum2*sum2;
			sum2sq+=temp;
		}             //   System.out.println("la somma è"+sum1+"e la somma dei quadratti è"+sum1sq);
		
		double stemp=0, ptemp=1;
		
		for (String film1: u1c.keySet()){
			for (String film2: u2c.keySet()){
		ptemp=u1c.get(film1)*u2c.get(film2);
			}
	Psum+=ptemp;
		}
		         //System.out.println("la somma è"+sum1+"e la somma dei quadratti è"+Psum);
			double num = Psum-(sum1-(sum2/6));
	double den= Math.sqrt(sum1sq-(sum1*sum1))*(sum2sq-(sum2*sum2)/6);
	cp=num/den;
	if(den==0)
	return 0;
	else return cp;
	}

	public double[] cpUvT( String w1, Map <String,Map<String, Double>> critics){
		double []d1= new double [critics.size()];
		int i=0;
		for (String criticsi: critics.keySet()){
			d1[i]=coeffp(w1, criticsi, critics);
			i++;
		}
	return d1;
	}

	public double [][] cpTvT(Map <String,Map<String, Double>>critics){
		int i=0;
		double [][] d2=null;
		d2=new double[critics.size()][critics.size()];
	for(String s : critics.keySet()){
		d2[i] = cpUvT(s,critics);
		i++;
	}
	return d2;
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
		  //SR.put("Toby", 4.0);
		
	      Map <String , Double> YMD = new HashMap <String , Double >();
		  
	      YMD.put("Lisa Rose", 2.5);
	      YMD.put("Gene Seymour", 3.5);
	      YMD.put("Michael Philips", 2.5);
	      YMD.put("Claudia Puig", 2.5);
	      YMD.put("Mick Lasalle", 2.0);
	      YMD.put("Jack Mathews", 3.5);
	      //YMD.put("Toby", 1.0);
		  
	      Map <String , Double> TNL = new HashMap <String , Double >();
		  
	      TNL.put("Lisa Rose", 3.0);
	      TNL.put("Gene Seymour", 3.0);
	      TNL.put("Michael Philips", 4.0);
	      TNL.put("Claudia Puig", 4.5);
	      TNL.put("Mick Lasalle", 3.0);
	      TNL.put("Jack Mathews", 3.5);
	      //TNL.put("Toby", 3.5);
		  
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
	       
	       MrCpItemBased mrib= new MrCpItemBased();
	       System.out.println("Il coeff di Pearson fra LadyInTheWater e Superman è " + mrib.coeffp
	    		   ("Lady in the water", "Superman returns", cpm));
	        
	       System.out.println("");
	       System.out.println("***Il coeff di Pearson di uno verso tutti gli altri******");
	       MrCpItemBased mrib1= new MrCpItemBased();
	      
	       double [] lista = new double[cpm.size()];
	      
	     lista = mrib1.cpUvT( "Lady in the water", cpm);  
	     
	     for(int i = 0; i<lista.length; i++){
	    	 System.out.println("Il coeff di Pearson dell film Lady in the water e il film "+i+" è "+lista[i]);
	     }
	  
	     System.out.println("");
	       System.out.println("***Il coeff di Pearson di tutti verso tutti è ******");
	       MrCpItemBased mrib2= new MrCpItemBased();
	      
	       double [][] lista2 = new double[cpm.size()][cpm.size()];
	      
	     lista2 = mrib2.cpTvT(cpm);  
	     
	     for(int i = 0; i<lista2.length;i++){
	    		for(int j = 0; j<lista2[0].length;j++)
	    	System.out.println("Il coeff di Pearson del film "+i+" verso il film " +j+" è "+lista2[i][j]);
	    	}
	  
	  }

}
