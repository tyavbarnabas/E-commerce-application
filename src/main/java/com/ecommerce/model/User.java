package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    @Column(nullable = false,unique = true, length = 45)
   private String email;
    @Column(nullable = false,length= 64)
    private String password;

    @Column(nullable = false,length = 45)
   private String firstName;

    @Column(nullable = false,length = 45)
   private String lastName;
}
