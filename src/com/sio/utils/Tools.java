package com.sio.utils;

public class Tools {

	
	public Tools(){
		
	}
	public static String  parseDate(String date)
    {
        String[] arrayDate = date.split("/");
        String dateFormatted = arrayDate[2] + "-" + arrayDate[1] + "-" + arrayDate[0];
        System.out.println(dateFormatted);
        return dateFormatted;
    }	
	
	
	public static String  getMois(String date)
    {
        String[] arrayDate = date.split("-");
        String dateFormatted =  arrayDate[1] + "-" + arrayDate[0];
        System.out.println("date du gteMois" +dateFormatted);
        return dateFormatted;
    }	
	
		
	
}
