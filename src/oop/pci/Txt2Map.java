package oop.pci;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
	    
public class Txt2Map{
	    public static void main(String[] args) throws FileNotFoundException {
	        Scanner scanner = new Scanner(new FileReader("test.txt"));

	        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
	        
	        Map<String , Double > mapi = new HashMap<String, Double>();
	        
	        while (scanner.hasNextLine()) {
	            String[] columns = scanner.nextLine().split(",");
	            double[] values = new double [columns.length];
	            
	               for(int i = 0; i< values.length ; i++){
	            	values[i]= Double.parseDouble(columns[2]);
	            	mapi.put(columns[1], values[i]);
	            	//mapi.clear();
	               }
	        }

	        System.out.println(map); 
	     
	        Txt2Map t2m = new Txt2Map();
	       t2m.distEuclid("Lisa Rose", "Gene Seymour", map);
	    }
	    
	    public double distEuclid(String m1, String m2, Map <String,Map<String, Double>> cpm){
			
			Map <String, Double> m1c = cpm.get(m1);
			Map<String, Double> m2c = cpm.get(m2);
			
			double d =0, dx=0, dy=0, dis=0;
			
			for (String critic_i: m1c.keySet()){
				double v1x =  m1c.get(critic_i); // per ogni stringa critico trova il suo valore
			      Double v2x = m2c.get(critic_i);
			      if(v2x == null)
				        continue;
			               dx=(v2x-v1x);
			
			    for (String critic_j: m2c.keySet()){
			    		double v1y = m1c.get(critic_j); // per ogni stringa critico trova il suo valore
			       		double v2y = m2c.get(critic_j);
			       		      if(v2y == 0)
			       			        continue;
			       		               dy=(v2y-v1y);
			
			    }
		 dis = Math.pow(dx,2)+ Math.pow(dy,2);
			}
			 return d=Math.sqrt(dis);
		}

	}

