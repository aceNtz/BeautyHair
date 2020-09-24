package beautyhair.main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beautyhair.main.entity.Company;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public Company getCompanyInfo() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Company> query = session.createQuery("FROM Company", Company.class);
		Company company = query.getSingleResult();
		
		return company;
	}

	@Transactional
	@Override
	public void updateCompanyInfo(Company company) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(company);
	}
	
	
	
	
	
	
	
	
	
	

}
