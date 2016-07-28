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
 * @TODO ��ĿProjectҵ���߼������
 * @author GUO
 * @date 2014-7-21����10:43:51
 */
public class ProjectService {

	
	/**
	 * 
	 * @TODO  ����������Ϣ��¼����
	 * @author GUO
	 * @data 2014-7-24����11:07:54
	 * @param loc ������
	 * @return ����
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
	 * @TODO ������Ŀ״̬Ϊ1 ���б�
	 * @author GUO
	 * @data 2014-7-24����11:03:10
	 * @param loc ������
	 * @param pageSize һҳ������
	 * @param nowPage �����ǵڼ�ҳ
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
	 * @data 2014-7-21����10:42:12
	 * @param project
	 * @return �ɹ����
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
	 * @TODO ����IDɾ����¼ 
	 * @author GUO
	 * @data 2014-7-21����10:44:29
	 * @param proId
	 * @return �ɹ����
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
	 * @TODO ���¼�¼ 
	 * @author GUO
	 * @data 2014-7-21����10:44:52
	 * @param project
	 * @return �ɹ����
	 */
	public static int update(Project project)
	{
		
		ProjectDAO projectDAO=new ProjectDAO();
		Transaction t=projectDAO.getSession().beginTransaction();
//		String proID=project.getProId();
//		//��ȡ����
//		Project oldproject=projectDAO.findById(proID);
//		//���ö���
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
		//���¶���
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
	 * @TODO ��ȡ���м�¼ 
	 * @author GUO
	 * @data 2014-7-21����10:47:06
	 * @return List�б�
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
	 * @TODO:������Ŀ��ŷ�����Ŀʵ��
	 * @author Dong 
	 * @date 2014-7-21����1:51:23
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
	 * ������Ŀ��״̬��ȡ�ڶ�Ӧ״̬�µ�������Ŀ
	 * @param status //״̬�� ,��ȡֵΪ0�����ѯ�����������
	 * @param projectType //��Ŀ���͡����������ࡱ���ߡ����������ࡱ����ȡֵΪ""�����ѯ���������
	 * @param startRow //��ҳ����ʼ��
	 * @param pageSize	//һҳ������Ŀ������Ϊ0�򲻽��з�ҳ��ѯ��
	 * @return
	 * @author ղ����
	 * @date:2014-7-22����7:57:57
	 */
	public List<Project> getProjectList(int status, String projectType,
			int startRow, int pageSize) {
		
		ProjectDAO proDAO = new ProjectDAO();
		return proDAO.getProjectList(status, projectType, startRow, pageSize);
	}
	
	/**
	 * @TODO:����ָ�������Ŀ���
	 * @author Dong 
	 * @date 2014-7-23����8:47:51
	 * @return -1��ʾδ�ҵ�ָ����Ŀ 0 ��ʾʧ�� 1��ʾ���³ɹ�
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
	 * @param loc ������
	 * @param status ״̬���
	 * @return ����
	 * @TODO:��ȡָ��״̬��ָ��������Ŀ������
	 * @author Dong 
	 * @date 2014-7-24����8:21:13
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
	 * @TODO:��ȡָ������״̬ʵʩ��������Ŀ�б�
	 * @author Dong 
	 * @date 2014-7-24����8:35:20
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
	 * @TODO:��ȡָ������״̬ʵʩ��������Ŀ����
	 * @author Dong 
	 * @date 2014-7-24����8:49:25
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
	 * ���ݹؼ��ֽ��в�ѯ
	 * @param proStatusPassed
	 * @param selType
	 * @param selValue
	 * @return
	 * @author ղ����
	 * @date:2014-7-25����9:56:45
	 */
	public List<Project> search(String selType,	String selValue, 
			int startRow, int pageSize) {
		ProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.search(selType, selValue, startRow, pageSize);
		
	}


	/**
	 * ��ѯ�鵵�����Ŀ������Ŀ״̬Ϊ14����15��
	 * @param selType
	 * @param selValue
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @author ղ����
	 * @date:2014-7-25����5:54:01
	 */
	public List<Project> getProjectListForRecord(String selType,
			String selValue, int startRow, int pageSize) {
		ProjectDAO projectDAO = new ProjectDAO();
		return projectDAO.getProjectListForRecord(selType, selValue, startRow, pageSize);
	}
 }
