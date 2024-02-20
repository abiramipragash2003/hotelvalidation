package hotel.booking.Repository;

import hotel.booking.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<Booking,Integer>
{

}
