package booknowplus.application.booking.service;


import booknowplus.application.booking.command.CreateBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;

public class CreateBookingService {

    private final BookingRepository bookingRepository;

    public CreateBookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    public Booking createBooking(CreateBookingCommand command) {

        Booking booking = Booking.create(
        command.getId(),
        command.getUserId(),
        command.getServiceId(),
        command.getBookingTime()
        );

        bookingRepository.save(booking);
        return booking;
    }

}
