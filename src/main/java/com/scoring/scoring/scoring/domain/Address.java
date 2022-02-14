package com.scoring.scoring.scoring.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {


    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "region")
    private String region;
    @Column(name = "type_of_locality")
    private String typeOfLocality;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "number_of_house")
    private String numberOfHouse;
    @Column(name = "number_of_flat")
    private Integer numberOfFlat;
    @Column(name = "live_from")
    private LocalDate liveFrom;
}
