package org.example.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
@SecondaryTable(name = "User_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))

@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true, nullable = false)
    @NotNull(message = "Username cannot be empty")
    @Size(min = 8, max = 20, message = "Password must be within 8-20 characters")
    private String userName;

    @Column(table = "user_details")
   // @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits, optionally prefixed with '+'")
  //  @NotNull(message = "Phone number cannot be empty")
    private String phoneNumber;

  //  @Column(table = "user_details")
  //  @NotNull(message = "Email cannot be empty")
    private String  email;


   // @Size(min = 8, max = 20 , message = "Password must be within 8-20 characters")
  //  @NotNull(message = "Password cannot be empty")
    private String password;

}
