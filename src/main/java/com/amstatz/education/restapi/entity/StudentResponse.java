package com.amstatz.education.restapi.entity;

import java.util.Set;

import com.amstatz.education.restapi.util.EducationClassUtils;

public class StudentResponse extends Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentResponse() {
		super();
	}
	
	public StudentResponse(Student student) {
		super.setClasses(student.getClasses());
		super.setId(student.getId());
		super.setName(student.getName());
	}
	
	public Set<EducationClassSummary> getEducationClassSummary() {
		Set<EducationClass> classes = this.getClasses();
		
		return EducationClassUtils.convertClassSetToClassSummarySet(classes);
	}

	
}
