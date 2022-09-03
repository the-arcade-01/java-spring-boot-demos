package org.arcade.batchmysql.batch.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDataField {
    private String city;
    private String street_name;
    private String zip_code;
    private String country;
}
