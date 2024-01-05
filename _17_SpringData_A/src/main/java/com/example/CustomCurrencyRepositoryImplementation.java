package com.example;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Currency;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomCurrencyRepositoryImplementation implements CustomCurrencyRepository {

	EntityManager entityManager;
	
	//@Autowired
	public CustomCurrencyRepositoryImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	@Override
	public List<Currency> findByCode(String code) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Currency> cq = cb.createQuery(Currency.class);
		
		// You need to define the main entity
		Root<Currency> currency = cq.from(Currency.class);
		
		// Define all the conditions of the query
		Predicate codePredicate = cb.equal(currency.get("code"), code);
		
		//You can have more than one where clause
		cq.where(codePredicate);
		
		// Create the query and after that executed
		TypedQuery<Currency> query = entityManager.createQuery(cq);
		return query.getResultList();
	}

//	E Override di tutti gli altri metodi....	

	@Override
	public List<Currency> findByCodeAndDescription(String code, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Currency> findByDescriptionOrderByCodeAsc(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Currency> findByDescriptionOrderByCodeDesc(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Currency retrieveByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
