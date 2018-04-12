package bodyMeasurement;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class bodyMeasurementHandler implements Serializable{
	ArrayList<bodyMeasurement> measurements = new ArrayList<bodyMeasurement>();	
	
	public bodyMeasurementHandler() {

	}
		public void build() {
			System.out.println("building BMH handler");
			bodyMeasurement b1 = new bodyMeasurement(89.0,18.0,40.0,32.0,108.0,60.0,40.0,84.0,54.0,43.0);
			measurements.add(b1);
			System.out.println(measurements.size());
			System.out.println("complete");
		}
	   public void load()
	   {

	      {
	         try
	         {
	        	System.out.println("Trying to load bodyMeasurements");
	            File file = new File("bodyMeasure.xml");
	            System.out.println("File read");
	            XMLDecoder decoder = new XMLDecoder(new FileInputStream(file));
	            System.out.println("file decoded");
	            measurements = (ArrayList<bodyMeasurement>) decoder.readObject();
	            System.out.println("object transfer");
	            decoder.close();
	         }
	         catch (IOException e)
	         {
	        	 System.out.println("Failed");
	         }
	      }
	   }
	   
	   public void save() {
	   
	         try
	         {
	        	System.out.println("Trying to save bodyMeasurements");
	            File file = new File("bodyMeasure.xml");
	            System.out.println("file located");
	            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
	            System.out.println("outputstream loaded");
	            //encoder.writeObject(bodyMeasurement);
	            System.out.println("object writen");
	            encoder.close();
	            System.out.println("closed");
	         }
	         catch (IOException e)
	         {
	        	 System.out.println("Failed");
	         }
	      }
	   }
	

