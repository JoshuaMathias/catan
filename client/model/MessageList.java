package client.model;

import java.util.ArrayList;
/**
 * This class represents a list of messages.
 * @author Ife's group
 *
 */
public class MessageList {

	private ArrayList<MessageLine> lines;

	public ArrayList<MessageLine> getLines() {
		return lines;
	}

	public void setLines(ArrayList<MessageLine> lines) {
		this.lines = lines;
	}
}
