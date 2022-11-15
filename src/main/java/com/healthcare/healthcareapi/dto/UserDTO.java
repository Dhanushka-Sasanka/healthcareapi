package com.healthcare.healthcareapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userID;
    private String userName;
    private String userEmail;
    private UserType userType;
    private String password;

}
