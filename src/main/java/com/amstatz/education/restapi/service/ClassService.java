/**
 * 
 */
package com.amstatz.education.restapi.service;

import java.util.List;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;


/**
 * @author jeremycurran
 *
 */
public interface ClassService {
	public EducationClass retrieveClass(String name) throws Exception;
	public EducationClass retrieveClass(Integer id) throws Exception;
	public List<EducationClassSummary> retrieveClassSummary() throws Exception; 
}
