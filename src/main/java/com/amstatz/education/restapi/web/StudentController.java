/**
 * 
 */
package com.amstatz.education.restapi.web;

import java.util.List;

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

import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.ServiceResponse;
import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentResponse;
import com.amstatz.education.restapi.entity.StudentSummary;
import com.amstatz.education.restapi.form.ClassForm;
import com.amstatz.education.restapi.form.StudentForm;
import com.amstatz.education.restapi.service.StudentService;

/**
 * @author jeremycurran
 *
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/students/byname/{name}", method = RequestMethod.GET)
	public @ResponseBody StudentResponse retrieveStudentByName(@PathVariable String name) throws Exception {
		return new StudentResponse(studentService.retrieveStudent(name));
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public @ResponseBody StudentResponse retrieveStudentById(@PathVariable String id) throws Exception {
		return new StudentResponse(studentService.retrieveStudent(Integer.parseInt(id)));
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<StudentSummary>> retrieveStudentSummary() throws Exception {
		List<StudentSummary> studentSummary = studentService.retrieveStudentSummary();
		return new ResponseEntity<List<StudentSummary>>(studentSummary, HttpStatus.OK);
	}
}
