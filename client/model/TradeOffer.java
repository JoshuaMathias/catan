package client.model;
/**
 * This class represents a trade offer.
 * @author Ife's group
 *
 */
public class TradeOffer {

	private int sender;
	private int receiver;
	private ResourceList offer;
	
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public ResourceList getOffer() {
		return offer;
	}
	public void setOffer(ResourceList offer) {
		this.offer = offer;
	}
}
