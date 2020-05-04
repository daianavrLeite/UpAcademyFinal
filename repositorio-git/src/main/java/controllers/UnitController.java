package controllers;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Path;

import controllers.PersonController.Secured;
import models.Unit;
import repositories.UnitRepository;
import services.UnitService;

@Secured
@PermitAll
@Path("units")
public class UnitController extends EntityController<UnitService, UnitRepository, Unit>

{
	
}
