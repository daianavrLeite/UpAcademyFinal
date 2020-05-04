package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.QueryParam;

import models.Client;
import models.GenericInteraction;
import models.Interaction;
import models.InteractionType;
import models.Person;
import models.Unit;

public class InteractionRepository extends EntityRepository <Interaction>{

	protected String getAllWeeksQueryName() {
		return Interaction.GET_ALL_WEEKS;
	}
	
	protected String getAllWeeksFilterQueryName() {
		return Interaction.GET_ALL_WEEKS_FILTER;
	}
	
	protected String getAllClientsQueryName() {
		return Interaction.GET_ALL_CLIENTS;
	}
	protected String getAllClientsFilterQueryName() {
		return Interaction.GET_ALL_CLIENTS_FILTER;
	}
	
	protected String getAllBManagersQueryName() {
		return Interaction.GET_ALL_B_MANAGERS;
	}
	
	protected String getAllBManagersFilterQueryName() {
		return Interaction.GET_ALL_B_MANAGERS_FILTER;
	}
	protected String getAllUnitiesQueryName() {
		return Interaction.GET_ALL_UNITIES;
	}
	protected String getAllUnitiesFilterQueryName() {
		return Interaction.GET_ALL_UNITIES_FILTER;
	}
	protected String getAllInteractionsQueryName() {
		return Interaction.GET_ALL_INTERACTIONS;
	}
	protected String getAllInteractionsFilterQueryName() {
		return Interaction.GET_ALL_INTERACTIONS_FILTER;
	}
//	protected String getAllFilterQueryName() {
//		return Interaction.GET_ALL_FILTER;
//	}
	protected String getAllSearchQueryName() {
		return Interaction.GET_ALL_SEARCH;
	}
	
	protected String getAllQueryName() {
		return Interaction.GET_ALL;
	}
	
	protected String getAllBetweenQueryName() {
		return Interaction.GET_ALL_BETWEEN;
	}
	
	protected String getAllRevenuePerClientQueryName() {
		return Interaction.GET_ALL_REVENUE_PER_CLIENT;
	}
	
	protected String getAllRevenuePerManagerQueryName() {
		return Interaction.GET_ALL_REVENUE_PER_MANAGER;
	}
	
//	public Collection<Interaction> showAllBetween(Long startIndex, Long quantity) {
//		return entityManager.createNamedQuery(getAllBetweenQueryName())
//				.setParameter("startIndex", startIndex)
//				.setParameter("quantity", quantity)
//				.getResultList();
//	}
	
	 /**************************
	 * Dashboard Module Starts *
	 **************************/
	
	protected String getAllCvsByManagerPerWeekQueryName() {
		return Interaction.GET_ALL_CVS_PER_MANAGER_PER_WEEK;
	}
	
	protected String countAllCvsPerWeekPerManagerQueryName() {
		return Interaction.COUNT_ALL_CVS_PER_WEEK_PER_MANAGER;
	}
	
	protected String countAllInteractionsPerUnitQueryName() {
		return Interaction.COUNT_ALL_INTERACTIONS_PER_UNIT;
	}
	
	protected String countAllInteractionsPerInteractionTypeQueryName() {
		return Interaction.COUNT_ALL_INTERACTIONS_PER_INTERACTION_TYPE;
	}
	
	protected String countAllInteractionsPerClientQueryName() {
		return Interaction.COUNT_ALL_INTERACTIONS_PER_CLIENT;
	}
	
	protected String countAcceptedContractsPerWeekQueryName() {
		return Interaction.COUNT_ACCEPTED_CONTRACTS_PER_WEEK;
	}
	
	protected String countAllInterviewsPerWeekQueryName() {
		return Interaction.COUNT_ALL_INTERVIEWS_PER_WEEK;
	}
	
	protected String countAllContractsPerWeekQueryName() {
		return Interaction.COUNT_ALL_CONTRACTS_PER_WEEK;
	}
	
	 /************************
	 * Dashboard Module Ends *
	 ************************/
	
