package booknowplus.application.booking.port.in;

import booknowplus.application.booking.command.CancelBookingCommand;
import booknowplus.domain.model.Booking;

public interface CancelBookingUseCase {
    void cancelBooking(CancelBookingCommand command);
}
