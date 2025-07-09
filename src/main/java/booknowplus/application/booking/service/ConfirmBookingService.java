package booknowplus.application.booking.service;

import booknowplus.application.booking.command.ConfirmBookingCommand;
import booknowplus.application.booking.port.in.ConfirmBookingUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class ConfirmBookingService implements ConfirmBookingUseCase {

    private final BookingRepository bookingRepository;

    public ConfirmBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public Booking confirmBooking(ConfirmBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.confirm();
        bookingRepository.save(booking);
        return booking;
    }
}
