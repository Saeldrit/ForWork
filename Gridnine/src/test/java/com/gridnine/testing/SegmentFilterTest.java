package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SegmentFilterTest {

    private final SegmentForTest segmentForTest = new SegmentForTest();
    private final SegmentFilter segmentFilter = new SegmentFilter(
            segmentForTest.generateSegment());

    @Test
    public void testSearchFlightNonStop() {
        List<Flight> flights = segmentFilter.searchFlightNonStop();
        for (int i = 0; i < flights.size() - 1; i++) {
            Assert.assertEquals(1, flights.get(i).getSegments().size());
        }
    }

    @Test
    public void testCalculateTransferTime() {
        List<Flight> flights = segmentFilter.calculateTransferTime();
        int result = 0;

        for (var segment : flights) {
            int segmentSize = segment.getSegments().size();

            for (int i = 0; i < segmentSize - 1; i++) {
                LocalDateTime arrivalDate = segment.getSegments().get(i).getArrivalDate();
                LocalDateTime departureDate = segment.getSegments().get(i + 1).getDepartureDate();
                long msArrivalDate = Timestamp.valueOf(arrivalDate).getTime();
                long msDepartureDate = Timestamp.valueOf(departureDate).getTime();
                long converterToHours = (msDepartureDate - msArrivalDate) / 3600000;
                result += (int) converterToHours;
            }
            Assert.assertTrue(result >= 2);
            Assert.assertTrue(segmentSize > 1);
        }
    }

    @Test
    public void testSearchFlightDepartureBeforeTimeNow() {
        List<Flight> flights = segmentFilter.searchFlightDepartureBeforeTimeNow();
        List<Flight> flightsCheck = new ArrayList<>();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime segmentDate = null;

        for (var segment : flights) {
            for (int i = 0; i < 1; i++) {
                segmentDate = segment.getSegments().get(i).getDepartureDate();
            }
            long msDateNow = Math.abs(Timestamp.valueOf(localDateTime).getTime());
            long msSegmentDate = Math.abs(Timestamp.valueOf(segmentDate).getTime());

            if (msDateNow > msSegmentDate) {
                flightsCheck.add(segment);
            }
            Assert.assertTrue(msDateNow > msSegmentDate);
            Assert.assertNotNull(flightsCheck);
        }
    }

    @Test
    public void testSearchFlightArrivalBeforeDeparture() {
        List<Flight> flights = segmentFilter.searchFlightArrivalBeforeDeparture();
        LocalDateTime departureDateTime;
        LocalDateTime arrivalDateTime;

        for (var segment : flights) {
            int lastSegment = segment.getSegments().size() - 1;

            departureDateTime = segment.getSegments().get(0).getDepartureDate();
            arrivalDateTime = segment.getSegments().get(lastSegment).getArrivalDate();

            long msDepartureDate = Timestamp.valueOf(departureDateTime).getTime();
            long msArrivalDate = Timestamp.valueOf(arrivalDateTime).getTime();
            Assert.assertTrue(msDepartureDate > msArrivalDate);
        }
    }
}
