package com.kamar.ticketing_system_fin.ticket.repository;

import com.kamar.ticketing_system_fin.ticket.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * the task repository.
 * @author kamar baraka.*/


@Repository
public interface TasksRepository extends PagingAndSortingRepository<Tasks, Long>, JpaRepository<Tasks, Long> {
}
