package com.apress.quickpoll.service;

import com.apress.quickpoll.domain.Poll;
import com.apress.quickpoll.exception.ResourceNotFoundException;
import com.apress.quickpoll.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;


    public ResponseEntity<Iterable<Poll>> getAllpolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }


    public ResponseEntity<?> createPoll(Poll poll) {
        poll = pollRepository.save(poll);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Poll poll = pollRepository.findById(pollId).orElse(null);
        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

    public ResponseEntity<?> getPoll(Long pollId) {
        verifyPoll(pollId);
        Poll p = pollRepository.findById(pollId).orElse(null);
        if (p == null){
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    public ResponseEntity<?> updatePoll(Poll poll, Long pollId) {
        verifyPoll(pollId);
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deletePoll(Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
