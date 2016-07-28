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
 * Fundsupervisioninfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Fundsupervisioninfo
 * @author MyEclipse Persistence Tools
 */

public class FundsupervisioninfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FundsupervisioninfoDAO.class);
	// property constants
	public static final String FSISUPERVISION_NAME = "fsisupervisionName";
	public static final String FSINO = "fsino";
	public static final String COST_FUND = "costFund";
	public static final String BALANCE = "balance";
	public static final String FSICHECK_RESULT = "fsicheckResult";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Fundsupervisioninfo transientInstance) {
		log.debug("saving Fundsupervisioninfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fundsupervisioninfo persistentInstance) {
		log.debug("deleting Fundsupervisioninfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fundsupervisioninfo findById(java.lang.Integer id) {
		log.debug("getting Fundsupervisioninfo instance with id: " + id);
		try {
			Fundsupervisioninfo instance = (Fundsupervisioninfo) getSession()
					.get("com.hwadee.orm.Fundsupervisioninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fundsupervisioninfo instance) {
		log.debug("finding Fundsupervisioninfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Fundsupervisioninfo")
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
		log.debug("finding Fundsupervisioninfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Fundsupervisioninfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFsisupervisionName(Object fsisupervisionName) {
		return findByProperty(FSISUPERVISION_NAME, fsisupervisionName);
	}

	public List findByFsino(Object fsino) {
		return findByProperty(FSINO, fsino);
	}

	public List findByCostFund(Object costFund) {
		return findByProperty(COST_FUND, costFund);
	}

	public List findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findByFsicheckResult(Object fsicheckResult) {
		return findByProperty(FSICHECK_RESULT, fsicheckResult);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Fundsupervisioninfo instances");
		try {
			String queryString = "from Fundsupervisioninfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fundsupervisioninfo merge(Fundsupervisioninfo detachedInstance) {
		log.debug("merging Fundsupervisioninfo instance");
		try {
			Fundsupervisioninfo result = (Fundsupervisioninfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fundsupervisioninfo instance) {
		log.debug("attaching dirty Fundsupervisioninfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fundsupervisioninfo instance) {
		log.debug("attaching clean Fundsupervisioninfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}