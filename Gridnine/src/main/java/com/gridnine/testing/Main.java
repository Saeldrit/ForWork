package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Вам нужно написать небольшой модуль, который будет заниматься
 * фильтрацией набора перелётов согласно различным правилам.
 * 1.	вылет до текущего момента времени
 * 2.	имеются сегменты с датой прилёта раньше даты вылета
 * 3.	общее время, проведённое на земле превышает два часа
 * (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
 *
 * @Author Alexey Pavlovskiy
 * @Version 1.0
 */
public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        List<Flight> flightList = new ArrayList<>(FlightBuilder.createFlights());
        SegmentFilter segmentFilter = new SegmentFilter(flightList);

        System.out.println(ANSI_YELLOW + "We have all Flights" + ANSI_RESET);
        flightList.forEach(System.out::println);

        System.out.println(ANSI_YELLOW + "\nPrinting flights up to the current" +
                "point in time" + ANSI_RESET);
        segmentFilter.searchFlightDepartureBeforeTimeNow().forEach(System.out::println);

        System.out.println(ANSI_YELLOW + "\nPrinting flights with an arrival date" +
                "earlier than the departure date" + ANSI_RESET);
        segmentFilter.searchFlightArrivalBeforeDeparture().forEach(System.out::println);

        System.out.println(ANSI_YELLOW + "\nPrinting flights with transfers " +
                "longer than two hours" + ANSI_RESET);
        segmentFilter.calculateTransferTime().forEach(System.out::println);

        System.out.println(ANSI_YELLOW + "\nPrinting flights for Non-Stop" + ANSI_RESET);
        segmentFilter.searchFlightNonStop().forEach(System.out::println);
    }
}
