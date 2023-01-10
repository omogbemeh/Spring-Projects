package icu.praise.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends Person{
    private String address;
    private String city;
    private int telephone;
}
