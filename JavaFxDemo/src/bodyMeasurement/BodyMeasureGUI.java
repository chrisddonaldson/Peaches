package bodyMeasurement;
import javafx.scene.control.Button;
//import java.awt.Insets;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class BodyMeasureGUI {
	static GridPane grid = new GridPane();
	bodyMeasurement latest;
	

			
	public BodyMeasureGUI(){
		//grid.setGridLinesVisible(true);
		grid.setHgap(10);
		grid.setVgap(10);
		Label Title  = new Label("Body Measurements screen.");
		grid.add(Title, 0, 0);
		grid.setPadding(new Insets(20, 20, 20, 20));
		
		latest = bodyMeasurementHandler.getLastest();
		
		Label bwL  = new Label("Body weight measurement:");
		grid.add(bwL, 0, 1);
		Label bw  = new Label(Double.toString(latest.getBodyWeight()));
		grid.add(bw, 1, 1);
		
		Label calL  = new Label("Caliper measurement:");
		grid.add(calL, 0, 2);
		Label cal  = new Label(Double.toString(latest.getCaliper()));
		grid.add(cal, 1, 2);
		
		Label uaL  = new Label("Upper arm measurement:");
		grid.add(uaL, 0, 3);
		Label ua  = new Label(Double.toString(latest.getUpperArm()));
		grid.add(ua, 1, 3);
		
		Label tL  = new Label("Thigh measurement");
		grid.add(tL, 0, 4);
		Label t  = new Label(Double.toString(latest.getThigh()));
		grid.add(t, 1, 4);
		
		Label faL  = new Label("Forearm measurement:");
		grid.add(faL, 0, 5);
		Label fa  = new Label(Double.toString(latest.getForearm()));
		grid.add(fa, 1, 5);
		
		Label chL  = new Label("Chest measurement:");
		grid.add(chL, 0, 6);
		Label ch  = new Label(Double.toString(latest.getChest()));
		grid.add(ch, 1, 6);
		
		Label caL  = new Label("Calf measurement:");
		grid.add(caL, 0, 7);
		Label ca  = new Label(Double.toString(latest.getCalf()));
		grid.add(ca, 1, 7);
		
		Label waL  = new Label("Waist measurment:");
		grid.add(waL, 0, 8);
		Label wa  = new Label(Double.toString(latest.getWaist()));
		grid.add(wa, 1, 8);
		
		Label shoL  = new Label("Shoulder measurement:");
		grid.add(shoL, 0, 9);
		Label sho  = new Label(Double.toString(latest.getShoulder()));
		grid.add(sho, 1, 9);
		
		Label neL  = new Label("Neck measurement:");
		grid.add(neL, 0, 10);
		Label ne  = new Label(Double.toString(latest.getNeck()));
		grid.add(ne, 1, 10);
		
		Button newEntry=  new Button("New Entry");
		newEntry.setOnAction(e -> {
			BodyMeasurementNewEntry.display();
		});
		grid.add(newEntry, 0, 11);
		
		
	}
	public static GridPane getBodyMeasureGUI(){
		return grid;
	}
	
}
	