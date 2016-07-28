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
 * Implementplanfundsbuget entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Implementplanfundsbuget
 * @author MyEclipse Persistence Tools
 */

public class ImplementplanfundsbugetDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ImplementplanfundsbugetDAO.class);
	// property constants
	public static final String IMPLE_PLAN = "implePlan";
	public static final String SPECIAL_FUND = "specialFund";
	public static final String SELF_FUND = "selfFund";
	public static final String MELT_FUND = "meltFund";
	public static final String MATURITIES = "maturities";
	public static final String OTHER_FUND = "otherFund";
	public static final String TOTAL_FUND = "totalFund";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Implementplanfundsbuget transientInstance) {
		log.debug("saving Implementplanfundsbuget instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Implementplanfundsbuget persistentInstance) {
		log.debug("deleting Implementplanfundsbuget instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Implementplanfundsbuget findById(java.lang.Integer id) {
		log.debug("getting Implementplanfundsbuget instance with id: " + id);
		try {
			Implementplanfundsbuget instance = (Implementplanfundsbuget) getSession()
					.get("com.hwadee.orm.Implementplanfundsbuget", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Implementplanfundsbuget instance) {
		log.debug("finding Implementplanfundsbuget instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Implementplanfundsbuget")
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
		log.debug("finding Implementplanfundsbuget instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Implementplanfundsbuget as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByImplePlan(Object implePlan) {
		return findByProperty(IMPLE_PLAN, implePlan);
	}

	public List findBySpecialFund(Object specialFund) {
		return findByProperty(SPECIAL_FUND, specialFund);
	}

	public List findBySelfFund(Object selfFund) {
		return findByProperty(SELF_FUND, selfFund);
	}

	public List findByMeltFund(Object meltFund) {
		return findByProperty(MELT_FUND, meltFund);
	}

	public List findByMaturities(Object maturities) {
		return findByProperty(MATURITIES, maturities);
	}

	public List findByOtherFund(Object otherFund) {
		return findByProperty(OTHER_FUND, otherFund);
	}

	public List findByTotalFund(Object totalFund) {
		return findByProperty(TOTAL_FUND, totalFund);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Implementplanfundsbuget instances");
		try {
			String queryString = "from Implementplanfundsbuget";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Implementplanfundsbuget merge(
			Implementplanfundsbuget detachedInstance) {
		log.debug("merging Implementplanfundsbuget instance");
		try {
			Implementplanfundsbuget result = (Implementplanfundsbuget) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Implementplanfundsbuget instance) {
		log.debug("attaching dirty Implementplanfundsbuget instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Implementplanfundsbuget instance) {
		log.debug("attaching clean Implementplanfundsbuget instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}