package kodlama.io.hrms.mernis;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 7.5.0.0
//
// Created by Quasar Development 
//
//----------------------------------------------------

import java.util.Date;


public interface UVADateTimeConverter
{
    java.util.Date convertDateTime(String strDate);
    java.util.Date convertTime(String strDate);
    java.util.Date convertDate(String strDate);
    String convertDuration(String value);
    String getStringFromDateTime(Date value);
    String getStringFromDate(Date value);
    String getStringFromTime(Date value);
    String getStringFromDuration(String value);
}