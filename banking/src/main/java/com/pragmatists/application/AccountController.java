package com.pragmatists.application;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Controller
@RequestMapping("/account")
public class AccountController {


    @PostMapping
    HttpEntity<?> createAccount(@RequestParam String owner) {
        String id = UUID.randomUUID().toString();
        //TODO add saving Account

        URI location = fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return created(location).build();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    HttpEntity<AccountResource> getAccount(@PathVariable String id) {
        AccountResource accountResource = new AccountResource(id, "", "john.doe@example.com", 0);
        //TODO add fetching Account

        return ok(accountResource);
    }

    @PutMapping(path = "/{id}/withdraw", produces = APPLICATION_JSON_VALUE)
    HttpEntity<?> withdraw(@PathVariable String id, @RequestParam String amount) {
        //TODO add withdraw functionality
        return noContent().build();
    }

    @PutMapping(path = "/{id}/deposit", produces = APPLICATION_JSON_VALUE)
    HttpEntity<?> deposit(@PathVariable String id, @RequestParam String amount, @RequestParam String accountId) {
        //TODO add deposit functionality
        return noContent().build();
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    HttpEntity<?> closeAccount(@PathVariable String id) {
        //TODO add closing Account

        return noContent().build();
    }


}