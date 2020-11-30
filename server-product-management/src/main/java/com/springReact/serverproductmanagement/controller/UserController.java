package com.springReact.serverproductmanagement.controller;

import com.springReact.serverproductmanagement.model.Role;
import com.springReact.serverproductmanagement.model.Transaction;
import com.springReact.serverproductmanagement.model.User;
import com.springReact.serverproductmanagement.service.ProductService;
import com.springReact.serverproductmanagement.service.TransactionService;
import com.springReact.serverproductmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //default role
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
        //principal = httpservletrequest.getUserPrincipale();
        if (principal == null || principal.getName() == null) {
            //logout will also use here so we should return ok http status
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction) {
        transaction.setPurchaseDate(LocalDateTime.now());
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}
