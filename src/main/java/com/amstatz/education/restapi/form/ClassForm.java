/**
 * 
 */
package com.amstatz.education.restapi.form;

/**
 * @author jeremycurran
 *
 */
public class ClassForm {
	private Integer Id;
	private String name;
	private String description;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
