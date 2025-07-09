package booknowplus.application.booking.service;

import booknowplus.application.booking.port.in.GetBookingByServiceIdUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.List;

public class GetBookingByServiceIdService implements GetBookingByServiceIdUseCase {
    private final BookingRepository bookingRepository;

    public GetBookingByServiceIdService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public List<Booking> findByServiceId(Long serviceId) {
        return bookingRepository.findByServiceId(serviceId);
    }

}
