package com.hwadee.orm;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CompleteeditioninfoAttachment entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.hwadee.orm.CompleteeditioninfoAttachment
 * @author MyEclipse Persistence Tools
 */

public class CompleteeditioninfoAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompleteeditioninfoAttachmentDAO.class);
	// property constants
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_URL = "attachmentUrl";

	public void save(CompleteeditioninfoAttachment transientInstance) {
		log.debug("saving CompleteeditioninfoAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CompleteeditioninfoAttachment persistentInstance) {
		log.debug("deleting CompleteeditioninfoAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompleteeditioninfoAttachment findById(java.lang.Integer id) {
		log.debug("getting CompleteeditioninfoAttachment instance with id: "
				+ id);
		try {
			CompleteeditioninfoAttachment instance = (CompleteeditioninfoAttachment) getSession()
					.get("com.hwadee.orm.CompleteeditioninfoAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CompleteeditioninfoAttachment instance) {
		log.debug("finding CompleteeditioninfoAttachment instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.hwadee.orm.CompleteeditioninfoAttachment")
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
		log.debug("finding CompleteeditioninfoAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CompleteeditioninfoAttachment as model where model."
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
		log.debug("finding all CompleteeditioninfoAttachment instances");
		try {
			String queryString = "from CompleteeditioninfoAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CompleteeditioninfoAttachment merge(
			CompleteeditioninfoAttachment detachedInstance) {
		log.debug("merging CompleteeditioninfoAttachment instance");
		try {
			CompleteeditioninfoAttachment result = (CompleteeditioninfoAttachment) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CompleteeditioninfoAttachment instance) {
		log.debug("attaching dirty CompleteeditioninfoAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompleteeditioninfoAttachment instance) {
		log.debug("attaching clean CompleteeditioninfoAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}