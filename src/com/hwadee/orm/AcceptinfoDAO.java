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
 * Acceptinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.orm.Acceptinfo
 * @author MyEclipse Persistence Tools
 */

public class AcceptinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AcceptinfoDAO.class);
	// property constants
	public static final String ACCEPT_RESULT = "acceptResult";
	public static final String ACCEPT_NAME = "acceptName";
	public static final String ACCEPT_OPINION = "acceptOpinion";
	public static final String REST_FUND = "restFund";
	public static final String AIMASSES_EVALUATE_RESULT = "aimassesEvaluateResult";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Acceptinfo transientInstance) {
		log.debug("saving Acceptinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Acceptinfo persistentInstance) {
		log.debug("deleting Acceptinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Acceptinfo findById(java.lang.Integer id) {
		log.debug("getting Acceptinfo instance with id: " + id);
		try {
			Acceptinfo instance = (Acceptinfo) getSession().get(
					"com.hwadee.orm.Acceptinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Acceptinfo instance) {
		log.debug("finding Acceptinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Acceptinfo")
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
		log.debug("finding Acceptinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Acceptinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAcceptResult(Object acceptResult) {
		return findByProperty(ACCEPT_RESULT, acceptResult);
	}

	public List findByAcceptName(Object acceptName) {
		return findByProperty(ACCEPT_NAME, acceptName);
	}

	public List findByAcceptOpinion(Object acceptOpinion) {
		return findByProperty(ACCEPT_OPINION, acceptOpinion);
	}

	public List findByRestFund(Object restFund) {
		return findByProperty(REST_FUND, restFund);
	}

	public List findByAimassesEvaluateResult(Object aimassesEvaluateResult) {
		return findByProperty(AIMASSES_EVALUATE_RESULT, aimassesEvaluateResult);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Acceptinfo instances");
		try {
			String queryString = "from Acceptinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Acceptinfo merge(Acceptinfo detachedInstance) {
		log.debug("merging Acceptinfo instance");
		try {
			Acceptinfo result = (Acceptinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Acceptinfo instance) {
		log.debug("attaching dirty Acceptinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Acceptinfo instance) {
		log.debug("attaching clean Acceptinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * @param proId
	 * @return
	 * @author Õ²ÁÁÃû
	 * @date:2014-7-24ÏÂÎç7:23:29
	 */
	public Acceptinfo getAcceptInfoByProject(String proId) {
		
		String hql = "SELECT p.acceptinfos FROM Project p WHERE p.proId=:proId";
		
		//String hql = "SELECT p.commentinfos FROM Project p WHERE p.proId='51012410200220131001035'";
		
		Query query = getSession().createQuery(hql);
		query.setParameter("proId", proId);
		return (Acceptinfo) query.uniqueResult();
	}
}