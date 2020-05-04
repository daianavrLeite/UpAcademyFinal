package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import models.Unit;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "nipc") }) // unique values in DB
@NamedQueries({ @NamedQuery(name = Client.GET_ALL_CLIENTS, query = "SELECT c FROM Client c"),
		@NamedQuery(name = Client.GET_ALL_CLIENTS_IDS, query = "SELECT c.id FROM Client c"),
		@NamedQuery(name = Client.GET_CLIENT_BY_NAME, query = "SELECT c FROM Client c WHERE c.name =:name"),
		@NamedQuery(name= Client.GET_CLIENT_BY_NIPC, query = "SELECT c FROM Client c WHERE c.nipc =:nipc"),
		@NamedQuery(name=  Client.CLEAR_INTERACTION_BY_CLIENTID , query=" DELETE FROM Interaction i WHERE i.client.id = :clientId"),
		@NamedQuery(name = Client.GET_COUNT_INTERACTIONS, query = "SELECT m, COUNT(i.client.id) FROM Client m LEFT JOIN Interaction i ON m.id = i.client.id GROUP BY m.id "),
		@NamedQuery(name = Client.COUNT, query = "SELECT COUNT(c.id) FROM Client c"),
@NamedQuery(name = Client.GET_ALL_CLIENTS_QUERY_NAME, query="SELECT c FROM Client c"),
@NamedQuery(name = Client.UPDATE_POTENTIAL_REVENUE, query = "UPDATE Client c SET c.potentialRevenue = c.potentialRevenue + :value WHERE c.id =:id"),
@NamedQuery(name = Client.UPDATE_DECREASE_POTENTIAL_REVENUE, query = "UPDATE Client c SET c.potentialRevenue = c.potentialRevenue - :value WHERE c.id =:id"),
@NamedQuery(name = Client.TOP5_POTENTIAL_REVENUE, query="SELECT c.name, c.potentialRevenue FROM Client c ORDER BY c.potentialRevenue DESC")
})

public class Client extends Entity_

{
	public static final String GET_ALL_CLIENTS = "Client.getAllClients";
	public static final String GET_ALL_CLIENTS_IDS = "Client.getAllClientsIds";
	public static final String GET_CLIENT_BY_NAME = "Client.getClientByName";
	public static final String GET_CLIENT_BY_NIPC = "Client.getClientByNipc";
	public static final String CLEAR_INTERACTION_BY_CLIENTID = "Client.clearInteractionByClientId";
	public static final String GET_COUNT_INTERACTIONS = "Client.getCountInteraction";
	public static final String COUNT = "Client.Count";	
	public static final String GET_ALL_CLIENTS_QUERY_NAME = "Product.getAllClients" ;
	public static final String UPDATE_POTENTIAL_REVENUE = "Client.updateRevenue";
	public static final String UPDATE_DECREASE_POTENTIAL_REVENUE = "Client.updateDecreaseRevenue";
	public static final String TOP5_POTENTIAL_REVENUE = "Client.top5PotentialRevenue";
	
	private static final long serialVersionUID = 1L;

	private String name;
	private int nipc;
	private long potentialRevenue;
	
	public Client() {
	}

	public String getName()

	{
		return name;
	}

	public void setName(String name)

	{
		this.name = name;
	}

	public int getNipc()

	{
		return nipc;
	}

	public void setNipc(int nipc)
	{
		this.nipc = nipc;
	}
	
	public long getPotentialRevenue()

	{
		return potentialRevenue;
	}

	public void setPotentialRevenue(long potentialRevenue)
	{
		this.potentialRevenue = potentialRevenue;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", nipc=" + nipc + ", potentialRevenue=" + potentialRevenue +"]";
	}
	
	}


