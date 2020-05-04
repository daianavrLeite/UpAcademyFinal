package controllers;

import java.util.Collection;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Entity_;
import repositories.EntityRepository;
import services.EntityService;

public abstract class EntityController<S extends EntityService<R, E>, R extends EntityRepository<E>, E extends Entity_>

{

	@Inject // Inject generic variable in runtime
	protected S service;

	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response save(E object)

	{
		try {
			E saveObject = service.save(object);
			return Response.ok(saveObject).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}

	}

	@PUT
	@PermitAll
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response update(@PathParam("id") long id, E object)

	{
		try {
			E saveObject = service.save(object);
			return Response.ok(saveObject).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@PermitAll
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public Response delete(@PathParam("id") long id)

	{
		try {
			service.delete(id);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
	}

	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> showAllEntities() {
		return service.showAllEntities();
	}

	@GET
	@PermitAll
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds()

	{
		return service.getAllKeys();
	}

	@GET
	@PermitAll
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public E getEntity(@PathParam("id") long id)

	{
		return service.getObject(id);
	}

}
