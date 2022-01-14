package com.gridnine.testing;

import java.util.List;

public interface SegmentFilterServices {
    List<Flight> calculateTransferTime();

    List<Flight> searchFlightDepartureBeforeTimeNow();

    List<Flight> searchFlightArrivalBeforeDeparture();

    List<Flight> searchFlightNonStop();
}
