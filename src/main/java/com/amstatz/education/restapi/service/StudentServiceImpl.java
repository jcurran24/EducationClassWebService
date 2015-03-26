/**
 * 
 */
package com.amstatz.education.restapi.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amstatz.education.restapi.dao.StudentDAO;
import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;

/**
 * @author jeremycurran
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.service.StudentService#retrieveStudent(java.lang.String)
	 */
	@Override
	public Student retrieveStudent(String name) throws Exception {
		return studentDAO.selectStudent(name);
	}

	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.service.StudentService#retrieveStudent(java.lang.Integer)
	 */
	@Override
	public Student retrieveStudent(Integer id) throws Exception {
		return studentDAO.selectStudent(id);
	}

	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.service.StudentService#retrieveAllStudents()
	 */
	@Override
	public List<StudentSummary> retrieveStudentSummary() throws Exception {
		return studentDAO.selectStudentSummary();
	}
}
