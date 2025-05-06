package booknowplus.application.booking.service;

import booknowplus.application.booking.port.in.GetBookingById;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.NoSuchElementException;

public class GetBookingByIdService implements GetBookingById {

    private final BookingRepository bookingRepository;

    public GetBookingByIdService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found"));
    }

}
