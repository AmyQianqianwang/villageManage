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
 * Jobcompetitioninfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Jobcompetitioninfo
 * @author MyEclipse Persistence Tools
 */

public class JobcompetitioninfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JobcompetitioninfoDAO.class);
	// property constants
	public static final String JOB_NAME = "jobName";
	public static final String JOB_PAY = "jobPay";
	public static final String JOB_DESCRIPTION = "jobDescription";
	public static final String JOB_REQUIREMENT = "jobRequirement";
	public static final String PEOPLE_NAME = "peopleName";
	public static final String COMPETITION_RESULT = "competitionResult";
	public static final String CONTRACT_FUNDS = "contractFunds";
	public static final String JCICHECK_RESULT = "jcicheckResult";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Jobcompetitioninfo transientInstance) {
		log.debug("saving Jobcompetitioninfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobcompetitioninfo persistentInstance) {
		log.debug("deleting Jobcompetitioninfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobcompetitioninfo findById(java.lang.Integer id) {
		log.debug("getting Jobcompetitioninfo instance with id: " + id);
		try {
			Jobcompetitioninfo instance = (Jobcompetitioninfo) getSession()
					.get("com.hwadee.orm.Jobcompetitioninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jobcompetitioninfo instance) {
		log.debug("finding Jobcompetitioninfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Jobcompetitioninfo")
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
		log.debug("finding Jobcompetitioninfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Jobcompetitioninfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJobName(Object jobName) {
		return findByProperty(JOB_NAME, jobName);
	}

	public List findByJobPay(Object jobPay) {
		return findByProperty(JOB_PAY, jobPay);
	}

	public List findByJobDescription(Object jobDescription) {
		return findByProperty(JOB_DESCRIPTION, jobDescription);
	}

	public List findByJobRequirement(Object jobRequirement) {
		return findByProperty(JOB_REQUIREMENT, jobRequirement);
	}

	public List findByPeopleName(Object peopleName) {
		return findByProperty(PEOPLE_NAME, peopleName);
	}

	public List findByCompetitionResult(Object competitionResult) {
		return findByProperty(COMPETITION_RESULT, competitionResult);
	}

	public List findByContractFunds(Object contractFunds) {
		return findByProperty(CONTRACT_FUNDS, contractFunds);
	}

	public List findByJcicheckResult(Object jcicheckResult) {
		return findByProperty(JCICHECK_RESULT, jcicheckResult);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Jobcompetitioninfo instances");
		try {
			String queryString = "from Jobcompetitioninfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobcompetitioninfo merge(Jobcompetitioninfo detachedInstance) {
		log.debug("merging Jobcompetitioninfo instance");
		try {
			Jobcompetitioninfo result = (Jobcompetitioninfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobcompetitioninfo instance) {
		log.debug("attaching dirty Jobcompetitioninfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobcompetitioninfo instance) {
		log.debug("attaching clean Jobcompetitioninfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}