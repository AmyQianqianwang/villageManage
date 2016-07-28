package com.hwadee.service;
import org.hibernate.Query;
import static com.hwadee.util.Constant.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.hwadee.orm.Project;
import com.hwadee.orm.ProjectDAO;
/**
 * 
 * @TODO 项目Project业务逻辑层操作
 * @author GUO
 * @date 2014-7-21上午10:43:51
 */
public class ProjectService {

	
	/**
	 * 
	 * @TODO  返回所有信息记录行数
	 * @author GUO
	 * @data 2014-7-24上午11:07:54
	 * @param loc 区域码
	 * @return 行数
	 */
	@SuppressWarnings("unchecked")
	public static int getProjectInfoRowCount(String loc) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus=1 and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	public static int getTodayProjectInfoRowCount(String loc) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where  P.proId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	
	/**
	 * 
	 * @TODO 返回项目状态为1 的列表
	 * @author GUO
	 * @data 2014-7-24上午11:03:10
	 * @param loc 区域码
	 * @param pageSize 一页多少行
	 * @param nowPage 现在是第几页
	 * @return list<Project>
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> projectInfoListByStatus(String loc, int pageSize, int nowPage,int status) {
		
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus='"+status+"'  and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Project> list = q.list();
		session.close();
		return list;
	}

	
	
	/**
	 * @TODO 
	 * @author GUO
	 * @data 2014-7-21上午10:42:12
	 * @param project
	 * @return 成功与否
	 */
	public static int save(Project project)
	{
		ProjectDAO projectDAO =new ProjectDAO();
		Transaction transaction= projectDAO.getSession().beginTransaction();
		try {
			projectDAO.save(project);
			transaction.commit();
			return OK;
		} catch (Exception e) {
			transaction.rollback();
			return FAILD;
			// TODO: handle exception
		}
		finally{
			projectDAO.getSession().close();
		}
	}
	
	/**
	 * 
	 * @TODO 根据ID删除记录 
	 * @author GUO
	 * @data 2014-7-21上午10:44:29
	 * @param proId
	 * @return 成功与否
	 */
	public static int delete(String proId)
	{
		ProjectDAO projectDAO=new ProjectDAO();
		Transaction transaction=projectDAO.getSession().beginTransaction();
		Project persistentInstance=projectDAO.findById(proId);
		try {
			projectDAO.delete(persistentInstance);
			transaction.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			return FAILD;
		}
	}
	
	/**
	 * @TODO 更新记录 
	 * @author GUO
	 * @data 2014-7-21上午10:44:52
	 * @param project
	 * @return 成功与否
	 */
	public static int update(Project project)
	{
		
		ProjectDAO projectDAO=new ProjectDAO();
		Transaction t=projectDAO.getSession().beginTransaction();
//		String proID=project.getProId();
//		//获取对象
//		Project oldproject=projectDAO.findById(proID);
//		//设置对象
//		oldproject.setUser(project.getUser());
//		oldproject.setLocation(project.getLocation());
//		oldproject.setProName(project.getProName());
//		oldproject.setRecTime(project.getRecTime());
//		oldproject.setProType(project.getProType());
//		oldproject.setProKind(project.getProKind());
//		oldproject.setProContext(project.getProContext());
//		oldproject.setProSource(project.getProSource());
//		oldproject.setFamilyCount(project.getFamilyCount());
//		oldproject.setElectTime(project.getElectTime());
//		oldproject.setPlanEndTime(project.getPlanEndTime());
//		oldproject.setImpleMethod(project.getImpleMethod());
//		oldproject.setProStatus(project.getProStatus());
//		oldproject.setUnitName(project.getUnitName());
//		oldproject.setPaddingTime(project.getPaddingTime());
//		oldproject.setTableComment(project.getTableComment());
		//更新对象
		try {
		//	projectDAO.getSession().saveOrUpdate(oldproject);
			projectDAO.getSession().saveOrUpdate(project);
			t.commit();
			return OK;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return FAILD;
		}
		finally
		{
			projectDAO.getSession().close();
		}
	}
	
	/**
	 * 
	 * @TODO 获取所有记录 
	 * @author GUO
	 * @data 2014-7-21上午10:47:06
	 * @return List列表
	 */
	public static List<?> getAllProject()
	{
		ProjectDAO projectDAO=new ProjectDAO();
		Session session=projectDAO.getSession();
		String hql="from Project";
		Query query=session.createQuery(hql);
		List<?> list=query.list();
		session.close();
		return list;
	}
	
	
	/**
	 * @TODO:根据项目编号返回项目实例
	 * @author Dong 
	 * @date 2014-7-21下午1:51:23
	 */
	public static Project getProjectByID(String proID){
		ProjectDAO proDAO=new ProjectDAO();
		Project project=null;
		try{
			project=proDAO.findById(proID);
		}catch(Exception e){
			project=null;
		}finally{
			proDAO.getSession().close();
		}
		return project;
	}
	
