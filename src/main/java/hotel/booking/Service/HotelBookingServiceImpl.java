package hotel.booking.Service;

import hotel.booking.Exception.HotelBookingIdNotFoundException;
import hotel.booking.Model.Booking;
import hotel.booking.Repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService
{
    @Autowired
    HotelBookingRepository hotelBookingRepository;
    @Override
    public Booking createBooking(@RequestBody Booking booking) {
        return hotelBookingRepository.save(booking);

    }

    @Override
    public List<Booking> getAllBooking() {
        return hotelBookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int bookingId) {

        Optional<Booking> optional = hotelBookingRepository.findById(bookingId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        else
        {
            throw new HotelBookingIdNotFoundException("Booking Id not exists");
        }


    }

    @Override
    public String DeleteBookingById(int bookingId) {
        String status=null;
        Optional<Booking> optional=hotelBookingRepository.findById(bookingId);
        if(optional.isPresent())
        {
            hotelBookingRepository.deleteById(bookingId);
            status="booking deleted";
        }
        else {
            status="booking not deleted,Please check your Booking Id";
        }
        return status;
    }
}
