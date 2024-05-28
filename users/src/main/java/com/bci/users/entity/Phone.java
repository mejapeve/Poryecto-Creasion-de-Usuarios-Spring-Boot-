package com.bci.users.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="number")
    private String number;
    @Column(name="citycode")
    private String citycode;
    @Column(name="countrycode")
    private String countrycode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
