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

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return pollService.updatePoll(poll, pollId);
    }


    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return pollService.deletePoll(pollId);
    }

}