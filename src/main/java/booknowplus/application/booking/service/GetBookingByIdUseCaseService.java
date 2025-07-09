package booknowplus.application.booking.service;

import booknowplus.application.booking.port.in.GetBookingByIdUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

import java.util.NoSuchElementException;

public class GetBookingByIdUseCaseService implements GetBookingByIdUseCase {

    private final BookingRepository bookingRepository;

    public GetBookingByIdUseCaseService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Booking not found"));
    }

}
