package com.realestate.dto.request;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO  {


    @Size(max = 15)
    @NotNull(message = "Please enter your first name")
    
    private String firstName;

    @Size(max = 15)
    @NotNull(message = "Please enter your last name")
    
    private String lastName;

    @Size(min = 4, max = 60, message = "Please enter min 4 characters")
    @NotNull(message = "Please enter your password")
    
    private String password;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size(min = 14, max = 14, message = "Phone number should be exact 10 characters")
    @NotNull(message = "Please enter your phone number")
    
    private String phoneNumber;

    @Email(message = "Please enter valid email")
    @Size(min = 5, max = 150)
    @NotNull(message = "Please enter your email")
    
    private String email;

    @Size(max = 250)
    @NotNull(message = "Please enter your address")
    
    private String address;

    @Size(max = 15)
    @NotNull(message = "Please enter your zip code")
  
    private String zipCode;


    private RoleRequestDTO role;

   
    private Boolean builtIn;

    
    private Set<TourRequestRequestDTO> tourRequests;

    
    private Set<ReviewRequestDTO> reviews;

}