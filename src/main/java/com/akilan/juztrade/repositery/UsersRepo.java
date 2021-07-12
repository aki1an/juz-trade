package com.akilan.juztrade.repositery;

import com.akilan.juztrade.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,String> {

    @Query(value = "select password from users where user_id = :userId",nativeQuery = true)
    public String fetchPasswordByUserId(@Param("userId")String userId);

}
