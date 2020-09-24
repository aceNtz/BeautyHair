package beautyhair.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beautyhair.main.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Transactional
	@Override
	public List<Role> getRolesList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Role> query = session.createQuery("FROM Role", Role.class);
		List<Role> list = query.getResultList();
		
		return list;
	}
	
	
	
}
