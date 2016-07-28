package com.hwadee.orm;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ImplementplanfundsbugetAttachment entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.hwadee.orm.ImplementplanfundsbugetAttachment
 * @author MyEclipse Persistence Tools
 */

public class ImplementplanfundsbugetAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ImplementplanfundsbugetAttachmentDAO.class);
	// property constants
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_URL = "attachmentUrl";

	public void save(ImplementplanfundsbugetAttachment transientInstance) {
		log.debug("saving ImplementplanfundsbugetAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ImplementplanfundsbugetAttachment persistentInstance) {
		log.debug("deleting ImplementplanfundsbugetAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ImplementplanfundsbugetAttachment findById(java.lang.Integer id) {
		log.debug("getting ImplementplanfundsbugetAttachment instance with id: "
				+ id);
		try {
			ImplementplanfundsbugetAttachment instance = (ImplementplanfundsbugetAttachment) getSession()
					.get("com.hwadee.orm.ImplementplanfundsbugetAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ImplementplanfundsbugetAttachment instance) {
		log.debug("finding ImplementplanfundsbugetAttachment instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.hwadee.orm.ImplementplanfundsbugetAttachment")
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
		log.debug("finding ImplementplanfundsbugetAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ImplementplanfundsbugetAttachment as model where model."
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
		log.debug("finding all ImplementplanfundsbugetAttachment instances");
		try {
			String queryString = "from ImplementplanfundsbugetAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImplementplanfundsbugetAttachment merge(
			ImplementplanfundsbugetAttachment detachedInstance) {
		log.debug("merging ImplementplanfundsbugetAttachment instance");
		try {
			ImplementplanfundsbugetAttachment result = (ImplementplanfundsbugetAttachment) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImplementplanfundsbugetAttachment instance) {
		log.debug("attaching dirty ImplementplanfundsbugetAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImplementplanfundsbugetAttachment instance) {
		log.debug("attaching clean ImplementplanfundsbugetAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}