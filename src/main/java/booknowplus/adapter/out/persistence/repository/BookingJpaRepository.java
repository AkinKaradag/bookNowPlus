package booknowplus.adapter.out.persistence.repository;

import booknowplus.adapter.out.persistence.entities.BookingJpaEntitiy;
import booknowplus.domain.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingJpaRepository extends JpaRepository<BookingJpaEntitiy, Long> {

    List<BookingJpaEntitiy> findByUserId(Long userId);
    List<BookingJpaEntitiy> findByServiceId(Long serviceId);

}
