package booknowplus.application.booking.service;

import booknowplus.application.booking.command.CancelBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

public class CancelBookingService {

    private final BookingRepository bookingRepository;

    public CancelBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}

    public void cancelBooking(CancelBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.cancel();
        bookingRepository.save(booking);
    }

}
