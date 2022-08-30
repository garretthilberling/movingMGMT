package com.moving_mgmt.repositories;
import com.moving_mgmt.model.User;
import org.springframework.data.jpa.repository.JpaRepository; // so the interface will inherit the methods used to access the database for standard CRUD operations
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value="select * from User u where u.username = ?1", nativeQuery = true)
    User findByUsername(String username) throws Exception; // custom query method

    @Query(value="select * from User u where u.email = ?1", nativeQuery = true)
    User findByEmail(String email) throws Exception;

    @Modifying
    @Query(value="delete from User u where u.username = ?1", nativeQuery = true)
    void deleteByUsername(String username);
}