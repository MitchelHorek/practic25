package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Class3 {
    public static class Date1 {
        int day, month, year;
        int h, min;

        Date1(int day, int month, int year, int h, int min) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.h = h;
            this.min = min;
        }
        public String toString() {
            String day1, month1, h1, min1;
            if (day>0 && day<10)
                day1 = "0"+day;
            else
                day1= ""+day;
            if (month>0 && month<10)
                month1 = "0"+ month;
            else
                month1 = ""+month;
            if (h>0 && h<10)
                h1 = "0"+h;
            else
                h1= ""+h;
            if (min>=0 && min<10)
                min1 = "0"+min;
            else
                min1= ""+min;
            return day1 + "." + month1 + ".0" + year + " "+h1+":"+min1;

        }
    }


    public static void main(String[] args) {
        Date1 date1 = new Date1(27, 11, 20, 9, 0);
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy HH:mm");
        System.out.print("Аралкина Евгения Максимовна\nдата и время выдачи задания: "+date1.toString()+
                "\nдата и время сдачи задания: " +formatForDateNow.format(date));
    }
}
