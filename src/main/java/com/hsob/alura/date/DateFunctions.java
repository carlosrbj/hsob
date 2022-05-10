package com.hsob.alura.date;

import org.apache.tomcat.jni.Local;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateFunctions {
    public static void main(String[] args) {
        LocalDateTime i = LocalDateTime.now();
        Duration dezSec = Duration.ofSeconds(10);
        LocalDateTime i2 = i.plus(dezSec);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(LocalDateTime.now().getHour());

        LocalDateTime d1 = LocalDateTime.of(2014,12,15,13,0);
        LocalDateTime d2 = LocalDateTime.of(2014,12,25,13,0);

        System.out.println("Dias de Diferença: " + ChronoUnit.DAYS.between(d1, d2));


        LocalDate birthday = LocalDate.of(2021, 4, 29);
        LocalDate today = LocalDate.now();

        Period d = Period.between(birthday, today);
        System.out.println("You are " + d.getYears() + " years, " +
                d.getMonths() + " months, and " +
                d.getDays() + " days old.");

        System.out.println("=================");

        Date k = new Date();
        LocalDate l =  LocalDateTime.ofInstant(k.toInstant(), ZoneId.systemDefault()).toLocalDate();
        System.out.println(l);

        System.out.println("====================\n");



        System.out.println(YearMonth.now().isSupported(
                ChronoUnit.MONTHS));
        System.out.println(YearMonth.now().isSupported(
                ChronoField.DAY_OF_MONTH));
        System.out.println(MonthDay.now().isSupported(
                ChronoField.DAY_OF_MONTH));
        System.out.println(LocalDate.now().isSupported(
                ChronoUnit.DAYS));
        System.out.println(LocalDateTime.now().isSupported(
                ChronoField.HOUR_OF_AMPM));
        System.out.println(LocalDateTime.now().isSupported(
                ChronoField.YEAR));
    }


}
