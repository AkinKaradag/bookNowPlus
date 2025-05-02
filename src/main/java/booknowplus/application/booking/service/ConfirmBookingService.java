package booknowplus.application.booking.service;

import booknowplus.application.booking.command.ConfirmBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

public class ConfirmBookingService {

    private final BookingRepository bookingRepository;

    public ConfirmBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}


    public void confirmBooking(ConfirmBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        booking.confirm();
        bookingRepository.save(booking);
    }
}
