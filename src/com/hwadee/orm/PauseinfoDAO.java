package com.hwadee.orm;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pauseinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.orm.Pauseinfo
 * @author MyEclipse Persistence Tools
 */

public class PauseinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PauseinfoDAO.class);
	// property constants
	public static final String PAUSE_REASON = "pauseReason";
	public static final String PROPONENT = "proponent";
	public static final String REASON_DESCRIPTION = "reasonDescription";
	public static final String HANDLING_SUGGESTION = "handlingSuggestion";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Pauseinfo transientInstance) {
		log.debug("saving Pauseinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pauseinfo persistentInstance) {
		log.debug("deleting Pauseinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pauseinfo findById(java.lang.Integer id) {
		log.debug("getting Pauseinfo instance with id: " + id);
		try {
			Pauseinfo instance = (Pauseinfo) getSession().get(
					"com.hwadee.orm.Pauseinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pauseinfo instance) {
		log.debug("finding Pauseinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Pauseinfo")
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
		log.debug("finding Pauseinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pauseinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPauseReason(Object pauseReason) {
		return findByProperty(PAUSE_REASON, pauseReason);
	}

	public List findByProponent(Object proponent) {
		return findByProperty(PROPONENT, proponent);
	}

	public List findByReasonDescription(Object reasonDescription) {
		return findByProperty(REASON_DESCRIPTION, reasonDescription);
	}

	public List findByHandlingSuggestion(Object handlingSuggestion) {
		return findByProperty(HANDLING_SUGGESTION, handlingSuggestion);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Pauseinfo instances");
		try {
			String queryString = "from Pauseinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pauseinfo merge(Pauseinfo detachedInstance) {
		log.debug("merging Pauseinfo instance");
		try {
			Pauseinfo result = (Pauseinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pauseinfo instance) {
		log.debug("attaching dirty Pauseinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pauseinfo instance) {
		log.debug("attaching clean Pauseinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}