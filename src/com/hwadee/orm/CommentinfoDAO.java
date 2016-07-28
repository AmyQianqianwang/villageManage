package com.hwadee.orm;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commentinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Commentinfo
 * @author MyEclipse Persistence Tools
 */

public class CommentinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommentinfoDAO.class);
	// property constants
	public static final String QUARTER = "quarter";
	public static final String COMMENT_OBJECT = "commentObject";
	public static final String COMMENT_NAME = "commentName";
	public static final String COMMENT_SITUATION = "commentSituation";
	public static final String CICHECK_RESULT = "cicheckResult";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Commentinfo transientInstance) {
		log.debug("saving Commentinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Commentinfo persistentInstance) {
		log.debug("deleting Commentinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Commentinfo findById(java.lang.Integer id) {
		log.debug("getting Commentinfo instance with id: " + id);
		try {
			Commentinfo instance = (Commentinfo) getSession().get(
					"com.hwadee.orm.Commentinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commentinfo instance) {
		log.debug("finding Commentinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Commentinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Commentinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commentinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuarter(Object quarter) {
		return findByProperty(QUARTER, quarter);
	}

	public List findByCommentObject(Object commentObject) {
		return findByProperty(COMMENT_OBJECT, commentObject);
	}

	public List findByCommentName(Object commentName) {
		return findByProperty(COMMENT_NAME, commentName);
	}

	public List findByCommentSituation(Object commentSituation) {
		return findByProperty(COMMENT_SITUATION, commentSituation);
	}

	public List findByCicheckResult(Object cicheckResult) {
		return findByProperty(CICHECK_RESULT, cicheckResult);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Commentinfo instances");
		try {
			String queryString = "from Commentinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commentinfo merge(Commentinfo detachedInstance) {
		log.debug("merging Commentinfo instance");
		try {
			Commentinfo result = (Commentinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commentinfo instance) {
		log.debug("attaching dirty Commentinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentinfo instance) {
		log.debug("attaching clean Commentinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * 根据Project对象查找一个关联的评议项目实体
	 * @param project
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-23下午1:55:12
	 */
	public Commentinfo getCommentinfoByProject(String proId) {
		String hql = "SELECT p.commentinfos FROM Project p WHERE p.proId=:proId";
		
		//String hql = "SELECT p.commentinfos FROM Project p WHERE p.proId='51012410200220131001035'";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("proId", proId);
		return (Commentinfo) query.uniqueResult();
	}
	
	
}