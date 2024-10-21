package employeemanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * It is class perform the Date operaters.
 * </p>
 */
public class DateUtil {
	
  /**
   * <p>
   * It is method to convert string.
   * </p>
   * @param date is denotes the String date.
   * @return Date value for given string.
   */
  public static Date convertToDate(String date) {
    SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
    try {
      return dateFormate.parse(date);
    } catch(Exception e) {
      return null;
    }
  }
}