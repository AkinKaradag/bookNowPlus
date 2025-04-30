package booknowplus.adapter.out.persistence.repository;

import booknowplus.adapter.out.persistence.entities.BookingJpaEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingJpaRepository extends JpaRepository<BookingJpaEntitiy, Long> {

}
