/**
 * 
 */
package com.amstatz.education.restapi.entity;

import java.util.Set;

import com.amstatz.education.restapi.util.EducationClassUtils;

/**
 * @author jeremycurran
 *
 */
public class EducationClassResponse extends EducationClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EducationClassResponse() {
		super();
	}
	
	public EducationClassResponse(EducationClass educationClass) {
		super.setId(educationClass.getId());
		super.setName(educationClass.getName());
		super.setDescription(educationClass.getDescription());
		super.setStudents(educationClass.getStudents());
	}
	
	public Set<StudentSummary> getStudentSummary() {
		Set<Student> students = this.getStudents();
		
		return EducationClassUtils.convertStudentsSetToStudentSummary(students);
	}
	
}