	protected String getAllInteractionsByUserId() {
		return Interaction.GET_ALL_INTERACTIONS_BY_USER_ID;
	}
	
	
	@Override
	public Class<Interaction> getEntityClass() {
		return Interaction.class;
	}

	@Override
	public String getAllEntityQueryName() {

		return null;
	}

	@Override
	protected String getAllIdsQueryName() {

		return null;
	}
//	
	public Collection<Interaction> showAll() {
		return entityManager.createNamedQuery(getAllQueryName()).getResultList();
	}
	
	public Collection<Interaction> showAllBetween(int startIndex, int quantity) {
		return entityManager.createNamedQuery(getAllQueryName())
				.setFirstResult(startIndex)
				.setMaxResults(quantity)
				.getResultList();
	}


	public Collection<String> showAllWeeks() {
		
		return entityManager.createNamedQuery
				(getAllWeeksQueryName(), String.class)
				.getResultList();
	}
	
	public Collection<Interaction> showAllWeeksFilter(String filter) {
		
		return entityManager.createNamedQuery
				(getAllWeeksFilterQueryName()).setParameter("filter", filter)
				.getResultList();
	}
	
	public Collection<String> showAllClients() {
		
		return entityManager.createNamedQuery
				(getAllClientsQueryName(), String.class)
				.getResultList();
	}
	
	public Collection<Interaction> showAllClientsFilter(String filter) {
		return entityManager.createNamedQuery
				(getAllClientsFilterQueryName()).setParameter("filter", filter)
				.getResultList();
	}
	
	public Collection<String> showAllBManagers() {
		
		return entityManager.createNamedQuery
				(getAllBManagersQueryName(), String.class)
				.getResultList();
	}
	
	public Collection<Interaction> showAllBManagersFilter(String filter) {
		return entityManager.createNamedQuery
				(getAllBManagersFilterQueryName()).setParameter("filter", filter)
				.getResultList();
	}

	public Collection<String> showAllInteractions() {
		
		return entityManager.createNamedQuery
				(getAllInteractionsQueryName(), String.class)
				.getResultList();
	}
	
	public Collection<Interaction> showAllInteractionsFilter(String filter) {
		return entityManager.createNamedQuery
				(getAllInteractionsFilterQueryName()).setParameter("filter", filter)
				.getResultList();
	}

	public Collection<String> showAllUnities() {
		
		return entityManager.createNamedQuery
				(getAllUnitiesQueryName(), String.class)
				.getResultList();
	}
	
	public Collection<Interaction> showAllUnitiesFilter(String filter) {
		
		return entityManager.createNamedQuery
				(getAllUnitiesFilterQueryName()).setParameter("filter", filter)
				.getResultList();
	}

//	public Collection<Interaction> showAllFilter(String filter) {
//		return entityManager.createNamedQuery
//				(getAllFilterQueryName(), getEntityClass()).setParameter("filter", filter)
//				.getResultList();
//	}
	
	public Collection<Interaction> showAllSearch(String search) {
		return entityManager.createNamedQuery
				(getAllSearchQueryName(), getEntityClass()).setParameter("search", search).getResultList();
	}
	
	public Collection<Interaction> showAllRevenuePerClient(String name, String interaction) {
		return entityManager.createNamedQuery
				(getAllRevenuePerClientQueryName())
				.setParameter("name", name)
				.setParameter("interaction", interaction)
				.getResultList();
	}
	
	public Collection<Interaction> showAllRevenuePerManager(String name, String interaction) {
		return entityManager.createNamedQuery
				(getAllRevenuePerManagerQueryName())
				.setParameter("name", name)
				.setParameter("interaction", interaction)
				.getResultList();
	}
	
	public Collection<Interaction> filtrer(String myselectWeek,
			String myselectUnit,
			String myselectClient,
			String myselectBM,
			String myselectInteration,
			int startIndex,
			int quantity) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Interaction> q = cb.createQuery(Interaction.class);
		Root<Interaction> root = q.from(Interaction.class);
		q.select(root);
		q.orderBy(cb.asc(root.get("dateInteraction").as(Integer.class)));
		
		List<Predicate> listPredicate = new ArrayList<Predicate>();
		
