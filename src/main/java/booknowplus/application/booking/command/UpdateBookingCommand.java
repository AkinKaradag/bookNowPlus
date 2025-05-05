package booknowplus.application.booking.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UpdateBookingCommand {
    public final Long id;
    public final LocalDateTime bookingTime;
}
