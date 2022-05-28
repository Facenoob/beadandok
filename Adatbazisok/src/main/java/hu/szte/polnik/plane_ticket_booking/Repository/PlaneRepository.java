package hu.szte.polnik.plane_ticket_booking.Repository;

import hu.szte.polnik.plane_ticket_booking.Model.Plane;
import org.springframework.data.repository.CrudRepository;

public interface PlaneRepository extends CrudRepository<Plane, Integer> {
}
