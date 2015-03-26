/**
 * 
 */
package com.amstatz.education.restapi.service;

import java.util.List;
import java.util.Set;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;

/**
 * @author jeremycurran
 *
 */
public interface StudentService {
	public Student retrieveStudent(String name) throws Exception;
	public Student retrieveStudent(Integer id) throws Exception;
	public List<StudentSummary> retrieveStudentSummary() throws Exception;
}
