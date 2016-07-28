/**
 * @author: 詹亮名
 * @date: 2014-7-23下午8:24:38
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
	 * 上传文件工具（可同时上传多个文件）
	 * @param request 请求
	 * @param path 文件保存的路径(不包括文件名)
	 * @return 返回 Map 附件名称(attachmentName),附件地址(绝对地址包括文件名和后缀attachmentURL)
	 * @author 詹亮名
	 * @date:2014-7-23下午8:43:23
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> upload(HttpServletRequest request, String path) {
		//判断提交过来的表单是否为文件上传菜单 
        boolean isMultipart= ServletFileUpload.isMultipartContent(request);
System.out.println(request.getParameter("commentObject"));
        Map<String, String> nameMap = new HashMap<String, String>();
        
        if(isMultipart){
        	//构造一个文件上传处理对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            // 检查文件夹是否存在
         	File file = new File(path);
         	if (!file.exists())
			{
				file.mkdir();//如果文件夹不存在就创建该文件夹
			}
         	
         	
            List<FileItem> fileItems;
			try {
				
				fileItems = (List<FileItem>)upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();
				upload.setHeaderEncoding("UTF-8");
				// 设置允许用户上传文件大小,单位:字节
				upload.setSizeMax(1024 * 1024 * 100);
				
				while (iter.hasNext())
				{
					FileItem item = (FileItem)iter.next();
					if (item.isFormField())
					{
						// 如果item是正常的表单域
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
