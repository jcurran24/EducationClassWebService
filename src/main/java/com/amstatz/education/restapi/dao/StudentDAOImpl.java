/**
 * 
 */
package com.amstatz.education.restapi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;
import com.amstatz.education.restapi.entity.Student;
import com.amstatz.education.restapi.entity.StudentSummary;

/**
 * @author jeremycurran
 *
 */
@Repository
public class StudentDAOImpl implements StudentDAO {
	//private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	
	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.dao.StudentDAO#selectAllStudents()
	 */
	@Override
	public List<StudentSummary> selectStudentSummary() throws Exception {
		List<StudentSummary> studentSummary = null;
	
		try {
			studentSummary = new ArrayList<StudentSummary>();
			Query query = entityManager.createQuery("SELECT NEW com.amstatz.education.restapi.entity.StudentSummary(s.id, s.name) from Student s");
			//Query query = session.createQuery("from EducationClass");
			studentSummary = query.getResultList();
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting all students " + e.getMessage());
		}
		return studentSummary;
	}

	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.dao.StudentDAO#selectStudent(java.lang.Integer)
	 */
	@Override
	public Student selectStudent(Integer id) throws Exception {
		Student student = null;
		
		try {
			Query query = entityManager.createQuery("from Student s where s.id = ?");
			
			query.setParameter(1, id);
			student = (Student)query.getSingleResult();
		} catch(NoResultException e) {
			throw new Exception("Exception occurred when selecting Student s by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(NonUniqueResultException e) {
			throw new Exception("Exception occurred when selecting Student s by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting Student s by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(QueryTimeoutException e) {
			throw new Exception("Exception occurred when selecting Student s by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} 
		return student;
	}

	/* (non-Javadoc)
	 * @see com.amstatz.education.restapi.dao.StudentDAO#selectStudent(java.lang.String)
	 */
	@Override
	public Student selectStudent(String name) throws Exception {
		Student student = null;
		
		try {
			Query query = entityManager.createQuery("from Student s where s.name = ?");
			
			query.setParameter(1, name);
			student = (Student)query.getSingleResult();
		} catch(HibernateException e) {
			throw new Exception("Exception occurred when selecting Student by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(NoResultException e) {
			throw new Exception("Exception occurred when selecting Student by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(NonUniqueResultException e) {
			throw new Exception("Exception occurred when selecting Student by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting Student by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(QueryTimeoutException e) {
			throw new Exception("Exception occurred when selecting Student by name = " + name + ". Exception msg: " + e.getMessage());
		} 
		return student;
	}
}
