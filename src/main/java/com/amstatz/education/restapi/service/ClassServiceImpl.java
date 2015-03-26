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

import com.amstatz.education.restapi.dao.EducationClassDAO;
import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;


/**
 * @author jeremycurran
 *
 */
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private EducationClassDAO classDAO;

	@Override
	public EducationClass retrieveClass(String name) throws Exception {
		return classDAO.selectClass(name);
	}

	@Override
	public EducationClass retrieveClass(Integer id) throws Exception {
		return classDAO.selectClass(id);
	}
	
	public List<EducationClassSummary> retrieveClassSummary() throws Exception {
		return classDAO.selectClassSummary();
	}
}
