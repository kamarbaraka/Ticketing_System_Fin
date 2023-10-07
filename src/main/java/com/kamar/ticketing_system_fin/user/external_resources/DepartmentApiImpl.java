package com.kamar.ticketing_system_fin.user.external_resources;

import com.kamar.ticketing_system_fin.department.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
/**
 * the implementation of the department API.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class DepartmentApiImpl implements DepartmentApi{

    private final RestTemplate restTemplate;

    @Override
    public Department getDepartmentByName(String name) {

        /*send the request and get the response*/
        String url = "http://api/departments/" + name;
        ResponseEntity<Department> departmentEntity = restTemplate.getForEntity(url, Department.class);
        return departmentEntity.getBody();

    }

    @Override
    public List<Department> getAllDepartments() {

        /*send the request and get the response and return it*/
        String url = "http://api/departments";
        Department[] departmentArray = restTemplate.getForEntity(url, Department[].class).getBody();
        assert departmentArray != null;
        return Arrays.asList(departmentArray);
    }
}
