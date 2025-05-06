package application.booking.service;

import booknowplus.application.booking.port.in.GetBookingById;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.GetBookingByIdService;
import booknowplus.domain.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetBookingByIdServiceTest {

    @Mock
    BookingRepository bookingRepository;
    GetBookingById getBookingById;

    @BeforeEach
    void setUp() {
        getBookingById = new GetBookingByIdService(bookingRepository);
    }

    @Test
    void shouldFindBookingById() {
        //GIVEN
        Booking booking = Booking.create(1L, 20L, 30L, LocalDateTime.of(2025, 5, 1, 12, 0));

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        //WHEN
        Booking result = getBookingById.getBookingById(1L);

        //THEN
        assertEquals(booking, result);
        verify(bookingRepository).findById(1L);
    }

    @Test
    void shouldNotFindBookingById() {
        //GIVEN
        when(bookingRepository.findById(99L)).thenReturn(Optional.empty());

        //WHEN / THEN
        assertThrows(NoSuchElementException.class , () -> getBookingById.getBookingById(99L));
    }

}
