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
 * Progresssupervisioninfo entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Progresssupervisioninfo
 * @author MyEclipse Persistence Tools
 */

public class ProgresssupervisioninfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProgresssupervisioninfoDAO.class);
	// property constants
	public static final String PSISUPERVISION_NAME = "psisupervisionName";
	public static final String PRIMARY_PROGRESS = "primaryProgress";
	public static final String PRIMARY_PROBLEM = "primaryProblem";
	public static final String MID_PROGRESS = "midProgress";
	public static final String MID_PROBLEM = "midProblem";
	public static final String LAST_PROGRESS = "lastProgress";
	public static final String LAST_PROBLEM = "lastProblem";
	public static final String PSICHECK_RESULT = "psicheckResult";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Progresssupervisioninfo transientInstance) {
		log.debug("saving Progresssupervisioninfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Progresssupervisioninfo persistentInstance) {
		log.debug("deleting Progresssupervisioninfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Progresssupervisioninfo findById(java.lang.Integer id) {
		log.debug("getting Progresssupervisioninfo instance with id: " + id);
		try {
			Progresssupervisioninfo instance = (Progresssupervisioninfo) getSession()
					.get("com.hwadee.orm.Progresssupervisioninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Progresssupervisioninfo instance) {
		log.debug("finding Progresssupervisioninfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Progresssupervisioninfo")
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
		log.debug("finding Progresssupervisioninfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Progresssupervisioninfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPsisupervisionName(Object psisupervisionName) {
		return findByProperty(PSISUPERVISION_NAME, psisupervisionName);
	}

	public List findByPrimaryProgress(Object primaryProgress) {
		return findByProperty(PRIMARY_PROGRESS, primaryProgress);
	}

	public List findByPrimaryProblem(Object primaryProblem) {
		return findByProperty(PRIMARY_PROBLEM, primaryProblem);
	}

	public List findByMidProgress(Object midProgress) {
		return findByProperty(MID_PROGRESS, midProgress);
	}

	public List findByMidProblem(Object midProblem) {
		return findByProperty(MID_PROBLEM, midProblem);
	}

	public List findByLastProgress(Object lastProgress) {
		return findByProperty(LAST_PROGRESS, lastProgress);
	}

	public List findByLastProblem(Object lastProblem) {
		return findByProperty(LAST_PROBLEM, lastProblem);
	}

	public List findByPsicheckResult(Object psicheckResult) {
		return findByProperty(PSICHECK_RESULT, psicheckResult);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Progresssupervisioninfo instances");
		try {
			String queryString = "from Progresssupervisioninfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Progresssupervisioninfo merge(
			Progresssupervisioninfo detachedInstance) {
		log.debug("merging Progresssupervisioninfo instance");
		try {
			Progresssupervisioninfo result = (Progresssupervisioninfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Progresssupervisioninfo instance) {
		log.debug("attaching dirty Progresssupervisioninfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Progresssupervisioninfo instance) {
		log.debug("attaching clean Progresssupervisioninfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}