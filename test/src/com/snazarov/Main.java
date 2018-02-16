package com.snazarov;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;

public class Main {

    public static void main(String[] args) {

        System.out.println(String.format("excessiveMoney = %d",
                        calcExcessiveMoney(3932, LocalDate.parse("2018-02-28"))));
    }

    private static long calcExcessiveMoney(final long remainderMoney, final LocalDate end) {

        long weekDays = calcWeekDays(LocalDate.now(), end);
        System.out.println(String.format("weekdays = %d", weekDays));

        return remainderMoney - weekDays * 390;
    }

    private static long calcWeekDays(final LocalDate start, final LocalDate end) {

        final DayOfWeek startWeekDay = start.getDayOfWeek().getValue() < 6 ? start.getDayOfWeek() : DayOfWeek.MONDAY;
        final DayOfWeek endWeekDay = end.getDayOfWeek().getValue() < 6 ? end.getDayOfWeek() : DayOfWeek.FRIDAY;

        final long nrOfWeeks = ChronoUnit.DAYS.between(start, end) / 7;
        final long totalWeekDays = nrOfWeeks * 5 + Math.floorMod(endWeekDay.getValue() - startWeekDay.getValue(), 5);

        return totalWeekDays;
    }
}
