package com.hwadee.orm;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Location entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.orm.Location
 * @author MyEclipse Persistence Tools
 */

public class LocationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LocationDAO.class);
	// property constants
	public static final String CITY_NAME = "cityName";
	public static final String COUNTRY_NAME = "countryName";
	public static final String TOWN_NAME = "townName";
	public static final String VILLAGE_NAME = "villageName";
	public static final String PEOPLE_COUNT = "peopleCount";
	public static final String SUMMARY = "summary";

	public void save(Location transientInstance) {
		log.debug("saving Location instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Location persistentInstance) {
		log.debug("deleting Location instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Location findById(java.lang.String id) {
		log.debug("getting Location instance with id: " + id);
		try {
			Location instance = (Location) getSession().get(
					"com.hwadee.orm.Location", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Location instance) {
		log.debug("finding Location instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Location")
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
		log.debug("finding Location instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Location as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List findByCountryName(Object countryName) {
		return findByProperty(COUNTRY_NAME, countryName);
	}

	public List findByTownName(Object townName) {
		return findByProperty(TOWN_NAME, townName);
	}

	public List findByVillageName(Object villageName) {
		return findByProperty(VILLAGE_NAME, villageName);
	}

	public List findByPeopleCount(Object peopleCount) {
		return findByProperty(PEOPLE_COUNT, peopleCount);
	}

	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	public List findAll() {
		log.debug("finding all Location instances");
		try {
			String queryString = "from Location";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Location merge(Location detachedInstance) {
		log.debug("merging Location instance");
		try {
			Location result = (Location) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Location instance) {
		log.debug("attaching dirty Location instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Location instance) {
		log.debug("attaching clean Location instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}