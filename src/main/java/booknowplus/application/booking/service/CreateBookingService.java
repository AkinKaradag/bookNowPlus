package booknowplus.application.booking.service;


import booknowplus.application.booking.command.CreateBookingCommand;
import booknowplus.application.booking.port.in.CreateBookingUseCase;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class CreateBookingService implements CreateBookingUseCase {

    private final BookingRepository bookingRepository;


    public CreateBookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
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
