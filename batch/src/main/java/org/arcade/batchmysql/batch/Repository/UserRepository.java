package org.arcade.batchmysql.batch.Repository;

import org.arcade.batchmysql.batch.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
