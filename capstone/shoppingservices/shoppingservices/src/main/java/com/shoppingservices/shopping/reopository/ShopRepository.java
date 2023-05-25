package com.shoppingservices.shopping.reopository;

import com.shoppingservices.shopping.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shopping,String> {
}
