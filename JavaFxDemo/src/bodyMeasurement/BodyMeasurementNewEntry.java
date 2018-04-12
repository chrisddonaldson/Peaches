package bodyMeasurement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BodyMeasurementNewEntry {
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("New Body Measurement Entry");
		window.setMinWidth(250);
		
		
		Label titel = new Label("Add a new entry");
		Button closeButton = new Button("Accept");

		
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.setHgap(10);
		layout.setVgap(10);
		Label bwl = new Label("Body Weight(kg):");
		TextField bwt = new TextField();
		layout.add(bwl,0, 1);
		layout.add(bwt, 1, 1);
		
		Label call = new Label("Caliper Measurement(mm):");
		TextField calt = new TextField();
		layout.add(call,0, 2);
		layout.add(calt, 1, 2);
		
		Label ual = new Label("Upper Arm(mm):");
		TextField uat = new TextField();
		layout.add(ual,0, 3);
		layout.add(uat, 1, 3);
		
		Label tl = new Label("Thigh(mm):");
		TextField tt = new TextField();
		layout.add(tl,0, 4);
		layout.add(tt, 1, 4);
		
		Label fal = new Label("Forearm(mm):");
		TextField fat = new TextField();
		layout.add(fal,0, 5);
		layout.add(fat, 1, 5);
		
		Label chl = new Label("Chest(mm):");
		TextField cht = new TextField();
		layout.add(chl,0, 6);
		layout.add(cht, 1, 6);
		
		Label cal = new Label("Calf(mm):");
		TextField cat = new TextField();
		layout.add(cal,0, 7);
		layout.add(cat, 1, 7);
		
		Label wal = new Label("Waist(mm):");
		TextField wat = new TextField();
		layout.add(wal,0, 8);
		layout.add(wat, 1, 8);
		
		Label shol = new Label("Shoulder(mm):");
		TextField shot = new TextField();
		layout.add(shol,0, 9);
		layout.add(shot, 1, 9);
		
		Label nel = new Label("Neck(mm):");
		TextField net = new TextField();
		layout.add(nel,0, 10);
		layout.add(net, 1, 10);
		
		layout.add(titel, 0,0);
		layout.add(closeButton, 1, 11);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(20,20,20,20));
		
		
		closeButton.setOnAction(e -> {
			bodyMeasurementHandler.add(new bodyMeasurement(
					 Double.parseDouble(bwt.getText()),Double.parseDouble(calt.getText()),Double.parseDouble(uat.getText()),
					 Double.parseDouble(tt.getText()),Double.parseDouble(fat.getText()),Double.parseDouble(cht.getText()),
					 Double.parseDouble(cat.getText()),Double.parseDouble(wat.getText()),Double.parseDouble(shot.getText()), Double.parseDouble(net.getText())));
			bodyMeasurementHandler.save();
			bodyMeasurementHandler.build();
			window.close();
		});
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
