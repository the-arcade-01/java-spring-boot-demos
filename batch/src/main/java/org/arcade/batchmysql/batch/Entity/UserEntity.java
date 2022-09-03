package org.arcade.batchmysql.batch.Entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    private String phone_number;
    private String social_insurance_number;
    private Date date_of_birth;
    private String employment;
    private String address;
}
