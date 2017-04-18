package oop.pci;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text2Map {

	 public static void main(String[] args) throws FileNotFoundException {
	        
	    	Scanner scanner = new Scanner(new FileReader("test1.txt"));

	        HashMap<String, Double> mapi = new HashMap<String, Double>();
	        HashMap<String, Map< String, Double >> map = new HashMap<String ,Map<String, Double >>();
	        String []columns= new String[3];
	        
	        while (scanner.hasNextLine()) {
	            columns = scanner.nextLine().split(",");
	            
	            double[] values = new double [columns.length];
	            
	               for(int i = 0; i< values.length ; i++){
	            	values[i]= Double.parseDouble(columns[2]);
	            	mapi.put(columns[1], values[i]);
	            	//mapi.clear();
	               }
	              map.put(columns[0],mapi);
	            //map.clear();
	        }
	        scanner.close();
	
	Text2Map t2m = new Text2Map();
	System.out.println("la dist euclid tra Lisa Rose e Gene Seymour è  "+t2m.distEuclid("Lisa Rose", "Gene Seymour", map));
	System.out.println("Il coeff di Pearson tra Michael Phillips e Gene Seymour è  "+t2m.coeffp("Michael Phillips", "Gene Seymour", map));
	 
	 }

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

	 
	 public double coeffp(String u1, String u2, Map <String,Map<String, Double>> critics){
			Map <String, Double> u1c = critics.get(u1);
			Map<String, Double> u2c = critics.get(u2);
			//metto dei system.out per visualizzare i valori di u1, u2
			double sum1=0, sum2=0, sum1sq=0, sum2sq=0;
			double Psum=0;
			double cp = 0;
			
			for (String film: u1c.keySet()){
				sum1 += u1c.get(film);
				sum1sq+=u1c.get(film)*u1c.get(film);
			}             
			//System.out.println("la somma per il critico 1 è "+sum1+"e la somma dei quadratti è "+sum1sq);
			double med1= sum1/(critics.size()-1);
			//System.out.println(med1);
			
			for (String film: u2c.keySet()){
				sum2 += u2c.get(film);
				sum2sq +=Math.pow(u2c.get(film),2);
			}               
			//System.out.println("la somma per il critico 2 è "+sum2+"e la somma dei quadratti è "+sum2sq);
			double med2= sum2/(critics.size()-1);
			
			double s1=Math.sqrt(sum1sq/(critics.size()-1)-(med1*med1));
			double s2=Math.sqrt(sum2sq/(critics.size()-1)-(med2*med2));
			 
			for (String film: u1c.keySet()){
				if(u2c.get(film)== null)
					continue;
				Psum+=u1c.get(film)*u2c.get(film);
			}	
			//System.out.println("Psum dovrebbe essere 59.5 e invece è "+Psum);		
			
			double num= (Psum/(critics.size()-1))-med1*med2;
				//System.out.println(num);
		     double den = s1*s2;
		     cp=num/den;
		  if(den==0)
		 return 0;
		           else return cp;
		}
}
