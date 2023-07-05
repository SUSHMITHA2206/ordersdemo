package com.java.ordersdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.ordersdemo.model.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long> {

}