	/**
	 * 根据项目的状态获取在对应状态下的所有项目
	 * @param status //状态码 ,若取值为0，则查询不加入该条件
	 * @param projectType //项目类型“公共服务类”或者“基础建设类”，若取值为""，则查询加入该条件
	 * @param startRow //分页处理开始行
	 * @param pageSize	//一页所含条目数（若为0则不进行分页查询）
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-22下午7:57:57
	 */
	public List<Project> getProjectList(int status, String projectType,
			int startRow, int pageSize) {
		
		ProjectDAO proDAO = new ProjectDAO();
		return proDAO.getProjectList(status, projectType, startRow, pageSize);
	}
	
	/**
	 * @TODO:更新指定编号项目编号
	 * @author Dong 
	 * @date 2014-7-23上午8:47:51
	 * @return -1表示未找到指定项目 0 表示失败 1表示更新成功
	 */
	public static int updateProStatus(String proID,int proStatus){
		int result=0;
		ProjectDAO dao=new ProjectDAO();
		Session s=dao.getSession();
		Transaction t=s.beginTransaction();
		try{
			Project pro=dao.findById(proID);
			if(pro==null){
				result=-1;
			}else{
				pro.setProStatus(proStatus);
				s.update(pro);
				t.commit();
				result=1;
			}
		}catch(Exception e){
			t.rollback();
			result=0;
		}finally{
			dao.getSession().close();
		}
		return result;
	}

	/**
	 * @param loc 区域码
	 * @param status 状态编号
	 * @return 行数
	 * @TODO:获取指定状态，指定区域项目的行数
	 * @author Dong 
	 * @date 2014-7-24下午8:21:13
	 */
	@SuppressWarnings("unchecked")
	public static int getProjectInfoRowCount(String loc,int status) {
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus='"+status+"' and P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}
	
	/**
	 * @TODO:获取指定区域状态实施方法的项目列表
	 * @author Dong 
	 * @date 2014-7-24下午8:35:20
	 */
	@SuppressWarnings("unchecked")
	public static List<Project> getProjectList(String loc,int pageSize,int nowPage,int status,String impleMethod){
		int start = 1;
		if (pageSize > 0 && nowPage > 0) {
			start = pageSize * (nowPage - 1);
		}
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus='"+status+"' and ";
		if(impleMethod!=null){
			hql+="P.impleMethod='"+impleMethod+"' and ";
		}
		hql+="P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		q.setFirstResult(start);
		q.setMaxResults(pageSize);
		List<Project> list = q.list();
		session.close();
		return list;
	}
	
	/**
	 * @TODO:获取指定区域状态实施方法的项目数量
	 * @author Dong 
	 * @date 2014-7-24下午8:49:25
	 */
	@SuppressWarnings("unchecked")
	public static int getProjectListRowCount(String loc,int status,String impleMethod){
		ProjectDAO projectDAO = new ProjectDAO();
		Session session = projectDAO.getSession();
		String hql="from Project P where P.proStatus='"+status+"' and ";
		if(impleMethod!=null){
			hql+="P.impleMethod='"+impleMethod+"' and ";
		}
		hql+="P.location.locId like '%"+ loc +"%'";
		Query q = session.createQuery(hql);
		List<Project> list = q.list();
		session.close();
		if(null == list || list.size() == 0){
			return 0;
		}
		return list.size();
	}


	/**
	 * 根据关键字进行查询
	 * @param proStatusPassed
	 * @param selType
	 * @param selValue
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-25上午9:56:45
	 */
	public List<Project> search(String selType,	String selValue, 
			int startRow, int pageSize) {
		ProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.search(selType, selValue, startRow, pageSize);
		
	}


	/**
	 * 查询归档后的项目（即项目状态为14或者15）
	 * @param selType
	 * @param selValue
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @author 詹亮名
	 * @date:2014-7-25下午5:54:01
	 */
	public List<Project> getProjectListForRecord(String selType,
			String selValue, int startRow, int pageSize) {
		ProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getProjectListForRecord(selType, selValue, startRow, pageSize);
	}
 }
