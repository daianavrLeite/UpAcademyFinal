package services;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import models.Client;
import models.Person;
import models.dto.PaginateDTO;
import models.dto.PersonDTO;
import repositories.PersonRepository;
import utils.PasswordUtils;

@RequestScoped
public class PersonService extends EntityService<PersonRepository, Person>

{

	@Inject
	protected ClientService CLIENT_SERVICE;

	@Transactional
	public Person create(PersonDTO entity) throws Exception {

		if (checkUserExists(entity.getUsername()) == true) {

			throw new Exception("  Username already exists!  ");

		} else if (checkEmailExists(entity.getEmail()) == true) {

			throw new Exception("  Email already exists!  ");
		} else {
			Person m = new Person();

			String password = entity.getPassword();
			String[] hashcode = passwordToHashcode(password);
			m = entity.normalize(entity, m, hashcode[1], hashcode[0]);
			try {
				sendGrid(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return repository.create(m);
		}
	}

	// Issue token to the client when login is valid and Return token
	public String checkIfPasswordValid(PersonDTO userDTO, String password) throws Exception {

		Person myUser = repository.getManagerByUsername(userDTO.getUsername());
		Algorithm algorithm = Algorithm.HMAC256(myUser.getSalt() + myUser.getHashcode());
		String token = JWT.create().withIssuer(userDTO.getUsername()).withClaim("role", myUser.getRole()).withClaim("id", myUser.getId())
				.sign(algorithm);
		System.out.println(token);

		String key = myUser.getHashcode();
		String salt = myUser.getSalt();
		if (!PasswordUtils.verifyPassword(password, key, salt)) {

			throw new BadRequestException("Invalid Password");
		}
		try {
			DecodedJWT jwt = JWT.decode(token);
			String iss = jwt.getIssuer();
		} catch (JWTDecodeException exception) {
			// Invalid token
		}
		return token;
	}

	public String[] passwordToHashcode(String password)

	{
		String salt = PasswordUtils.generateSalt(50).get();
		String key = PasswordUtils.hashPassword(password, salt).get();
		String[] result = { key, salt };
		return result;
	}

	// send email when SuperUser creates a new manager.CHANGE EMAIL
	public void sendGrid(PersonDTO entity) throws IOException {

		Mail mail = new Mail();
		Email from = new Email("kpimanager13@gmail.com");
		Email to = new Email(entity.getEmail()); // use your own email address here
		mail.setFrom(from);
		mail.setTemplateId("d-d2707774fecd4221b757231424f79fc2");

		Personalization personalization = new Personalization();
		personalization.addDynamicTemplateData("username", entity.getUsername());
		personalization.addDynamicTemplateData("password", entity.getPassword());
		personalization.addTo(to);
		mail.addPersonalization(personalization);

		SendGrid sg = new SendGrid(System.getProperty("SGKey"));
		Request request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			Response response = sg.api(request);

		} catch (IOException ex) {
			ex.printStackTrace();
			throw ex;
		}

	}
	
	
	public Collection <Person> showAllEntitiesByUnit(long unitId)
	
	{
		return repository.showAllEntitiesByUnit(unitId);
	}
	
	public Collection <Person> showAllManagers()
	
	{
		return repository.showAllManagers();
	}

	/******* logic to avoid duplicated values at DB on creation **************/
	public Boolean checkUserExists(String username) {
		boolean flag = false;
		try {
			Person check = repository.getManagerByUsername(username);
			if (check.getUsername().length() != 0) {
				flag = true;
			}
		} catch (NoResultException nre) {
			flag = false;
		}
		return flag;
	}

	public Boolean checkEmailExists(String email) {

		boolean flag = false;
		try {
			Person check = repository.getManagerByEmail(email);
	
			if (check.getEmail().length() != 0) {
			
				flag = true;
			}
		} catch (NoResultException nre) {

			flag = false;
		}
		return flag;
	}
	
	
	public Collection <Person> showAllDirectors()
	
	{
		return repository.showAllDirectors();
	}
	

	
	@Override
	public Person  getObject(long id) {
		
	 return repository.getObj(id);
	 
	}

	public void clearInteractionByUserId(long id) {

		repository.clearInteractionByUserId(id);
		repository.remove(id);
	}
	
	public PaginateDTO<Person> getCount(int startIndex, int quantity) {
		Collection<Person> person =  repository.showAllManagers(startIndex, quantity);
		Long count = repository.getTotal();
		PaginateDTO<Person> p = new PaginateDTO<Person>(person, count);
		return p;
	}
}






















