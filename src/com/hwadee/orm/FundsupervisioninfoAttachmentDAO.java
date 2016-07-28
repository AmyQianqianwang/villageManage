package com.hwadee.orm;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * FundsupervisioninfoAttachment entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.hwadee.orm.FundsupervisioninfoAttachment
 * @author MyEclipse Persistence Tools
 */

public class FundsupervisioninfoAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FundsupervisioninfoAttachmentDAO.class);
	// property constants
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_URL = "attachmentUrl";

	public void save(FundsupervisioninfoAttachment transientInstance) {
		log.debug("saving FundsupervisioninfoAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FundsupervisioninfoAttachment persistentInstance) {
		log.debug("deleting FundsupervisioninfoAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FundsupervisioninfoAttachment findById(java.lang.Integer id) {
		log.debug("getting FundsupervisioninfoAttachment instance with id: "
				+ id);
		try {
			FundsupervisioninfoAttachment instance = (FundsupervisioninfoAttachment) getSession()
					.get("com.hwadee.orm.FundsupervisioninfoAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FundsupervisioninfoAttachment instance) {
		log.debug("finding FundsupervisioninfoAttachment instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.hwadee.orm.FundsupervisioninfoAttachment")
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
		log.debug("finding FundsupervisioninfoAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FundsupervisioninfoAttachment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAttachmentName(Object attachmentName) {
		return findByProperty(ATTACHMENT_NAME, attachmentName);
	}

	public List findByAttachmentUrl(Object attachmentUrl) {
		return findByProperty(ATTACHMENT_URL, attachmentUrl);
	}

	public List findAll() {
		log.debug("finding all FundsupervisioninfoAttachment instances");
		try {
			String queryString = "from FundsupervisioninfoAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FundsupervisioninfoAttachment merge(
			FundsupervisioninfoAttachment detachedInstance) {
		log.debug("merging FundsupervisioninfoAttachment instance");
		try {
			FundsupervisioninfoAttachment result = (FundsupervisioninfoAttachment) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FundsupervisioninfoAttachment instance) {
		log.debug("attaching dirty FundsupervisioninfoAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FundsupervisioninfoAttachment instance) {
		log.debug("attaching clean FundsupervisioninfoAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}