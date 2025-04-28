package domain.model;

import domain.model.enm.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Booking {

    private final Long id;
    private final Long userId;
    private final Long serviceId;
    private LocalDateTime bookingDate;
    private BookingStatus status; //Enum für Status CONFIRMED, CANCELLED

    public void confirm() {
        if(this.status != BookingStatus.PENDING) {
            throw new IllegalStateException("Only pending bookings can be confirmed");
        }
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancel() {
        if(this.status == BookingStatus.CANCELLED) {
            throw new IllegalStateException("Booking is already cancelled");
        }
        this.status = BookingStatus.CANCELLED;
    }

    public void updateBookingDate(LocalDateTime newDate) {
        if(this.status == BookingStatus.CANCELLED) {
            throw new IllegalStateException("Cannot update a cancelled booking");
        }
        this.bookingDate = newDate;
    }

}
