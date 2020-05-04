package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
		@NamedQuery(name = Interaction.GET_ALL, query = "SELECT i FROM Interaction i ORDER BY i.dateInteraction + 0"),
		@NamedQuery(name = Interaction.GET_ALL_WEEKS, query = "SELECT DISTINCT i.dateInteraction FROM Interaction i ORDER BY i.dateInteraction + 0"),
		@NamedQuery(name = Interaction.GET_ALL_WEEKS_FILTER, query = "SELECT i FROM Interaction i WHERE i.dateInteraction = :filter ORDER BY i.dateInteraction"),
		@NamedQuery(name = Interaction.GET_ALL_UNITIES, query = "SELECT DISTINCT i.unit.nameUnit FROM Interaction i ORDER BY i.unit.nameUnit"),
		@NamedQuery(name = Interaction.GET_ALL_UNITIES_FILTER, query = "SELECT i FROM Interaction i WHERE i.unit.nameUnit = :filter ORDER BY i.unit.nameUnit"),
		@NamedQuery(name = Interaction.GET_ALL_B_MANAGERS, query = "SELECT DISTINCT i.person.name FROM Interaction i ORDER BY i.person.name"),
		@NamedQuery(name = Interaction.GET_ALL_B_MANAGERS_FILTER, query = "SELECT i FROM Interaction i WHERE i.person.name = :filter ORDER BY i.person.name"),
		@NamedQuery(name = Interaction.GET_ALL_CLIENTS, query = "SELECT DISTINCT i.client.name FROM Interaction i ORDER BY i.client.name"),
		@NamedQuery(name = Interaction.GET_ALL_CLIENTS_FILTER, query = "SELECT i FROM Interaction i WHERE i.client.name = :filter ORDER BY i.client.name"),
		@NamedQuery(name = Interaction.GET_ALL_INTERACTIONS, query = "SELECT DISTINCT i.interactionType.interactionType FROM Interaction i ORDER BY i.interactionType.interactionType"),
		@NamedQuery(name = Interaction.GET_ALL_INTERACTIONS_BY_USER_ID, query = "SELECT i FROM Interaction i WHERE i.person.id =: personId"),
		@NamedQuery(name = Interaction.GET_ALL_INTERACTIONS_FILTER, query = "SELECT i FROM Interaction i WHERE i.interactionType.interactionType = :filter ORDER BY i.interactionType"),
		@NamedQuery(name = Interaction.GET_ALL_BETWEEN, query = "SELECT i FROM Interaction i WHERE i.id >= :startIndex AND i.id < :quantity ORDER BY i.dateInteraction + 0"),
		//	@NamedQuery(name = Interaction.GET_ALL_FILTER, query="SELECT i FROM Interaction i WHERE :filter ORDER BY i.dateInteraction"),
		@NamedQuery(name = Interaction.GET_ALL_SEARCH, query = "SELECT i FROM Interaction i WHERE i.dateInteraction LIKE :search"
				+ " OR i.unit.nameUnit LIKE :search" + " OR i.person.name LIKE :search"
				+ " OR i.interactionType.interactionType LIKE :search"
				+ " OR i.client.name LIKE :search ORDER BY i.dateInteraction"),
        @NamedQuery(name = Interaction.GET_INTERACTIONS_GROUP_BY_CLIENT_AND_INTERACTION_TYPE, query=" Select count(i) as countInteractions, c.name, it.interactionType from Interaction i join i.client c "
        		+ "join i.interactionType it where i.interactionType.id in (1,2) group by c.name, it.interactionType"),
        @NamedQuery(name = Interaction.GET_INTERACTIONS_GROUP_BY_MANAGER_AND_INTERACTION_TYPE, query=" Select count(i) as countInteractions, c.name, it.interactionType from Interaction i join i.person c "
        		+ "join i.interactionType it where i.interactionType.id in (1,2)  group by c.name, it.interactionType"),
		// Second TAB queries
		@NamedQuery(name = Interaction.GET_ALL_REVENUE_PER_CLIENT, query = "SELECT i.client.potentialRevenue FROM Interaction i WHERE i.client.name = :name AND i.interactionType.interactionType = :interaction"),
		@NamedQuery(name = Interaction.GET_ALL_REVENUE_PER_MANAGER, query = "SELECT i.client.potentialRevenue FROM Interaction i WHERE i.person.name = :name AND i.interactionType.interactionType = :interaction"),
		
		// Dashboard Module Starts
		@NamedQuery(name = Interaction.GET_ALL_CVS_PER_MANAGER_PER_WEEK, query = "SELECT i FROM Interaction i WHERE i.dateInteraction = :week AND i.person.name = :manager AND i.interactionType.interactionType = 'CV enviado' ORDER BY i.interactionType.id"),
		@NamedQuery(name = Interaction.COUNT_ALL_CVS_PER_WEEK_PER_MANAGER, query = "SELECT COUNT(i.interactionType) FROM Interaction i WHERE i.dateInteraction = :week AND i.person.name = :manager AND i.interactionType.interactionType = 'CV enviado' ORDER BY i.interactionType.id"),
		@NamedQuery(name = Interaction.COUNT_ALL_INTERACTIONS_PER_UNIT, query = "SELECT COUNT(i.interactionType) FROM Interaction i WHERE i.unit.nameUnit = :unit"),
		@NamedQuery(name = Interaction.COUNT_ALL_INTERACTIONS_PER_INTERACTION_TYPE, query = "SELECT COUNT(i.interactionType) FROM Interaction i WHERE i.interactionType.interactionType = :interactionType"),
		@NamedQuery(name = Interaction.COUNT_ALL_INTERACTIONS_PER_CLIENT, query = "SELECT COUNT(i.interactionType) FROM Interaction i WHERE i.client.name = :clientName"),
		@NamedQuery(name = Interaction.COUNT_ACCEPTED_CONTRACTS_PER_WEEK, query = "SELECT COUNT(i) FROM Interaction i WHERE i.interactionType.interactionType = 'Proposta aceite' AND i.dateInteraction = :week"),
		@NamedQuery(name = Interaction.COUNT_ALL_INTERVIEWS_PER_WEEK, query = "SELECT COUNT(i) FROM Interaction i WHERE i.interactionType.interactionType = 'Entrevista' AND i.dateInteraction = :week"),
		@NamedQuery(name = Interaction.COUNT_ALL_CONTRACTS_PER_WEEK, query = "SELECT COUNT(i) FROM Interaction i WHERE i.dateInteraction = :week AND (i.interactionType.interactionType = 'Proposta aceite' OR i.interactionType.interactionType = 'Proposta recusada')"),
		// Dashboard Module Ends
		
})

