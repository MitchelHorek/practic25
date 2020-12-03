package com.company;
import java.util.Scanner;
public class Main {
    public static class Date {
        int day, month, year;
        int h, min;

        Date(int day, int month, int year, int h, int min) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.h = h;
            this.min = min;
        }
    }

    public static class Calendar {
        int day, month, year;

        Calendar(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Date[] dates = new Date[10];
        Calendar[] calendars = new Calendar[10];
        int d, m, y;
        for (int i = 0; i < 10; ++i) {
            d = scan.nextInt();
            m = scan.nextInt();
            y = scan.nextInt();
            dates[i] = new Date(d, m, y, scan.nextInt(), scan.nextInt());
            calendars[i] = new Calendar(d, m, y);
        }
    }
}

