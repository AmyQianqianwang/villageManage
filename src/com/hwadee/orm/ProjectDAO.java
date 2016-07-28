package com.hwadee.orm;

import java.util.ArrayList;
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
 * Project entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hwadee.orm.Project
 * @author MyEclipse Persistence Tools
 */

public class ProjectDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProjectDAO.class);
	// property constants
	public static final String PRO_NAME = "proName";
	public static final String PRO_TYPE = "proType";
	public static final String PRO_KIND = "proKind";
	public static final String PRO_CONTEXT = "proContext";
	public static final String PRO_SOURCE = "proSource";
	public static final String FAMILY_COUNT = "familyCount";
	public static final String IMPLE_METHOD = "impleMethod";
	public static final String PRO_STATUS = "proStatus";
	public static final String UNIT_NAME = "unitName";
	public static final String TABLE_COMMENT = "tableComment";

	public void save(Project transientInstance) {
		log.debug("saving Project instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Project persistentInstance) {
		log.debug("deleting Project instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Project findById(java.lang.String id) {
		log.debug("getting Project instance with id: " + id);
		try {
			Project instance = (Project) getSession().get(
					"com.hwadee.orm.Project", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Project instance) {
		log.debug("finding Project instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hwadee.orm.Project")
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
		log.debug("finding Project instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Project as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProName(Object proName) {
		return findByProperty(PRO_NAME, proName);
	}

	public List findByProType(Object proType) {
		return findByProperty(PRO_TYPE, proType);
	}

	public List findByProKind(Object proKind) {
		return findByProperty(PRO_KIND, proKind);
	}

	public List findByProContext(Object proContext) {
		return findByProperty(PRO_CONTEXT, proContext);
	}

	public List findByProSource(Object proSource) {
		return findByProperty(PRO_SOURCE, proSource);
	}

	public List findByFamilyCount(Object familyCount) {
		return findByProperty(FAMILY_COUNT, familyCount);
	}

	public List findByImpleMethod(Object impleMethod) {
		return findByProperty(IMPLE_METHOD, impleMethod);
	}

	public List findByProStatus(Object proStatus) {
		return findByProperty(PRO_STATUS, proStatus);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByTableComment(Object tableComment) {
		return findByProperty(TABLE_COMMENT, tableComment);
	}

	public List findAll() {
		log.debug("finding all Project instances");
		try {
			String queryString = "from Project";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Project merge(Project detachedInstance) {
		log.debug("merging Project instance");
		try {
			Project result = (Project) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Project instance) {
		log.debug("attaching dirty Project instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Project instance) {
		log.debug("attaching clean Project instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/**
	 * 根据项目的状态获取在对应状态下的所有项目
	 * @param status //状态码 ,若取值为0，则查询不加入该条件
	 * @param projectType //项目类型“公共服务类”或者“基础建设类”，若取值为""，则查询加入该条件
	 * @param startRow //分页处理开始行
	 * @param pageSize	//一页所含条目数（若为0则不进行分页查询）
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-22下午8:16:45
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getProjectList(int status, String projectType,
			int startRow, int pageSize) {
		List<Project> list = null;
		
		
		try {
			String hql = "FROM Project AS p WHERE 1=1 ";
			
			if (status != 0) {
				hql += "AND p.proStatus=:status ";
			}
			if ( !projectType.trim().equals("") ) {
				hql += "AND p.proType=:projectType ";
			}
			
			hql += "ORDER BY p.paddingTime ASC";
			
			Query query = getSession().createQuery(hql);
			
			if (status != 0) {
				query.setParameter("status", status);
			}
			if ( !projectType.trim().equals("") ) {
				query.setParameter("projectType", projectType);
			}
			
			//分页处理
			if (pageSize > 0) {
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
			}
			
			list = (List<Project>)query.list();
		} catch (Exception e) {
			list = new ArrayList<Project>();
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * @param status
	 * @param selType
	 * @param selValue
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-25上午9:58:48
	 */
	@SuppressWarnings("unchecked")
	public List<Project> search(String selType, String selValue,
			int startRow, int pageSize) {
		
		List<Project> list = null;
		try {
			String hql = "FROM Project AS p WHERE p."+ selType +" like :key ";
			
			hql += "ORDER BY p.paddingTime DESC";
			
			Query query = getSession().createQuery(hql);
			
			query.setParameter("key", "%" + selValue + "%");
			
			//分页处理
			if (pageSize > 0) {
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
			}
			
			list = (List<Project>)query.list();
		} catch (Exception e) {
			list = new ArrayList<Project>();
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询归档后的项目（即项目状态为14或者15）
	 * @param selType
	 * @param selValue
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-25下午5:55:34
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getProjectListForRecord(String selType,
			String selValue, int startRow, int pageSize) {
		List<Project> list = null;
		try {
			String hql = "FROM Project AS p WHERE p."+ selType +" like :key ";
			
			hql += " AND p.proStatus=14 OR p.proStatus=15 ";
			
			hql += "ORDER BY p.paddingTime DESC";
			
			Query query = getSession().createQuery(hql);
			
			query.setParameter("key", "%" + selValue + "%");
			
			//分页处理
			if (pageSize > 0) {
				query.setFirstResult(startRow);
				query.setMaxResults(pageSize);
			}
			
			list = (List<Project>)query.list();
		} catch (Exception e) {
			list = new ArrayList<Project>();
			e.printStackTrace();
		}
		return list;
	}
}