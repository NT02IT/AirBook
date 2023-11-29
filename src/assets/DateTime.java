/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import assets.EnumCheck.DateValidStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author agond
 */
public class DateTime{
    private String strDate; //Truyen vao voi dinh dang dd/mm/yyyy moi hoat dong
    private static String pattern = "\\d{1,2}/\\d{1,2}/\\d{4}";
    private static Date dateDate;
    private static SimpleDateFormat ddMMyyyy  = new SimpleDateFormat("dd/MM/yyyy");
    
    public DateTime(){}
    
    public DateTime(String strDate) throws ParseException{
        this.strDate = strDate;
        dateDate = ddMMyyyy.parse(strDate);
    }
    
    public static String convertFormat(String dateString, String originalFormat, String newFormat) throws ParseException{
        SimpleDateFormat originalFormatSDF = new SimpleDateFormat(originalFormat);
        Date dateInput = originalFormatSDF.parse(dateString);
        SimpleDateFormat newFormatSDF = new SimpleDateFormat(newFormat);
        String dateOutput = newFormatSDF.format(dateInput);
        return dateOutput;
    }
    public static String convertFormatDayTime(String dateString, String originalFormat, String newFormat) throws DateTimeParseException {
        DateTimeFormatter originalFormatter = DateTimeFormatter.ofPattern(originalFormat);
        LocalDateTime dateTime = LocalDateTime.parse(dateString, originalFormatter);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern(newFormat);
        String formattedDate = dateTime.format(newFormatter);
        return formattedDate;
    }


    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static Date strtoDate(String strDate) throws ParseException{
        dateDate = ddMMyyyy.parse(strDate);
        return dateDate;
    }
    public Date strtoDate() throws ParseException{
        dateDate = ddMMyyyy.parse(strDate);
        return dateDate;
    }
    
    public static Date now(){
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }

    public static DateValidStatus checkFormat(String strDate){
        if(strDate.equals("")) return DateValidStatus.ISNULL;

        boolean isMatch = Pattern.matches(pattern, strDate);
        if(!isMatch) return DateValidStatus.UNCORRECTFORMAT;
        else{
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH) + 1;
            int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            int inputDay = Integer.parseInt(strDate.split("/")[0]);
            int inputMonth = Integer.parseInt(strDate.split("/")[1]);
            int inputYear = Integer.parseInt(strDate.split("/")[2]);

            if (inputDay > maxDays || inputDay < 1 || inputMonth > 12 || inputMonth < 1 || (inputMonth == 2 && !isLeapYear(inputYear) && inputDay > 28)) {
                return DateValidStatus.INVALID;
            } else {
                return DateValidStatus.VALID;
            }
        }
    }
    public DateValidStatus checkFormat(){
        boolean isMatch = Pattern.matches(pattern, strDate);
        if(strDate.equals("")) return DateValidStatus.ISNULL;
        if(isMatch) return DateValidStatus.VALID;
        else return DateValidStatus.UNCORRECTFORMAT;
    }

    @Override
    public String toString() {
        return dateDate.toString();
    }    
}
