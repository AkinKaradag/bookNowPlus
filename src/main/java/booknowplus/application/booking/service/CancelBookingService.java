package booknowplus.application.booking.service;

import booknowplus.application.booking.command.CancelBookingCommand;
import booknowplus.application.booking.port.in.CancelBookingUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class CancelBookingService implements CancelBookingUseCase {

    private final BookingRepository bookingRepository;

    public CancelBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    @Override
    public void cancelBooking(CancelBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.cancel();
        bookingRepository.save(booking);
    }

}
