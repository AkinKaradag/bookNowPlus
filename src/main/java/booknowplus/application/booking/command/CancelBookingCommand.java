package booknowplus.application.booking.command;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CancelBookingCommand {
    private final Long id;
}
