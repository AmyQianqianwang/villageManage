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
 * Projectvoteinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Projectvoteinfo
 * @author MyEclipse Persistence Tools
 */

public class ProjectvoteinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProjectvoteinfoDAO.class);
	// property constants
	public static final String PVTYPE = "pvtype";
	public static final String PART_COUNT = "partCount";
	public static final String SUPPOSE_COUNT = "supposeCount";
	public static final String ACTUAL_COUNT = "actualCount";
	public static final String ATTEND_COUNT = "attendCount";
	public static final String TOTAL_COUNT = "totalCount";
	public static final String POSITIVE_COUNT = "positiveCount";
	public static final String NEGATIVE_COUNT = "negativeCount";
	public static final String ABSTENTION_COUNT = "abstentionCount";
	public static final String RESULT = "result";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Projectvoteinfo transientInstance) {
		log.debug("saving Projectvoteinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Projectvoteinfo persistentInstance) {
		log.debug("deleting Projectvoteinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Projectvoteinfo findById(java.lang.Integer id) {
		log.debug("getting Projectvoteinfo instance with id: " + id);
		try {
			Projectvoteinfo instance = (Projectvoteinfo) getSession().get(
					"com.hwadee.orm.Projectvoteinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Projectvoteinfo instance) {
		log.debug("finding Projectvoteinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Projectvoteinfo")
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
		log.debug("finding Projectvoteinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Projectvoteinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPvtype(Object pvtype) {
		return findByProperty(PVTYPE, pvtype);
	}

	public List findByPartCount(Object partCount) {
		return findByProperty(PART_COUNT, partCount);
	}

	public List findBySupposeCount(Object supposeCount) {
		return findByProperty(SUPPOSE_COUNT, supposeCount);
	}

	public List findByActualCount(Object actualCount) {
		return findByProperty(ACTUAL_COUNT, actualCount);
	}

	public List findByAttendCount(Object attendCount) {
		return findByProperty(ATTEND_COUNT, attendCount);
	}

	public List findByTotalCount(Object totalCount) {
		return findByProperty(TOTAL_COUNT, totalCount);
	}

	public List findByPositiveCount(Object positiveCount) {
		return findByProperty(POSITIVE_COUNT, positiveCount);
	}

	public List findByNegativeCount(Object negativeCount) {
		return findByProperty(NEGATIVE_COUNT, negativeCount);
	}

	public List findByAbstentionCount(Object abstentionCount) {
		return findByProperty(ABSTENTION_COUNT, abstentionCount);
	}

	public List findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Projectvoteinfo instances");
		try {
			String queryString = "from Projectvoteinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Projectvoteinfo merge(Projectvoteinfo detachedInstance) {
		log.debug("merging Projectvoteinfo instance");
		try {
			Projectvoteinfo result = (Projectvoteinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Projectvoteinfo instance) {
		log.debug("attaching dirty Projectvoteinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Projectvoteinfo instance) {
		log.debug("attaching clean Projectvoteinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}