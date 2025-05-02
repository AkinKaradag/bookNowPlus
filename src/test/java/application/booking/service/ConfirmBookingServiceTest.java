package application.booking.service;

import booknowplus.application.booking.command.ConfirmBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.ConfirmBookingService;
import booknowplus.domain.model.Booking;
import booknowplus.domain.model.enm.BookingStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConfirmBookingServiceTest {

    @Mock
    BookingRepository bookingRepository;

    ConfirmBookingService confirmBookingService;

    @BeforeEach
    void setUp() {
        confirmBookingService = new ConfirmBookingService(bookingRepository);
    }

    @Test
    void shouldConfirmBooking() {
        //GIVEN
        ConfirmBookingCommand command = new ConfirmBookingCommand(
                1L
        );
        Booking booking = Booking.create(command.getId(), 10L, 20L, LocalDateTime.now());

        when(bookingRepository.findById(command.getId())).thenReturn(Optional.of(booking));

        //WHEN
        confirmBookingService.confirmBooking(command);

        //THEN
        assertEquals(BookingStatus.CONFIRMED, booking.getStatus());
        verify(bookingRepository).save(booking);
    }

    @Test
    void shouldNotConfirmBookingWhenNotFound() {
        ConfirmBookingCommand command = new ConfirmBookingCommand(
                99L
        );
        when(bookingRepository.findById(command.getId())).thenReturn(Optional.empty());

        //WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> {
            confirmBookingService.confirmBooking(command);
        });
    }

}
