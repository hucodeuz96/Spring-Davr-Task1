package com.example.springdavrtask.hucode.util;


import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author "Husniddin Ulachov"
 * @created 10:06 PM on 6/17/2022
 * @project Spring-Davr-Task
 */
@Component
public class DateFormatUtil {

    public Date parseDate(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    public Date parseTime(String str) {
        Date time;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            time = dateFormat.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return time;
    }

    public String parseTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String sss = dateFormat.format(date);
        System.out.println(sss);
        return sss;
    }

}
