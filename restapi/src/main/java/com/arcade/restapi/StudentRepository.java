package com.arcade.restapi;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<StudentModel, Long> {

}
