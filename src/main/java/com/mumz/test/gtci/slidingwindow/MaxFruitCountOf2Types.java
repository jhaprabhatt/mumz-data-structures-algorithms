package com.mumz.test.gtci.slidingwindow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {

        return 1;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("yyyy/dd/MM");
        LocalDate localDate = LocalDate.parse("2022/06/04", formatter_1);
        long firstSecond = localDate.toEpochDay();

        localDate = LocalDate.parse("2022/08/02", formatter_1);
        long secondSecond = localDate.toEpochDay();

        System.out.println(firstSecond > secondSecond);
    }
}
