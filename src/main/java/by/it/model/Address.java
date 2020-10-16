package by.it.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@Table (name = "addresses")
public class Address {

    @Column(length = 25)
    private String city;

    @Column(length = 50)
    private String street;

    @Column (name = "hom_number", length = 10)
    private String homNumber;

    @Column (name = "flat_number", length = 10)
    private String flatNumber;

}
