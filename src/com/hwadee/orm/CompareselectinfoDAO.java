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
 * Compareselectinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Compareselectinfo
 * @author MyEclipse Persistence Tools
 */

public class CompareselectinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompareselectinfoDAO.class);
	// property constants
	public static final String CSNUMBER = "csnumber";
	public static final String CSCANDIDATE_NAME = "cscandidateName";
	public static final String CSRESULT = "csresult";
	public static final String CSCONTRACT_FUNDS = "cscontractFunds";
	public static final String CSPROJECT_SUPERVISION_NAME = "csprojectSupervisionName";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Compareselectinfo transientInstance) {
		log.debug("saving Compareselectinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Compareselectinfo persistentInstance) {
		log.debug("deleting Compareselectinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Compareselectinfo findById(java.lang.Integer id) {
		log.debug("getting Compareselectinfo instance with id: " + id);
		try {
			Compareselectinfo instance = (Compareselectinfo) getSession().get(
					"com.hwadee.orm.Compareselectinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Compareselectinfo instance) {
		log.debug("finding Compareselectinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Compareselectinfo")
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
		log.debug("finding Compareselectinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Compareselectinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCsnumber(Object csnumber) {
		return findByProperty(CSNUMBER, csnumber);
	}

	public List findByCscandidateName(Object cscandidateName) {
		return findByProperty(CSCANDIDATE_NAME, cscandidateName);
	}

	public List findByCsresult(Object csresult) {
		return findByProperty(CSRESULT, csresult);
	}

	public List findByCscontractFunds(Object cscontractFunds) {
		return findByProperty(CSCONTRACT_FUNDS, cscontractFunds);
	}

	public List findByCsprojectSupervisionName(Object csprojectSupervisionName) {
		return findByProperty(CSPROJECT_SUPERVISION_NAME,
				csprojectSupervisionName);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Compareselectinfo instances");
		try {
			String queryString = "from Compareselectinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Compareselectinfo merge(Compareselectinfo detachedInstance) {
		log.debug("merging Compareselectinfo instance");
		try {
			Compareselectinfo result = (Compareselectinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Compareselectinfo instance) {
		log.debug("attaching dirty Compareselectinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Compareselectinfo instance) {
		log.debug("attaching clean Compareselectinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}