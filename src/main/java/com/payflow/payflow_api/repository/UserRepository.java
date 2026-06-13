package com.payflow.payflow_api.repository;

import com.payflow.payflow_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUpiId(String upiId);
}
