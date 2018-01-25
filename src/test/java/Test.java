import java.util.Calendar;
import java.util.Date;

import com.hurenjieee.util.DateUtils;


public class Test {
    public static void main(String[] args) throws InterruptedException{
        Date date1 = DateUtils.parseDateTimess("2017-1-2 00:00:00");
        Date date2 = DateUtils.parseDateTimess("2016-12-1 00:00:00");
        System.out.println(DateUtils.intevalBetweenDate(date1,date2,Calendar.MONTH));
    }

}
