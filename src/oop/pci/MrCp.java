package oop.pci;
import java.util.*;

public class MrCp {

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
public static void main (String [] args){

Map <String , Double> ratesLR = new HashMap<String , Double >();

  ratesLR.put("Lady in the water", 2.5);
  ratesLR.put("Snakes on a plane", 3.5);
  ratesLR.put("Just my luck", 3.0);
  ratesLR.put("Superman returns", 3.5);
  ratesLR.put("The night Listener", 3.0);
  ratesLR.put("You me and Dupree", 2.5);
  
  
  
  Map <String , Double> ratesGS = new HashMap <String , Double >();
  
  ratesGS.put("Lady in the water", 3.0);
  ratesGS.put("Snakes on a plane", 3.5);
  ratesGS.put("Just my luck",1.5);
  ratesGS.put("Superman returns",  5.0);
  ratesGS.put("The night Listener", 3.0);
  ratesGS.put("You me and Dupree", 3.5);
  
  Map <String , Double> ratesMP = new HashMap <String , Double >();
  
  ratesMP.put("Lady in the water",   2.5);
  ratesMP.put("Snakes on a plane",   3.0);
  ratesMP.put("Just my luck",      3.0);
  ratesMP.put("Superman returns",    3.0);
  ratesMP.put("The night Listener", 3.0);
  ratesGS.put("You me and Dupree", 2.0);
  
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
  
 ratesT.put("Snakes on a plane", 4.5 );
 ratesT.put("You me and Dupree", 1.0);
 ratesT.put("Superman returns",  4.0);
  
  
  Map<String, Map<String, Double>> critics = new HashMap<String, Map<String, Double>> ();
  
  critics.put("Lisa Rose", ratesLR);
  critics.put("Gene Seymour", ratesGS);
  critics.put("Michael Phillips", ratesMP);
  critics.put("Claudia Puig", ratesCP);
  critics.put("Mick Lasale", ratesML);
  critics.put("John Matthews", ratesJM);
  critics.put("Toby", ratesT);
 

 // System.out.println(critics);
  
  System.out.println("");
  System.out.println("********** Uno degli critici verso uno ***************");
MrCp pmr = new MrCp();
System.out.println("coeff di pearson fra Lisa Rose e Gene Seymour" +
		" è "+ pmr.coeffp("Lisa Rose", "Gene Seymour", critics));

System.out.println("");

System.out.println("********** Uno degli critici verso tutti ***************");


MrCp pmr1 = new MrCp();

double [] lista = new double[critics.size()-1];
lista = pmr1.cpUvT("Lisa Rose", critics);

String [] d= new String[critics.size()-1];
int l=0;
for(String u: critics.keySet()){
	d[l]=u;
	if(u.equals("Lisa Rose"))
		continue;
	l++;
}

for(int i = 0; i<lista.length;i++){
System.out.println("coefficenti di Pearson di Lisa Rose verso critico " +d[i]+ " con valore "+lista[i]);
}

System.out.println("");
System.out.println("********** Tutti i critici verso tutti ***************");
MrCp pmr2 = new MrCp();
double[][]lista1 = new double[critics.size()][critics.size()];
lista1 = pmr2.cpTvT( critics);
for(int i = 0; i<lista1.length;i++){
	for(int j = 0; j<lista1[0].length;j++)
System.out.println("coefficenti di Pearson del critico "+i+" verso critico "+j+" con valore "+lista1[i][j]);
}
}
}
