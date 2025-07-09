package booknowplus.application.booking.port.in;

import booknowplus.application.booking.command.CreateBookingCommand;
import booknowplus.domain.model.Booking;

public interface CreateBookingUseCase {
    Booking createBooking(CreateBookingCommand command);
}
