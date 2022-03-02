package com.wiloke.corecommon.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    DateTimeUtils() {  }

    public static DateTimeUtils getInstance() {
        return new DateTimeUtils();
    }

    /**
     * Convert date to timestamp
     * @param strDate
     * @return
     */
    public Long strToTimestamp(String strDate) {
        try {
            final DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = formatter.parse(strDate);
            Timestamp ts = new Timestamp(date.getTime());
            return ts.getTime();
        }catch (ParseException e){
            return null;
        }
    }
}
