package booknowplus.application.booking.port.in;

import booknowplus.application.booking.command.ConfirmBookingCommand;
import booknowplus.domain.model.Booking;

public interface ConfirmBookingUseCase {
    Booking confirmBooking(ConfirmBookingCommand command);
}
