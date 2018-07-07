package cc.doctor.lovely.blog.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final int ONE_DAY_MILLISECONDS = 24 * 60 * 60 * 1000;

    public static Date timeAfter(Integer mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, mills);
        return calendar.getTime();
    }
}
