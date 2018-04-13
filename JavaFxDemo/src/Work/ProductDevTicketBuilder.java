package Work;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import Work.ProductDevTicket;
import Work.ProductDevTicketHandler;

public class ProductDevTicketBuilder {
	VBox infoBlock = new VBox(10);
	String name, date, des;
	Button delete = new Button("Delete");
	int ID;

	public ProductDevTicketBuilder(ProductDevTicket t) {
		this.name = t.getTitle();
		this.date = t.getDateCreated();
		this.des = t.getDescription();
		this.ID = t.getTicketID();
		delete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ProductDevTicketHandler.removeTicket(ID);
			}
		});
	}

	void update() {
		Label titleL = new Label(name);
		Label desL = new Label(des);
		Label dateL = new Label(date);
		Label idL = new Label(Integer.toString(ID));
		
		//DESIGN CYCLE PANE
		TitledPane tp = new TitledPane();
		Button addDesignCycle = new Button("Add Design Cycle");
		addDesignCycle.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
		
			}
		});
		tp.setText(name+"'s design cycles");
		tp.setContent(addDesignCycle);
		
		infoBlock.getChildren().addAll(idL, titleL, desL, dateL, delete,tp);
		infoBlock.setMaxWidth(150);
		desL.setWrapText(true);
	}

	VBox render() {
		return infoBlock;
	}

}
