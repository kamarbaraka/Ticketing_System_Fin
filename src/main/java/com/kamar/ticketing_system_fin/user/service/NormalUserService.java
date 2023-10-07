package com.kamar.ticketing_system_fin.user.service;

import com.kamar.ticketing_system_fin.user.data.UserDTO;
import com.kamar.ticketing_system_fin.user.entity.NormalUser;

import java.util.List;

/**
 * service for the normal user.
 * @author kamar baraka.*/

public interface NormalUserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    List<UserDTO> getAllUsers();
}
