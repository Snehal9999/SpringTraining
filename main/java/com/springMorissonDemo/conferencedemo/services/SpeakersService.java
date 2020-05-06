package com.springMorissonDemo.conferencedemo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springMorissonDemo.conferencedemo.models.Speakers;
import com.springMorissonDemo.conferencedemo.repository.SpeakersRepository;

@Service
public class SpeakersService {

	@Autowired
	public SpeakersRepository speakerRepository;
	

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Speakers> getAllSpeakerDetails(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		 Pageable paging = PageRequest.of(pageNo, pageSize);
		 
	        Page<Speakers> pagedResult = speakerRepository.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Speakers>();
	        }
	}

	public List<Speakers> getAllJPASpeakerList() {
		// TODO Auto-generated method stub
		int pageNumber = 1;
		int pageSize = 10;
		TypedQuery<Speakers> q = entityManager.createQuery(" from speakers where speaker_id<20 ",Speakers.class);
		q.setFirstResult(pageNumber);
		q.setMaxResults(pageSize);
		return q.getResultList();
	}

}
