package joy.cse.ru;
import org.apache.commons.csv.*;
import edu.duke.*;

import edu.duke.FileResource;

import java.io.File;
//import java.text.DecimalFormat;



public class AnalyseBabyName 
{

	public static  void main(String[] args) {
		// TODO Auto-generated method stub
		AnalyseBabyName babyNames = new AnalyseBabyName() ;
	//	babyNames.printName() ;
	//	babyNames.testGetRank() ;
	//	babyNames.totalBirths();
		//babyNames.testGetName();
		//babyNames.testYearOfHighestRank();
	//	babyNames.testAverageRank();
		//babyNames.testGetTotalBirthsRankedHigher();
		babyNames.testWhatIsNameInYear();

	}

	/*public void printName(){
		FileResource  fr = new FileResource() ; 
		
		
		for(CSVRecord  f : fr.getCSVParser(false)){
			
			int numBornBaby = Integer.parseInt(f.get(2)) ;
			
			if(numBornBaby <= 100){
				System.out.println("Name: " + f.get(0) + ", Gender: " + f.get(1) + ", Num Baby born: " + f.get(2));
				
			}
			
			
		}
		
		
	}*/
	
	public void printName(){
		FileResource fr = new FileResource() ;
		
		for(CSVRecord f : fr.getCSVParser(false)){
			
			int numBornBaby = Integer.parseInt(f.get(2)) ;
			
			if(numBornBaby<=100)
				 System.out.println("Name : " + f.get(0) +  " Gender : " + f.get(1) + "Number of Born : "  + f.get(2)  ) ;
			
		}

	
}

	

	public void totalBirths(){
		
		FileResource fr = new FileResource() ;
		
		int totalBirth = 0 ;
		int maleBirth = 0 ;
		int femaleBirth = 0 ;
		
	
		for(CSVRecord f : fr.getCSVParser(false)){
			int numBaby = Integer.parseInt(f.get(2) ) ;
			
			if(f.get(1).equals("M"))
				 maleBirth += numBaby ;
			else
				femaleBirth += numBaby ;	
			
		}
		
	/*	for(CSVRecord f : fr.getCSVParser(false) ){
			
			int numBaby = Integer.parseInt(f.get(2)) ;
			
			if(f.get(1).equals('M'))
				 maleBirth +=numBaby ;
			else
				femaleBirth += numBaby ;
			
		}*/
		
		totalBirth= maleBirth + femaleBirth;
		System.out.println("Total births: " + totalBirth);
		System.out.println("Total male births: " + maleBirth);
		System.out.println("Total female births: " + femaleBirth);
		
	}
	
	/*public int getRank(int year , String name , String gender){
		
		String fileName = "data/yob" + String.valueOf(year) + ".csv" ;
		int rank = 0 ;
		
		FileResource fr = new FileResource(fileName) ;
		
		for(CSVRecord f: fr.getCSVParser(false)){
			
			  if(f.get(1).equals(gender))
				   rank++;
			  if(f.get(0).equals(name))
				   return rank ; 
			  
		}
		
		
		
		return -1 ;
		
	}*/
	

	public int getRank( String name , String gender , int year  ){
		
		String fileName = "yob" + String.valueOf(year) + "short.csv" ; 
	    int rank = 0 ;
		FileResource fr = new FileResource(fileName) ;
		for(CSVRecord f : fr.getCSVParser(false)){
			if(f.get(1).equals(gender))
				rank++ ; 
			else if (!f.get(1).equals(gender))
				continue ;
			if(f.get(0).equals(name))
				return rank ; 
		}
		
		
		
		return -1 ;
	}
	
	
	public int yearOfHighestRank(String name , String gender){
		
		int highRank = Integer.MAX_VALUE;
		int currRank ;
		int highRankConYear = -1 ;
		
		for(int year = 2012 ; year<=2014 ; year++){
			
			currRank = getRank(name , gender , year ) ;
			if(currRank < highRank){
				 highRank = currRank ; 
			     highRankConYear = year ;}
		}
		
		
		
		return highRankConYear ; 
		
	}
	
	
	
