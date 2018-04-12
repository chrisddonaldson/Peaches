package bodyMeasurement;

import java.io.Serializable;
import java.util.Date;

public class bodyMeasurement implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 4926439262711233080L;
double bodyWeight, caliper, upperArm, forearm,chest,thigh, calf, waist, shoulder, neck;

public bodyMeasurement(){}

public bodyMeasurement(double bodyWeight, double caliper, double upperArm,double thigh, double forearm,double chest, double calf, double waist,
		double shoulder, double neck) {
	super();
	this.bodyWeight = bodyWeight;
	this.caliper = caliper;
	this.upperArm = upperArm;
	this.forearm = forearm;
	this.calf = calf;
	this.waist = waist;
	this.shoulder = shoulder;
	this.neck = neck;
	this.thigh=thigh;
	this.chest=chest;
}
public double getBodyWeight() {
	return bodyWeight;
}
public void setBodyWeight(double bodyWeight) {
	this.bodyWeight = bodyWeight;
}
public double getCaliper() {
	return caliper;
}
public void setCaliper(double caliper) {
	this.caliper = caliper;
}
public double getUpperArm() {
	return upperArm;
}
public void setUpperArm(double upperArm) {
	this.upperArm = upperArm;
}
public double getForearm() {
	return forearm;
}
public void setForearm(double forearm) {
	this.forearm = forearm;
}
public double getCalf() {
	return calf;
}
public void setCalf(double calf) {
	this.calf = calf;
}
public double getWaist() {
	return waist;
}
public void setWaist(double waist) {
	this.waist = waist;
}
public double getShoulder() {
	return shoulder;
}
public void setShoulder(double shoulder) {
	this.shoulder = shoulder;
}
public double getNeck() {
	return neck;
}
public void setNeck(double neck) {
	this.neck = neck;
}
}
