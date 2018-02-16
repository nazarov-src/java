package com.snazarov;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;

public class Main {

    public static void main(String[] args) {

        long weekDays = calcWeekDays(LocalDate.now(), LocalDate.parse("2018-02-28"));
        System.out.println(String.format("weekdays = %d", weekDays));

        long remainderMoney = 3932;
        long excessiveMoney  = remainderMoney - weekDays * 390;

        System.out.println(String.format("excessiveMoney = %d", excessiveMoney));
    }

    private static long calcWeekDays(final LocalDate start, final LocalDate end) {

        final DayOfWeek startWeekDay = start.getDayOfWeek().getValue() < 6 ? start.getDayOfWeek() : DayOfWeek.MONDAY;
        final DayOfWeek endWeekDay = end.getDayOfWeek().getValue() < 6 ? end.getDayOfWeek() : DayOfWeek.FRIDAY;

        final long nrOfWeeks = ChronoUnit.DAYS.between(start, end) / 7;
        final long totalWeekDays = nrOfWeeks * 5 + Math.floorMod(endWeekDay.getValue() - startWeekDay.getValue(), 5);

        return totalWeekDays;
    }
}
