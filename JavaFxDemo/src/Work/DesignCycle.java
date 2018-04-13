package Work;

import java.io.Serializable;

public class DesignCycle implements Serializable {

	int cycleId;
	int ticketId;
	String dateCreateed;
	String dateCompleted;
	String description;
	int position;
	public DesignCycle(int i) {
		this.ticketId = i;
	}
	public int getTicketId() {
		return ticketId;
	}
}
