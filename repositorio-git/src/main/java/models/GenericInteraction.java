package models;

public class GenericInteraction {
	
	
	int countInteractions;
	public int getCountInteractions() {
		return countInteractions;
	}
	public void setCountInteractions(int countInteractions) {
		this.countInteractions = countInteractions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInteractionType() {
		return interactionType;
	}
	public void setInteractionType(String interactionType) {
		this.interactionType = interactionType;
	}
	String name;
	String interactionType;

}
