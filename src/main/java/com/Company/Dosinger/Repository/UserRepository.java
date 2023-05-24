package com.Company.Dosinger.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Company.Dosinger.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE email = :email",nativeQuery = true)
    public Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE mobile = :mobile",nativeQuery = true)
    public Optional<User> findByMobile(String mobile);


    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET name = :name WHERE mobile = :mobile",nativeQuery = true)
    void updateName(String mobile, String name);
}
