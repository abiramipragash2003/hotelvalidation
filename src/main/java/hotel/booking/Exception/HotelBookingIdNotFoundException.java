package hotel.booking.Exception;

public class HotelBookingIdNotFoundException extends RuntimeException
{
    String msg;
    public HotelBookingIdNotFoundException(String msg){
        super(msg);
        this.msg=msg;
    }
}
