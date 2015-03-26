/**
 * 
 */
package com.amstatz.education.restapi.dao;

import java.util.List;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;

/**
 * @author jeremycurran
 *
 */
public interface EducationClassDAO {
	public List<EducationClassSummary> selectClassSummary() throws Exception;
	public EducationClass selectClass(Integer id) throws Exception;
	public EducationClass selectClass(String name) throws Exception;
}
