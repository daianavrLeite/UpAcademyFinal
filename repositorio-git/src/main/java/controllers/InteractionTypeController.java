package controllers;

import javax.ws.rs.Path;

import models.InteractionType;
import repositories.InteractionTypeRepository;
import services.InteractionTypeService;

@Path("interactiontype")
public class InteractionTypeController extends EntityController<InteractionTypeService, InteractionTypeRepository, InteractionType> 

{

	
	
}
