package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Weights;



@Repository
public interface WeightsRepository extends JpaRepository<Weights,Integer> {

}
