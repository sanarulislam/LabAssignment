import edu.duke.*;
import java.io.*;
public class ImageInversion {
	
	public ImageResource InversionImage(ImageResource inputImage){
		  ImageResource outImage = new ImageResource(inputImage.getWidth() , inputImage.getHeight()) ;
		  for(Pixel pixel : inputImage.pixels()){
			  
			  Pixel inPixel = inputImage.getPixel(pixel.getX() , pixel.getY()) ;
			  int a = 255 - inPixel.getRed() ;
			  int b = 255 - inPixel.getBlue() ; 
			  int c = 255 - inPixel.getGreen() ; 
			  pixel.setRed(a) ;
			  pixel.setGreen(c) ; 
			  pixel.setBlue(b);
			  
		  }
		  
		
		
		  return outImage  ; 
	}
	
	public static void main(String args[]){
		
		ImageInversion ob = new ImageInversion() ; 
		DirectoryResource dr = new DirectoryResource() ; 
		
		for(File f : dr.selectedFiles()){
			ImageResource inputImage = new ImageResource(f) ; 
			
			String fname = inputImage.getFileName() ; 
			String newFileName = "invert-" + fname ; 
			ImageResource outPutImage = ob.InversionImage(inputImage) ;
			outPutImage.setFileName(newFileName);
			outPutImage.draw();
			outPutImage.save();
			
		}
		
		
	}

}
