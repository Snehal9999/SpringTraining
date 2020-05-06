package com.springMorissonDemo.conferencedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springMorissonDemo.conferencedemo.models.Sessions;

public interface SessionRepository extends JpaRepository<Sessions, Long> {

}
