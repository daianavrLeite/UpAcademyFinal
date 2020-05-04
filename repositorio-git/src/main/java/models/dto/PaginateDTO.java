package models.dto;

import java.util.Collection;

import models.Client;

public class PaginateDTO<T> {

	private Collection<T> elements;
	private Long totalElements;
	
	public Collection<T> getElements() {
		return elements;
	}
	public void setElements(Collection<T> elements) {
		this.elements = elements;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	
	public PaginateDTO(Collection<T> client, Long count) {
		setElements(client);
		setTotalElements(count);
	}
}
