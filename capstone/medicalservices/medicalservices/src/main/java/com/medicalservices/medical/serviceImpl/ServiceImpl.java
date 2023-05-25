package com.medicalservices.medical.serviceImpl;
import com.medicalservices.medical.entity.Cart;
import com.medicalservices.medical.entity.Medicine;
import com.medicalservices.medical.repository.MedicalRepository;
import com.medicalservices.medical.sevice.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.medicalservices.medical.repository.MedicalRepository.*;

@Service
public class ServiceImpl implements MedicalService {
    @Autowired
    MedicalRepository medicalRepository;
    RestTemplate restTemplate=new RestTemplate();
    @Override
    public String addmedicinetocart(Cart cartitem) {
        String url="http://localhost:8083/api/addToCart";
        String id = cartitem.getProduct_id();
        Optional<Medicine> medicineitem=medicalRepository.findById(id);
        int quantity=medicineitem.get().getNoOfTablets();
        if(cartitem.getQuantity()<=medicineitem.get().getNoOfTablets()){
            String stringResponseEntity=restTemplate.postForObject(url,cartitem,String.class);
//            cartService.addtocart(cartitem);
                medicineitem.get().setNoOfTablets(quantity);
                return "added to cart successfully";
        }

        else {
            return "item exceeds limit";
        }
    }
}
