package org.example.springboot.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Length;

@Entity
@Table(name = "Users")
@SecondaryTable(name = "User_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))

//@Setter
//@Getter
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Username cannot be empty")
    private String userName;

    @Column(table = "user_details")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits, optionally prefixed with '+'")
    private String phoneNumber;

    @Column(table = "user_details")
    private String  email;


    @Size(min = 8, max = 20 , message = "Password must be within 8-20 characters")
    private String password;

}
