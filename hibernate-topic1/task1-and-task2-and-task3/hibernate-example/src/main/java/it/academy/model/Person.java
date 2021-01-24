package it.academy.model;

import lombok.*;

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
    @GeneratedValue
    private Integer id;

    @NonNull
    private Integer age;

    @NonNull
    private String name;

    @NonNull
    private String surname;
}