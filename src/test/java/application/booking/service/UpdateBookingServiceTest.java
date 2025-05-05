package application.booking.service;

import booknowplus.application.booking.command.UpdateBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.UpdateBookingService;
import booknowplus.domain.model.Booking;
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
public class UpdateBookingServiceTest {

    @Mock
    BookingRepository bookingRepository;

    UpdateBookingService updateBookingService;

    @BeforeEach
    void setUp() {
        updateBookingService = new UpdateBookingService(bookingRepository);
    }

    @Test
    void shouldUpdateBooking() {
        //GIVEN
        UpdateBookingCommand command = new UpdateBookingCommand(
                1L,
                LocalDateTime.of(2025, 7, 3, 16, 30)
        );
        Booking booking = Booking.create(command.getId(), 10L, 20L, LocalDateTime.of(2025, 6, 2, 15, 30));

        when(bookingRepository.findById(command.getId())).thenReturn(Optional.of(booking));


        // WHEN
        updateBookingService.updateBooking(command);

        // THEN
        assertEquals(command.getBookingTime(), booking.getBookingDate());
        verify(bookingRepository).save(booking);

    }

    @Test
    void shouldNotUpdateBookingWhenBookingNotFound() {
        //GIVEN
        UpdateBookingCommand command = new UpdateBookingCommand(
                99L,
                LocalDateTime.of(2025, 3, 6, 11, 30)
        );
        when(bookingRepository.findById(command.getId())).thenReturn(Optional.empty());

        //WHEN / THEN
        assertThrows(IllegalArgumentException.class, () -> updateBookingService.updateBooking(command));
    }

    @Test
    void shouldNotUpdateBookingWhenCancelled() {
        //GIVEN
        UpdateBookingCommand command = new UpdateBookingCommand(
                2L, LocalDateTime.of(2025, 3, 6, 11, 30)
        );
        Booking booking = Booking.create(command.getId(), 10L, 20L, command.getBookingTime());
        booking.cancel();
        when(bookingRepository.findById(command.getId())).thenReturn(Optional.of(booking));

        //WHEN / THEN
        assertThrows(IllegalStateException.class, () -> updateBookingService.updateBooking(command));
    }

}
