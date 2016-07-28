/**
 * @author: ղ����
 * @date: 2014-7-23����8:24:38
 */
package com.hwadee.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {
	/**
	 * �ϴ��ļ����ߣ���ͬʱ�ϴ�����ļ���
	 * @param request ����
	 * @param path �ļ������·��(�������ļ���)
	 * @return ���� Map ��������(attachmentName),������ַ(���Ե�ַ�����ļ����ͺ�׺attachmentURL)
	 * @author ղ����
	 * @date:2014-7-23����8:43:23
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> upload(HttpServletRequest request, String path) {
		//�ж��ύ�����ı��Ƿ�Ϊ�ļ��ϴ��˵� 
        boolean isMultipart= ServletFileUpload.isMultipartContent(request);
System.out.println(request.getParameter("commentObject"));
        Map<String, String> nameMap = new HashMap<String, String>();
        
        if(isMultipart){
        	//����һ���ļ��ϴ��������
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            // ����ļ����Ƿ����
         	File file = new File(path);
         	if (!file.exists())
			{
				file.mkdir();//����ļ��в����ھʹ������ļ���
			}
         	
         	
            List<FileItem> fileItems;
			try {
				
				fileItems = (List<FileItem>)upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				upload.setHeaderEncoding("UTF-8");
				// ���������û��ϴ��ļ���С,��λ:�ֽ�
				upload.setSizeMax(1024 * 1024 * 100);
				
				while (iter.hasNext())
				{
					FileItem item = (FileItem)iter.next();
					if (item.isFormField())
					{
						// ���item�������ı���
					}
					else
					{
						//String name = item.getFieldName();
						//String value = item.getString("UTF-8");
						String fileName = item.getName();
						
						
						if (fileName != null && !fileName.trim().equals(""))
						{
							File fileOnServer = new File(path + String.valueOf(File.separator) + fileName);
							item.write(fileOnServer);
						}
						nameMap.put("attachmentName", fileName);
						nameMap.put("attachmentURL", path + File.separator + fileName);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        return nameMap;
	}
}
