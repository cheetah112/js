package com.example.usermanagementbackend.repository;

import com.example.usermanagementbackend.entity.User;
import com.example.usermanagementbackend.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String Email);
    List<UserDto> findByName(String name);

//    @Query("select new com.example.usermanagementbackend.model.dto.")
 //   List<UserDto> findAllDto();
//    select new com.example.User.Dto.UserDto(u.id, u.name, u.email, u.phone, u.address, u.avatar) from User u"

}
