package com.base.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static void addCookie(String name, String value,
	    HttpServletResponse response) {
	try {
	    // 存入cookie时设置编码
	   
	    Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));	   
	    cookie.setMaxAge(60 * 60 * 24); // 有效时间为1天
	    cookie.setPath("/InnovateSPOC/");
	    response.addCookie(cookie);
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public static String getUserid(HttpServletRequest request) {
	Cookie[] cookies = request.getCookies();// 获得所有cookie对象
	String userid = null;
	for(int i=0;i<cookies.length;i++) { // 遍历cookie数组
	    if (cookies[i].getName().equals("username")) { // 判断此cookie的key值是否是username
	        try {
		    userid = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	return userid;

    }

    public static boolean addCookie(HttpServletRequest request,
	    HttpServletResponse response) {
	Cookie[] cookies = request.getCookies();
	boolean flag = false;
	for(int i=0;i<cookies.length;i++) {
	    if (cookies[i].getName().equals("username")) {
	        cookies[i].setMaxAge(60 * 60 * 24);
	        response.addCookie(cookies[i]);
	        flag = true;
	        break;
	    }

	}

	return flag;
    }

    public static String getCookieUsername(HttpServletRequest request,
	    HttpServletResponse response) {
	Cookie[] cookies = request.getCookies();
	for(int i=0;i<cookies.length;i++){
	    if (cookies[i].getName().equals("username")) {
	        try {
		    return URLDecoder.decode(cookies[i].getValue(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }

	}

	return "";
    }

    public static String getCookieImage(HttpServletRequest request,
	    HttpServletResponse response) {
	Cookie[] cookies = request.getCookies();
	for(int i=0;i<cookies.length;i++) {
	    try {// 取出时设置编码
		if (cookies[i].getName().equals("image")) {
		    return URLDecoder.decode(cookies[i].getValue(), "UTF-8");
		}
	    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

	return "";
    }

    public static String getCookieNoReadNumber(HttpServletRequest request,
	    HttpServletResponse response) {
	Cookie[] cookies = request.getCookies();
	for(int i=0;i<cookies.length;i++) {
	    try {// 取出时设置编码
		if (cookies[i].getName().equals("noReadNumber")) {
		    return URLDecoder.decode(cookies[i].getValue(), "UTF-8");
		}
	    } catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	}

	return "";
    }

    // 判断用户是否登录
    // 情况一：未登录，返回登录界面
    // 情况二：登录成功，但未响应时间超过了10分钟，需要重新登录
    // 情况三：登录成功，响应时间也未超过了10分钟，则重新更新登录时间
    public static boolean checkLogin(HttpServletRequest request,
	    HttpServletResponse response, Cookie[] cookies) {
	// Cookie[] cookies=request.getCookies();
	boolean flag = false;
	for(int i=0;i<cookies.length;i++) {
	    if (cookies[i].getName().equalsIgnoreCase("username"))// 判断是否登录，如果登录成功就会有cookie字段username
	    {
	        flag = true;
	        break;
	    }
	}
	// System.out.print(flag);
	if (!flag) // 如果没有登录，则直接返回
	    return flag;
	else { // 如果登录成功，则判断未响应时间是否超过了10分钟
	    for(int i=0;i<cookies.length;i++) {
		try {// 取出时设置编码
		    if (cookies[i].getName().equalsIgnoreCase("logintime"))// 判断未响应时间超过了10分钟
		    {
			// 大数值字符串不能转化为Integer
			BigInteger loginTime = new BigInteger(URLDecoder.decode(cookies[i].getValue(), "UTF-8"));
			long currentTime = new Date().getTime();
			long subTime = currentTime - loginTime.longValue();

			if (subTime / (1000 * 60 * 60 * 24) >= 1) { // 未响应时间是否超过一天
			    flag = false;
			    // System.out.print("超过时间");
			} else {// 未超过了10分钟,则更新时间
			    cookies[i].setMaxAge(60 * 60 * 24);
			    cookies[i].setPath("/InnovateSPOC/");
			    cookies[i].setValue(String.valueOf(currentTime));
			    response.addCookie(cookies[i]);
			}
		    }
		} catch (UnsupportedEncodingException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	    }
	}

	return flag;
    }

    public static void loginout(HttpServletRequest request,
	    HttpServletResponse response) {
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {

	    for(int i=0;i<cookies.length;i++) {
		String cookieName = cookies[i].getName();
		if (cookieName.equals("username")
		    || cookieName.equals("logintime")
		    || cookieName.equals("adminValue")) {
		cookies[i].setValue(null);
		cookies[i].setPath("/InnovateSPOC/");
		cookies[i].setMaxAge(0);
		response.addCookie(cookies[i]);
		}

	    }
	}

	return;
    }

}
