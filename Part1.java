
public class Part1
{
   public String findSimpleGene               (String dna) {
        
        int startIndex = dna.indexOf("ATG");
        
        if(startIndex==-1)  return "";
        
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        
        while (currIndex != -1) {
            
            if((currIndex - startIndex) % 3 == 0) {
              
               return dna.substring(startIndex, currIndex +3);
            }
 
            else {
                  currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        
        return "";
    }
    
    public void testFindGeneSimple() {
        
        String dna = "ATTAAAAA";
        System.out.println("DNA sequence is " + dna);
        String gene = findSimpleGene               (dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGATGATGTAATGTAATG";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATATTATATATTA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna);
        System.out.println("Gene is " + gene);
        
        
        dna = "ATGATTAAATGTAA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGATTAAATTAA";
        System.out.println("DNA sequence is " + dna);
        gene = findSimpleGene               (dna);
        System.out.println("Gene is " + gene);
    }
}
