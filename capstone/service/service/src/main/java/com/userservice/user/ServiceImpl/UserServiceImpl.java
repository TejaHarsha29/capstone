package com.userservice.user.ServiceImpl;
import com.userservice.user.Service.UserService;
import com.userservice.user.entity.User;
import com.userservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User added Successfully";
    }
    @Override
    public float findbalance(int user_id){
        return userRepository.findById(user_id).get().getBalance();
    }
//    @Override
//    public String BuyNow(int user_id) {
//        float billamount= cartService.BillAmount(user_id);
//        if(billamount<=userRepository.findById(user_id).get().getBalance())
//        {
//           float balance= userRepository.findById(user_id).get().getBalance()-billamount;
//
//            userRepository.findById(user_id).get().setBalance(balance);
//            return "purchase successful";
//        }
//        else return "insufficient funds";
//        }

    @Override
    public String AddMoney(float amount, int UserId) {
        Optional<User> user=userRepository.findById(UserId);
        float bal=user.get().getBalance();
        float newbal=bal+amount;
        user.get().setBalance(newbal);
        return "amount added";
    }

}
