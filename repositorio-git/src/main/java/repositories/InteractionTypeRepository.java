package repositories;

import models.InteractionType;
import models.Unit;

public class InteractionTypeRepository extends EntityRepository <InteractionType> {

	@Override
	public Class<InteractionType> getEntityClass() 
	
	{
		return InteractionType.class;
	}

	@Override
	public String getAllEntityQueryName() 
	
	{
		return InteractionType.GET_ALL_INTERACTIONTYPE_QUERY_NAME;
	}

	@Override
	protected String getAllIdsQueryName()
	
	{
		return InteractionType.GET_ALL_INTERACTIONTYPE_IDS;
	}

	
	
}
