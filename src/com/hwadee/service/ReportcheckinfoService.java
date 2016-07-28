package com.hwadee.service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
import com.hwadee.orm.Reportcheckinfo;
import com.hwadee.orm.ReportcheckinfoDAO;

import static com.hwadee.util.Constant.*;
/**
 * @TODO 申报审核业务逻辑 
 * @author GUO
 * @date 2014-7-21上午11:43:25
 */
public class ReportcheckinfoService {

	
	
	public static List<Reportcheckinfo> countyCheckInfoListByStatus(
			String loc, int pageSize, int nowPage, int status) {
		// TODO Auto-generated method stub
	
			int start = 1;
			if (pageSize > 0 && nowPage > 0) {
				start = pageSize * (nowPage - 1);
			}
			ReportcheckinfoDAO dao = new ReportcheckinfoDAO();
			Session session = dao.getSession();
			String hql="from Reportcheckinfo R where R.project.proStatus='"+status+"'  and R.project.location.locId like '%"+ loc +"%'";
			Query q = session.createQuery(hql);
			q.setFirstResult(start);
			q.setMaxResults(pageSize);
			List<Reportcheckinfo> list = q.list();
			session.close();
			return list;
		
	}
	
	public static int getCountyCheckRowCount(String loc,int status) {
		ReportcheckinfoDAO dao = new ReportcheckinfoDAO();
		Session session = dao.getSession();
		String hql="from Reportcheckinfo R where R.project.proStatus='"+status+"' and R.project.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Reportcheckinfo> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	/**
	 * @TODO 保存
	 * @author GUO
	 * @data 2014-7-21上午11:47:49
	 * @param rci
	 * @return 成功与否
	 */
	public static int save(Reportcheckinfo rci)
	{
		ReportcheckinfoDAO dao=new ReportcheckinfoDAO();
		Transaction t=dao.getSession().beginTransaction();
		try {
			dao.save(rci);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		}
		finally{
			dao.getSession().close();
		}
	}
	
	/**
	 * @TODO 删除 
	 * @author GUO
	 * @data 2014-7-21上午11:47:29
	 * @param rciid
	 * @return 成功与否
	 */
	public static int delete(int rciid)
	{
		ReportcheckinfoDAO dao=new ReportcheckinfoDAO();
		Transaction transaction=dao.getSession().beginTransaction();
		Reportcheckinfo checkinfo=dao.findById(rciid);
		try {
			dao.delete(checkinfo);
			transaction.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return FAILD;
		}
		finally{
			dao.getSession().close();
		}
	}
	
	/**
	 * @TODO 更新
	 * @author GUO
	 * @data 2014-7-21上午11:47:12
	 * @param rci
	 * @return 成功与否
	 */
	public static int update(Reportcheckinfo rci)
	{
		ReportcheckinfoDAO dao=new ReportcheckinfoDAO();
		Session session=dao.getSession();
		Transaction t=session.beginTransaction();
		try {
			session.saveOrUpdate(rci);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		}
		finally
		{
			session.close();
		}
		
	}
	
	/**
	 * 
	 * @TODO 获取所有申报审核信息 
	 * @author GUO
	 * @data 2014-7-21上午11:47:00
	 * @return
	 */
	public static List<?> getAllReportcheckinfo()
	{
		ReportcheckinfoDAO dao=new ReportcheckinfoDAO();
		Session session=dao.getSession();
		String hql = "from Reportcheckinfo";
		Query q = session.createQuery(hql);
		List<?> list = q.list();
		session.close();
		return list;
	}


	
}
