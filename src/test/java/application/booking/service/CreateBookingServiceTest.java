package application.booking.service;

import booknowplus.application.booking.command.CreateBookingCommand;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.application.booking.service.CreateBookingService;
import booknowplus.domain.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateBookingServiceTest {
    private BookingRepository bookingRepository;
    private CreateBookingService createBookingService;

    @BeforeEach
    void setUp() {
        bookingRepository = mock(BookingRepository.class);
        createBookingService = new CreateBookingService(bookingRepository);
    }

    @Test
    void shouldCreateBookingAndSaveToRepository() {
        //GIVEN: Ich habe einen Command mit Buchungsdaten
        CreateBookingCommand command = new CreateBookingCommand(
                1L, //bookingId
                10L, //userId
                20L, //serviceId
                LocalDateTime.of(2025, 5, 1, 10, 0)
        );

        //WHEN: Ich führe den Service aus
        Booking result = createBookingService.createBooking(command);

        //THEN: Ich überprüfe, ob das Repository aufgerufen wurde
        ArgumentCaptor<Booking> bookingCaptor = ArgumentCaptor.forClass(Booking.class);
        verify(bookingRepository).save(bookingCaptor.capture()); // wurde save(...) aufgerufen?

        Booking savedBooking = bookingCaptor.getValue(); // ich hole mir das Booking, das gespeichert wurde

        // Hier kann ich die Inhalte prüfen
        assertEquals(10L, savedBooking.getUserId());
        assertEquals(20L, savedBooking.getServiceId());
        assertEquals(LocalDateTime.of(2025, 5, 1, 10, 0), savedBooking.getBookingDate());

        //Prüfe, ob es dasselbe Objekt war
        assertEquals(result, savedBooking);

    }


}
