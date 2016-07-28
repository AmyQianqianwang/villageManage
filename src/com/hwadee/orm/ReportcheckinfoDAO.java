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
 * Reportcheckinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Reportcheckinfo
 * @author MyEclipse Persistence Tools
 */

public class ReportcheckinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReportcheckinfoDAO.class);
	// property constants
	public static final String COUNTRY_CHECK_RESULT = "countryCheckResult";
	public static final String COMPANY_CHECK_RESULT = "companyCheckResult";
	public static final String CITY_CHECK_RESULT = "cityCheckResult";
	public static final String CHECK_RESULT = "checkResult";
	public static final String WRITE_TABLE_NAME = "writeTableName";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Reportcheckinfo transientInstance) {
		log.debug("saving Reportcheckinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reportcheckinfo persistentInstance) {
		log.debug("deleting Reportcheckinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reportcheckinfo findById(java.lang.Integer id) {
		log.debug("getting Reportcheckinfo instance with id: " + id);
		try {
			Reportcheckinfo instance = (Reportcheckinfo) getSession().get(
					"com.hwadee.orm.Reportcheckinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Reportcheckinfo instance) {
		log.debug("finding Reportcheckinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Reportcheckinfo")
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
		log.debug("finding Reportcheckinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Reportcheckinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCountryCheckResult(Object countryCheckResult) {
		return findByProperty(COUNTRY_CHECK_RESULT, countryCheckResult);
	}

	public List findByCompanyCheckResult(Object companyCheckResult) {
		return findByProperty(COMPANY_CHECK_RESULT, companyCheckResult);
	}

	public List findByCityCheckResult(Object cityCheckResult) {
		return findByProperty(CITY_CHECK_RESULT, cityCheckResult);
	}

	public List findByCheckResult(Object checkResult) {
		return findByProperty(CHECK_RESULT, checkResult);
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
		log.debug("finding all Reportcheckinfo instances");
		try {
			String queryString = "from Reportcheckinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reportcheckinfo merge(Reportcheckinfo detachedInstance) {
		log.debug("merging Reportcheckinfo instance");
		try {
			Reportcheckinfo result = (Reportcheckinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reportcheckinfo instance) {
		log.debug("attaching dirty Reportcheckinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reportcheckinfo instance) {
		log.debug("attaching clean Reportcheckinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}