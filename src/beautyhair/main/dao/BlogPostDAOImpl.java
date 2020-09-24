package beautyhair.main.dao;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beautyhair.main.entity.BlogPost;

@Repository
public class BlogPostDAOImpl implements BlogPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Transactional
	@Override
	public void saveBlogPost(BlogPost blogPost) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(blogPost);
		
	}

	@Transactional
	@Override
	public List<BlogPost> getBlogPostList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("FROM BlogPost", BlogPost.class);
		List<BlogPost> list = query.getResultList();
		
		return list;
	}

	
	@Transactional
	@Override
	public List<BlogPost> getMyBlogPostList(Principal principal) {
		Session session = sessionFactory.getCurrentSession();
		
		String username = principal.getName();
		Query<BlogPost> query = session.createQuery("FROM BlogPost WHERE author.username=:username", BlogPost.class);
		query.setParameter("username", username);
		
		List<BlogPost> list = query.getResultList();
		
		
		return list;
	}


	@Transactional
	@Override
	public BlogPost getBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		BlogPost post = session.get(BlogPost.class, id);
		
		return post;
	}

	@Transactional
	@Override
	public void updateImportantBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		BlogPost bp = session.get(BlogPost.class, id);
		
		bp.setImportant(!bp.getImportant());
		
		session.update(bp);		
	}

	
	@Transactional
	@Override
	public void deleteBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();

		BlogPost bp = session.get(BlogPost.class, id);
		
		session.delete(bp);
		
	}

	
	@Transactional
	@Override
	public List<BlogPost> getThreeImportantBlogsForIndexPage() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.important = 1 AND bp.enabled = 1 ORDER BY bp.id DESC", BlogPost.class).setMaxResults(3);
		List<BlogPost> list = query.getResultList();
		
		
		return list;
		
	}

	@Transactional
	@Override
	public List<BlogPost> getTwelweRecentBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC", BlogPost.class).setMaxResults(12);
		List<BlogPost> list = query.getResultList();
		
		return list;
	}

	
	@Transactional
	@Override
	public List<BlogPost> getTwoRecentBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC", BlogPost.class).setMaxResults(2);
		List<BlogPost> list = query.getResultList();
		
		
		return list;
	}
	

	
	@Transactional
	@Override
	public List<BlogPost> getAllEnabledBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC", BlogPost.class);
		List<BlogPost> list = query.getResultList();
		
		
		return list;
	}

	@Transactional
	@Override
	public List<BlogPost> getThreePopularBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT b FROM BlogPost b WHERE b.enabled = 1 AND b.important = 1 ORDER BY b.viewCount DESC", BlogPost.class).setMaxResults(3);
		List<BlogPost> list = query.getResultList();
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
