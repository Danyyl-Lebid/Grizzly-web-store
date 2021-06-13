package com.github.grizzly.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address")
    private String address;

    public Address(String address) {
        this.address = address;
    }

}