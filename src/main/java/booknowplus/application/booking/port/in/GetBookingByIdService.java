package booknowplus.application.booking.port.in;

import booknowplus.domain.model.Booking;

public interface GetBookingByIdService {
    Booking getBookingById(Long id);
}
