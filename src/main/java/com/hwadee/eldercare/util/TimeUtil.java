package com.hwadee.eldercare.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public String getTimeString(String format){
        SimpleDateFormat df= new SimpleDateFormat(format);
        return df.format(new Date());
    }

}
