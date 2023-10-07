package com.kamar.ticketing_system_fin.department.repository;

import com.kamar.ticketing_system_fin.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the department repository.
 * @author kamar baraka.*/


@Repository
public interface DepartmentRepository  extends JpaRepository<Department, String > {
}
