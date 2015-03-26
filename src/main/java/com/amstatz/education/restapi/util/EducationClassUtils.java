/**
 * 
 */
package com.amstatz.education.restapi.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;

/**
 * @author jeremycurran
 *
 */
public class EducationClassUtils {
	public static Set<EducationClassSummary> convertClassSetToClassSummarySet(Set<EducationClass> classSet) {
		Set<EducationClassSummary> classSummary = new TreeSet<EducationClassSummary>();
			
		Iterator<EducationClass> iterator = classSet.iterator();
		while(iterator != null && iterator.hasNext()) {
			
			EducationClass theClass = iterator.next();
			
			classSummary.add(new EducationClassSummary(theClass.getId(), theClass.getName()));
			
		}
		return classSummary;
	}
	
	public static Set<StudentSummary> convertStudentsSetToStudentSummary(Set<Student> studentsSet) {
		Set<StudentSummary> studentSummary = new TreeSet<StudentSummary>();
			
		Iterator<Student> iterator = studentsSet.iterator();
		while(iterator != null && iterator.hasNext()) {
			
			Student student = iterator.next();
			
			studentSummary.add(new StudentSummary(student.getId(), student.getName()));
			
		}
		return studentSummary;
	}
}
