import edu.duke.*;
import java.io.*;
public class BatchGrayScale {
	
	public ImageResource grayScale(ImageResource inputImage){
		
		    ImageResource outImage = new ImageResource(inputImage.getWidth() , inputImage.getHeight()) ;
		    
		    for(Pixel pixel : outImage.pixels()){
		    	Pixel inPixel = inputImage.getPixel(pixel.getX(),pixel.getY()) ; 
		    	int average = (inPixel.getGreen() + inPixel.getBlue() + inPixel.getRed()) / 3 ; 
		    	pixel.setRed(average);
		    	pixel.setBlue(average);
		    	pixel.setGreen(average);
		    	
		    }
		
	    	return outImage ; 
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		DirectoryResource dr = new DirectoryResource() ;
		
		for(File f : dr.selectedFiles()){
			
			BatchGrayScale ob = new BatchGrayScale() ; 
			ImageResource inputImage = new ImageResource(f) ; 
			String fname = inputImage.getFileName() ; 
			String newFileName = "gray-" + fname ; 
			ImageResource outputImage = ob.grayScale(inputImage);
			outputImage.setFileName(newFileName);
			
			outputImage.draw(); 
			outputImage.save();
		}
	}

}
