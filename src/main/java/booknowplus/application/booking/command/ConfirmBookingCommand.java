package booknowplus.application.booking.command;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConfirmBookingCommand {
    private final Long id;
}
