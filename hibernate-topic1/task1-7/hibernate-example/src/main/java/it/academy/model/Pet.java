package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String petId;

    @Column
    @Access(AccessType.FIELD)
    private String petType;

    @Column
    private String petName;

    @Column
    private Integer petAge;

    @Transient
    @Column
    private String petColorEyes;

    private Address address;
}
