/**
 * 
 */
package com.amstatz.education.restapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author jeremycurran
 *
 */
@Entity
@Table(name="class")
public class EducationClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	private String name;
	
	
	private String description;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToMany
	@JoinTable(name="Class_Student", 
    joinColumns=@JoinColumn(name="CLASS_ID", referencedColumnName="ID"),
    inverseJoinColumns=@JoinColumn(name="STUDENT_ID", referencedColumnName="ID"))
	private Set<Student> students;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ManyToMany(
	        targetEntity=com.amstatz.education.restapi.entity.Student.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
	    )
	    @JoinTable(
	        name="CLASS_STUDENT",
	        joinColumns=@JoinColumn(name="CLASS_ID"),
	        inverseJoinColumns=@JoinColumn(name="STUDENT_ID")
	    )
	@Basic(fetch = FetchType.LAZY)
	protected Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
