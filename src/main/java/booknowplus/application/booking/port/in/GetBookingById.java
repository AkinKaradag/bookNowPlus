package booknowplus.application.booking.port.in;

import booknowplus.domain.model.Booking;

public interface GetBookingById {
    Booking getBookingById(Long id);
}
