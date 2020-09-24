package beautyhair.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beautyhair.main.entity.Picture;

@Repository
public class PictureDAOImpl implements PictureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public List<Picture> getPictureList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Picture> query = session.createQuery("FROM Picture", Picture.class);
		List<Picture> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public List<Picture> getAllVisiblePictures() {
		Session session = sessionFactory.getCurrentSession();

		Query<Picture> query = session.createQuery("SELECT p FROM Picture p WHERE p.visible = 1 ORDER BY p.important", Picture.class);
		List<Picture> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public List<Picture> getThreeImportantPicturesForIndex() {
		Session session = sessionFactory.getCurrentSession();

		Query<Picture> query = session.createQuery("SELECT p FROM Picture p WHERE p.visible = 1 AND p.important = 1", Picture.class).setMaxResults(3);
		List<Picture> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public Picture getPicture(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Picture picture = session.get(Picture.class, id);
		
		return picture;
	}

	@Transactional
	@Override
	public void saveOrUpdatePicture(Picture picture) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(picture);	
	}

	@Transactional
	@Override
	public void deletePicture(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Picture picture = session.get(Picture.class, id);
		session.delete(picture);
	}

	@Transactional
	@Override
	public void changePictureVisibleStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Picture picture = session.get(Picture.class, id);
		
		picture.setVisible(!picture.getVisible());
		
		session.update(picture);
		
	}

	@Transactional
	@Override
	public void changePictureImportantStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Picture picture = session.get(Picture.class, id);
		
		picture.setImportant(!picture.getImportant());
		
		session.update(picture);
		
	}
	
	
	
	
	
	
	
	

}
