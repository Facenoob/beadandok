package hu.szte.polnik.plane_ticket_booking.Repository;

import hu.szte.polnik.plane_ticket_booking.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
