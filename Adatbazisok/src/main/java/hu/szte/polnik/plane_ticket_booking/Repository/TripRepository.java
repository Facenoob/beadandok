package hu.szte.polnik.plane_ticket_booking.Repository;

import hu.szte.polnik.plane_ticket_booking.Model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}
