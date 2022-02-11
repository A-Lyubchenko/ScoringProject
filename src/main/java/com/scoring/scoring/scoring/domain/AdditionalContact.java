package com.scoring.scoring.scoring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "additional_contact")
public class AdditionalContact {

    @Id
    private UUID id = UUID.randomUUID();

    @NotEmpty(message = "Contact cannot be null")
    @Column(name = "contact")
    private String additionalContact;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be null")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname cannot be null")
    private String surname;

    @Column(name = "last_name")
    @NotEmpty(message = "Surname cannot be null")
    private String lastName;

    @Column(name = "phone_number")
    @NotEmpty(message = "Surname cannot be null")
   @Pattern(regexp = "^\\+?3?8?(0[\\s\\.-]\\d{2}[\\s\\.-]\\d{3}[\\s\\.-]\\d{2}[\\s\\.-]\\d{2})$",
            message = "Valid phone number +380 xx xxx xx xx, or +380-xx-xxx-xx-xx")
    private String phoneNumber;


//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
//    private Person person;




}
