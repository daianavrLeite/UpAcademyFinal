package repositories;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.NoResultException;

import models.Client;
import models.Interaction;
import models.Person;

@ApplicationScoped
public class ClientRepository extends EntityRepository<Client>

{
	protected String top5PotentialRevenueQueryName() {
		return Client.TOP5_POTENTIAL_REVENUE;
	}

	@Override
	public Class<Client> getEntityClass()

	{
		return Client.class;
	}

	@Override
	public String getAllEntityQueryName()

	{
		return Client.GET_ALL_CLIENTS;
	}

	@Override
	protected String getAllIdsQueryName()

	{
		return Client.GET_ALL_CLIENTS_IDS;
	}

	public int updateRevenue(long id, long value) {
		return entityManager.createNamedQuery(Client.UPDATE_POTENTIAL_REVENUE).setParameter("value", value)
				.setParameter("id", id).executeUpdate();

	}

	public void updateDecreaseRevenue(long id, Long potentialRevenue) {
		// TODO Auto-generated method stub
		entityManager.createNamedQuery(Client.UPDATE_DECREASE_POTENTIAL_REVENUE).setParameter("value", potentialRevenue)
				.setParameter("id", id).executeUpdate();
	}

	public Client getClientByName(String name) throws NoResultException {

		return entityManager.createNamedQuery(Client.GET_CLIENT_BY_NAME, Client.class).setParameter("name", name)
				.getSingleResult();
	}

	public Client getClientByNipc(int nipc) throws NoResultException {

		return entityManager.createNamedQuery(Client.GET_CLIENT_BY_NIPC, Client.class).setParameter("nipc", nipc)
				.getSingleResult();
	}

	public void clearInteractionByClientId(long clientId) {
		entityManager.createNamedQuery(Client.CLEAR_INTERACTION_BY_CLIENTID).setParameter("clientId", clientId)
				.executeUpdate();

	}

	public Collection<Client> getCount(int startIndex, int quantity) {
		return entityManager.createNamedQuery(Client.GET_COUNT_INTERACTIONS).setFirstResult(startIndex)
				.setMaxResults(quantity).getResultList();
	}

	public Long getTotal() {
		return (long) entityManager.createNamedQuery(Client.COUNT).getSingleResult();
	}

	/***************************
	 * Dashboard Module Starts *
	 **************************/

	public Collection<Client> top5PotentialRevenue() {
		return entityManager.createNamedQuery(top5PotentialRevenueQueryName()).setFirstResult(0).setMaxResults(5).getResultList();
	}

	/************************
	 * Dashboard Module Ends *
	 ************************/

}
