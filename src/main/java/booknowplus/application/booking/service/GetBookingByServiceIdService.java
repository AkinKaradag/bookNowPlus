package booknowplus.application.booking.service;

import booknowplus.application.booking.port.in.GetBookingByServiceIdQuery;
import booknowplus.application.booking.port.in.GetBookingByUserIdQuery;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.List;

public class GetBookingByServiceIdService implements GetBookingByServiceIdQuery {
    private final BookingRepository bookingRepository;

    public GetBookingByServiceIdService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public List<Booking> findByServiceId(Long serviceId) {
        return bookingRepository.findByServiceId(serviceId);
    }

}
