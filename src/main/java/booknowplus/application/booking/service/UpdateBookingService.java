package booknowplus.application.booking.service;

import booknowplus.application.booking.command.UpdateBookingCommand;
import booknowplus.application.booking.port.in.CancelBookingUseCase;
import booknowplus.application.booking.port.in.UpdateBookingUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookingService implements UpdateBookingUseCase {
    private final BookingRepository bookingRepository;
    
    public UpdateBookingService(BookingRepository bookingRepository) {this.bookingRepository = bookingRepository;}
    
    @Override
    public Booking updateBooking(UpdateBookingCommand command) {
        Booking booking = bookingRepository.findById(command.getId())
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        booking.updateBookingDate(command.getBookingTime());
        bookingRepository.save(booking);
        return booking;
    }
}
