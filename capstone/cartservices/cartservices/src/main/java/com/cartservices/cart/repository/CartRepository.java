package com.cartservices.cart.repository;

import com.cartservices.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    public List<Cart> findByUserId(int userId);
//    @Query(value = "DELETE FROM cart c WHERE c.product_id=?")
//    public Cart findByProductId(String ProductId);
}
