package repositories;

import models.Client;
import models.Unit;

public class UnitRepository extends EntityRepository <Unit>{

	@Override
	public Class<Unit> getEntityClass() 
	
	{
		return Unit.class;
	}

	@Override
	public String getAllEntityQueryName() 
	
	{
		return Unit.GET_ALL_UNITS_QUERY_NAME;
	}

	@Override
	protected String getAllIdsQueryName()
	
	{
		return Unit.GET_ALL_UNITS_IDS;
	}


}
