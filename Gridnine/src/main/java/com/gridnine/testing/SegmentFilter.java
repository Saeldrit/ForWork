package com.gridnine.testing;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SegmentFilter implements SegmentFilterServices {

    private final List<Flight> flightList;

    public SegmentFilter(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public List<Flight> searchFlightNonStop() {
        List<Flight> flights = new ArrayList<>();

        if (checkSizeSegment()) {
            for (var segment : flightList) {
                int segmentSize = segment.getSegments().size();
                if (segmentSize == 1) {
                    flights.add(segment);
                }
            }
        }
        return flights;
    }

    @Override
    public List<Flight> calculateTransferTime() {
        List<Flight> flights = new ArrayList<>();
        int result = 0;

        if (checkSizeSegment()) {
            for (var segment : flightList) {
                int segmentSize = segment.getSegments().size();

                if (segmentSize > 1) {
                    for (int i = 0; i < segmentSize - 1; i++) {
                        LocalDateTime arrivalDate = segment.getSegments().get(i).getArrivalDate();
                        LocalDateTime departureDate = segment.getSegments().get(i + 1).getDepartureDate();
                        long msArrivalDate = Timestamp.valueOf(arrivalDate).getTime();
                        long msDepartureDate = Timestamp.valueOf(departureDate).getTime();
                        long converterToHours = (msDepartureDate - msArrivalDate) / 3600000;
                        result += (int) converterToHours;
                    }
                    if (result > 2) {
                        flights.add(segment);
                    }
                }
            }
        } else {
            printError();
        }
        return flights;
    }

    @Override
    public List<Flight> searchFlightDepartureBeforeTimeNow() {
        List<Flight> flights = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();

        if (checkSizeSegment()) {
            for (var segment : flightList) {
                LocalDateTime segmentDateTime = segment.getSegments().get(0).getDepartureDate();

                if (compareSegmentTime(localDateTime, segmentDateTime)) {
                    flights.add(segment);
                }
            }
        } else {
            printError();
        }
        return flights;
    }

    @Override
    public List<Flight> searchFlightArrivalBeforeDeparture() {
        List<Flight> flights = new ArrayList<>();

        if (checkSizeSegment()) {
            for (var segment : flightList) {
                int segmentSize = segment.getSegments().size() - 1;
                LocalDateTime departureDate = segment.getSegments().get(0).getDepartureDate();
                LocalDateTime arrivalDate = segment.getSegments().get(segmentSize).getArrivalDate();

                if (compareSegmentTime(departureDate, arrivalDate)) {
                    flights.add(segment);
                }
            }
        } else {
            printError();
        }
        return flights;
    }

    private boolean compareSegmentTime(LocalDateTime departureDate,
                                       LocalDateTime arrivalDate) {
        long msDepartureDate = Timestamp.valueOf(departureDate).getTime();
        long msArrivalDate = Timestamp.valueOf(arrivalDate).getTime();

        return msDepartureDate > msArrivalDate;
    }

    private boolean checkSizeSegment() {
        return flightList.size() > 0;
    }

    private void printError() {
        if (!(checkSizeSegment())) {
            throw new IllegalArgumentException("Ooooppsss...check your Flights");
        }
    }
}
