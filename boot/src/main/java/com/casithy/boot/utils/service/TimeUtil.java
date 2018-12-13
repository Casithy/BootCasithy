package com.casithy.boot.utils.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 下午3:00:08
 *
 */
public class TimeUtil {
	
	private static final String TIME_01 = "yyyy-MM-dd HH:mm:ss";
	
	public static String getTimeStamp(){
		String timeNow = String.valueOf((Long)(new Date()).getTime());
        return timeNow;
    }
	
	public static String getTimeString(String timeStamp,String timeFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
		String timeNow = sdf.format(new Date(Long.parseLong(timeStamp)));
		return timeNow;
	}
	
	public static void main(String[] args) {
		System.out.println(getTimeStamp());
	}
}
 