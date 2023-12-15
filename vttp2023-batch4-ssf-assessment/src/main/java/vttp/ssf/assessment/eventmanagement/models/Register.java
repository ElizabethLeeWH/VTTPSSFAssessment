package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Register {
    @NotEmpty(message = "Full Name is a mandatory field")
    @Size(min = 5, max = 25, message = "Full Name must be between 5 to 25 characters")
    private String fullName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Birth date must be a past date less than today")
    private Date birthDay;

    @Email(message = "Invalid Email Format")
    @Size(max = 50, message = "Email length exceeded 50 characters")
    @NotBlank(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String phoneNo;

    @Min(value = 1, message = "Minimum tickets starts from 1")
    @Max(value = 3, message = "Maximum tickets cannot exceed 3")
    private Integer tickets;
 
}
