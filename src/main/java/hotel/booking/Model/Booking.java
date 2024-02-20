package hotel.booking.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    //@Generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bookingId;
    @NotBlank(message = "Mail id should not be blank")
    private String userMailid;
    @NotBlank(message = "Hotel name should not be blank")
    private String hotelName;
    @FutureOrPresent
    private Date fromDate;
    @FutureOrPresent
    private Date toDate;
    @NotBlank(message = "Place name should not be blank")
    private String place;
    @NotBlank(message = "Room Type should not be blank")
    private String roomType;

}
