package models.dto;

import models.Person;

public class PersonDTO 

{

	private String username;
	private String password;
	private String email;
	private String role;
	
	public String getUsername()
	
	{
		return username;
	}
	
	public void setUsername(String username)
	
	{
		this.username = username;
	}
	
	public String getPassword() 
	
	{
		return password;
	}
	
	public void setPassword(String password) 
	
	{
		this.password = password;
	}
	
	public String getEmail()
	
	{
		return email;
	}
	
	public void setEmail(String email)
	
	{
		this.email = email;
	}
	
	public String getRole()
	
	{
		return role;
	}
	
	public void setRole(String role) 
	
	{
		this.role = role;
	}
	
	public PersonDTO toDTO(Person p,PersonDTO pdto) 
	
	{
		
		pdto.setUsername(p.getUsername());
		pdto.setEmail(p.getEmail());
		pdto.setPassword(p.getHashcode());
		return pdto;
	}
	
	public Person normalize(PersonDTO pdto, Person p, String salt, String hash)
	
	{
	
		p.setUsername(pdto.getUsername());
		p.setEmail(pdto.getEmail());
		p.setRole(pdto.getRole());
		p.setHashcode(hash);
		p.setSalt(salt);
		return p;
	}
}
