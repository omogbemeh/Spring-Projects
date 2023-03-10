package dev.praiseo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends Person{

    public User(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
