package utility;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author DJBond
 */
public class DateTimeUtility {
   
    public static String formatSQLDate(Date d) {
       String f;
      final String DATEPATTERN = "MM/dd/YYYY";
       final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATEPATTERN);
           if (d==null) {
            return null;
        }
        
        f = FORMATTER.format(d);
        return f;
    }
    public static String formatSQLTime(Time t){
        String f;
       final String TIMEPATTERN = "h:mm a";
       final SimpleDateFormat FORMATTER = new SimpleDateFormat(TIMEPATTERN);
        if (t==null) {
            return null;
        }  f = FORMATTER.format(t);
        return f;
    }
    public static Calendar stringDateFormat(String d)throws ParseException{
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   Date date = (Date) sdf.parse(d);
   Calendar calDate = Calendar.getInstance();
   calDate.setTime(date);
   return calDate;
    }

}