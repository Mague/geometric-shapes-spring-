package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.GeometricFigureEntity;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface GeometricFigureRepository extends CrudRepository<GeometricFigureEntity, Long>{}
