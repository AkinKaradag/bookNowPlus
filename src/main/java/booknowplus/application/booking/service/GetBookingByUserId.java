package booknowplus.application.booking.service;


import booknowplus.application.booking.port.in.GetBookingByUserIdQuery;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.List;

public class GetBookingByUserId implements GetBookingByUserIdQuery {
    private final BookingRepository bookingRepository;

    public GetBookingByUserId(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public List<Booking> findByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
