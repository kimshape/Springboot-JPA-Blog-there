package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

//DAO
//자동으로 Bean등록됨
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
