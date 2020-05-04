package services;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;

import models.GenericInteraction;
import models.Interaction;
import models.dto.Paginate;
import models.Person;
import repositories.InteractionRepository;

@RequestScoped // Avoid circular dependency between services
public class InteractionService extends EntityService<InteractionRepository, Interaction>{


	@Inject // Inject generic variable in runtime
	protected InteractionRepository I;
	@Inject
	protected ClientService CS;
	
	public Collection<Interaction> showAll() {
		return I.showAll();
	}
	
	public Collection<String> showAllWeeks() {
		return I.showAllWeeks();
	}
	
	public Collection<Interaction> showAllWeeksFilter(String filter) {
		return I.showAllWeeksFilter(filter);
	}
	
	public Collection<String> showAllClients() {
		return I.showAllClients();
	}
	
	public Collection<Interaction> showAllClientsFilter(String filter) {
		return I.showAllClientsFilter(filter);
	}
	
	public Collection<String> showAllUnities() {
		return I.showAllUnities();
	}
	
	public Collection<Interaction> showAllUnitiesFilter(String filter) {
		return I.showAllUnitiesFilter(filter);
	}
	
	public Collection<String> showAllBManagers() {
		return I.showAllBManagers();
	}
	
	public Collection<Interaction> showAllBManagersFilter(String filter) {
		return I.showAllBManagersFilter(filter);

	}
	
	public Collection<String> showAllInteractions() {
		return I.showAllInteractions();
	}
	
	public Collection<Interaction> showAllInteractionsFilter(String filter) {
		return I.showAllInteractionsFilter(filter);

	}
	
	public Collection<Interaction> showAllRevenuePerClient(String name, String interaction) {
		return I.showAllRevenuePerClient(name, interaction);

	}
	
	public Collection<Interaction> showAllRevenuePerManager(String name, String interaction) {
		return I.showAllRevenuePerManager(name, interaction);

	}
	
	public List<GenericInteraction> filterClient() {
		return I.filterClient();
	}
	
	public List<GenericInteraction> filterManager() {
		return I.filterManager();
	}

//	public Collection<Interaction> showAllFilter(String filter) {
//		return I.showAllFilter(filter);
//	}

	public Collection<Interaction> showAllSearch(String search) {
		return I.showAllSearch(search);
	}
	
	public Collection<Interaction> showAllBetween(int startIndex, int quantity) {
		return I.showAllBetween(startIndex, quantity);
	}

	 /**************************
	 * Dashboard Module Starts *
	 **************************/
	
	/**
	 * Gets all cvs sent per manager per week
	 * @param manager manager name
	 * @param week week of cv sent
	 * @return a collection containing all cvs sent by week
	 */
	public Collection<Interaction> getAllCvsPerWeekPerManager(String manager, String week) {
		return I.getAllCvsPerWeekPerManager(manager, week);
	}
	
	/**
	 * Counts all cvs sent per manager per week
	 * @param manager manager name
	 * @param week week of cv sent
	 * @return the count of all cvs set per manager per week
	 */
	public long countAllCvsPerWeekPerManager(String manager, String week) {
		return I.countAllCvsPerWeekPerManager(manager, week);
	}
	
	/**
	 * Counts all interactions per business unit
	 * @param unit business unit
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerUnit(String unit) {
		return I.countAllInteractionsPerUnit(unit);
	}
	
	/**
	 * Counts all interactions per interaction type
	 * @param interactionType interaction type
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerInteractionType(String interactionType) {
		return I.countAllInteractionsPerInteractionType(interactionType);
	}
	
	/**
	 * Counts all interactions per client
	 * @param clientName client name
	 * @return the count of all interactions
	 */
	public long countAllInteractionsPerClient(String clientName) {
		return I.countAllInteractionsPerClient(clientName);
	}


	public Paginate filtrer(String myselectWeek, String myselectUnity, String myselectClient, String myselectBM,String myselectInteration, int startIndex, int quantity) {
		Collection<Interaction> interactions = I.filtrer(myselectWeek, myselectUnity, myselectClient, myselectBM, myselectInteration, startIndex, quantity ); 
		Long count = filterCount(myselectWeek, myselectUnity, myselectClient, myselectBM, myselectInteration);
		Paginate p = new Paginate (interactions, count);
		return p;
	}
	
	/**
	 * Counts all contracts per week
	 * @param week week
	 * @return all contracts signed per week
	 */
	public long countAcceptedContractsPerWeek(String week) {
		return I.countAcceptedContractsPerWeek(week);
	}
	
	/**
	 * Counts all interviews per week
	 * @param week week
	 * @return all interviews per week
	 */
	public long countAllInterviewsPerWeek(@QueryParam("week") String week) {
		return I.countAllInterviewsPerWeek(week);
	}

	public Long filterCount(String myselectWeek, String myselectUnity, String myselectClient, String myselectBM,String myselectInteration) {
		return I.filterCount(myselectWeek, myselectUnity, myselectClient, myselectBM, myselectInteration);
	}

	public long countAllContractsPerWeek(@QueryParam("week") String week) {
		return I.countAllContractsPerWeek(week);
	}
	
	/************************
	* Dashboard Module Ends *
	************************/
	
	
	public Collection<Interaction> showAllInteractionsByUser(long personId)
	
	{
		
		return I.getInteractionsByUserId(personId);
		
	}


	@Override
	public Interaction save(Interaction object) throws Exception {
		// TODO Auto-generated method stub
		if(object.getInteractionType().getId()==2) {
			CS.updateRevenue(object.getClient().getId(), object.getPotentialRevenue());
		}
		return I.save(object);
	}

	@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		Interaction object = I.getObj(id);
		if(object.getInteractionType().getId()==2) {
			CS.updateDecreaseRevenue(object.getClient().getId(), object.getPotentialRevenue());
		}
		super.delete(id);
	}
	
    public Collection<Interaction> filtro(String myselectSemana, String myselectUnidade, String myselectCliente, String myselectBM,String myselectInteration) {
        return I.filtro(myselectSemana, myselectUnidade, myselectCliente, myselectBM, myselectInteration);
    }
	



}
