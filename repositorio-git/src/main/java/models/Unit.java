package models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = Unit.GET_ALL_UNITS_QUERY_NAME, query="SELECT u FROM Unit u"),
@NamedQuery(name = Unit.GET_ALL_UNITS_IDS, query="SELECT u FROM Unit u")
})

public class Unit extends Entity_ 

{

	public static final String GET_ALL_UNITS_QUERY_NAME = "Unit.getAllUnits" ;
	public static final String GET_ALL_UNITS_IDS = "Unit.getAllUnitsIds";
	
	
	private static final long serialVersionUID = 1L;
	
	private String nameUnit;

	public String getNameUnit() {
		return nameUnit;
	}

	public void setNameUnit(String nameUnit) {
		this.nameUnit = nameUnit;
	}

}


