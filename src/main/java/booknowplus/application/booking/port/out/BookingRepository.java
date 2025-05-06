package booknowplus.application.booking.port.out;

import booknowplus.domain.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    void save(Booking booking);

    List<Booking> findByUserId(Long userId);

    List<Booking> findByServiceId(Long serviceId);

    Optional<Booking> findById(Long id);
}
