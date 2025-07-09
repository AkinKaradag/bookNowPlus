package booknowplus.application.booking.port.in;


import booknowplus.application.booking.command.UpdateBookingCommand;
import booknowplus.domain.model.Booking;

public interface UpdateBookingUseCase {
    Booking updateBooking(UpdateBookingCommand command);
}
