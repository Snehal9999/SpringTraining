package com.springMorissonDemo.conferencedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springMorissonDemo.conferencedemo.models.Speakers;

public interface SpeakersRepository extends  PagingAndSortingRepository<Speakers, Long>{

	

}
