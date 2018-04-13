package Work;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gui.PublicElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Work.ProductDevTicket;
import bodyMeasurement.bodyMeasurement;

public class ProductDevTicketHandler implements Serializable {

	private static final long serialVersionUID = 4685773832326641627L;
	int length = 10;
	static FlowPane fp = new FlowPane(20, 20);

	public static ArrayList<ProductDevTicket> tickets = new ArrayList<ProductDevTicket>();
	public static ArrayList<ProductDevTicket> ticketsU = new ArrayList<ProductDevTicket>();
	public static ArrayList<ProductDevTicket> blank = new ArrayList<ProductDevTicket>();

	static ArrayList<ProductDevTicketBuilder> builders = new ArrayList<ProductDevTicketBuilder>();

	public ProductDevTicketHandler() {

	}

	public static void setup() {
		System.out.println("Setup Running");
		ProductDevTicket tempTicket = new ProductDevTicket(0, "", "", "");
		ProductDevTicketBuilder tempBuidler = new ProductDevTicketBuilder(tempTicket);
		ProductDevTicket t1 = new ProductDevTicket(0, "LTN90", "13/04/2018", "Build it.");
		ProductDevTicket t2 = new ProductDevTicket(1, "LTN80", "12/04/2018", "Make it");
		ProductDevTicket t3 = new ProductDevTicket(2, "LTN70", "11/04/2018", "Work it");
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		ticketsU = tickets;
		save();
	}

	// Construct the tickets#

	static public void displayTickets() {
		// System.out.println("Clearing the builder Arraylist");
		builders.clear();
		// System.out.println("Clearing the FlowPane of children");
		fp.getChildren().clear();
		// System.out.println("Setting new Position ID's");
		for (int i = 0; i < tickets.size(); i++) {
			ProductDevTicket tempTicket;
			tempTicket = tickets.get(i);
			tempTicket.setTicketID(i);
		}
		// System.out.println("making new Vbox");
		VBox tempBox = new VBox();
		// System.out.println("Generating tempTicket");
		ProductDevTicket tempTicket = new ProductDevTicket(0, "", "", "");
		// System.out.println("Generating new temp builder");
		ProductDevTicketBuilder tempBuilder = new ProductDevTicketBuilder(tempTicket);
		// System.out.println("Starting Building Loop");
		for (int i = 0; i < tickets.size(); i++) {
			// System.out.println("Constructing builder: "+i);
			tempBuilder = new ProductDevTicketBuilder(tickets.get(i));
			// System.out.println("Adding builder "+i +" to builder list");
			builders.add(tempBuilder);
			// System.out.println("Setting temp builder to new builder object from list");
			tempBuilder = builders.get(i);
			// System.out.println("Updating that builder");
			tempBuilder.update();
			// System.out.println("setting temp box to the render content for new builder");
			tempBox = tempBuilder.render();
			// System.out.println("adding tempbox to flowpane");
			fp.getChildren().addAll(tempBox);
		}
		// System.out.println("loop complete, displaying flowpane on mainpage");
		PublicElements.workRoot.getChildren().clear();
		PublicElements.workRoot.getChildren().addAll(fp);
	}

	public static void addNewTicket() {
		VBox root = new VBox(8);
		Label titleL = new Label("Title");
		Label desL = new Label("Description");
		Label dateL = new Label("Date");
		TextField title = new TextField();
		TextField des = new TextField();
		TextField date = new TextField();
		Button submit = new Button("Submit");

		root.getChildren().addAll(titleL, title, desL, des, dateL, date, submit);
		Stage stage = new Stage();
		submit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String t, d, de;
				t = title.getText();
				d = date.getText();
				de = des.getText();
				ProductDevTicket tempTicket = new ProductDevTicket(0, d, t, de);
				ticketsU = tickets;
				ticketsU.add(tempTicket);
				save();
				displayTickets();

				stage.close();
			}
		});
		stage.setTitle("My New Stage Title");
		stage.setScene(new Scene(root, 450, 450));
		stage.show();
	}

	static void removeTicket(int i) {
		System.out.println("Tickets syncronising");
		ticketsU = tickets;
		System.out.println("Removing ticket " + i);
		ticketsU.remove(i);
		System.out.println("Running save");
		save();
		System.out.println("Running Display");
		displayTickets();
	}

	public static void load() {
		try {
			// Use XMLDecoder to read the same XML file in.
			final XMLDecoder decoder = new XMLDecoder(new FileInputStream(new File("ProductDevelopmentTickets.xml")));
			final ArrayList<ProductDevTicket> listFromFile = (ArrayList<ProductDevTicket>) decoder.readObject();
			decoder.close();
			System.out.println("Loading Tickets successful");
			System.out.println("Reading Arraylist: " + listFromFile);
			tickets = listFromFile;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void save() {
		try {
			System.out.println("Opening Encoder");
			final XMLEncoder encoder = new XMLEncoder(
					new BufferedOutputStream(new FileOutputStream(new File("ProductDevelopmentTickets.xml"))));
			System.out.println("removeing old tickets");
			encoder.remove(tickets);
			System.out.println("Writing new tickets");
			encoder.writeObject(ticketsU);
			System.out.println("Syncronising Lists");
			tickets = ticketsU;
			System.out.println("Closing Encoder");
			encoder.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Failure");
		}
	}
}
