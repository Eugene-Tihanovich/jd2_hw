package it.academy.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "increment-generator")
    @GenericGenerator(name = "increment-generator", strategy = "increment")
    private Integer id;

    @NonNull
    private Integer age;

    @NonNull
    private String name;

    @NonNull
    private String surname;
}