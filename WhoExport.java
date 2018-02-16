package joy.cse.ru;
import org.apache.commons.csv.*;
import edu.duke.*;

public class WhoExport {

	public static void main(String[] args) {
		WhoExport f = new WhoExport() ;
		f.testAllMethod() ;

	}
	public String  countryInfo(CSVParser parser , String country ){
		
		for(CSVRecord record : parser){
			
			if(record.get("Country").equals(country))
			{
				String ob ;
				ob = record.get("Country") + ": " + record.get("Exports")+": " + record.get("Value (dollars)") ;
				return ob ;
			}
		}
		
		return "NOT FOUND";
	} 
	
	
	public void listExportersTwoProducts(CSVParser parser , String exportItem1 , String exportItem2 ){
		
		     for(CSVRecord record : parser ){
		    	 
		    	 if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2))
		    		 System.out.println(record.get("Country")) ;
		    	 
		     }
		
	}
	
	public int  numberOfExporters(CSVParser parser , String exportItem){
		int numExporter = 0 ;
		for(CSVRecord record : parser){
			if(record.get("Exports").contains(exportItem))
				numExporter++;
				
		}
		
		return numExporter ;
		
		
	}
	
	public void bigExportes(CSVParser parser , String amount ){
		String exportValue = "" ; 
		long exportValue1 = 0;
		long exportValue2 = 0;
		amount = amount.replaceAll("," , "") ;
		exportValue1 = Long.valueOf(amount.substring(1)) ;
		
		for(CSVRecord record : parser){
			exportValue = record.get("Value (dollars)") ;
			exportValue = exportValue.replaceAll("," , "") ; 
			exportValue2 = Long.valueOf(exportValue.substring(1)) ;
			
			if(exportValue2 > exportValue1)
				System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
			
			
		}
		
	}
	public void testAllMethod(){
		
		  FileResource fr = new FileResource() ;
		  CSVParser parser = fr.getCSVParser();
		
	    //System.out.println(countryInfo(parser , "Germany"));
		
	    //parser = fr.getCSVParser();
		//listExportersTwoProducts( parser , "gold" , "diamonds" ) ; 
		
		//listExportersTwoProducts( parser , String exportItem1 , String exportItem2 ) ;
		//System.out.println(numberOfExporters(parser , "gold"));
		  bigExportes(parser , "$999,999,999,") ;
		  
		
	}

}
