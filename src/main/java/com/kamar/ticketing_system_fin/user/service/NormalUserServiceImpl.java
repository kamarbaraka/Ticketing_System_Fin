package com.kamar.ticketing_system_fin.user.service;

import com.kamar.ticketing_system_fin.department.entity.Department;
import com.kamar.ticketing_system_fin.user.data.UserDTO;
import com.kamar.ticketing_system_fin.user.entity.NormalUser;
import com.kamar.ticketing_system_fin.user.external_resources.DepartmentApi;
import com.kamar.ticketing_system_fin.user.repository.NormalUserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * implementation of the normal user service.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class NormalUserServiceImpl implements NormalUserService {

    private final ModelMapper mapper;
    private final NormalUserRepository userRepository;

    private final DepartmentApi departmentApi;

    /**
     * convert DTO to Entity*/
    private NormalUser convertToEntity(UserDTO userDTO){

        /*set configuration to exclude null values*/
        mapper.getConfiguration().setSkipNullEnabled(true);

        /*convert and return*/
        return mapper.map(userDTO, NormalUser.class);
    }

    /**
     * convert Entity to DTO.
     * @param normalUser the {@link NormalUser} object.
     * @return {@link UserDTO}*/
    private UserDTO convertToDTO(NormalUser normalUser){

        /*convert and return*/
        return mapper.map(normalUser, UserDTO.class);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        /*confirm if the department exists*/
        Department department = departmentApi.getDepartmentByName(userDTO.getDepartment());
        /*map the DTO to entity*/
        NormalUser normalUser = convertToEntity(userDTO);
        /*set the department property*/
        normalUser.setDepartment(department);
        /*persist and return*/
        NormalUser savedUser = userRepository.save(normalUser);
        return convertToDTO(savedUser);
    }

    @Override
    public UserDTO getUserByEmail(String email) {

        /*get the user with email*/
        NormalUser normalUser = userRepository.findNormalUserByEmail(email);
        /*map the user to DTO and return*/
        return convertToDTO(normalUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        /*get all users*/
        List<NormalUser> allUsers = userRepository.findAll();
        /*map the users to DTO and return*/
        return allUsers.stream().map(this::convertToDTO).toList();
    }
}
