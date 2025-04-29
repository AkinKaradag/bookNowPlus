package application.booking.service;


import application.booking.command.CreateBookingCommand;
import domain.model.Booking;

public class CreateBookingService {
    public Booking createBooking(CreateBookingCommand command) {

        return Booking.create(
        command.getId(),
        command.getUserId(),
        command.getServiceId(),
        command.getBookingTime()
        );
    }

}