	public String getName(int year ,int rank, String gender){
		   String filename = "yob" + String.valueOf(year)+"short.csv" ;
		   FileResource fr = new FileResource(filename) ;
		   int currrank = 0 ;
		   
		   
		   for(CSVRecord f : fr.getCSVParser(false)){
			   
			   if(f.get(1).equals(gender))
				   currrank++;
			   
			   if(currrank==rank)
				   return f.get(0) ;
			   
				   
		   }
		 
		    return "No Name" ;
	} 
	
	
	public double averageRank(String name , String gender){
		DirectoryResource dr = new DirectoryResource();
		//boolean found = false ; 
		int currRank = 0;
		int totalFound = 0;
		int totalNumberOfRanks = 0;
		double ave ;
		
		
		for(File fr : dr.selectedFiles()){
			totalFound++;
			currRank = 0; 
			FileResource frr = new FileResource() ;
			
			
			for(CSVRecord f :frr.getCSVParser(false) ){
				if(!f.get(1).equals(gender))
					continue;
				currRank++;
				if(f.get(0).equals(name))
				{
					System.out.println(currRank );
					//found = true;
					//totalRank++;
					//totalNumberOfRanks += currRank;
					break;
				}
				
			}
			System.out.println(currRank) ;
			System.out.println(totalFound);
			totalNumberOfRanks = totalNumberOfRanks + currRank ;
			
			
		}
		
		if( totalNumberOfRanks==0)
			return -1.0 ;
		else{
			ave = ( totalNumberOfRanks / totalFound) ;
			return ave ;
			
		}
		
	}
	
	public int getTotalBirthsRankedHigher(int year , String name , String gender ){
		
		String fileName = "yob" + year + "short.csv" ;
		FileResource fr = new FileResource(fileName) ;
		int totalRank = 0 ;
		for(CSVRecord f:fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(f.get(2)) ;
			
			if(f.get(0).equals(name))
				break ;
			if(!f.get(1).equals(gender))
				continue ;
			
				totalRank += numBorn ;
				System.out.println(numBorn);
			
			
		}
		return totalRank ;
	}
	
  public String	whatIsNameInYear(String name , int year , int newYear , String gender )
  {
	 // String fileName = "yob" + year + ".csv" ;
	  
	//  FileResource fr = new FileResource(fileName) ;
	//  int rank = 0 ;
	  
	 /* for(CSVRecord f : fr.getCSVParser(false)){
		  if(f.get(0).equals(name))
			  break;
		  if(!f.get(1).equals(gender))
			  continue;
			  rank++;
		  
	  }*/
	  
	  int rrank = getRank( name , gender , year) ;
	  
	  
 	  
	  String reName = getName( newYear , rrank , gender ) ;
	  
	  return reName ;
  }
  
  
  void tset(){
	  
	//  whatIsNameInYear("joy" , 2012 , 2010 , "M");
	  printName() ;
  }
  public void testGetRank()
	{
		System.out.println(getRank("Mason", "M", 2012));
		System.out.println(getRank("Mason", "F", 2012));
		
	}
  
  public void testGetName()
 	{
 		//System.out.println(getRank("Mason", "M", 2012));
 		System.out.println(getName(2012,2 , "F"));
 		
 	}
  public void testYearOfHighestRank(){
	  System.out.println(yearOfHighestRank("Mason", "M"));
  }
  
  public void testAverageRank(){
	  System.out.println(averageRank("Jacob", "M"));
	  
  }
  
  public void  testGetTotalBirthsRankedHigher(){
	  
	  System.out.println( getTotalBirthsRankedHigher(2012 , "Ethan" , "M"));
  }
  
  public void testWhatIsNameInYear(){
	  
	  System.out.println(whatIsNameInYear("Isabella" , 2012 , 2014 , "F"));
  }
	
	
	
	
}



