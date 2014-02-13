package com.crm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;



/**
 * DAO工厂类,主要功能是根据用户的请求，实例化相应的DAO实例并返回
 * 
 * @author 许润华
 * @createTime 2010.07.23
 * @lastModifyTime 2010.07.24
 */
public class DAOFactory {
    /* DAOFactory实例*/
    private static DAOFactory instance;
    /* 请求的DAO类名称*/
    private String daoName;
    /* 属性文件对于的Properties*/
    private Properties daoProps;
    
    /**
     * 默认构造函数
     * 
     * 采用单利模式,后遭函数为私有方法
     */
    private DAOFactory() {
	init();
    }
    
    /**
     * 获得DAOFactory类实例
     * 
     * @return DAOFactory实例 
     */
    synchronized public static DAOFactory getInstance() {
	// 如果之前没有实例化过，实例化一个DAOFactory
	if (instance == null) {
	    instance = new DAOFactory();
	}
	return instance;
    }
    
    /**
     * 根据请求返回Object类型的相应DAO实例
     * 
     * @param daoName 请求实例化的DAO类名称
     * @return 实例化好的DAO类
     */
    public Object getDAO(String daoName) {
	// 获取属性文件中键值对应的Value
	String clazz = daoProps.getProperty(daoName);
	// 如果没有获得，报错
	if (clazz == null) {
	    System.err.println("没有注册你请求的DAO类,请查看dao.xml");
	}
	
	Object dao = null;
	// 实例化类实例
	try {
	    dao = Class.forName(clazz).newInstance(); 
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	
	return dao;
    }
    
    /**
     * 构造初始化, 根据dao的配置文件
     * 获取dao名称对应的完整路径的类
     * 
     */
    private void init() {
	InputStream is = getClass().getResourceAsStream("/dao.xml");
	daoProps = new Properties();
	try {
	    daoProps.loadFromXML(is); 
	} catch (InvalidPropertiesFormatException e) {
	    System.err.println("读取DAO配置文件失败:");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.err.println("读取DAO配置文件失败:");
	    e.printStackTrace();
	} finally {
	    try {
		is.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * @param daoName the daoName to set
     */
    public void setDaoName(String daoName) {
	this.daoName = daoName;
    }

    /**
     * @return the daoName
     */
    public String getDaoName() {
	return daoName;
    }
}
