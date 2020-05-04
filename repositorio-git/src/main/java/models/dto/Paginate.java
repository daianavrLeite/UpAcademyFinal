package models.dto;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import models.Interaction;

@JsonSerialize
public class Paginate {

	

	private Collection<Interaction> elements;
	private Long totalElements;
	
	public Collection<Interaction> getElements() {
		return elements;
	}

	public void setElements(Collection<Interaction> elements) {
		this.elements = elements;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Paginate(Collection<Interaction> elements, Long totalElements) {
		this.elements = elements;
		this.totalElements = totalElements;
	}

	@Override
	public String toString() {
		return "Paginate [elements=" + elements + ", totalElements=" + totalElements + "]";
	}
	
	
	
	
}
