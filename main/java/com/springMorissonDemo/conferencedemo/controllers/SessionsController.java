package com.springMorissonDemo.conferencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springMorissonDemo.conferencedemo.models.Sessions;
import com.springMorissonDemo.conferencedemo.repository.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	@Autowired
	public SessionRepository sessionRepository;
	
	@GetMapping
	public List<Sessions> listAllSessions() 
	{
		return sessionRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Sessions findSessionById(@PathVariable Long id)
	{
		return sessionRepository.getOne(id);
	}

	@PostMapping
	public void saveSessionDetails(@RequestBody Sessions sessionsDtls)
	{
		sessionRepository.saveAndFlush(sessionsDtls);
	}
	
	@RequestMapping(value= "{id}" , method = RequestMethod.DELETE)
	public void deleteSessionDetails(@PathVariable Long id)
	{
		sessionRepository.deleteById(id);
	}

	
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public Sessions updateSessionDtls(@PathVariable Long id , @RequestBody Sessions sessionDtls)
	{
	  Sessions existingDtls = sessionRepository.getOne(id);
	BeanUtils.copyProperties(sessionDtls, existingDtls);  
return sessionRepository.saveAndFlush(existingDtls);
	}
}
