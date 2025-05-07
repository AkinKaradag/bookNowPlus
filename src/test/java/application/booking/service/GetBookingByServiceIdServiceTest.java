package application.booking.service;

import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.GetBookingByServiceIdService;
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
public class GetBookingByServiceIdServiceTest {

    @Mock
    BookingRepository bookingRepository;
    GetBookingByServiceIdService getBookingByServiceIdService;

    @BeforeEach
    void setUp() {
        getBookingByServiceIdService = new GetBookingByServiceIdService(bookingRepository);
    }

    @Test
    void shouldGetBookingByServiceId() {
        //GIVEN
        List<Booking> bookings = List.of(
                Booking.create(1L, 20L, 30L, LocalDateTime.now()),
                Booking.create(2L, 12L, 30L, LocalDateTime.now())
        );

        when(bookingRepository.findByServiceId(30L)).thenReturn(bookings);

        //WHEN
        List<Booking> result = getBookingByServiceIdService.findByServiceId(30L);

        //THEN
        assertEquals(bookings, result);

    }

}
