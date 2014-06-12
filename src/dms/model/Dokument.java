package dms.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dokument {
	
	@Id
	private long id;

		
	private String name;

	private String typ;

	private String kategorie;

	private Collection<String> keyWords;

	private String comment;
	
	private String inhalt;

}
