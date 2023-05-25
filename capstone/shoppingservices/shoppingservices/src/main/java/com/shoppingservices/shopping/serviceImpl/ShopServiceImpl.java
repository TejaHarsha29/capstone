package com.shoppingservices.shopping.serviceImpl;
import com.shoppingservices.shopping.entity.Shopping;
import com.shoppingservices.shopping.reopository.ShopRepository;
import com.shoppingservices.shopping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingservices.shopping.entity.Cart;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepository shopRepository;
    RestTemplate restTemplate=new RestTemplate();

    @Override
    public String AddShopToCart(Cart cartitem) {
        String url="http://localhost:8083/api/addToCart";
        String Id=cartitem.getProduct_id();
        Optional<Shopping> shopitem=shopRepository.findById(Id);
        int quantity=shopitem.get().getAvailability();
        if(cartitem.getQuantity()<=shopitem.get().getAvailability())
        {
            String stringResponseEntity=restTemplate.postForObject(url,cartitem,String.class);
            //cartService.addtocart(cartitem);
            shopitem.get().setAvailability(quantity);
            return "Added Cinema to Cart successfully";
        }
        else {
            return "seats Not available";
        }

    }

}
