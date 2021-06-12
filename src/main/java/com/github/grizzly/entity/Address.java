package com.github.grizzly.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Table(name = "ADDRESS")
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")

    private long id;

    private String fullAddress;

    public Address(long id, String fullAddress) {
        this.id = id;
        this.fullAddress = fullAddress;
    }
}