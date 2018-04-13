package Work;

import java.io.Serializable;

public class ProductDevTicket implements Serializable {

	int ticketID;
	String dateCreated, title, description;

	public ProductDevTicket() {
	}

	public ProductDevTicket(int ticketID, String dateCreated, String title, String description) {
		this.ticketID = ticketID;
		this.dateCreated = dateCreated;
		this.title = title;
		this.description = description;
		DesignCycleHandler designCycleHandler  = new DesignCycleHandler(this);
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
