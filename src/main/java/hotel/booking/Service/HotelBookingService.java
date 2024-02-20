package hotel.booking.Service;

import hotel.booking.Model.Booking;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface HotelBookingService {

    public Booking createBooking(@RequestBody Booking booking);
    public List<Booking> getAllBooking();
    Booking getBookingById(int bookingId);

    public String DeleteBookingById(int bookingId);

}
