package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SegmentForTest {

    public List<Flight> generateSegment() {
        LocalDateTime nowTime = LocalDateTime.now();
        List<Flight> flightList = new ArrayList<>();

        Flight flight = FlightBuilder.createFlight(nowTime, nowTime.plusHours(5));
        Flight flight2 = FlightBuilder.createFlight(nowTime, nowTime.minusHours(5));
        Flight flight3 = FlightBuilder.createFlight(nowTime, nowTime.plusHours(2),
                nowTime.plusHours(5), nowTime.plusHours(6));
        Flight flight4 = FlightBuilder.createFlight(nowTime, nowTime.plusHours(2),
                nowTime.plusHours(3), nowTime.plusHours(4),
                nowTime.plusHours(6), nowTime.plusHours(7));
        Flight flight5 = FlightBuilder.createFlight(nowTime, nowTime.plusDays(1));
        Flight flight6 = FlightBuilder.createFlight(nowTime, nowTime.minusDays(1));

        flightList.add(flight);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);

        return flightList;
    }
}
