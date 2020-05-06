package com.springMorissonDemo.conferencedemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.springMorissonDemo.conferencedemo.models.Speakers;
import com.springMorissonDemo.conferencedemo.repository.SpeakersRepository;
import com.springMorissonDemo.conferencedemo.services.SpeakersService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

	@Autowired
	public SpeakersRepository speakersRepository;

	@Autowired
	public SpeakersService speakerService;

	@GetMapping
	public Iterable<Speakers> getAllSpeakers() {
		return speakersRepository.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Optional<Speakers> getSpeakerById(@PathVariable Long id) {
		return speakersRepository.findById(id);
	}

	@PostMapping
	public Speakers saveSpeakers(@RequestBody final Speakers speakerdetails) {
		return speakersRepository.save(speakerdetails);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteSpeaker(@PathVariable Long id) {
		speakersRepository.deleteById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speakers updateSpeaker(@PathVariable Iterable<Long> id, @RequestBody Speakers speakerDtls) {
		Iterable<Speakers> details = speakersRepository.findAllById(id);

		for (Speakers s : details) {
			BeanUtils.copyProperties(speakerDtls, s);
		}
		return (Speakers) speakersRepository.saveAll(details);
	}

	@RequestMapping(value="/GetAllSpeakerList", method = RequestMethod.GET)
	public ResponseEntity<List<Speakers>> getAllSpeakers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		List<Speakers> list = speakerService.getAllSpeakerDetails(pageNo, pageSize);

		return new ResponseEntity<List<Speakers>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	//Implementing JPA for Pagination 
	
	@RequestMapping(value="/jpaPagination" , method = RequestMethod.GET)
	public ResponseEntity<List<Speakers>> jpaSpeakerList()
	{
		List<Speakers> jpaSpeakerList = speakerService.getAllJPASpeakerList();
		return new ResponseEntity<List<Speakers>>(jpaSpeakerList, new HttpHeaders(), HttpStatus.OK);

	}
}
