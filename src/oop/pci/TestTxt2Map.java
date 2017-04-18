package oop.pci;
import java.io.*;
import java.util.*;

class TestTxt2Map {
	
    public static void main(String[] args) throws FileNotFoundException {
        
    	Scanner scanner = new Scanner(new FileReader("test.txt"));

        
        HashMap<String, Map< String, Double >> map = new HashMap<String ,Map<String, Double >>();
       
        String []columns= null;
        double vote = 0;
        while (scanner.hasNextLine()) {
            columns = scanner.nextLine().split(",");
            String name = columns[0];
            String film = columns[1];
           vote= Double.parseDouble(columns[2]);
           Map<String, Double> mapi = map.get(name);
        if (mapi!=null){
        	mapi.put(film, vote);
        	
        }   else
        	mapi = new HashMap<String, Double>();
        mapi.put(film, vote);
           map.put(name,mapi);
        }
        scanner.close();
        TestTxt2Map t2m = new TestTxt2Map();
       System.out.println(map);
       //System.out.println("il coeff di Pearson tra Michael Philips" +
       	//	" e Mick Lasalle è "+ t2m.coeffp("Michael Philips", "Mick Lasalle", map));
       //System.out.println("la distanza euclidea è "+ t2m.distEuclid("Michael Philips", "Mick Lasalle", map));

        String [] critici= new String[map.size()-1];
        int l=0;
        for(String u: map.keySet()){
        	critici[l]=u;
        	if(u.equals("Lisa Rose"))
        		continue;
        	l++;
        }

        System.out.println("***********Calcolo del coeff di Pearson di Lisa Rose verso tutti gli altri************** ");
        double [] d1 = new double[map.size()];
        d1= t2m.cpUvT( "Lisa Rose",map);
       
       for(int j = 0; j<d1.length; j++){
       	System.out.println("Il coeff di Pearson di Lisa Rose verso critico " +critici[j]+ " è " +d1[j]);
       }
       System.out.println("*********Calcolo distanza Euclidea di Lisa Rose verso tutti gli altri****************************+++ ");
       String [] criticj= new String[map.size()];
       int c=0;
       for(String u: map.keySet()){
       	criticj[c]=u;
       	if(u.equals("Lisa Rose"))
       		continue;
       	c++;
       }
       double [] d = new double[map.size()];
      d= t2m.deUvT( "Lisa Rose", map);
       for(int i = 0; i<d.length; i++){
    	System.out.println("La dist euclidea di Lisa Rose verso critico "+criticj[i]+" è "+d[i]);
        }
    }
 
public Double distEuclid(String u1, String u2, Map <String,Map<String, Double>> critics){
		
        Map <String, Double> u1c = critics.get(u1);
		Map<String, Double> u2c = critics.get(u2);
		double d = 0;
	
	for (String film : u1c.keySet()){
			double v1 = u1c.get(film); // per ogni stringa film trova il suo valore
		      Double v2 = u2c.get(film);
		      //System.out.println(v1);
		      // System.out.println("_");
		               if(v2 == null)
				        continue;
		               d+=(v2-v1)*(v2-v1);
		             //  System.out.println(v2);
		      //         System.out.println("*");
		}
		return Math.sqrt(d);
	}
public double[] deUvT( String w1,Map <String,Map<String, Double>> critics){
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
		d1[i]=deUvT( criticsi,critics);
		i++;
	}
return d1;
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
public double[] cpUvT( String w1, Map <String,Map<String, Double>> critics){
	double []d1= new double [critics.size()-1];
	int i=0;
	for (String criticsi: critics.keySet()){
		if(criticsi.equals(w1))
			continue;
		d1[i]=coeffp(w1, criticsi, critics);
		i++;
	}
	return d1;
}

public double [][] cpTvT(Map <String,Map<String, Double>>critics){
	int i=0;
	double [][] d2=null;
	d2=new double[critics.size()][critics.size()-1];
for(String s : critics.keySet()){
	d2[i] = cpUvT(s,critics);
	i++;
	}
    return d2;
 }
}