package com.arcade.springrest.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Course {

    @Id
    private Long id;
    private String title;
    private String description;

}
