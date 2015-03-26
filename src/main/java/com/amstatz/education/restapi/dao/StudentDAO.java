/**
 * 
 */
package com.amstatz.education.restapi.dao;

import java.util.List;

import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;

/**
 * @author jeremycurran
 *
 */
public interface StudentDAO {
	public List<StudentSummary> selectStudentSummary() throws Exception;
	public Student selectStudent(Integer id) throws Exception;
	public Student selectStudent(String name) throws Exception;
}
