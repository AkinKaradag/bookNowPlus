package booknowplus.application.booking.port.in;

import booknowplus.domain.model.Booking;

import java.util.List;

public interface GetBookingByUserIdQuery {
    List<Booking> findByUserId(Long userId);
}
