package com.simpleTalk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FTPUtil {
	private static Logger log=LoggerFactory.getLogger(FTPUtil.class);
	
	private  static String ftpip=PropertiesUtil.getProperty("ftp.ip");
	private  static String ftpusername=PropertiesUtil.getProperty("ftp.username");
	private  static String ftppassword=PropertiesUtil.getProperty("ftp.password");
	private  static String ftppath=PropertiesUtil.getProperty("ftp.path");
	
	private String ip;
	private int port;
	private String username;
	private String password;
	private FTPClient ftpClient;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public FTPClient getFtpClient() {
		return ftpClient;
	}
	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
	public FTPUtil(String ip, int port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	 public static boolean uploadFile(List<File> fileList) throws IOException {
	        FTPUtil ftpUtil = new FTPUtil(ftpip, 21, ftpusername, ftppassword);
	        log.info("开始连接ftp服务器");
	        boolean result = ftpUtil.uploadFile("img",fileList);
	        log.info("开始连接ftp服务器,结束上传,上传结果:{}",result);
	        return result;
	    }


	    private boolean uploadFile(String remotePath,List<File> fileList) throws IOException {
	        boolean uploaded = true;
	        FileInputStream fis = null;
	        //连接FTP服务器
	        if(connectFtp(this.ip,this.port,this.username,this.password)){
	            try {
	                ftpClient.changeWorkingDirectory(remotePath);
	                ftpClient.mkd(remotePath);
	                ftpClient.setBufferSize(1024);
	                ftpClient.setControlEncoding("UTF-8");
	                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	                ftpClient.enterLocalPassiveMode();
	                for(File fileItem : fileList){
	                    fis = new FileInputStream(fileItem);
	                    ftpClient.storeFile(fileItem.getName(),fis);
	                }

	            } catch (IOException e) {
	                log.error("上传文件异常",e);
	                uploaded = false;
	                e.printStackTrace();
	            } finally {
	                fis.close();
	                ftpClient.disconnect();
	            }
	        }
	        return uploaded;
	    }
	
	
	/**
	 * 连接ftp服务器
	 * @param ip
	 * @param port
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean connectFtp(String ip, int port, String username, String password){
		boolean isSuccess=false;
		ftpClient=new FTPClient();
		try {
			ftpClient.connect(ip);
			isSuccess=ftpClient.login(username, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
}
