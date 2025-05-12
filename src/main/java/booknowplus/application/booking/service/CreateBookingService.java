package booknowplus.application.booking.service;


import booknowplus.application.booking.command.CreateBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.common.IdGenerator;
import booknowplus.domain.model.Booking;

public class CreateBookingService {

    private final BookingRepository bookingRepository;
    private final IdGenerator bookinIdGenerator;

    public CreateBookingService(BookingRepository bookingRepository, IdGenerator bookinIdGenerator) {
        this.bookingRepository = bookingRepository;
        this.bookinIdGenerator = bookinIdGenerator;
    }


    public Booking createBooking(CreateBookingCommand command) {
        Long id = bookinIdGenerator.generateId();
        Booking booking = Booking.create(
        id,
        command.getUserId(),
        command.getServiceId(),
        command.getBookingTime()
        );

        bookingRepository.save(booking);
        return booking;
    }

}
