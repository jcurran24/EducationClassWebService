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
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hsqldb.Server;
import org.hsqldb.server.WebServer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.amstatz.education.restapi.entity.EducationClass;
import com.amstatz.education.restapi.entity.EducationClassSummary;


/**
 * @author jeremycurran
 *
 */
@Repository
public class EducationClassDAOImpl implements EducationClassDAO {
	//private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("school");
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EducationClassSummary> selectClassSummary() throws Exception {
		List<EducationClassSummary> classSummary = new ArrayList<EducationClassSummary>();
	
		try {
			Query query = entityManager.createQuery("SELECT NEW com.amstatz.education.restapi.entity.EducationClassSummary(c.id, c.name) from EducationClass c");
			classSummary = query.getResultList();
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting all classes " + e.getMessage());
		}  
		return classSummary;
	}

	/* (non-Javadoc)
	 * @see com.jeremy.practice.restapi.dao.ProductDAO#selectProduct(java.lang.Long)
	 */
	@Override
	public EducationClass selectClass(Integer id) throws Exception {
		EducationClass theClass = null;
		
		try {
			Query query = entityManager.createQuery("from EducationClass c where c.id = ?");
			
			query.setParameter(1, id);
			theClass = (EducationClass)query.getSingleResult();
		} catch(NoResultException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(NonUniqueResultException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} catch(QueryTimeoutException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by id = " + Integer.toString(id) + ". Exception msg: " + e.getMessage());
		} 
		return theClass;
	}

	/* (non-Javadoc)
	 * @see com.jeremy.practice.restapi.dao.ProductDAO#selectProduct(java.lang.String)
	 */
	@Override
	public EducationClass selectClass(String name) throws Exception {
		EducationClass theClass = null;
		
		try {
			Query query = entityManager.createQuery("from EducationClass c where c.name = ?");
			
			query.setParameter(1, name);
			theClass = (EducationClass)query.getSingleResult();
		} catch(HibernateException e) {
			throw new Exception("Exception occurred when selecting product by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(NoResultException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(NonUniqueResultException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(IllegalStateException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by name = " + name + ". Exception msg: " + e.getMessage());
		} catch(QueryTimeoutException e) {
			throw new Exception("Exception occurred when selecting EducationClass c by name = " + name + ". Exception msg: " + e.getMessage());
		} 
		return theClass;
	}
}
