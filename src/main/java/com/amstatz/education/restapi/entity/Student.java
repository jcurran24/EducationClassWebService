/**
 * 
 */
package com.amstatz.education.restapi.entity;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author jeremycurran
 *
 */
@Entity
@Table(name="student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	private String name;
	
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
	
	@ManyToMany
	@JoinTable(name="Class_Student", 
    joinColumns=@JoinColumn(name="STUDENT_ID", referencedColumnName="ID"),
    inverseJoinColumns=@JoinColumn(name="CLASS_ID", referencedColumnName="ID"))
	private Set<EducationClass> classes;
	
	@ManyToMany(
	        targetEntity=com.amstatz.education.restapi.entity.Student.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
	    )
	    @JoinTable(
	        name="CLASS_STUDENT",
	        joinColumns=@JoinColumn(name="STUDENT_ID"),
	        inverseJoinColumns=@JoinColumn(name="CLASS_ID")
	    )
	@Basic(fetch = FetchType.LAZY)
	protected Set<EducationClass> getClasses() {
		return classes;
	}
	public void setClasses(Set<EducationClass> classes) {
		this.classes = classes;
	}
}
