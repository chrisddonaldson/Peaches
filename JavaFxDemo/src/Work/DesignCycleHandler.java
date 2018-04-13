package Work;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DesignCycleHandler implements Serializable{
	ProductDevTicket ticket;
	ArrayList<DesignCycle> designCycleHandler;
	DesignCycleHandler(ProductDevTicket ticket){
		ArrayList<DesignCycle> designCycleHandler= new ArrayList<DesignCycle>();
		this.ticket=ticket;
		}
	void addDesignCycle() {
		DesignCycle c1 = new DesignCycle(0);
		this.designCycleHandler.add(c1);
	}
	HBox diplay(){
		DesignCycle tempDc;
		tempDc= designCycleHandler.get(0);
		int i = tempDc.getTicketId();
		Label x = new Label("#"+i);
		HBox h = new HBox();
		h.getChildren().addAll(x);
		return h;
		
	}
	
}