		if (!myselectWeek.equals("null")) {
			listPredicate.add(cb.equal((root.get("dateInteraction")), myselectWeek));
		}
		
		if (!myselectUnit.equals("null")) {
			Join<Interaction, Unit> join = root.join("unit"); 
			listPredicate.add(cb.equal((join.get("nameUnit")), myselectUnit));
		}
		
		if (!myselectClient.equals("null")) {
			Join<Interaction, Client> join = root.join("client"); 
			listPredicate.add(cb.equal((join.get("name")), myselectClient));
		}
		
		if (!myselectBM.equals("null")) {
			Join<Interaction, Person> join = root.join("person"); 
			listPredicate.add(cb.equal((join.get("name")), myselectBM));
		}
		
		if (!myselectInteration.equals("null")) {
			Join<Interaction, InteractionType> join = root.join("interactionType"); 
			listPredicate.add(cb.equal((join.get("interactionType")), myselectInteration));
		}
		
		q.where(listPredicate.toArray(new Predicate[0]));
		
		q.select(root);

		List<Interaction> varFilter = entityManager.createQuery(q).getResultList();
		if(startIndex+quantity > varFilter.size()) {
			return varFilter.subList(startIndex, varFilter.size());			
		} else {
			return varFilter.subList(startIndex, startIndex+quantity);			
		}
	}

	
	
	
	public long filterCount(String myselectWeek,
			String myselectUnit,
			String myselectClient,
			String myselectBM,
			String myselectInteration) {

		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> q = qb.createQuery(Long.class);
		Root<Interaction> root = q.from(Interaction.class);
		q.select(qb.count(root));
		
		List<Predicate> listPredicate = new ArrayList<Predicate>();
		
		if (!myselectWeek.equals("null")) {
			listPredicate.add(qb.equal((root.get("dateInteraction")), myselectWeek));
		}
		
		if (!myselectUnit.equals("null")) {
			Join<Interaction, Unit> join = root.join("unit"); 
			listPredicate.add(qb.equal((join.get("nameUnit")), myselectUnit));
		}
		
		if (!myselectClient.equals("null")) {
			Join<Interaction, Client> join = root.join("client"); 
			listPredicate.add(qb.equal((join.get("name")), myselectClient));
		}
		
		if (!myselectBM.equals("null")) {
			Join<Interaction, Person> join = root.join("person"); 
			listPredicate.add(qb.equal((join.get("name")), myselectBM));
		}
		
		if (!myselectInteration.equals("null")) {
			Join<Interaction, InteractionType> join = root.join("interactionType"); 
			listPredicate.add(qb.equal((join.get("interactionType")), myselectInteration));
		}
		
		q.where(listPredicate.toArray(new Predicate[0]));
		
		q.select(qb.count(root));
		
		return entityManager.createQuery(q).getSingleResult();
	}
	
	
    public List<GenericInteraction>filterClient( ) {
        
        TypedQuery<GenericInteraction> query= (TypedQuery<GenericInteraction>) entityManager.createNamedQuery(Interaction.GET_INTERACTIONS_GROUP_BY_CLIENT_AND_INTERACTION_TYPE);
        
//        		query.setParameter("clientName", myselectClient);
        
        return query.getResultList();
    }
    
    public List<GenericInteraction>filterManager( ) {
        
        TypedQuery<GenericInteraction> query= (TypedQuery<GenericInteraction>) entityManager.createNamedQuery(Interaction.GET_INTERACTIONS_GROUP_BY_MANAGER_AND_INTERACTION_TYPE);
        
//        		query.setParameter("managerName", myselectManager);
        
        return query.getResultList();
    }
	
	 /**************************
	 * Dashboard Module Starts *
	 **************************/

	/**
	 * Gets all cvs sent per week
	 * @param week week of cv sent
	 * @return a collection containing all cvs sent by week
	 */
	@SuppressWarnings("unchecked")
	public Collection<Interaction> getAllCvsPerWeekPerManager(String manager, String week) {
		return entityManager.createNamedQuery(getAllCvsByManagerPerWeekQueryName()).setParameter("week", week).setParameter("manager", manager).getResultList();
	}
	
	/**
	 * Counts all cvs sent per manager per week
	 * @param manager manager name
	 * @param week week of cv sent
	 * @return the count of all cvs set per manager per week
	 */
	public long countAllCvsPerWeekPerManager(String manager, String week) {
		return entityManager.createNamedQuery(countAllCvsPerWeekPerManagerQueryName(), Long.class).setParameter("manager", manager).setParameter("week", week).getSingleResult();
	}
	
	/**
	 * Counts all interactions per business unit
	 * @param unit business unit
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerUnit(String unit) {
		return entityManager.createNamedQuery(countAllInteractionsPerUnitQueryName(), Long.class).setParameter("unit", unit).getSingleResult();
	}
	
	/**
	 * Counts all interactions per interaction type
	 * @param interactionType interaction type
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerInteractionType(String interactionType) {
		return entityManager.createNamedQuery(countAllInteractionsPerInteractionTypeQueryName(), Long.class).setParameter("interactionType", interactionType).getSingleResult();
	}
	
	/**
	 * Counts all interactions per client name
	 * @param clientName client name
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerClient(String clientName) {
		return entityManager.createNamedQuery(countAllInteractionsPerClientQueryName(), Long.class).setParameter("clientName", clientName).getSingleResult();
	}
	
	/**
	 * Counts all accepted contracts per week
	 * @param week week
	 * @return all accepted contracts signed per week
	 */
	public long countAcceptedContractsPerWeek(String week) {
		return entityManager.createNamedQuery(countAcceptedContractsPerWeekQueryName(), Long.class).setParameter("week", week).getSingleResult();
	}
	
	/**
	 * Counts all interviews per week
	 * @param week week
	 * @return all interviews per week
	 */
	public long countAllInterviewsPerWeek(@QueryParam("week") String week) {
		return entityManager.createNamedQuery(countAllInterviewsPerWeekQueryName(), Long.class).setParameter("week", week).getSingleResult();
	}
	
	/**
	 * Counts all contracts per week
	 * @param week week	
	 * @return all contracts per week
	 */
	public long countAllContractsPerWeek(@QueryParam("week") String week) {
		return entityManager.createNamedQuery(countAllContractsPerWeekQueryName(), Long.class).setParameter("week", week).getSingleResult();
	}

	/************************
	* Dashboard Module Ends *
	************************/
	
	
	
	public Collection<Interaction> getInteractionsByUserId(long personId) {
		return entityManager.createNamedQuery(getAllInteractionsByUserId(), getEntityClass()).setParameter("personId" , personId).getResultList();
	}
	
	
	public Collection<Interaction> filtro(String myselectSemana,
            String myselectUnidade,
            String myselectCliente,
            String myselectBM,
            String myselectInteration) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Interaction> q = cb.createQuery(Interaction.class);
        Root<Interaction> root = q.from(Interaction.class);
        q.select(root);

        List<Predicate> listPredicate = new ArrayList<Predicate>();

        if (!myselectSemana.equals("null")) {
            listPredicate.add(cb.equal((root.get("dateInteraction")), myselectSemana));
        }

        if (!myselectUnidade.equals("null")) {
            Join<Interaction, Unit> join = root.join("unit"); 
            listPredicate.add(cb.equal((join.get("nameUnit")), myselectUnidade));
        }

        if (!myselectCliente.equals("null")) {
            Join<Interaction, Client> join = root.join("client"); 
            listPredicate.add(cb.equal((join.get("name")), myselectCliente));
        }

        if (!myselectBM.equals("null")) {
            Join<Interaction, Person> join = root.join("person"); 
            listPredicate.add(cb.equal((join.get("name")), myselectBM));
        }

        if (!myselectInteration.equals("null")) {
            Join<Interaction, InteractionType> join = root.join("interactionType"); 
            listPredicate.add(cb.equal((join.get("interactionType")), myselectInteration));
        }

        q.where(listPredicate.toArray(new Predicate[0]));

        q.select(root);

        return entityManager.createQuery(q).getResultList();
    }
}
