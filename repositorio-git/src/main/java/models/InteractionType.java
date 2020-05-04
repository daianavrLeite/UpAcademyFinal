package models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = InteractionType.GET_ALL_INTERACTIONTYPE_QUERY_NAME, query="SELECT i FROM InteractionType i"),
@NamedQuery(name = InteractionType.GET_ALL_INTERACTIONTYPE_IDS, query="SELECT i.id FROM InteractionType i")
})



public class InteractionType extends Entity_

{

	public static final String GET_ALL_INTERACTIONTYPE_QUERY_NAME = "InteractionType.getAllInteractionType" ;
	public static final String GET_ALL_INTERACTIONTYPE_IDS = "InteractionType.getAllInteractionTypeIds" ;
	private static final long serialVersionUID = 1L;
	
	private String interactionType;

	
	public String getInteractionType()
	
	{
		return interactionType;
	}

	public void setInteractionType(String interactionType) 
	
	{
		this.interactionType = interactionType;
	}
	
	

}
