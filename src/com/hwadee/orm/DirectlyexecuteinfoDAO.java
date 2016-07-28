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
 * Directlyexecuteinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Directlyexecuteinfo
 * @author MyEclipse Persistence Tools
 */

public class DirectlyexecuteinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DirectlyexecuteinfoDAO.class);
	// property constants
	public static final String PROJECT_LEADER_NAME = "projectLeaderName";
	public static final String PROJECT_LEADER_TEL = "projectLeaderTel";
	public static final String PROJECT_SUPERVISION_NAME = "projectSupervisionName";
	public static final String PROJECT_SUPERVISION_TEL = "projectSupervisionTel";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Directlyexecuteinfo transientInstance) {
		log.debug("saving Directlyexecuteinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Directlyexecuteinfo persistentInstance) {
		log.debug("deleting Directlyexecuteinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Directlyexecuteinfo findById(java.lang.Integer id) {
		log.debug("getting Directlyexecuteinfo instance with id: " + id);
		try {
			Directlyexecuteinfo instance = (Directlyexecuteinfo) getSession()
					.get("com.hwadee.orm.Directlyexecuteinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Directlyexecuteinfo instance) {
		log.debug("finding Directlyexecuteinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Directlyexecuteinfo")
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
		log.debug("finding Directlyexecuteinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Directlyexecuteinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProjectLeaderName(Object projectLeaderName) {
		return findByProperty(PROJECT_LEADER_NAME, projectLeaderName);
	}

	public List findByProjectLeaderTel(Object projectLeaderTel) {
		return findByProperty(PROJECT_LEADER_TEL, projectLeaderTel);
	}

	public List findByProjectSupervisionName(Object projectSupervisionName) {
		return findByProperty(PROJECT_SUPERVISION_NAME, projectSupervisionName);
	}

	public List findByProjectSupervisionTel(Object projectSupervisionTel) {
		return findByProperty(PROJECT_SUPERVISION_TEL, projectSupervisionTel);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Directlyexecuteinfo instances");
		try {
			String queryString = "from Directlyexecuteinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Directlyexecuteinfo merge(Directlyexecuteinfo detachedInstance) {
		log.debug("merging Directlyexecuteinfo instance");
		try {
			Directlyexecuteinfo result = (Directlyexecuteinfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Directlyexecuteinfo instance) {
		log.debug("attaching dirty Directlyexecuteinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Directlyexecuteinfo instance) {
		log.debug("attaching clean Directlyexecuteinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}