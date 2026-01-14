package com.example.blog.repository;

import com.example.blog.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IautorRepository extends JpaRepository<Autor, Long> {
}