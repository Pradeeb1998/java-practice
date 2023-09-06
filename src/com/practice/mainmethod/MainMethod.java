package com.practice.mainmethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainMethod{
	
	public static void main(String args[]) {
		
		System.out.println(new Date().toLocaleString());
		
		
		
		
		DateFormat inputFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		
		System.out.println(inputFormat.format(new Date()).toString());
		
		System.out.println(inputFormat.toString());
	}
	
	
}