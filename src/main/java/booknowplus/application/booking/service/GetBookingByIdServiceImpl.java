package booknowplus.application.booking.service;

import booknowplus.application.booking.port.in.GetBookingByIdService;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.NoSuchElementException;

public class GetBookingByIdServiceImpl implements GetBookingByIdService {

    private final BookingRepository bookingRepository;

    public GetBookingByIdServiceImpl(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found"));
    }

}
