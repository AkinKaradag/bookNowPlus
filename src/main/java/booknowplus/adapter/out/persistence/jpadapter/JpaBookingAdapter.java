package booknowplus.adapter.out.persistence.jpadapter;

import booknowplus.adapter.out.persistence.entities.BookingJpaEntitiy;
import booknowplus.adapter.out.persistence.repository.BookingJpaRepository;
import booknowplus.application.booking.port.out.BookingRepository;
import booknowplus.domain.model.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaBookingAdapter implements BookingRepository {

    private final BookingJpaRepository jpaRepo;

    @Override
    public void save(Booking booking){
        jpaRepo.save(mapToJpaEntity(booking));
    }

    @Override
    public Optional<Booking> findById(Long id){
        return jpaRepo.findById(id)
                .map(this::mapToDomain);
    }


    private BookingJpaEntitiy mapToJpaEntity(Booking booking) {
        return BookingJpaEntitiy.builder()
                .id(booking.getId())
                .userId(booking.getUserId())
                .serviceId(booking.getServiceId())
                .bookingDateTime(booking.getBookingDate())
                .status(booking.getStatus())
                .build();
    }

    private Booking mapToDomain(BookingJpaEntitiy entity) {
        return Booking.create(
                entity.getId(),
                entity.getUserId(),
                entity.getServiceId(),
                entity.getBookingDateTime()
        );
    }

}
