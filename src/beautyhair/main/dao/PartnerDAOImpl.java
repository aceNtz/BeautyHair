package beautyhair.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beautyhair.main.entity.Partner;

@Repository
public class PartnerDAOImpl implements PartnerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Partner> getPartnerList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Partner> query = session.createQuery("FROM Partner", Partner.class);		
		List<Partner> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public List<Partner> getFourImportantPartnersForIndex() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Partner> query = session.createQuery("FROM Partner ORDER BY important DESC", Partner.class).setMaxResults(4);		
		List<Partner> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public List<Partner> getSixPartnersForFooter() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Partner> query = session.createQuery("FROM Partner ORDER BY important DESC", Partner.class).setMaxResults(6);		
		List<Partner> list = query.getResultList();
		
		return list;
	}

	

	@Transactional
	@Override
	public void saveOrUpdatePartner(Partner partner) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(partner);
		
	}

	@Transactional
	@Override
	public void deletePartner(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Partner partner = session.get(Partner.class, id);
		session.delete(partner);
	}

	@Transactional
	@Override
	public Partner getPartner(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Partner partner = session.get(Partner.class, id);
		
		return partner;
	}

	
}
