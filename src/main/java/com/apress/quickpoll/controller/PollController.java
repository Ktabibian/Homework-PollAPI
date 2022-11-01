package com.apress.quickpoll.controller;

import com.apress.quickpoll.domain.Poll;
import com.apress.quickpoll.repository.PollRepository;
import com.apress.quickpoll.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private PollRepository pollRepository;


    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return pollService.getAllpolls();
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return pollService.getPoll(pollId);
    }

    //    @GetMapping(value = "/{id}")
//    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
//        return ResponseEntity.ok().body(pollService.getSinglePoll(id));
//    }
    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return pollService.updatePoll(poll, pollId);
    }


    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return pollService.deletePoll(pollId);
    }

//    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
//    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
//        // Save the entity
//        Poll p = pollRepository.save(poll);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    }

//      @RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
//      public void updateLocation(@RequestBody Location location, @PathVariable String id) {
//
//         locationService.updateLocation(id, location);

}