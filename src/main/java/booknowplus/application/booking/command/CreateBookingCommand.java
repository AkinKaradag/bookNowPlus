package booknowplus.application.booking.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateBookingCommand {
    private final Long userId;
    private final Long serviceId;
    private final LocalDateTime bookingTime;
}
