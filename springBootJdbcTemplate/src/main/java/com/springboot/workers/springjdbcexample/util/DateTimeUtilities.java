package com.springboot.workers.springjdbcexample.util;

import java.sql.Timestamp;

public class DateTimeUtilities {

	public static Timestamp getTimeStamp()
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
}
