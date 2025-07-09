package booknowplus.application.booking.port.in;

import booknowplus.domain.model.Booking;

import java.util.List;

public interface GetBookingByServiceIdUseCase {
    List<Booking> findByServiceId(Long serviceId);
}
