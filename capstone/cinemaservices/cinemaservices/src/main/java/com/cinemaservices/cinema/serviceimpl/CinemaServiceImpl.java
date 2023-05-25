package com.cinemaservices.cinema.serviceimpl;
import com.cinemaservices.cinema.entity.Cart;
import com.cinemaservices.cinema.entity.Cinema;
import com.cinemaservices.cinema.repository.CinemaRepository;
import com.cinemaservices.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    CinemaRepository cinemaRepository;
    RestTemplate restTemplate=new RestTemplate();
    @Override
    public String AddCinemaToCart(Cart cartitem) {
        String url="http://localhost:8083/api/addToCart";
        String Id=cartitem.getProduct_id();
        Optional<Cinema> cinemaItem=cinemaRepository.findById(Id);
        int quantity=cinemaItem.get().getAvailabeSeats();
        if(cartitem.getQuantity()<=cinemaItem.get().getAvailabeSeats())
        {
            String stringResponseEntity=restTemplate.postForObject(url,cartitem,String.class);
            //cartService.addtocart(cartitem);
            cinemaItem.get().setAvailabeSeats(quantity);
            return "Added Cinema to Cart successfully";
        }
        else {
            return "seats Not available";
        }

    }
}
