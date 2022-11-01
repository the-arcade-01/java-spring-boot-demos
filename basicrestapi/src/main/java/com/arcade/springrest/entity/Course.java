package com.arcade.springrest.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    private Long id;
    private String title;
    private String description;

}
