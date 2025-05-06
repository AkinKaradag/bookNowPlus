package application.booking.service;

import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.GetBookingByUserId;
import booknowplus.domain.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetBookingByUserIdServiceTest {
    @Mock
    BookingRepository bookingRepository;
    GetBookingByUserId getBookingByUserId;

    @BeforeEach
    void setUp() {
        getBookingByUserId = new GetBookingByUserId(bookingRepository);
    }

    @Test
    //GIVEN
    void shouldGetBookingByUserId() {
        List<Booking> bookings = List.of(
                Booking.create(1L, 20L, 30L, LocalDateTime.now()),
                Booking.create(1L, 20L, 30L, LocalDateTime.now())
        );

        when(bookingRepository.findByUserId(20L)).thenReturn(bookings);

        //WHEN
        List<Booking> result = getBookingByUserId.findByUserId(20L);

        //THEN
        assertEquals(bookings, result);
    }

}
