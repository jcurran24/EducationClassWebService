/**
 * 
 */
package com.amstatz.education.restapi.web;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amstatz.education.restapi.entity.EducationClassResponse;
import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.ServiceResponse;
import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.form.ClassForm;
import com.amstatz.education.restapi.service.ClassService;



/**
 * @author jeremycurran
 *
 */
@Controller
public class ClassRestController {
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "/classes/byname/{name}", method = RequestMethod.GET)
	//@RequestMapping(value = "/retrieveProductByName.html", method = RequestMethod.GET)
	public @ResponseBody EducationClassResponse retrieveClassByName(@PathVariable String name) throws Exception {
		return new EducationClassResponse(classService.retrieveClass(name));
	}
	
	@RequestMapping(value = "/classes/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody EducationClassResponse retrieveClassById(@PathVariable String id) throws Exception {
		return new EducationClassResponse(classService.retrieveClass(Integer.valueOf(id)));
	}
	
	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<EducationClassSummary>> retrieveClassSummary() throws Exception {
		List<EducationClassSummary> educationClassSummaryList = classService.retrieveClassSummary();
		
	    return new ResponseEntity<List<EducationClassSummary>>(educationClassSummaryList, HttpStatus.OK);
	}
}
