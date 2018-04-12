package bodyMeasurement;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class bodyMeasurementHandler implements Serializable{

	private static final long serialVersionUID = 6784423204114561291L;
	
	public static ArrayList<bodyMeasurement> measurements = new ArrayList<bodyMeasurement>();
	public static bodyMeasurement latest;
	
	public ArrayList<bodyMeasurement> getMeasurements() {
		return measurements;
	}
	public void setMeasurements(ArrayList<bodyMeasurement> measurements) {
		this.measurements = measurements;
	}
	public bodyMeasurementHandler() {

	}
	public static void build() {
		System.out.println("Building BMH handler");
		load();
		latest = measurements.get(measurements.size()-1);
	}
		
		
	public static void load(){
		   try {
			      // Use XMLDecoder to read the same XML file in.
			      final XMLDecoder decoder = new XMLDecoder(new FileInputStream(new File("bodyMeasure.xml")));
			      final ArrayList<bodyMeasurement> listFromFile = (ArrayList<bodyMeasurement>) decoder.readObject();
			      decoder.close();
			      System.out.println("Load successful");
			      System.out.println("Reading Arraylist: " + listFromFile);
			      measurements = listFromFile;
		   }catch(IOException ex) {
				   ex.printStackTrace();
				   }}
	   
	   public static void save() {
		   try {
			      final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
			              new FileOutputStream(new File("bodyMeasure.xml"))));
			          encoder.writeObject(measurements);
			          encoder.close();
		   }
		   catch(IOException ex) {
			   ex.printStackTrace();
		   }
	   }
	   public static void add(bodyMeasurement b) {
		   measurements.add(b);
		   save();
	   }
	   public void remove(int i) {
		   measurements.remove(i);
		   save();
	   }
	   public static bodyMeasurement getLastest() {
		  return latest;
	   }
}

