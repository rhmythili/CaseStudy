package com.example.poc.repository;

import org.springframework.stereotype.Repository;

import com.example.poc.entity.LoanDetailsDE;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetailsDE, Integer>{

}
