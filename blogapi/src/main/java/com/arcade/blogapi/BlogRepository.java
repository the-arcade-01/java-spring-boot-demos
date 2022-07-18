package com.arcade.blogapi;

import org.springframework.data.jpa.repository.JpaRepository;

interface BlogRepository extends JpaRepository<BlogModel, Long> {

}