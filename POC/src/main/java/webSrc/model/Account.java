package webSrc.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	public Account() {
		// TODO Auto-generated constructor stub
	}
	private String id;
	
	private String name;
	
	@JsonProperty("date_entered")
	private String dateEntered;
	
	@JsonProperty("date_modified")
	private String dateModified;
	
	@JsonProperty("modified_user_id")
	private String modifiedUserId;
	
	private String description;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dateEntered
	 */
	public String getDateEntered() {
		return dateEntered;
	}
	/**
	 * @param dateEntered the dateEntered to set
	 */
	public void setDateEntered(String dateEntered) {
		this.dateEntered = dateEntered;
	}
	/**
	 * @return the dateModified
	 */
	public String getDateModified() {
		return dateModified;
	}
	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	/**
	 * @return the modifiedUserId
	 */
	public String getModifiedUserId() {
		return modifiedUserId;
	}
	/**
	 * @param modifiedUserId the modifiedUserId to set
	 */
	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
