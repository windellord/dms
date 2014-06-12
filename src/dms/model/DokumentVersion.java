package dms.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class DokumentVersion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String version;
	
	@ManyToOne
	private User editor;
	
	private Date timestamp;

	private String comment;

}
