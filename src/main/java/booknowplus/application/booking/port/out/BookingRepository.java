package booknowplus.application.booking.port.out;

import booknowplus.domain.model.Booking;

import java.util.Optional;

public interface BookingRepository {
    void save(Booking booking);


    Optional<Booking> findById(Long id);
}
