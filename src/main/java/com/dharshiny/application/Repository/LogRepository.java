package com.dharshiny.application.Repository;

import com.dharshiny.application.Model.LogModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogModel,String>{
    
}
