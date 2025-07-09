package booknowplus.application.booking.port.in;

import booknowplus.domain.model.Booking;

public interface GetBookingByIdUseCase {
    Booking getBookingById(Long id);
}
