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
 * Selfbuildinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Selfbuildinfo
 * @author MyEclipse Persistence Tools
 */

public class SelfbuildinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SelfbuildinfoDAO.class);
	// property constants
	public static final String SBPROJECT_LEADER_NAME = "sbprojectLeaderName";
	public static final String SBPROJECT_LEADER_TEL = "sbprojectLeaderTel";
	public static final String SBMATERIALS_PURCHASE_NAME = "sbmaterialsPurchaseName";
	public static final String SBMATERIALS_PURCHASE_TEL = "sbmaterialsPurchaseTel";
	public static final String WRITE_TABLE_NAME = "writeTableName";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Selfbuildinfo transientInstance) {
		log.debug("saving Selfbuildinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Selfbuildinfo persistentInstance) {
		log.debug("deleting Selfbuildinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Selfbuildinfo findById(java.lang.Integer id) {
		log.debug("getting Selfbuildinfo instance with id: " + id);
		try {
			Selfbuildinfo instance = (Selfbuildinfo) getSession().get(
					"com.hwadee.orm.Selfbuildinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Selfbuildinfo instance) {
		log.debug("finding Selfbuildinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Selfbuildinfo")
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
		log.debug("finding Selfbuildinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Selfbuildinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySbprojectLeaderName(Object sbprojectLeaderName) {
		return findByProperty(SBPROJECT_LEADER_NAME, sbprojectLeaderName);
	}

	public List findBySbprojectLeaderTel(Object sbprojectLeaderTel) {
		return findByProperty(SBPROJECT_LEADER_TEL, sbprojectLeaderTel);
	}

	public List findBySbmaterialsPurchaseName(Object sbmaterialsPurchaseName) {
		return findByProperty(SBMATERIALS_PURCHASE_NAME,
				sbmaterialsPurchaseName);
	}

	public List findBySbmaterialsPurchaseTel(Object sbmaterialsPurchaseTel) {
		return findByProperty(SBMATERIALS_PURCHASE_TEL, sbmaterialsPurchaseTel);
	}

	public List findByWriteTableName(Object writeTableName) {
		return findByProperty(WRITE_TABLE_NAME, writeTableName);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Selfbuildinfo instances");
		try {
			String queryString = "from Selfbuildinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Selfbuildinfo merge(Selfbuildinfo detachedInstance) {
		log.debug("merging Selfbuildinfo instance");
		try {
			Selfbuildinfo result = (Selfbuildinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Selfbuildinfo instance) {
		log.debug("attaching dirty Selfbuildinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Selfbuildinfo instance) {
		log.debug("attaching clean Selfbuildinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}