public class Interaction extends Entity_ {

	public static final String GET_ALL_WEEKS = "Interaction.getAllWeeks";
	public static final String GET_ALL_WEEKS_FILTER = "Interaction.getAllWeeksFilter";
	public static final String GET_ALL_UNITIES = "Interaction.getAllUnities";
	public static final String GET_ALL_UNITIES_FILTER = "Interaction.getAllUnitiesFilter";
	public static final String GET_ALL_B_MANAGERS = "Interaction.getAllBManagers";
	public static final String GET_ALL_B_MANAGERS_FILTER = "Interaction.getAllBManagersFilter";
	public static final String GET_ALL_CLIENTS = "Interaction.getAllClients";
	public static final String GET_ALL_CLIENTS_FILTER = "Interaction.getAllClientsFilter";
	public static final String GET_ALL_INTERACTIONS = "Interaction.getAllInteractions";
	public static final String GET_ALL_INTERACTIONS_FILTER = "Interaction.getAllInteractionsFilter";
//	public static final String GET_ALL_FILTER = "Interaction.getAllFilter";
	public static final String GET_ALL_SEARCH = "Interaction.getAllSearch";
	public static final String GET_ALL = "Interaction.getAll";
	public static final String GET_ALL_BETWEEN = "Interaction.getAllBetween";
	public static final String GET_ALL_REVENUE_PER_CLIENT = "Interaction.getAllRevenuePerClient";
	public static final String GET_ALL_REVENUE_PER_MANAGER = "Interaction.getAllRevenuePerManager";
    public static final String GET_INTERACTIONS_GROUP_BY_CLIENT_AND_INTERACTION_TYPE= "Interaction.getInteractionGroupByClientAndInteractionType";
    public static final String GET_INTERACTIONS_GROUP_BY_MANAGER_AND_INTERACTION_TYPE= "Interaction.getInteractionGroupByManagerAndInteractionType";

    
	// Dashboard Module Starts
	public static final String GET_ALL_CVS_PER_MANAGER_PER_WEEK = "Interaction.getAllCvsPerManagerPerWeek";
	public static final String COUNT_ALL_CVS_PER_WEEK_PER_MANAGER = "Interaction.countAllCvsPerWeekPerManager";
	public static final String COUNT_ALL_INTERACTIONS_PER_UNIT = "Interaction.countAllInteractionsPerUnit";
	public static final String COUNT_ALL_INTERACTIONS_PER_INTERACTION_TYPE = "Interaction.countAllInteractionsPerInteractionType";
	public static final String COUNT_ALL_INTERACTIONS_PER_CLIENT = "Interaction.countAllInteractionsPerClient";
	public static final String COUNT_ACCEPTED_CONTRACTS_PER_WEEK = "Interaction.countAcceptedContractsPerWeek";
	public static final String COUNT_ALL_INTERVIEWS_PER_WEEK = "Interaction.countAllInterviewsPerWeek";
	public static final String COUNT_ALL_CONTRACTS_PER_WEEK = "Interaction.countAllContractsPerWeek";
	// DashBoard Module Ends
	
	public static final String GET_ALL_INTERACTIONS_BY_USER_ID = "Interaction.getAllInteractionsByUserId";

	private static final long serialVersionUID = 1L;
	

	private String dateInteraction;
	private Long potentialRevenue;
	// These are the child entities (check Person, Unit, Client and InteractionType to see parent entites and its annotations
	
	// Not sure if implemented as for example:  https://vladmihalcea.com/the-best-way-to-map-a-onetoone-relationship-with-jpa-and-hibernate/
	
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id") // It's going to make a reference to each individual table of person, unit, client
	private Person person;
	@OneToOne
	@JoinColumn(name = "unit_id", referencedColumnName = "id")
	private Unit unit;
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	@OneToOne
	@JoinColumn(name = "interactionType_id", referencedColumnName = "id")
	private InteractionType interactionType;

	
	public Long getPotentialRevenue() {
		return potentialRevenue;
	}

	public void setPotentialRevenue(Long potentialRevenue) {
		this.potentialRevenue = potentialRevenue;
	}
	
	public String getDateInteraction()

	{
		return dateInteraction;
	}

	public void setDateInteraction(String dateInteraction)

	{
		this.dateInteraction = dateInteraction;
	}

	public Person getPerson()

	{
		return person;
	}

	public void setPerson(Person person)

	{
		this.person = person;
	}

	public Unit getUnit()

	{
		return unit;
	}

	public void setUnit(Unit unit)

	{
		this.unit = unit;
	}

	public Client getClient()

	{
		return client;
	}

	public void setClient(Client client)

	{
		this.client = client;
	}

	public InteractionType getInteractionType()

	{
		return interactionType;
	}

	public void setInteractionType(InteractionType interactionType)

	{
		this.interactionType = interactionType;
	}

}
