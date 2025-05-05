package application.booking.service;

import booknowplus.application.booking.command.CancelBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.CancelBookingService;
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
public class CancelBookingServiceTest {

    @Mock
    BookingRepository bookingRepository;

    CancelBookingService cancelBookingService;

    @BeforeEach
    void setUp() {
        cancelBookingService = new CancelBookingService(bookingRepository);
    }

    @Test
    void shouldCancelBooking() {
        //GIVEN
        CancelBookingCommand command = new CancelBookingCommand(
                1L
        );

        Booking booking = Booking.create(command.getId(), 10L, 20L, LocalDateTime.now());

        when(bookingRepository.findById(command.getId())).thenReturn(Optional.of(booking));

        //WHEN
        cancelBookingService.cancelBooking(command);

        //THEN
        assertEquals(BookingStatus.CANCELLED, booking.getStatus());
        verify(bookingRepository).save(booking);

    }

    @Test
    void shouldNotCancelBookingWhenNotFound() {
        //GIVEN
        CancelBookingCommand command = new CancelBookingCommand(
                99L
        );
        when(bookingRepository.findById(command.getId())).thenReturn(Optional.empty());

        //WHEN / THEN
        assertThrows(IllegalArgumentException.class, () ->
                cancelBookingService.cancelBooking(command));

    }

    @Test
    void shouldThrowWhenBookingWhenBookingAlreadyCancelled() {
        //GIVEN
        CancelBookingCommand command = new CancelBookingCommand(
                2L
        );
        Booking booking = Booking.create(command.getId(), 10L, 20L, LocalDateTime.now());
        booking.cancel();
        when(bookingRepository.findById(command.getId())).thenReturn(Optional.of(booking));


        //WHEN / THEN
        assertThrows(IllegalStateException.class, () -> {
            cancelBookingService.cancelBooking(command);
        });

    }

}
