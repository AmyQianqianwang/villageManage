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
 * Completeeditioninfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hwadee.orm.Completeeditioninfo
 * @author MyEclipse Persistence Tools
 */

public class CompleteeditioninfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompleteeditioninfoDAO.class);
	// property constants
	public static final String NEED_EDIT = "needEdit";
	public static final String EDIT_CONTEXT = "editContext";
	public static final String GO_INTO_VOTE = "goIntoVote";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Completeeditioninfo transientInstance) {
		log.debug("saving Completeeditioninfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Completeeditioninfo persistentInstance) {
		log.debug("deleting Completeeditioninfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Completeeditioninfo findById(java.lang.Integer id) {
		log.debug("getting Completeeditioninfo instance with id: " + id);
		try {
			Completeeditioninfo instance = (Completeeditioninfo) getSession()
					.get("com.hwadee.orm.Completeeditioninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Completeeditioninfo instance) {
		log.debug("finding Completeeditioninfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Completeeditioninfo")
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
		log.debug("finding Completeeditioninfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Completeeditioninfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNeedEdit(Object needEdit) {
		return findByProperty(NEED_EDIT, needEdit);
	}

	public List findByEditContext(Object editContext) {
		return findByProperty(EDIT_CONTEXT, editContext);
	}

	public List findByGoIntoVote(Object goIntoVote) {
		return findByProperty(GO_INTO_VOTE, goIntoVote);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Completeeditioninfo instances");
		try {
			String queryString = "from Completeeditioninfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Completeeditioninfo merge(Completeeditioninfo detachedInstance) {
		log.debug("merging Completeeditioninfo instance");
		try {
			Completeeditioninfo result = (Completeeditioninfo) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Completeeditioninfo instance) {
		log.debug("attaching dirty Completeeditioninfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Completeeditioninfo instance) {
		log.debug("attaching clean Completeeditioninfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}