package com.scoring.scoring.scoring.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "person")
public class Person {

    @Id
    private UUID id = UUID.randomUUID();


    @NotEmpty(message = "Name cannot be null")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Surname cannot be null")
    @Column(name = "surname")
    private String surname;

    @Min(value = 20, message = "Age should not be less than 20")
    @Max(value = 70, message = "Age should not be greater than 70")
    @NotNull(message = "Age cannot be null")
    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Sex cannot be null")
    @Column(name = "sex")
    private String sex;

    @NotEmpty(message = "Marital cannot be null")
    @Column(name = "marital")
    private String marital;

    @Max(value = 10, message = "Dependents Amount should not be more than 10")
    @NotNull(message = "Dependents Amount cannot be null")
    @Column(name = "dependents_amount")
    private Integer dependentsAmount;


    @Pattern(regexp = "^\\+?3?8?(0[\\s\\.-]\\d{2}[\\s\\.-]\\d{3}[\\s\\.-]\\d{2}[\\s\\.-]\\d{2})$",
            message = "Valid phone number +380 xx xxx xx xx, or +380-xx-xxx-xx-xx")
    @NotEmpty(message = "Phone number cannot be null")
    @Column(name = "phone_number")
    private String phoneNumber;


//    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private List<AdditionalContact> additionalContact;


}
