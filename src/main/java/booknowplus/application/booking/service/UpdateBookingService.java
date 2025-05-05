package booknowplus.application.booking.service;

import booknowplus.application.booking.command.UpdateBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;


public class UpdateBookingService {
    private final BookingRepository bookingRepository;
    
    public UpdateBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}
    
    
    public void updateBooking(UpdateBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        booking.updateBookingDate(command.getBookingTime());
        bookingRepository.save(booking);
    }
}
