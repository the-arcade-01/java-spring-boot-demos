package com.arcade.cat.Repository;

import com.arcade.cat.Entity.CatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<CatModel, Long> {
}
