package com.neovision.bank.user

import com.neovision.bank.security.Role
import com.neovision.bank.security.User
import com.neovision.bank.security.UserRole

class UserService {

    List<User> getAll(){
        return User.findAll()
    }

    User getOne(Long id){
        return User.findById(id)
    }

    User createUser(String email, String password){
        User user = new User(username: email, password: password)
        user.save(flush:true)
        UserRole.create(user, Role.userRole, true)
        return user
    }
}
