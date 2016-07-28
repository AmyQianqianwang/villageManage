package com.hwadee.orm;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProjectvoteinfoAttachment entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.hwadee.orm.ProjectvoteinfoAttachment
 * @author MyEclipse Persistence Tools
 */

public class ProjectvoteinfoAttachmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProjectvoteinfoAttachmentDAO.class);
	// property constants
	public static final String ATTACHMENT_NAME = "attachmentName";
	public static final String ATTACHMENT_URL = "attachmentUrl";

	public void save(ProjectvoteinfoAttachment transientInstance) {
		log.debug("saving ProjectvoteinfoAttachment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProjectvoteinfoAttachment persistentInstance) {
		log.debug("deleting ProjectvoteinfoAttachment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProjectvoteinfoAttachment findById(java.lang.Integer id) {
		log.debug("getting ProjectvoteinfoAttachment instance with id: " + id);
		try {
			ProjectvoteinfoAttachment instance = (ProjectvoteinfoAttachment) getSession()
					.get("com.hwadee.orm.ProjectvoteinfoAttachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProjectvoteinfoAttachment instance) {
		log.debug("finding ProjectvoteinfoAttachment instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.ProjectvoteinfoAttachment")
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
		log.debug("finding ProjectvoteinfoAttachment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ProjectvoteinfoAttachment as model where model."
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
		log.debug("finding all ProjectvoteinfoAttachment instances");
		try {
			String queryString = "from ProjectvoteinfoAttachment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProjectvoteinfoAttachment merge(
			ProjectvoteinfoAttachment detachedInstance) {
		log.debug("merging ProjectvoteinfoAttachment instance");
		try {
			ProjectvoteinfoAttachment result = (ProjectvoteinfoAttachment) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProjectvoteinfoAttachment instance) {
		log.debug("attaching dirty ProjectvoteinfoAttachment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProjectvoteinfoAttachment instance) {
		log.debug("attaching clean ProjectvoteinfoAttachment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}