package com.hwadee.orm;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * SelfbuildinfoAttachment entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.SelfbuildinfoAttachment
 * @author MyEclipse Persistence Tools
 */

public class SelfbuildinfoAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SelfbuildinfoAttachmentDAO.class);
	// property constants
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_URL = "attachmentUrl";

	public void save(SelfbuildinfoAttachment transientInstance) {
		log.debug("saving SelfbuildinfoAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SelfbuildinfoAttachment persistentInstance) {
		log.debug("deleting SelfbuildinfoAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SelfbuildinfoAttachment findById(java.lang.Integer id) {
		log.debug("getting SelfbuildinfoAttachment instance with id: " + id);
		try {
			SelfbuildinfoAttachment instance = (SelfbuildinfoAttachment) getSession()
					.get("com.hwadee.orm.SelfbuildinfoAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SelfbuildinfoAttachment instance) {
		log.debug("finding SelfbuildinfoAttachment instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.SelfbuildinfoAttachment")
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
		log.debug("finding SelfbuildinfoAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SelfbuildinfoAttachment as model where model."
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
		log.debug("finding all SelfbuildinfoAttachment instances");
		try {
			String queryString = "from SelfbuildinfoAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SelfbuildinfoAttachment merge(
			SelfbuildinfoAttachment detachedInstance) {
		log.debug("merging SelfbuildinfoAttachment instance");
		try {
			SelfbuildinfoAttachment result = (SelfbuildinfoAttachment) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SelfbuildinfoAttachment instance) {
		log.debug("attaching dirty SelfbuildinfoAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SelfbuildinfoAttachment instance) {
		log.debug("attaching clean SelfbuildinfoAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}