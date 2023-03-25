package com.example.usermanagementbackend.repository;

import com.example.usermanagementbackend.database.UserDatabase;
import com.example.usermanagementbackend.entity.User;
import com.example.usermanagementbackend.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<> {
//     public Optional<User> findByEmail(String email) {
//        return UserDatabase.users
//                .stream()
//                .filter(user -> user.getEmail().equals(email))
//                .findFirst();
//    }

    List<UserDto> findByName();

     @Query("select new com.example.usermanagementbackend.model.dto.UserDto(u.id) from User u")
    List<UserDto> findAllDto();
}
