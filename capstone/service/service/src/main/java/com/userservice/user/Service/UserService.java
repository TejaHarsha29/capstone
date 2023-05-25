package com.userservice.user.Service;

import com.userservice.user.entity.User;

public interface UserService {
    public String addUser(User user);

    float findbalance(int user_id);

    //    public String BuyNow(int id);
    public String AddMoney(float amount,int UserId);
}
