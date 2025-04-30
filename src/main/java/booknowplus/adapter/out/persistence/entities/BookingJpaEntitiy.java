package booknowplus.adapter.out.persistence.entities;

import booknowplus.domain.model.enm.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingJpaEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long serviceId;
    private LocalDateTime bookingDateTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
