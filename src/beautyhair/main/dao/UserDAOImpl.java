package beautyhair.main.dao;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beautyhair.main.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Transactional
	@Override
	public List<User> getUserList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("FROM User", User.class);
		List<User> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class, username);
		
		return user;
	}

	@Transactional
	@Override
	public void saveOrUpdateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);
	}


	@Transactional
	@Override
	public void enableDisableUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = getUserByUsername(username);
		user.setEnabled(!user.getEnabled());
		session.update(user);
	}

	@Transactional
	@Override
	public void deleteUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class, username);
		session.delete(user);
	}

	@Transactional
	@Override
	public User getPrincipal(Principal principal) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = session.get(User.class, principal.getName());
		
		return user;
	}

	@Transactional
	@Override
	public List<User> getFourEmployeesForIndex() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.enabled = 1", User.class).setMaxResults(4);
		List<User> list = query.getResultList();
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
