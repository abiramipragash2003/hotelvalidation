package hotel.booking.Exception;

import hotel.booking.Model.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler {

        @ExceptionHandler(HotelBookingIdNotFoundException.class)
        public ApiError add(HotelBookingIdNotFoundException e, HttpServletRequest request)
        {
            List<String> stringList=new ArrayList<>();
            stringList.add(e.getMessage());
            ApiError apiError=ApiError.builder().Path(request.getRequestURI())
                    .message(stringList.toString())
                    .date(new Date())
                    .build();
            return apiError;  //json response
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError show(HttpServletRequest request, BindingResult bindingResult)
    {
        List<FieldError> field=bindingResult.getFieldErrors();
        //field.stream().map(e->new StringBuilder(e.getField())).collect(Collectors.joining());
        StringBuilder sb=new StringBuilder();
        for(FieldError f:field)
        {
            sb.append(f.getField()+":"+f.getDefaultMessage());
        }
        ApiError apiError= ApiError.builder().Path(request.getRequestURI()).message(sb.toString()).date(new Date()).build();
        return apiError;
    }


}
