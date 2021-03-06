import java.io.*;
public class Part2
{
    public String findSimpleGene               (String dna , String startCodon , String stopCodon) {
        int k = 1;
        
        String ckString = dna.toUpperCase();
      
              
        if(ckString!=dna)
            k = 0;
                    
        
        int startIndex = ckString.indexOf(startCodon);
        
        if(startIndex==-1)  return "";
        
        int currIndex = ckString.indexOf(stopCodon, startIndex + 3);
        
        while (currIndex != -1) {
            
            if((currIndex - startIndex) % 3 == 0) {
              
               String storeString = ckString.substring(startIndex, currIndex +3);
               if(k==0){
                    return storeString.toLowerCase();
               }
               
               else
                   return storeString;
               
            }
            else {
                  currIndex = ckString.indexOf(stopCodon, currIndex + 1);
            }
        }
        
        return "";
    }
    
    public void testFindGeneSimple() {
        
        
        
        String startCodon = "ATG";
        String stopCodon = "TAA";
        
        String dna = "atgjhgkjg";
        System.out.println("DNA sequence is " + dna);
        
        String gene = findSimpleGene               (dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "atgatgtagtaa";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "ATATTATATATTA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        
        dna = "ATGATTAAATGATAA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "ATGATTAAATTAA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
    }
}
