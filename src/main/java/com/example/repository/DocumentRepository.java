package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
